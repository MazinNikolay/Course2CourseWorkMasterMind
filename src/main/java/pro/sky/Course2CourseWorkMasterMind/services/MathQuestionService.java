package pro.sky.Course2CourseWorkMasterMind.services;

import org.springframework.stereotype.Service;
import pro.sky.Course2CourseWorkMasterMind.exceptions.NotAllowedException;
import pro.sky.Course2CourseWorkMasterMind.model.Question;
import pro.sky.Course2CourseWorkMasterMind.repisitory.interfaces.QuestionRepository;
import pro.sky.Course2CourseWorkMasterMind.services.Interfaces.QuestionService;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService {
    private final QuestionRepository repository;

    public MathQuestionService(QuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Question add(String question, String answer) {
        throw new NotAllowedException();
    }

    @Override
    public Question add(Question question) {
        throw new NotAllowedException();
    }

    @Override
    public Question remove(Question question) {
        throw new NotAllowedException();
    }

    @Override
    public Question remove(String question, String answer) {
        throw new NotAllowedException();
    }

    @Override
    public Collection<Question> getAll() {
        throw new NotAllowedException();
    }

    @Override
    public Question getRandomQuestion() {
        Random rnd = new Random();
        int firstValue = rnd.nextInt(50);
        int secondValue = rnd.nextInt(50);
        int actionValue = rnd.nextInt(4);
        String question = "";
        int res = 0;
        char action = ' ';
        switch (actionValue) {
            case 0: {
                action = '+';
                res = firstValue + secondValue;
                break;
            }
            case 1: {
                action = '-';
                res = firstValue - secondValue;
                break;
            }
            case 2: {
                action = '*';
                res = firstValue * secondValue;
                break;
            }
            case 3: {
                action = '/';
                res = firstValue / secondValue;
                break;
            }
        }
        question = "Какой результат у выражения: " + String.valueOf(firstValue) + String.valueOf(action)
                + String.valueOf(secondValue);
        System.out.printf("%s%s%s=%s", firstValue, action, secondValue, res);
        return new Question(question, String.valueOf(res));
    }
}
