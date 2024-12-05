package third.student;

import jakarta.persistence.*;

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private int creditPoints;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    // Default constructor
    public Course() {
    }

    // Parameterized constructor
    public Course(String name, String description, int creditPoints) {
        this.name = name;
        this.description = description;
        this.creditPoints = creditPoints;
    }

    // Parameterized constructor with all fields
    public Course(Long id, String name, String description, int creditPoints, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creditPoints = creditPoints;
        this.classroom = classroom;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    // toString() method
    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creditPoints=" + creditPoints +
                ", classroom=" + (classroom != null ? classroom.getId() : null) +
                '}';
    }
}
