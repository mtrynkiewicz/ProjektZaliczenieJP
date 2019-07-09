//package Trynio.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "orderPositions")
//public class orderPosition
//{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//    @Column(name = "quantity")
//    private float quantity;
//    @Column(name = "discountPercent")
//    private float discountPercent;
//
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private order singleOrder;
//
//    @ManyToOne
//    @JoinColumn(name = "orderitem_id")
//    private orderItem singleOrderItem;
//
//    public orderPosition()
//    {
//    }
//
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//
//    public order getSingleOrder() {
//        return singleOrder;
//    }
//
//    public void setSingleOrder(order singleOrder) {
//        this.singleOrder = singleOrder;
//    }
//
//    public orderItem getSingleOrderItem() {
//        return singleOrderItem;
//    }
//
//    public void setSingleOrderItem(orderItem singleOrderItem) {
//        this.singleOrderItem = singleOrderItem;
//    }
//
//    public float getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(float quantity) {
//        this.quantity = quantity;
//    }
//
//    public float getDiscountPercent() {
//        return discountPercent;
//    }
//
//    public void setDiscountPercent(float discountPercent) {
//        this.discountPercent = discountPercent;
//    }
//}
