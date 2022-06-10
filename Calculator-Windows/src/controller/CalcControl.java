package controller;

import view.CalculatorGUI;
import model.Calculator;

/*
 * @author Alex
 */
public class CalcControl {

    private CalculatorGUI calcGUI;           // é uma cópia da variável de referência do objeto da Classe CalculatorGUI para manipular os componentes gráficos da Calculadora
    private Calculator calc;                // é uma cópia da variável de referência do objeto da classe Calculator 

    public void takeReferenceVariable(CalculatorGUI calcGUI) {
        this.calcGUI = calcGUI;  // salva a variável de referência e a torna global
    }

    public void takeReferenceVariable(Calculator calc) {
        this.calc = calc;  // salva a variável de referência e a torna global
    }

    public CalcControl() {
    }
}
