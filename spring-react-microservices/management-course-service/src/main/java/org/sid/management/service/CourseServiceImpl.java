package org.sid.management.service;

import org.sid.management.model.Course;
import org.sid.management.model.Transaction;
import org.sid.management.repository.CourseRepository;
import org.sid.management.repository.TransactionRepository;
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
//        return courseRepository.findAllByIdIn(idList);
        return null;
    }

    @Override
    public List<Course> filterCourses(final String content) {
//        return courseRepository.findAllByTitle(content);
        return null;
    }

    @Override
    public List<Transaction> filterTransactionsOfUser(final Long userId){
//        return transactionRepository.findAllTransactionsOfUser(userId);
        return null;
    }

    @Override
    public List<Transaction> filterTransactionsOfCourse(final Long courseId){
//        return transactionRepository.findAllById(courseId);
        return null;
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
