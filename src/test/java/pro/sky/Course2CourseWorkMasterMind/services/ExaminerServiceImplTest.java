package pro.sky.Course2CourseWorkMasterMind.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.Course2CourseWorkMasterMind.exceptions.IncorrectArgumentException;
import pro.sky.Course2CourseWorkMasterMind.model.Question;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl out;

    private Set<Question> javaQuestionSet;

    @BeforeEach
    public void initSet() {
        javaQuestionSet = new HashSet<>(Arrays.asList(new Question("Что такое цикл?",
                        "Конструкция кода, которая повторяет одно и то же действие несколько " +
                                "столько, сколько нам потребуется) раз"),
                new Question("Что такое переменная?", "Это ячейка в памяти компьютера," +
                        " которой можно присвоить имя и в которой можно хранить данные"),
                new Question("Что такое инициализация?", "Присваивание какого-то значения" +
                        " переменной")));
    }

    @Test
    void getQuestionsWithIncorrectAmount() {
        //Начало теста
        assertThrows(IncorrectArgumentException.class, () -> out.getQuestions(15));
    }
    @Test
    void getQuestions() {
        //Подготовко ожидаемого результата
        when(javaQuestionService.getAll()).thenReturn(javaQuestionSet);
        when(javaQuestionService.getRandomQuestion()).thenReturn(javaQuestionSet.iterator().next());
        Collection<Question> result = out.getQuestions(1);

        //Начало теста
        assertTrue(result.contains(javaQuestionSet.iterator().next()));
        verify(javaQuestionService).getRandomQuestion();
    }
}