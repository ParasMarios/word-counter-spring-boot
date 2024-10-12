package com.mparaske.WordCounter.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/word-counter")
public class WordCounterController {

    @PostMapping("/count")
    public Map<String, Integer> countTextMetrics(@RequestBody String text) {
        Map<String, Integer> response = new HashMap<>();

        response.put("wordCount", calculateWordCount(text));
        response.put("charCount", calculateCharacterCount(text));
        response.put("paragraphCount", calculateParagraphCount(text));

        return response;
    }

    // Method to count words
    private int calculateWordCount(String text) {
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    // Method to count characters
    private int calculateCharacterCount(String text) {
        return text.replaceAll("\\s+", "").length();
    }

    // Method to count paragraphs
    private int calculateParagraphCount(String text) {
        String[] paragraphs = text.trim().split("\\n+");
        return paragraphs.length;
    }
}


