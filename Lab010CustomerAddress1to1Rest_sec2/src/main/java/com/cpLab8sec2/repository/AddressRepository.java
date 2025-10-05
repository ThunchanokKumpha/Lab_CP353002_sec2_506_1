package com.cpLab8sec2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpLab8sec2.entity.Address;

public interface AddressRepository  extends JpaRepository<Address, Long> {}

