package com.bd.tpfinal.model;

public class Sent extends OrderStatus
{

    private Order order;

    public Sent(Order order)
    {
        this.order = order;
    }

    @Override
    public boolean canAssign()
    {
        return false;
    }

    @Override
    public boolean canRefuse()
    {
        return false;
    }

    @Override
    public boolean canDeliver()
    {
        return false;
    }

    //TODO: esto activa la actualización de puntajes
    @Override
    public boolean canFinish()
    {
        this.order.setStatus(new Delivered(order));
        return true;
    }
}
