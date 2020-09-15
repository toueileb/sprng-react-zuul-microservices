package org.sid.management.repository;


import org.sid.management.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends IGenericDao<Course>, CrudRepository<Course, Long> {

////    List<Course> filterCourses(String text);
//
//    List<Course> findAllByTitle(String title);
////    List<Course> filterCoursesByIdList(List<Long> idList);
//
//    List<Course> findAllByIdIn(List<Long> idList);
}
