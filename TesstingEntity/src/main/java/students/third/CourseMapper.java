package students.third;

import org.springframework.stereotype.Component;
import students.second.Teacher;

@Component
public class CourseMapper {

    public CourseDTO toDTO(Course course) {
        return new CourseDTO(
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getTeacher() != null ? course.getTeacher().getId() : null
        );
    }
}
