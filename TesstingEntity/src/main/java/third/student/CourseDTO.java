package third.student;

public class CourseDTO {
        private Long id;
        private String name;
        private String description;
        private int creditPoints;

    public CourseDTO(Long id, String name, String description, int creditPoints) {
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
}
