package com.mytaxi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mytaxi.controller.mapper.CarMapper;
import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.datatransferobject.DriverDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.CarAlreadyInUseException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.service.car.CarService;

/**
 * All operations with a car will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("v1/cars")
public class CarController
{

    private final CarService carService;

    //Dependency injection that allows to get anything from controller. Also DriverDO stuff.
    @Autowired
    private DriverController driverController;


    @Autowired
    public CarController(final CarService carService)
    {
        this.carService = carService;
    }


    @GetMapping("/{carId}")
    public CarDTO getCar(@PathVariable long carId) throws EntityNotFoundException
    {
        return CarMapper.makeCarDTO(carService.find(carId));
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CarDTO createCar(@Valid @RequestBody CarDTO carDTO) throws ConstraintsViolationException
    {
        CarDO carDO = CarMapper.makeCarDO(carDTO);
        return CarMapper.makeCarDTO(carService.create(carDO));
    }


    @DeleteMapping("/{carId}")
    public void deleteCar(@PathVariable long carId) throws EntityNotFoundException
    {
        carService.delete(carId);
    }


    @PutMapping("/{carId}")
    public void updateCar(
        @PathVariable long carId, @RequestParam String licensePlate,
        @RequestParam Long seatCount, @RequestParam Boolean isConvertible, @RequestParam Long rating,
        @RequestParam String engineType, @RequestParam String manufacturer, @RequestParam Boolean isDeleted, @RequestParam Boolean inUse)
        throws EntityNotFoundException
    {

        carService.updateCar(carId, licensePlate, seatCount, isConvertible, rating, engineType, manufacturer, isDeleted, inUse);
    }


    @GetMapping
    public List<CarDTO> findCars()
    {
        return CarMapper.makeCarDTOList(carService.find());
    }


    @GetMapping("getcarbydriver/{driverId}")
    public DriverDTO getCarByOneOnlineDriver(
        @PathVariable long driverId,
        @RequestParam OnlineStatus onlineStatus,
        GeoCoordinate geoCoordinate)
        throws CarAlreadyInUseException, EntityNotFoundException
    {
        //Once coordinate is different than null, so car was selected by an online driver.
        //Also I've created a column in table to set inUser or not.
        if (geoCoordinate != null && onlineStatus.equals(OnlineStatus.ONLINE))
        {
            throw new CarAlreadyInUseException("The selected car is already in use! ");
        }

        return driverController.getDriver(driverId);

    }

}
