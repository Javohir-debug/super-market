package uz.narzullayev.market.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order_product")
public class OrderProduct implements Serializable {
    private static final long serialVersionUID = 1L;
    @Transient
    private static final String sequence="order_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequence)
    @SequenceGenerator(name = sequence, sequenceName = sequence, allocationSize = 1)
    @Column(name ="id")
    private Integer id;


    @Column(name = "created_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",referencedColumnName = "id",
                nullable = false,insertable = false,updatable = false)
    private Customer customer;


    @Column(name = "customer_id")
    private Integer customerId;

    @OneToMany(mappedBy = "order",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails =new HashSet<>();

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }
}
