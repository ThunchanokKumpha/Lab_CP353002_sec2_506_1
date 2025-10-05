package com.cpLab8sec2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpLab8sec2.dto.AddressRequest;
import com.cpLab8sec2.dto.AddressResponse;
import com.cpLab8sec2.dto.CustomerRequest;
import com.cpLab8sec2.dto.CustomerResponse;
import com.cpLab8sec2.entity.Address;
import com.cpLab8sec2.entity.Customer;
import com.cpLab8sec2.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repoCust;

    // Mapping
    private AddressResponse mapAddressToResponse(Address address) {
        if (address == null) return null;
        return new AddressResponse(
                address.getId(),
                address.getLine1(),
                address.getLine2(),
                address.getCity(),
                address.getPostalCode(),
                address.getCountry()
        );
    }

    private CustomerResponse mapToResponse(Customer cust) {
        return new CustomerResponse(
                cust.getId(),
                cust.getName(),
                cust.getEmail(),
                mapAddressToResponse(cust.getAddress())
        );
    }

    private Customer toEntity(CustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.getName());
        customer.setEmail(request.getEmail());

        if (request.getAddress() != null) {
            AddressRequest addrReq = request.getAddress();
            Address address = new Address();
            address.setLine1(addrReq.line1());
            address.setLine2(addrReq.line2());
            address.setCity(addrReq.city());
            address.setPostalCode(addrReq.postalCode());
            address.setCountry(addrReq.country());

            // เชื่อม Customer กับ Address
            address.setCustomer(customer);
            customer.setAddress(address);
        }

        return customer;
    }

    // CRUD 

    public List<CustomerResponse> getCustomerList() {
        List<Customer> customers = (List<Customer>) repoCust.findAll();
        return customers.stream()
                .map(this::mapToResponse)
                .toList();
    }

    public CustomerResponse getCustomerById(long id) {
        Customer customer = repoCust.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        return mapToResponse(customer);
    }

    @Transactional
    public CustomerResponse save(CustomerRequest cust) {
        Customer customer = toEntity(cust);
        Customer saved = repoCust.save(customer);
        return mapToResponse(saved);
    }

    @Transactional
    public CustomerResponse addCustomer(CustomerRequest cust) {
        return save(cust); // ใช้ save เดิม
    }

    @Transactional
    public CustomerResponse updateCustomer(long id, CustomerRequest custNew) {
        Customer custExist = repoCust.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));

        custExist.setName(custNew.getName());
        custExist.setEmail(custNew.getEmail());

        // อัปเดต Address
        AddressRequest addrReq = custNew.getAddress();
        if (addrReq != null) {
            Address addrExist = custExist.getAddress();
            if (addrExist == null) {
                addrExist = new Address();
                addrExist.setCustomer(custExist);
                custExist.setAddress(addrExist);
            }
            addrExist.setLine1(addrReq.line1());
            addrExist.setLine2(addrReq.line2());
            addrExist.setCity(addrReq.city());
            addrExist.setPostalCode(addrReq.postalCode());
            addrExist.setCountry(addrReq.country());
        }

        Customer saved = repoCust.save(custExist);
        return mapToResponse(saved);
    }

    @Transactional
    public void deleteCustomerById(long id) {
        Customer cust = repoCust.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException(id));
        repoCust.delete(cust);
    }
}
