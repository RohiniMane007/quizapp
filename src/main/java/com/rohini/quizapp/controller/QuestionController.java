package com.rohini.quizapp.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rohini.quizapp.model.Question;
import com.rohini.quizapp.service.QuestionService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("question")
@RequiredArgsConstructor
public class QuestionController {
	
	final private QuestionService questionService;
	
	@GetMapping("all-ques")
	public ResponseEntity<List<Question>> getAllQuestion() {
		return new ResponseEntity<>(
				questionService.getAllQuestion(), HttpStatus.OK);
	}
	
	@GetMapping("category/{category}")
	public ResponseEntity<List<Question>> getAllQuestion(@PathVariable String category) {
		return new ResponseEntity<> (questionService.getQuestionByCategory(category), HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity<String> postMethodName(@RequestBody Question question) {
		return new ResponseEntity<> (questionService.addQuestion(question), HttpStatus.CREATED);
	}
	

}
