package com.cpLab8sec2.dto;

public class CustomerResponse {
    private Long id;
    private String name;
    private String email;
    private AddressResponse address;

    public CustomerResponse(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public CustomerResponse(Long id, String name, String email, AddressResponse address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    // ✅ getters/setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public AddressResponse getAddress() { return address; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setAddress(AddressResponse address) { this.address = address; }
}
