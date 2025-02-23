package pro.sky.Course2CourseWorkMasterMind.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pro.sky.Course2CourseWorkMasterMind.exceptions.IncorrectArgumentException;
import pro.sky.Course2CourseWorkMasterMind.model.Question;
import pro.sky.Course2CourseWorkMasterMind.services.Interfaces.ExaminerService;
import pro.sky.Course2CourseWorkMasterMind.services.Interfaces.QuestionService;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final List<QuestionService> serviceList;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.serviceList = new ArrayList<>();
        this.serviceList.add(javaQuestionService);
        this.serviceList.add(mathQuestionService);
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        isCorrectAmount(amount);
        Set<Question> resultQuestions = new HashSet<>(amount);
        while (resultQuestions.size() < amount) {
            if (amount > 1 && resultQuestions.size() < amount - 1) {
                resultQuestions.add(serviceList.get(0).getRandomQuestion());
                resultQuestions.add(serviceList.get(1).getRandomQuestion());
            } else
                resultQuestions.add(serviceList.get(0).getRandomQuestion());
        }
        return resultQuestions;
    }

    private void isCorrectAmount(int amount) {
        int totalSize = serviceList.get(0).getAll().size() * 2;
        if (amount > totalSize) {
            throw new IncorrectArgumentException("Количество запрашиваемых воросов превышет количество" +
                    " вопросов в базе");
        }
    }
}
