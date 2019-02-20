package com.mytaxi.datatransferobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO
{
    @JsonIgnore
    private Long id;

    @NotNull(message = "License Plate can not be null!")
    private String licensePlate;

    private Long seatCount;

    private Boolean isConvertible;

    private Long rating;

    private String engineType;

    private String manufacturer;

    private Boolean inUse;


    private CarDTO()
    {}


    private CarDTO(Long id, String licensePlate, Long seatCount, Boolean isConvertible, Long rating, String engineType, String manufacturer, Boolean inUse)
    {
        this.id = id;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.isConvertible = isConvertible;
        this.rating = rating;
        this.engineType = engineType;
        this.manufacturer = manufacturer;
        this.setInUse(inUse);
    }


    public static CarDTOBuilder newBuilder()
    {
        return new CarDTOBuilder();
    }


    @JsonProperty
    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
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


    public Boolean getInUse()
    {
        return inUse;
    }


    public void setInUse(Boolean inUse)
    {
        this.inUse = inUse;
    }

    public static class CarDTOBuilder
    {
        private Long id;
        private String licensePlate;
        private Long seatCount;
        private Boolean isConvertible;
        private Long rating;
        private String engineType;
        private String manufacturer;
        private Boolean inUse;


        public CarDTOBuilder setId(Long id)
        {
            this.id = id;
            return this;
        }


        public CarDTOBuilder setLicensePlate(String licensePlate)
        {
            this.licensePlate = licensePlate;
            return this;
        }


        public CarDTOBuilder setSeatCount(Long seatCount)
        {
            this.seatCount = seatCount;
            return this;
        }


        public CarDTOBuilder setIsConvertible(Boolean isConvertible)
        {
            this.isConvertible = isConvertible;
            return this;
        }


        public CarDTOBuilder setRating(Long rating)
        {
            this.rating = rating;
            return this;
        }


        public CarDTOBuilder setEngineType(String engineType)
        {
            this.engineType = engineType;
            return this;

        }


        public CarDTOBuilder setManufacturer(String manufacturer)
        {
            this.manufacturer = manufacturer;
            return this;
        }


        public CarDTOBuilder setInUse(Boolean inUse)
        {
            this.inUse = inUse;
            return this;
        }


        public CarDTO createCarDTO()
        {
            return new CarDTO(id, licensePlate, seatCount, isConvertible, rating, engineType, manufacturer, inUse);
        }

    }
}
