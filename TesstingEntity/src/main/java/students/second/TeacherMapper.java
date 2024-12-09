package students.second;

import org.springframework.stereotype.Component;
import students.third.Course;

import java.util.stream.Collectors;

@Component
public class TeacherMapper {

    public TeacherDTO toDTO(Teacher teacher) {
        return new TeacherDTO(
                teacher.getId(),
                teacher.getName(),
                teacher.getCourses() != null ? teacher.getCourses()
                        .stream()
                        .map(Course::getId)
                        .collect(Collectors.toList()) : null
        );
    }
}
