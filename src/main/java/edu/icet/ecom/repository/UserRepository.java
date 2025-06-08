package edu.icet.ecom.repository;

import edu.icet.ecom.model.entity.BlogEntity;
import edu.icet.ecom.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

}

