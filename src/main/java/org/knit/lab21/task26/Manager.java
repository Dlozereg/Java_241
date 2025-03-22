package org.knit.lab21.task26;

public class Manager extends Solver{
    @Override
    protected boolean canSolve(Problem problem) {
        return problem.getDifficulty() < 30;
    }

    @Override
    protected void solve(Problem problem) {
        System.out.println("Problem solved by manager");
    }
}
