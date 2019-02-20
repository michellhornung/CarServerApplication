package com.mytaxi.controller.mapper;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CarMapper
{
    public static CarDO makeCarDO(CarDTO carDTO)
    {
        return new CarDO(
            carDTO.getLicensePlate(), carDTO.getSeatCount(), carDTO.getIsConvertible(), carDTO.getRating(),
            carDTO.getEngineType(), carDTO.getManufacturer(), carDTO.getInUse());
    }


    public static CarDTO makeCarDTO(CarDO carDO)
    {
        CarDTO.CarDTOBuilder carDTOBuilder =
            CarDTO
                .newBuilder()
                .setId(carDO.getId())
                .setLicensePlate(carDO.getLicensePlate())
                .setSeatCount(carDO.getSeatCount())
                .setIsConvertible(carDO.getIsConvertible())
                .setRating(carDO.getRating())
                .setEngineType(carDO.getEngineType())
                .setManufacturer(carDO.getManufacturer())
                .setInUse(carDO.getInUse());

        return carDTOBuilder.createCarDTO();
    }


    public static List<CarDTO> makeCarDTOList(Collection<CarDO> cars)
    {
        return cars
            .stream()
            .map(CarMapper::makeCarDTO)
            .collect(Collectors.toList());
    }
}
