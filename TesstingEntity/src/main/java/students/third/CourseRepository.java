package students.third;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    // Филтриране по преподавател (teacherId)
    @Query("SELECT c FROM Course c WHERE c.teacher.id = :teacherId")
    List<Course> findCoursesByTeacherId(@Param("teacherId") Long teacherId);

    // Филтриране по тип курс (ако имаш поле "type" в Course)
    @Query("SELECT c FROM Course c WHERE c.description LIKE %:type%")
    List<Course> findCoursesByType(@Param("type") String type);

    // Филтриране по преподавател и тип курс едновременно
    @Query("SELECT c FROM Course c WHERE c.teacher.id = :teacherId AND c.description LIKE %:type%")
    List<Course> findCoursesByTeacherAndType(@Param("teacherId") Long teacherId, @Param("type") String type);
}
