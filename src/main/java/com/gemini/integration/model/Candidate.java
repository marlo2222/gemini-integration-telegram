package com.gemini.integration.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Candidate {
    public List<Content> candidates;
    public PromptFeedback promptFeedback;


    public class Content {
        public ContentDetail content;
        public String finishReason;
        public int index;
        public List<SafetyRating> safetyRatings;

    }

    public class ContentDetail {
        public List<Part> parts;
        public String role;

    }

    public class Part {
        public String text;

    }

    public class SafetyRating {
        public String category;
        public String probability;

    }

    public class PromptFeedback {
        public List<SafetyRating> safetyRatings;

    }

}