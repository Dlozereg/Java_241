package org.knit.lab21.task26;

public class LegalDep extends Solver{
    @Override
    protected boolean canSolve(Problem problem) {
        return problem.getDifficulty() < 50;
    }

    @Override
    protected void solve(Problem problem) {
        System.out.println("Problem solved by Legal Department");
    }
}
