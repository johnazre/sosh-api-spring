package com.armby.soshapi.status;

import org.springframework.data.jpa.repository.JpaRepository;

// Give me access to all of the CRUD methods that I can use to interact with the database
public interface StatusRepository extends JpaRepository<Status, Long> {
}
