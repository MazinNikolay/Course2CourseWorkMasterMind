package pro.sky.Course2CourseWorkMasterMind.services.Interfaces;

import pro.sky.Course2CourseWorkMasterMind.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
