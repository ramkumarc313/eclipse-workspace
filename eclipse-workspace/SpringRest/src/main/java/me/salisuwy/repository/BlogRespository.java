package me.salisuwy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.salisuwy.model.Blog;

@Repository
public interface BlogRespository extends JpaRepository<Blog,Integer> {

}
