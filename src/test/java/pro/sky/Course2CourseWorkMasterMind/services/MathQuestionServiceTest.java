package pro.sky.Course2CourseWorkMasterMind.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Course2CourseWorkMasterMind.exceptions.NotAllowedException;
import pro.sky.Course2CourseWorkMasterMind.model.Question;
import pro.sky.Course2CourseWorkMasterMind.repisitory.interfaces.QuestionRepository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {

    @Mock
    private QuestionRepository questionRepository;

    @InjectMocks
    private MathQuestionService out;

    private Set<Question> questionSet;

    @BeforeEach
    public void initSet() {
        questionSet = new HashSet<>(Arrays.asList(new Question("Как еще называют периметр круга?",
                        "Окружность"),
                new Question("Что такое Пи, рациональное или иррациональное число?",
                        "Пи — иррациональное число."),
                new Question("Изображение, которое также можно увидеть в трех измерениях?",
                        "Голограмма")));
    }

    @Test
    void addWithStrnings() {
        //Начало теста
        assertThrows(NotAllowedException.class, () -> out.add(questionSet.iterator().next()));
    }

    @Test
    void addWithQuestion() {
        //Начало теста
        assertThrows(NotAllowedException.class, () -> out.add(questionSet.iterator().next()));
    }

    @Test
    void removeWithStrings() {
        //Начало теста
        assertThrows(NotAllowedException.class, () -> out.remove(questionSet.iterator().next()));
    }

    @Test
    void RemoveWithQuestion() {
        //Начало теста
        assertThrows(NotAllowedException.class, () -> out.remove(questionSet.iterator().next()));
    }

    @Test
    void getAll() {
        //Начало теста
        assertThrows(NotAllowedException.class, () -> out.getAll());
    }
}