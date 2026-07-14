package com.java.kayo.cinevault.repository;

import com.java.kayo.cinevault.Entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<Streaming, Long> {

}
