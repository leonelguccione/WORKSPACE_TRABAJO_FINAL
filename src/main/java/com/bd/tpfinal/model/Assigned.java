package com.bd.tpfinal.model;

public class Assigned extends OrderStatus
{
    private Order order;

    public Assigned(Order order)
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
        Cancel cancel = new Cancel(order);
        cancel.setCancelledByClient(false);
        this.order.setStatus(cancel);
        return true;
    }

    @Override
    public boolean canDeliver()
    {
        this.order.setStatus(new Sent(order));
        return true;
    }

    @Override
    public boolean canFinish()
    {
        return false;
    }
}
