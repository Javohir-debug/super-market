package uz.narzullayev.market.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "order_entity")
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Transient
    private static final String sequence="order_entity_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequence)
    @SequenceGenerator(name = sequence, sequenceName = sequence, allocationSize = 1)
    @Column(name ="id")
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",referencedColumnName = "id",updatable = false,insertable = false)
    private Customer customer;

    @Column(name = "created_At")
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    @CreatedDate
    private LocalDateTime localDateTime;

    @OneToMany(mappedBy = "orderEntity",cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetailList=new LinkedList<>();

    public List<OrderDetail> getOrderDetailList() {
        return orderDetailList;
    }

    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
        this.orderDetailList = orderDetailList;
    }

    public OrderEntity(Integer id, Customer customer, LocalDateTime localDateTime) {
        this.id = id;
        this.customer = customer;
        this.localDateTime = localDateTime;
    }

    public OrderEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
