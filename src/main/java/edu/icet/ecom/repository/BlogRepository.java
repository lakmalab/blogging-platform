package edu.icet.ecom.repository;

import edu.icet.ecom.model.entity.BlogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<BlogEntity,Long> {
}
