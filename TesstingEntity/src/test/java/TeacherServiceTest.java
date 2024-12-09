package students.second;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import students.second.Teacher;
import students.second.TeacherRepository;
import students.second.TeacherService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TeacherServiceTest {

    @Mock
    private TeacherRepository teacherRepository;

    @InjectMocks
    private TeacherService teacherService;

    @Test
    public void testGetAllTeachers() {
        // Arrange
        Teacher teacher1 = new Teacher(1L, "John Doe", "Computer Science");
        Teacher teacher2 = new Teacher(2L, "Jane Smith", "Mathematics");
        when(teacherRepository.findAll()).thenReturn(List.of(teacher1, teacher2));

        // Act
        List<Teacher> teachers = teacherService.getAllTeachers();

        // Assert
        assertThat(teachers).hasSize(2);
        assertThat(teachers.get(0).getName()).isEqualTo("John Doe");
    }

    @Test
    public void testGetTeacherById() {
        // Arrange
        Teacher teacher = new Teacher(1L, "John Doe", "Computer Science");
        when(teacherRepository.findById(1L)).thenReturn(Optional.of(teacher));

        // Act
        Teacher result = teacherService.getTeacherById(1L);

        // Assert
        assertThat(result.getName()).isEqualTo("John Doe");
        verify(teacherRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreateTeacher() {
        // Arrange
        Teacher teacher = new Teacher(null, "John Doe", "Computer Science");
        when(teacherRepository.save(teacher)).thenReturn(new Teacher(1L, "John Doe", "Computer Science"));

        // Act
        Teacher createdTeacher = teacherService.createTeacher(teacher);

        // Assert
        assertThat(createdTeacher.getId()).isEqualTo(1L);
        verify(teacherRepository, times(1)).save(teacher);
    }

    @Test
    public void testDeleteTeacher() {
        // Arrange
        Long teacherId = 1L;

        // Act
        teacherService.deleteTeacher(teacherId);

        // Assert
        verify(teacherRepository, times(1)).deleteById(teacherId);
    }
}
