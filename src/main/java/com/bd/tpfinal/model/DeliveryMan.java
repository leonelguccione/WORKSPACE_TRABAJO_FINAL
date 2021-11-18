package com.bd.tpfinal.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "deliverymans")
public class DeliveryMan extends User
{
    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private int id;

    private int numberOfSuccessOrders;

    private boolean free;

    private Date dateOfAdmission;

    private List<Order> ordersPending;

    public int getNumberOfSuccessOrders()
    {
        return numberOfSuccessOrders;
    }

    public void setNumberOfSuccessOrders(int numberOfSuccessOrders)
    {
        this.numberOfSuccessOrders = numberOfSuccessOrders;
    }

    public boolean isFree()
    {
        return free;
    }

    public void setFree(boolean free)
    {
        this.free = free;
    }

    public Date getDateOfAdmission()
    {
        return dateOfAdmission;
    }

    public void setDateOfAdmission(Date dateOfAdmission)
    {
        this.dateOfAdmission = dateOfAdmission;
    }

    public List<Order> getOrdersPending()
    {
        return ordersPending;
    }

    public void setOrdersPending(List<Order> ordersPending)
    {
        this.ordersPending = ordersPending;
    }
}
