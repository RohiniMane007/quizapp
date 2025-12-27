package com.rohini.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rohini.quizapp.model.Question;
import com.rohini.quizapp.repository.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {
	
	final private QuestionRepository questionRepository;
	
	public List<Question> getAllQuestion() {
		try {
			return questionRepository.findAll();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
		
	}
	
	public List<Question> getQuestionByCategory(String category) {
		try {
			return questionRepository.findByCategory(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
		
	}
	
	
	public String addQuestion(Question question) {
		try {
			questionRepository.save(question);
			return "success";
		} catch (Exception e) {
			return "fail";
		}
		
	}


}
