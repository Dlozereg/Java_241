package org.knit.lab21.task26;

public class ElPresidento extends Solver{
    @Override
    protected boolean canSolve(Problem problem) {
        return problem.getDifficulty() < 100;
    }

    @Override
    protected void solve(Problem problem) {
        System.out.println("Problem solved by El Presidento");
    }
}
