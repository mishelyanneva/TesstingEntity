package third.student;

import students.second.Teacher;

public class CourseMapper {
    public static CourseDTO toDTO(Course course) {
        return new CourseDTO(
                course.getId(),
                course.getName(),
                course.getDescription(),
                course.getCreditPoints(),
                course.getClassroom() != null ? course.getClassroom().getId() : null,
                course.getTeacher() != null ? course.getTeacher().getId() : null
        );
    }

    public static Course toEntity(CourseDTO courseDTO, Classroom classroom, Teacher teacher) {
        Course course = new Course();
        course.setId(courseDTO.getId());
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setCreditPoints(courseDTO.getCreditPoints());
        course.setClassroom(classroom);
        course.setTeacher(teacher);
        return course;
    }
}
