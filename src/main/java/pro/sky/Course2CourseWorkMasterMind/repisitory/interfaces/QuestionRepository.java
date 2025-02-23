package pro.sky.Course2CourseWorkMasterMind.repisitory.interfaces;

import pro.sky.Course2CourseWorkMasterMind.model.Question;

import java.util.Collection;

public interface QuestionRepository {

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
