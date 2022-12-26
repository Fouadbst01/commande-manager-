package org.sid.orderservicequery.repositories;

import org.sid.orderservicequery.entities.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<Command,String> {
}
