package com.example.demo.controller.category;

import com.example.demo.model.category.Category;
import com.example.demo.model.question.Question;
import com.example.demo.model.quiz.Quiz;
import com.example.demo.service.category.CategoryService;
import com.example.demo.service.question.QuestionService;
import com.example.demo.service.quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private QuizService quizService;

    @Autowired
    private QuestionService questionService;

    @GetMapping("/admin/categories")
    public List<Category> categories() {return categoryService.findAllCategory();}

    @GetMapping("/admin/categories/{id}")
    public Category findCategoryById(@PathVariable(value = "id") Long id) { return categoryService.findCategoryById(id); }

    @PostMapping("/admin/categories")
    public void saveCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    @PutMapping("/admin/categories/{id}")
    public void updateStudy(@PathVariable(value = "id") Long id, @RequestBody Category category) {
        category.setId(id);
        categoryService.saveCategory(category);
    }

    @DeleteMapping("/admin/categories/{id}")
    public Category deleteStudy(@PathVariable(value = "id") Long id) {
        Category category = categoryService.findCategoryById(id);
        List<Question> categoryQuestions = category.getQuestions();
//        for (Question question: categoryQuestions) {
//            question.setCategory(null);
//            questionService.saveQuestion(question);
//        }
        List<Quiz> categoryQuizzes = category.getQuizzes();
//        for (Quiz quiz: categoryQuizzes) {
//            quiz.setCategory(null);
//            quizService.saveQuiz(quiz);
//        }
        if (categoryQuestions.size() != 0) {
            return null;
        }
        if (categoryQuizzes.size() != 0) {
            return null;
        }
        categoryService.removeCategory(id);
        return category;
    }
}
