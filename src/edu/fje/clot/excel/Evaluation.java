package edu.fje.clot.excel;

/**
 *
 * @author m0r
 */
public class Evaluation {
    private String _name;
    private float _evaluation;
    
    public Evaluation(String name, float evaluation) {
        _name = name;
        _evaluation = evaluation;
    }
    
    public String getName() {
        return _name;
    }
    
    public float getEvaluation() {
        return _evaluation;
    }
}
