package com.bd.tpfinal.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int number;  //tal vez esto pueda ser el id, pero todavía no se para que sirve

    private Date dateOfOrder;

    private String comments;

    private float totalPrice;

    @OneToOne(mappedBy = "order", cascade=CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private OrderStatus status; //acá hay un Patrón State

    //TODO: verificar que deliveryMan podría ser null
    //se puede crear una Order sin asignar un deliveryMan
    @OneToOne
    private DeliveryMan deliveryMan;

    @OneToOne
    private Client client;

    //en el UML este campo se llama DeliveryAddress, tal vez se deba cambiar
    @OneToOne
    private Address address;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Qualification qualification;

    //relación uno a muchos
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    //"order_id" es el nombre de la columna de tabla items que se agrega para
    //mantener la relación
    private List<Item> items;

    //TODO: completar este constructor
    //solamente puse lo relativo a patrón STATE
    public Order()
    {
        setStatus(new Pending(this));
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    public Date getDateOfOrder()
    {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder)
    {
        this.dateOfOrder = dateOfOrder;
    }

    public String getComments()
    {
        return comments;
    }

    public void setComments(String comments)
    {
        this.comments = comments;
    }

    public float getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public DeliveryMan getDeliveryMan()
    {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan)
    {
        this.deliveryMan = deliveryMan;
    }

    public Client getClient()
    {
        return client;
    }

    public void setClient(Client client)
    {
        this.client = client;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Qualification getQualification()
    {
        return qualification;
    }

    public void setQualification(Qualification qualification)
    {
        this.qualification = qualification;
    }

    public List<Item> getItems()
    {
        return items;
    }

    public void setItems(List<Item> items)
    {
        this.items = items;
    }

    public OrderStatus getStatus()
    {
        return status;
    }

    public void setStatus(OrderStatus status)
    {
        this.status = status;
    }
}
