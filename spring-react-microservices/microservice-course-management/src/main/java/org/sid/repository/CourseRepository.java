package org.sid.repository;

import org.sid.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    List<Course> findAllByTitle(String title);

    List<Course> findAllByIdIn(List<Long> idList);
}
