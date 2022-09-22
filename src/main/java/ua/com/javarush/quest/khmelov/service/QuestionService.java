package ua.com.javarush.quest.khmelov.service;

import ua.com.javarush.quest.khmelov.dto.ui.AnswerDto;
import ua.com.javarush.quest.khmelov.dto.ui.QuestionDto;
import ua.com.javarush.quest.khmelov.entity.Question;
import ua.com.javarush.quest.khmelov.mapping.Mapper;
import ua.com.javarush.quest.khmelov.repository.QuestionRepository;
import ua.com.javarush.quest.khmelov.repository.Repository;

import java.util.List;
import java.util.Optional;

public enum QuestionService {

    INSTANCE;

    private final Repository<Question> questRepository = QuestionRepository.get();

    public Optional<QuestionDto> get(long id) {
        Question question = questRepository.get(id);
        //here can be service for answers, but it found in entity
        List<AnswerDto> answersDto = question.getAnswers().stream()
                .map(Mapper.answer::get)
                .map(Optional::orElseThrow)
                .toList();
        Optional<QuestionDto> questionDto = Mapper.question.get(question);
        questionDto.orElseThrow().setAnswers(answersDto);
        return questionDto;
    }
}
