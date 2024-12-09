package students.second;

import org.springframework.web.bind.annotation.*;
import students.third.CourseService;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    private final CourseService courseService;

    public TeacherController(TeacherService teacherService, CourseService courseService) {
        this.teacherService = teacherService;
        this.courseService = courseService;
    }

    @GetMapping("/{teacherId}/courses")
    public List<?> getCoursesByTeacher(@PathVariable Long teacherId) {
        return courseService.getCoursesByTeacher(teacherId);
    }
}
