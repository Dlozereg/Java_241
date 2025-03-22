package org.knit.lab21.task26;

public class Task26 {
    public static void execute(){
        Solver callCentre = new CallCentre();
        Solver manager = new Manager();
        Solver legalDep = new LegalDep();
        Solver elPresidento = new ElPresidento();


        callCentre.setNextSolver(manager);
        manager.setNextSolver(legalDep);
        legalDep.setNextSolver(elPresidento);


        callCentre.processRequest(new Problem(10, "easy"));
        callCentre.processRequest(new Problem(22, "medium"));
        callCentre.processRequest(new Problem(33, "hard"));
        callCentre.processRequest(new Problem(55, "very hard"));
        callCentre.processRequest(new Problem(100, "too hard"));
    }
}
