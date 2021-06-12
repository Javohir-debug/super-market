package uz.narzullayev.market.entity;

import uz.narzullayev.market.constant.Country;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Transient
    private static final String sequence="customer_sequence";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequence)
    @SequenceGenerator(name = sequence, sequenceName = sequence, allocationSize = 1)
    @Column(name ="id")
    private Integer id;

    @Column(name = "address")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    private Country country;

    @Column(name = "phone_number")
    private String phoneNumbers;

    public Customer(Integer id, String address, Country country, String phoneNumber) {
        this.id = id;
        this.address = address;
        this.country = country;
        this.phoneNumbers = phoneNumber;
    }

    public Customer( String address, Country country, String phoneNumber) {
        this.address = address;
        this.country = country;
        this.phoneNumbers = phoneNumber;
    }
    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getPhoneNumber() {
        return phoneNumbers;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumbers = phoneNumber;
    }
}
