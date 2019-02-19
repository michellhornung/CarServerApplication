package com.mytaxi.service.car;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;
import java.util.List;

public interface CarService
{

    CarDO find(Long carId) throws EntityNotFoundException;

    CarDO create(CarDO carDO) throws ConstraintsViolationException;

    void delete(Long carrId) throws EntityNotFoundException;

    void updateCar(long carId, String licensePlate, Long seatCount, Boolean isConvertible, Long rating, String engineType, String manufacturer, Boolean isDeleted) throws EntityNotFoundException;

    List<CarDO> find();

}
