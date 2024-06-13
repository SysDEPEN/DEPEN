package com.br.depen.apidepen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.br.depen.apidepen.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
