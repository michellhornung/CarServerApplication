package com.mytaxi.service.car;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

public interface CarService
{

    CarDO find(Long carId) throws EntityNotFoundException;


    CarDO create(CarDO carDO) throws ConstraintsViolationException;


    void delete(Long carrId) throws EntityNotFoundException;


    void updateCar(long carId, String licensePlate, Long seatCount, Boolean isConvertible, Long rating, String engineType, String manufacturer, Boolean isDeleted, Boolean inUse)
        throws EntityNotFoundException;


    List<CarDO> find();


    Page<DriverDO> findByLicensePlate(String licensePlate, Pageable pageable);


    Page<DriverDO> findByRating(Long rating, Pageable pageable);
    
    
    
    
    

}
