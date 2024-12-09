package students.third;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCoursesByTeacherId(Long teacherId) {
        return courseRepository.findCoursesByTeacherId(teacherId);
    }

    public List<Course> getCoursesByType(String type) {
        return courseRepository.findCoursesByType(type);
    }

    public List<Course> getCoursesByTeacherAndType(Long teacherId, String type) {
        return courseRepository.findCoursesByTeacherAndType(teacherId, type);
    }
}
