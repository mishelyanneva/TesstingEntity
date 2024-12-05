import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import third.student.Classroom;
import third.student.ClassroomDTO;
import third.student.ClassroomRepository;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class ClassroomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ClassroomRepository classroomRepository;

    @Test
    public void testCreateClassroom() throws Exception {
        // Arrange: Prepare the DTO for the request
        ClassroomDTO classroomDTO = new ClassroomDTO();
        classroomDTO.setHallNumber("Hall A");
        classroomDTO.setCapacity(50);

        // Act & Assert: Perform the POST request and validate the response
        mockMvc.perform(post("/api/classrooms")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(classroomDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hallNumber", is("Hall A")))
                .andExpect(jsonPath("$.capacity", is(50)));

        // Clean up the test data
        classroomRepository.deleteAll();
    }

    @Test
    public void testFindClassroomByHallNumber() throws Exception {
        // Arrange: Save a classroom in the repository
        Classroom classroom = new Classroom("Hall B", 30);
        classroomRepository.save(classroom);

        // Act & Assert: Perform the GET request with the hall number parameter and validate the response
        mockMvc.perform(get("/api/classrooms/by-hall-number")
                        .param("hallNumber", "Hall B"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.hallNumber", is("Hall B")))
                .andExpect(jsonPath("$.capacity", is(30)));

        // Clean up the test data
        classroomRepository.deleteAll();
    }

    @Test
    public void testGetAllClassrooms() throws Exception {
        // Arrange: Save multiple classrooms in the repository
        Classroom classroom1 = new Classroom("Hall C", 25);
        Classroom classroom2 = new Classroom("Hall D", 40);
        classroomRepository.save(classroom1);
        classroomRepository.save(classroom2);

        // Act & Assert: Perform the GET request and validate the response
        mockMvc.perform(get("/api/classrooms"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].hallNumber", is("Hall C")))
                .andExpect(jsonPath("$[0].capacity", is(25)))
                .andExpect(jsonPath("$[1].hallNumber", is("Hall D")))
                .andExpect(jsonPath("$[1].capacity", is(40)));

        // Clean up the test data
        classroomRepository.deleteAll();
    }

    @Test
    public void testGetNonExistentClassroomByHallNumber() throws Exception {
        // Act & Assert: Perform the GET request for a non-existent hall number
        mockMvc.perform(get("/api/classrooms/by-hall-number")
                        .param("hallNumber", "NonExistentHall"))
                .andExpect(status().isNotFound());
    }
}