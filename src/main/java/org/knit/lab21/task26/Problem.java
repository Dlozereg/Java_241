package org.knit.lab21.task26;

public class Problem {
    int difficulty;
    String description;

    public Problem(int difficulty, String description) {
        this.difficulty = difficulty;
        this.description = description;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
