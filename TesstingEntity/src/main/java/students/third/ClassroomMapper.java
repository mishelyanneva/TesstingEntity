package third.student;
import org.springframework.stereotype.Component;
import third.student.Classroom;
import third.student.ClassroomDTO;
import third.student.CourseDTO;

import java.util.stream.Collectors;

public class ClassroomMapper {
    public ClassroomDTO toDTO(Classroom classroom) {
        ClassroomDTO dto = new ClassroomDTO();
        dto.setId(classroom.getId());
        dto.setHallNumber(classroom.getHallNumber());
        dto.setCapacity(classroom.getCapacity());
        if (classroom.getCourses() != null) {
            dto.setCourses(classroom.getCourses().stream()
                    .map(course -> new CourseDTO(course.getId(), course.getName(), course.getDescription(), course.getCreditPoints()))
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public Classroom toEntity(ClassroomDTO dto) {
        Classroom classroom = new Classroom();
        classroom.setId(dto.getId());
        classroom.setHallNumber(dto.getHallNumber());
        classroom.setCapacity(dto.getCapacity());
        // Handle courses mapping as needed
        return classroom;
    }
}
