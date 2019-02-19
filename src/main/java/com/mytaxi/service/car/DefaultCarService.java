package com.mytaxi.service.car;

import com.mytaxi.dataaccessobject.CarRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some car specific things.
 * <p/>
 */
@Service
public class DefaultCarService implements CarService
{

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCarService.class);

    private final CarRepository carRepository;


    public DefaultCarService(final CarRepository carRepository)
    {
        this.carRepository = carRepository;
    }


    /**
     * Selects a car by id.
     *
     * @param carId
     * @return found car
     * @throws EntityNotFoundException if no car with the given id was found.
     */
    @Override
    public CarDO find(Long carId) throws EntityNotFoundException
    {
        return findCarById(carId);
    }


    /**
     * Creates a new car.
     *
     * @param carDO
     * @return
     * @throws ConstraintsViolationException if a car already exists with the given license plate, ... .
     */
    @Override
    public CarDO create(CarDO carDO) throws ConstraintsViolationException
    {
        CarDO car;
        try
        {
            car = carRepository.save(carDO);
        }
        catch (DataIntegrityViolationException e)
        {
            LOG.warn("ConstraintsViolationException while creating a car: {}", carDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return car;
    }


    /**
     * Deletes an existing car by id.
     *
     * @param carId
     * @throws EntityNotFoundException if no car with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long carId) throws EntityNotFoundException
    {
        CarDO carDO = find(carId);
        carDO.setDeleted(true); //just a flag to keep deleted items in car's table
    }


    /**
     * Update attribute for a car.
     *
     * @param carId
     * @throws EntityNotFoundException
     */
    @Override
    @Transactional
    public void updateCar(
        long carId, String licensePlate, Long seatCount, Boolean isConvertible, Long rating,
        String engineType, String manufacturer, Boolean isDeleted)
        throws EntityNotFoundException
    {

        CarDO carDO = find(carId);
        carDO.setDateCreated(carDO.getDateCreated());
        carDO.setLicensePlate(licensePlate);
        carDO.setSeatCount(seatCount);
        carDO.setIsConvertible(isConvertible);
        carDO.setRating(rating);
        carDO.setEngineType(engineType);
        carDO.setManufacturer(manufacturer);
        carDO.setDeleted(isDeleted);

    }


    /**
     * Find all cars.
     *
     * @param onlineStatus
     */
    @Override
    public List<CarDO> find()
    {
        return carRepository.findAll();
    }


    private CarDO findCarById(Long carId) throws EntityNotFoundException
    {
        return carRepository
            .findById(carId)
            .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + carId));
    }

}
