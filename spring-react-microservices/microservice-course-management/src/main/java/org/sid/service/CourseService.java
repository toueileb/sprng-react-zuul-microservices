package org.sid.service;


import org.sid.model.Course;
import org.sid.model.Transaction;

import java.util.List;

public interface CourseService {
    List<Course> allCourses();

    List<Course> filterCoursesByIdList(List<Long> idList);

    List<Course> filterCourses(String content);

    List<Transaction> filterTransactionsOfUser(Long userId);

    List<Transaction> filterTransactionsOfCourse(Long courseId);

    void saveTransaction(Transaction transaction);

    Course findCourseById(Long courseId);
}
