package students.third;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Филтриране по преподавател
    @GetMapping("/by-teacher/{teacherId}")
    public List<CourseDTO> getCoursesByTeacher(@PathVariable Long teacherId) {
        return courseService.getCoursesByTeacherId(teacherId)
                .stream()
                .map(course -> new CourseDTO(
                        course.getId(),
                        course.getName(),
                        course.getDescription(),
                        course.getTeacher().getId()))
                .toList();
    }

    // Филтриране по тип курс
    @GetMapping("/by-type")
    public List<CourseDTO> getCoursesByType(@RequestParam String type) {
        return courseService.getCoursesByType(type)
                .stream()
                .map(course -> new CourseDTO(
                        course.getId(),
                        course.getName(),
                        course.getDescription(),
                        course.getTeacher().getId()))
                .toList();
    }

    // Филтриране по преподавател и тип курс
    @GetMapping("/by-teacher-and-type")
    public List<CourseDTO> getCoursesByTeacherAndType(@RequestParam Long teacherId, @RequestParam String type) {
        return courseService.getCoursesByTeacherAndType(teacherId, type)
                .stream()
                .map(course -> new CourseDTO(
                        course.getId(),
                        course.getName(),
                        course.getDescription(),
                        course.getTeacher().getId()))
                .toList();
    }
}
