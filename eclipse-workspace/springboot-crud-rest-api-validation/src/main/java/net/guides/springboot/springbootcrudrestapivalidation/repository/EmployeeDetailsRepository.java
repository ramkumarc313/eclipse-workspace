package net.guides.springboot.springbootcrudrestapivalidation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot.springbootcrudrestapivalidation.model.EmployeeDetails;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails,Long> {

}
