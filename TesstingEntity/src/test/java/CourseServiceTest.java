package students.third;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import students.second.Teacher;
import students.third.Course;
import students.third.CourseRepository;
import students.third.CourseService;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService;

    @Test
    public void testGetAllCourses() {
        // Arrange
        Course course1 = new Course(1L, "Java Basics", "Intro to Java", 5, null);
        Course course2 = new Course(2L, "Advanced Java", "Deep dive into Java", 10, null);
        when(courseRepository.findAll()).thenReturn(List.of(course1, course2));

        // Act
        List<Course> courses = courseService.getAllCourses();

        // Assert
        assertThat(courses).hasSize(2);
        assertThat(courses.get(0).getName()).isEqualTo("Java Basics");
    }

    @Test
    public void testGetCourseById() {
        // Arrange
        Course course = new Course(1L, "Java Basics", "Intro to Java", 5, null);
        when(courseRepository.findById(1L)).thenReturn(Optional.of(course));

        // Act
        Course result = courseService.getCourseById(1L);

        // Assert
        assertThat(result.getName()).isEqualTo("Java Basics");
        verify(courseRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreateCourse() {
        // Arrange
        Course course = new Course(null, "Java Basics", "Intro to Java", 5, null);
        when(courseRepository.save(course)).thenReturn(new Course(1L, "Java Basics", "Intro to Java", 5, null));

        // Act
        Course createdCourse = courseService.createCourse(course);

        // Assert
        assertThat(createdCourse.getId()).isEqualTo(1L);
        verify(courseRepository, times(1)).save(course);
    }

    @Test
    public void testDeleteCourse() {
        // Arrange
        Long courseId = 1L;

        // Act
        courseService.deleteCourse(courseId);

        // Assert
        verify(courseRepository, times(1)).deleteById(courseId);
    }
}
