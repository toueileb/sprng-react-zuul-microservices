package org.sid.controller;

import org.sid.intercomm.LogClient;
import org.sid.intercomm.UserClient;
import org.sid.model.Transaction;
import org.sid.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/service")
public class CourseController {


    private UserClient userClient;
    private LogClient logClient;
    private CourseService courseService;

    public CourseController(UserClient userClient, LogClient logClient, CourseService courseService) {
        this.userClient = userClient;
        this.logClient = logClient;
        this.courseService = courseService;
    }

    @PostMapping("/user")
    public ResponseEntity<?> filterTransactions(@RequestBody Long userId){
        return new ResponseEntity<>(courseService.filterTransactionsOfUser(userId), HttpStatus.OK);
    }

    @GetMapping("/popular")
    public ResponseEntity<?> popularCourses(){
        List<Long> popularIdList = logClient.getPopularCourses();
        if(popularIdList==null || popularIdList.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(courseService.filterCoursesByIdList(popularIdList), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> allCourses(){
        return new ResponseEntity<>(courseService.allCourses(), HttpStatus.OK);
    }

    @PostMapping("/filter")
    public ResponseEntity<?> filterCourses(@RequestBody String text){
        return new ResponseEntity<>(courseService.filterCourses(text), HttpStatus.OK);
    }

    @PostMapping("/enroll")
    public ResponseEntity<?> saveTransaction(@RequestBody Transaction transaction){
        transaction.setDateOfIssue(LocalDateTime.now());
        transaction.setCourse(courseService.findCourseById(transaction.getCourse().getId()));
        courseService.saveTransaction(transaction);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping("/students")
    public ResponseEntity<?> findCourseStudents(@RequestBody Long courseId){
        List<Transaction> list = courseService.filterTransactionsOfCourse(courseId);
        if(list!=null && !list.isEmpty()){
            List<Long> userIdList = list.parallelStream().map(t->t.getUserId()).collect(Collectors.toList());
            List<String> students = userClient.getUsers(userIdList);
            return ResponseEntity.ok(students);
        }
        return ResponseEntity.notFound().build();
    }
}
