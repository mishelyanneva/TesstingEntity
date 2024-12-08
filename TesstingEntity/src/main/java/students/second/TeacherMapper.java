package students.second;

import students.third.Course;
import java.util.stream.Collectors;

public class TeacherMapper {

    public static TeacherDTO toDTO(Teacher teacher) {
        return new TeacherDTO(
                teacher.getId(),
                teacher.getName(),
                teacher.getSpecialty(),
                teacher.getCourses() != null ?
                        teacher.getCourses().stream().map(Course::getId).collect(Collectors.toList()) : null
        );
    }

    public static Teacher toEntity(TeacherDTO teacherDTO, List<Course> courses) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherDTO.getId());
        teacher.setName(teacherDTO.getName());
        teacher.setSpecialty(teacherDTO.getSpecialty());
        teacher.setCourses(courses);
        return teacher;
    }
}
