package com.mytaxi.domainobject;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(
    name = "car",
    uniqueConstraints = @UniqueConstraint(name = "uc_licensePlate", columnNames = {"licensePlate"}))
public class CarDO
{

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime dateCreated = ZonedDateTime.now();

    @Column(nullable = false)
    @NotNull(message = "License Plate can not be null!")
    private String licensePlate;

    @Column(nullable = true)
    private Long seatCount;

    @Column(nullable = true)
    private Boolean isConvertible = false;

    @Column
    private Long rating;

    @Column
    private String engineType;

    @Column
    private String manufacturer;

    @Column(nullable = false)
    private Boolean deleted = false;


    @SuppressWarnings("unused")
    private CarDO()
    {}


    public CarDO(String licensePlate, Long seatCount, Boolean isConvertible, Long rating, String engineType, String manufacturer)
    {
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.isConvertible = isConvertible;
        this.rating = rating;
        this.engineType = engineType;
        this.manufacturer = manufacturer;
        this.deleted = false;
    }


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public ZonedDateTime getDateCreated()
    {
        return dateCreated;
    }


    public void setDateCreated(ZonedDateTime dateCreated)
    {
        this.dateCreated = dateCreated;
    }


    public String getLicensePlate()
    {
        return licensePlate;
    }


    public void setLicensePlate(String licensePlate)
    {
        this.licensePlate = licensePlate;
    }


    public Long getSeatCount()
    {
        return seatCount;
    }


    public void setSeatCount(Long seatCount)
    {
        this.seatCount = seatCount;
    }


    public Boolean getIsConvertible()
    {
        return isConvertible;
    }


    public void setIsConvertible(Boolean isConvertible)
    {
        this.isConvertible = isConvertible;
    }


    public Long getRating()
    {
        return rating;
    }


    public void setRating(Long rating)
    {
        this.rating = rating;
    }


    public String getEngineType()
    {
        return engineType;
    }


    public void setEngineType(String engineType)
    {
        this.engineType = engineType;
    }


    public String getManufacturer()
    {
        return manufacturer;
    }


    public void setManufacturer(String manufacturer)
    {
        this.manufacturer = manufacturer;
    }


    public Boolean getDeleted()
    {
        return deleted;
    }


    public void setDeleted(Boolean deleted)
    {
        this.deleted = deleted;
    }

}
