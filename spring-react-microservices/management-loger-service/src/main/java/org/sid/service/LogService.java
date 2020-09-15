package org.sid.service;

import org.sid.model.Log;
import org.sid.model.Summary;

import java.util.List;

public interface LogService {
    Summary findSummaryByCourseId(Long courseId);

    Log saveOrUpdate(Log log);

    Summary saveOrUpdate(Summary summary);

    List<Summary> findPopularCourses();
}