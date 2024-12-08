package students.third;

public class CourseDTO {
    private Long id;
    private String name;
    private String description;
    private int creditPoints;
    private TeacherDTO teacherDTO; // Add a field for TeacherDTO

    public CourseDTO(Long id, String name, String description, int creditPoints, TeacherDTO teacherDTO) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creditPoints = creditPoints;
        this.teacherDTO = teacherDTO;
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

    public TeacherDTO getTeacherDTO() { // Getter for TeacherDTO
        return teacherDTO;
    }

    public void setTeacherDTO(TeacherDTO teacherDTO) { // Setter for TeacherDTO
        this.teacherDTO = teacherDTO;
    }
}