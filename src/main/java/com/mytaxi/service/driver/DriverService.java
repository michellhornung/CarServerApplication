package com.mytaxi.service.driver;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

public interface DriverService
{

    DriverDO find(Long driverId) throws EntityNotFoundException;


    DriverDO create(DriverDO driverDO) throws ConstraintsViolationException;


    void delete(Long driverId) throws EntityNotFoundException;


    void updateLocation(long driverId, double longitude, double latitude) throws EntityNotFoundException;


    List<DriverDO> find(OnlineStatus onlineStatus);


    Page<DriverDO> findByUsername(String username, Pageable pageable) throws EntityNotFoundException;


    Page<DriverDO> findByOnlineStatus(OnlineStatus onlineStatus, Pageable pageable);



}
