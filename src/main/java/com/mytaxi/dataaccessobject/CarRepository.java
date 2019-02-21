package com.mytaxi.dataaccessobject;

import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * Database Access Object for driver table.
 * <p/>
 */
public interface CarRepository extends CrudRepository<CarDO, Long>
{

    List<CarDO> findAll();

    Page<DriverDO> findByLicensePlate(String licensePlate, Pageable pageable);

    Page<DriverDO> findByRating(Long rating, Pageable pageable);



}
