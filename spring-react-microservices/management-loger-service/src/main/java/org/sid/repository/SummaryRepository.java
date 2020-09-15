package org.sid.repository;

import org.sid.model.Summary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SummaryRepository extends CrudRepository<Summary, Long> {

    Optional<Summary> findByCourseId(Long courseId);

    @Query(value = "update summary set hit_count = hit_count + 1 where course_id=?0", nativeQuery = true)
    void incrementHitCount(Long courseId);

    @Query(value = "Select * from summary limit 100", nativeQuery = true)
    List<Summary> findPopularCourses();
}