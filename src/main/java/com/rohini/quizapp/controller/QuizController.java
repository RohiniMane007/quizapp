package com.rohini.quizapp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohini.quizapp.model.QuestionWrapper;
import com.rohini.quizapp.model.Response;
import com.rohini.quizapp.service.QuizService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("quiz")
@RequiredArgsConstructor
public class QuizController {
	
	final private QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title ) {
		return quizService.createQuiz(category, numQ, title);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
		
		return quizService.getQuizQuestions(id);
		
	}
	
	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
		
		return quizService.calculateResult(id,responses);
		
	}
	
}
