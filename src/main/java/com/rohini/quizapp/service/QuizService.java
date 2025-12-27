package com.rohini.quizapp.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.rohini.quizapp.model.Question;
import com.rohini.quizapp.model.Quiz;
import com.rohini.quizapp.repository.QuestionRepository;
import com.rohini.quizapp.repository.QuizRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuizService {
	
	final private QuizRepository quizRepository;
	final private QuestionRepository questionRepository;
	
	public ResponseEntity<String> createQuiz(String category, Integer numQ, String title) {
		try {
			
			
			List<Question> questions = questionRepository.findRandomQuestionsByCategory(category, numQ);
			System.out.println(questions);
			Quiz quiz = new Quiz();
			quiz.setTitle(title);
			quiz.setId(numQ);
			quiz.setQuestion(questions);
			quizRepository.save(quiz);
			
			return new ResponseEntity<>("success",HttpStatus.CREATED);
			
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
		}
	}

}
