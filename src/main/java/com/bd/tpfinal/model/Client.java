package com.bd.tpfinal.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="clients")
public class Client extends User
{
    //hereda el campo id de User
    private Date dateOfRegister;
    private List<Order> orders;

    //relación uno a muchos, unidireccional
    //estamos del lado de uno
    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = false)
    @JoinColumn(name="id_client")  //se crea automaticamente al crear la table de Address
    private List<Address> addresses;

    public Date getDateOfRegister()
    {
        return dateOfRegister;
    }

    public void setDateOfRegister(Date dateOfRegister)
    {
        this.dateOfRegister = dateOfRegister;
    }

    public List<Order> getOrders()
    {
        return orders;
    }

    public void setOrders(List<Order> orders)
    {
        this.orders = orders;
    }

    public List<Address> getAddresses()
    {
        return addresses;
    }

    public void setAddresses(List<Address> addresses)
    {
        this.addresses = addresses;
    }
}
