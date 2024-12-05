package third.student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    // Find classrooms with a capacity greater than or equal to a given value
    @Query("SELECT c FROM Classroom c WHERE c.capacity >= :capacity")
    List<Classroom> findByMinimumCapacity(int capacity);

    // Find classrooms with a specific hall number
    @Query("SELECT c FROM Classroom c WHERE c.hallNumber = :hallNumber")
    Classroom findByHallNumber(String hallNumber);

    // Example: Custom query for classrooms with no courses assigned
    @Query("SELECT c FROM Classroom c WHERE c.courses IS EMPTY")
    List<Classroom> findEmptyClassrooms();
}

