package students.second;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<TeacherDTO> getAllTeachers() {
        return teacherService.getAllTeachers().stream().map(TeacherMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public Optional<TeacherDTO> getTeacherById(@PathVariable Long id) {
        return teacherService.getTeacherById(id).map(TeacherMapper::toDTO);
    }

    @PostMapping
    public TeacherDTO createTeacher(@RequestBody TeacherDTO teacherDTO) {
        Teacher teacher = TeacherMapper.toEntity(teacherDTO, null);
        return TeacherMapper.toDTO(teacherService.saveTeacher(teacher));
    }

    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }
}
