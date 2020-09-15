package org.sid.repository;

import org.sid.model.Log;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface LogRepository extends CrudRepository<Log, UUID> {
}
