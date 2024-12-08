package third.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses() {
        return courseService.getAllCourses().stream().map(CourseMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public Optional<CourseDTO> getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id).map(CourseMapper::toDTO);
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO) {
        // Add logic to fetch Classroom and Teacher by ID if needed
        return CourseMapper.toDTO(courseService.saveCourse(CourseMapper.toEntity(courseDTO, null, null)));
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
    }
}
