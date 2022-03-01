package com.bd.tpfinal.model;

public class Pending extends OrderStatus
{
    private Order order;

    public Pending(Order order)
    {
        this.order = order;
    }

    //TODO: es posible que los vuelva void a todos
    //Esto se ejecuta cuando el Client confirma y se lo asigna a un repartidor libre.
    @Override
    public boolean canAssign()
    {
        order.setStatus(new Pending(order));
        return true;
    }

    //el pedido es cancelado por el Client
    @Override
    public boolean canRefuse()
    {
        Cancel cancel = new Cancel(order);
        cancel.setCancelledByClient(true);
        this.order.setStatus(cancel);
        return true;
    }

    @Override
    public boolean canDeliver()
    {
        return false;
    }

    @Override
    public boolean canFinish()
    {
        return false;
    }
}
