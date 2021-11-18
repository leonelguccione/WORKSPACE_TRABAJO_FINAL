package com.bd.tpfinal.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ordersStatus")
public abstract class OrderStatus
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Date startDate;

    @JoinColumn(name = "order_id")
    //"order_id" es la columna de la tabla ordersStatus que tiene la clave foranea
    @OneToOne(fetch = FetchType.LAZY)
    private Order order;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }

    public boolean canAddItem()
    {
        return false;
    }

    //TODO: cambio esto.
    //era concreto y retornaba false
    public abstract boolean canAssign();

    public abstract boolean canRefuse();

    public abstract boolean canDeliver();

    public abstract boolean canFinish();

    public boolean canCancel()
    {
        return false;
    }

    public boolean addItem() throws Exception
    {
        throw new Exception("No se puede realizarse esta accion");
    }

    public boolean assign(DeliveryMan deliveryMan) throws Exception
    {
        throw new Exception("No se puede realizarse esta accion");
    }

    public boolean refuse() throws Exception
    {
        throw new Exception("No se puede realizarse esta accion");
    }

    public boolean deliver() throws Exception
    {
        throw new Exception("No se puede realizarse esta accion");
    }

    public boolean cancel() throws Exception
    {
        throw new Exception("No se puede realizarse esta accion");
    }

    public boolean finish() throws Exception
    {
        throw new Exception("No se puede realizarse esta accion");
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }
}
