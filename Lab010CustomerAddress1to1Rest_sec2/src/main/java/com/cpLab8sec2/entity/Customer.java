package com.cpLab8sec2.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    // ✅ ความสัมพันธ์ One-to-One (เชื่อมกับ Address)
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Address address;

    // ✅ Constructors
    public Customer() {}

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // ✅ Getter & Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ✅ เพิ่มสองอันนี้เข้าไป เพื่อให้เรียกใช้งานใน Service ได้
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
