package org.sid.service;

import org.sid.model.Course;
import org.sid.model.Transaction;
import org.sid.repository.CourseRepository;
import org.sid.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<Course> allCourses() {
        return (List<Course>) courseRepository.findAll();
    }

    @Override
    public List<Course> filterCoursesByIdList(final List<Long> idList){
        return courseRepository.findAllByIdIn(idList);
    }

    @Override
    public List<Course> filterCourses(final String content) {
        return courseRepository.findAllByTitle(content);
    }

    @Override
    public List<Transaction> filterTransactionsOfUser(final Long userId){
        return transactionRepository.findAllByUserId(userId);
    }

    @Override
    public List<Transaction> filterTransactionsOfCourse(final Long courseId){
        Course course = courseRepository.findById(courseId).get();
        List<Transaction> allByCourse = transactionRepository.findAllByCourse(course);
        return allByCourse;
    }

    @Override
    public void saveTransaction(final Transaction transaction){
        transactionRepository.save(transaction);
    }

    @Override
    public Course findCourseById(Long courseId){
        return courseRepository.findById(courseId).get();
    }
}
