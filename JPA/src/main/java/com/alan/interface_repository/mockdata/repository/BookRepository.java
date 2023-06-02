package com.alan.interface_repository.mockdata.repository;

import com.alan.interface_repository.mockdata.entity.MockData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<MockData, Long> {

}
