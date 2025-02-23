package pro.sky.Course2CourseWorkMasterMind.controllers;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.Course2CourseWorkMasterMind.exceptions.NotAllowedException;
import pro.sky.Course2CourseWorkMasterMind.model.Question;
import pro.sky.Course2CourseWorkMasterMind.services.Interfaces.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/math")
public class MathQuestionController {
    private final QuestionService service;

    public MathQuestionController(@Qualifier("mathQuestionService") QuestionService service) {
        this.service = service;
    }

    @ExceptionHandler(NotAllowedException.class)
    public ResponseEntity<String> notFoundHandle(NotAllowedException e) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(e.getMessage()
                + " " + HttpStatus.METHOD_NOT_ALLOWED);
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam(value = "question", required = false) String question,
                                @RequestParam(value = "answer", required = false) String answer) {
        return service.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam(value = "question", required = false) String question,
                                   @RequestParam(value = "answer", required = false) String answer) {
        return service.remove(question, answer);
    }

    @GetMapping
    public Collection<Question> getQuestions() {
        return service.getAll();
    }
}
