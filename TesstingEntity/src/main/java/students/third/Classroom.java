package third.student;

import jakarta.persistence.*;



import java.util.List;

@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hallNumber;
    private int capacity;

    @OneToMany(mappedBy = "classroom", cascade = CascadeType.ALL)
    private List<Course> courses;

    // Default constructor
    public Classroom() {
    }

    // Parameterized constructor
    public Classroom(String hallNumber, int capacity) {
        this.hallNumber = hallNumber;
        this.capacity = capacity;
    }

    // Parameterized constructor with all fields
    public Classroom(Long id, String hallNumber, int capacity, List<Course> courses) {
        this.id = id;
        this.hallNumber = hallNumber;
        this.capacity = capacity;
        this.courses = courses;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(String hallNumber) {
        this.hallNumber = hallNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // toString() method
    @Override
    public String toString() {
        return "Classroom{" +
                "id=" + id +
                ", hallNumber='" + hallNumber + '\'' +
                ", capacity=" + capacity +
                ", courses=" + (courses != null ? courses.size() : 0) +
                '}';
    }
}
