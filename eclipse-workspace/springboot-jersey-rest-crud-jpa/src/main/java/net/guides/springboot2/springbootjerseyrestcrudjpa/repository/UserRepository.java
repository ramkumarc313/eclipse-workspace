package net.guides.springboot2.springbootjerseyrestcrudjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.guides.springboot2.springbootjerseyrestcrudjpa.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
