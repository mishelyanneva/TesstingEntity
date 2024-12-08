package third.student;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import third.student.ClassroomDTO;
import third.student.ClassroomMapper;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/api/classrooms")
@Tag(name = "Classrooms", description = "API for managing classrooms")
public class ClassroomController {
    private final ClassroomService classroomService;
    private final ClassroomMapper classroomMapper;

    @Autowired
    public ClassroomController(ClassroomService classroomService, ClassroomMapper classroomMapper) {
        this.classroomService = classroomService;
        this.classroomMapper = classroomMapper;
    }

    @GetMapping
    @Operation(summary = "Get all classrooms", description = "Retrieve a list of all classrooms")
    public List<ClassroomDTO> getAllClassrooms() {
        return classroomService.getAllClassrooms().stream()
                .map(classroomMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PostMapping
    @Operation(summary = "Create a new classroom", description = "Create a new classroom with given details")
    public ClassroomDTO createClassroom(@RequestBody ClassroomDTO classroomDTO) {
        Classroom classroom = classroomMapper.toEntity(classroomDTO);
        Classroom savedClassroom = classroomService.saveClassroom(classroom);
        return classroomMapper.toDTO(savedClassroom);
    }
}
