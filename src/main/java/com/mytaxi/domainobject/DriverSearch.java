package com.mytaxi.domainobject;

import com.mytaxi.domainvalue.OnlineStatus;

public class DriverSearch
{

    private String username;

    private Long id;

    private OnlineStatus onlineStatus;

    private String licensePlate;

    private Long rating;


    public String getUsername()
    {
        return username;
    }


    public void setUsername(String username)
    {
        this.username = username;
    }


    public Long getId()
    {
        return id;
    }


    public void setId(Long id)
    {
        this.id = id;
    }


    public OnlineStatus getOnlineStatus()
    {
        return onlineStatus;
    }


    public void setOnlineStatus(OnlineStatus onlineStatus)
    {
        this.onlineStatus = onlineStatus;
    }


    public String getLicensePlate()
    {
        return licensePlate;
    }


    public void setLicensePlate(String licensePlate)
    {
        this.licensePlate = licensePlate;
    }


    public Long getRating()
    {
        return rating;
    }


    public void setRating(Long rating)
    {
        this.rating = rating;
    }

}
