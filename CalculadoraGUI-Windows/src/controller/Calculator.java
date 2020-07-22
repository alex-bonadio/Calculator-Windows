package controller;

import view.Start;
import java.awt.event.KeyEvent;

/**
 * @author Alex Bonadio Code Lines: 1714 Classe: 1135 Methods: 79
 */
public class Calculator {

    private short operation = 0;             //  1 adição 2 subtração 3 multiplicacao 4 divisão 5 potenciacao 6 radiciação 7 a 10 porcentagem
    private short accOperation = 0;          //  mantém salvo na memória a última operação aritmética realizada para ser usada no acumulador
    private double number = 0.0;             // armazena o valor digitado pelo usuário e também o resultado de cada operação aritmética
    private double aux = 0.0;                // armazena e mantém salvo na memória o 2º operando para fazer a acumulação 
    private short countOpClick = 0;          // armazena a quantidade de vezes que o usuário clicou em um dos botões das operações aritméticas (nenhuma vez, 1 vez)
    private short equalsClick = 0;           // armazena a quantidade de vezes que o usuário clicou no sinal de = (nenhuma vez, 1 vez)
    private boolean numpadTyped = false;     // muda para true quando o usuário clicar no teclado numérico
    private boolean firstOpTyped = false;    // muda para true quando o usuário clicar a 1º vez em um dos botões de operações aritiméticas
    private boolean secondOpTyped = false;   // muda para true quando o usuário clicar a 2º vez em um dos botões de operações aritiméticas
    private String mathExpression = "";      // é a string que armazena o que o usuário está fazendo na calculadora, para exibir no JLabel abaixo do Display principal
    private Start start;                     // é uma cópia da variável de referência do objeto da Classe Start para podermos interagir com os componente gráficos da Calculadora

    public Calculator() {
    }

    // método recebe a cópia da variável de referência do objeto start instanciado na classe Start
    public void sendReferenceVariable(Start start) {
        this.start = start;  // salva a variável de referência e a torna global
    }

    // método valida a entrada do usuário, permitindo apenas números e o char E do euler 
    public boolean validateNumber() {
        boolean check = true;  // se a entrada está correta, ou seja, possui apenas números ou o E, então é true
        if (!start.inputText.getText().isEmpty()) {
            //    int i = start.inputText.getText().length() - 1;
            if (start.inputText.getText().contains("Impossible")
                    || start.inputText.getText().contains("Exceed")) {
                cleanVariables(2);
                cleanVariables(3);
                writeZero();
                check = false;  // false significa que não passou no teste, tem caracteres inválidos
            } else {
                // start.inputText.getText().matches("^[-0.0-9.0]*$");
                check = true;  // true significa que passou na validação, não tem caracteres inválidos
            }
        }
        return check;
    }

    // método limpa as variáveis de instância de acordo com o level escolhido
    public void cleanVariables(int level) {
        switch (level) {
            case 1:
                mathExpression = "";
                start.labelExp.setText("");
                break;
            case 2:
                start.labelExp.setText("");
                mathExpression = " ";
                number = 0;
                operation = 0;
                countOpClick = 0;
                equalsClick = 0;
                firstOpTyped = false;
                secondOpTyped = false;
                numpadTyped = false;
                focus();
                break;
            case 3:
                start.inputText.setText("");
                focus();
                break;
            case 4:
                accOperation = 0;
                aux = 0;
                focus();
                break;
            default:
                break;
        }
    }

    // método faz o direcionamento para os métodos de cálculo de acordo com a escolha do usuário
    public void arithmetic() {
        boolean check = validateNumber();
        if (check == true) {  // se o número digitado está OK e não está vazio
            switch (operation) { // operação aritmética Simples escolhida pelo usuário
                case 1:  // caso 1 Adição Simples, exemplo: 2 + 2 = 4
                    simpleSum();
                    break;
                case 2:  // caso 2 Subtração Simples, exemplo: 2 - 2 = 0
                    simpleSub();
                    break;
                case 3:
                    simpleMult();
                    break;
                case 4:
                    simpleDiv();
                    break;
                case 5:
                    simplePow();
                    break;
                case 6:
                    simpleRoot();
                    break;
                case 7:
                    percentCalc();  // caso 7, chama o método da porcentagem
                    break;
                case 8:
                    percentCalc();
                    break;
                case 9:
                    percentCalc();
                    break;
                case 10:
                    percentCalc();
                    break;
            }
        } else {
            cleanVariables(2);
            cleanVariables(3);
        }
    }

    public void equalsAction() {
        boolean check = validateNumber();
        if (check == true) {
            maxNumber(number);
            arithmetic();
            formatLimit(operation);
            if (equalsClick == 1) {
                switch (accOperation) {
                    case 1:
                        accSum();   // função acumuladora de Soma da Calculadora 
                        break;
                    case 2:
                        accSub();   // função acumuladora de Subtração da Calculadora 
                        break;
                    case 3:
                        accMult();
                        break;
                    case 4:
                        accDiv();
                        break;
                    case 5:
                        accPow();
                        break;
                    default:
                        break;
                }
            }
            cleanVariables(2);
            firstOpTyped = true;
            numpadTyped = true;
            equalsClick = 1;
        }
        focus();
    }

    // método analisa se os botões operação aritmética devem fazer o papel do botão igual, ou trocar o sinal de operação, 
    // ou fazer uma operação complexa, exemplo: (2+5+9+6+8+) de acordo com a escolha do usuário
    public void calculationHub(short op) {  // Operação Complexa (2+6+9+10+256+986)
        formatZeroPercent();  // apagará a string "[0% of 0 = 0]" do Segundo Display
        boolean check = validateNumber();  // a entrada do usuário é validada
        if (check == true) {  // se passou no teste de validação
            maxNumber(number);  // verifica se o número digitado ou calculado não passou do limite do double
            if (operation != op && operation != 0 // se não é a operação escolhida anteriormente e não é a primeira operação [0], então o botão de operação faz o papel do igual
                    && numpadTyped == true) {  // o usuário já digitou um número, mas a operação escolhida anteriormente não é a mesma que a atual
                executeAnotherOperation(op);  // então é chamado o método para fazer o cálculo de outra operação
            }
            if (operation != op && operation != 0 && secondOpTyped == true // se a operação escolhida não for a atual, ex: soma e o usuário já clicou em algum botão das operações aritmétcas 1 ou 2 vezes
                    || operation != op && operation != 0 && firstOpTyped == true) { // então é troca de sinal e não é para fazer uma operação
                executeChangeSignal(op);  // método que troca de sinal, de + para - por exemplo
            }
            if (operation == op && numpadTyped == true // se a operação escolhida foi adição, por ex: e o usuário já digitou o número no display
                    || operation == 0 && numpadTyped == true) { // então será feito a operação 
                executeComplexCalculation(op);  // faz o cálculo escolhido
            }
            formatLimit(operation);  // o método limpa a string que é exibida no 2º display, caso ultrapasse o tamanho do próprio display, exibindo apenas o último resultado
            focus();  // faz o foco do cursor ficar em cima do display principal
        }
    }

    public void executeAnotherOperation(short op) {
        arithmetic();  // chama o método arithmetic que direciona para o método de operação simples de acordo com a operação escolhida pelo usuário
        formatAnotherOperation(op);
        operation = op;  // depois que é feito o cálculo de outra operação, pois o botão de soma fez o papel de igual, a operação agora será exemplo: [soma 1], não mais a anterior escolhida pelo usuário 
        accOperation = operation;  // agora o número da operação é salvo na memória RAM, para ser usado no acumulador
        countOpClick = 1; // como é a primeira vez que o usuário clicou no botão de operação, a contagem de clique aumenta para 1
        equalsClick = 0;  // a contagem da quantidade de clicks em cima do = é configurado para 0
        numpadTyped = false;  // o registro do clique do mouse em cima do teclado numérico é configurado como falso
        firstOpTyped = true;  // o registro do clique do mouse em cima do botão de operação é configurado como verdadeiro
    }

    public void executeChangeSignal(short op) {
        char chars[] = null;
        int i = mathExpression.length() - 1;
        if (i > 0) {
            chars = mathExpression.toCharArray();
            switch (op) {
                case 1:
                    chars[i - 1] = '+';
                    break;
                case 2:
                    chars[i - 1] = '-';
                    break;
                case 3:
                    chars[i - 1] = 'x';
                    break;
                case 4:
                    chars[i - 1] = '/';
                    break;
                case 5:
                    chars[i - 1] = '^';
                    break;
                default:
                    chars[i - 1] = '√';
                    break;
            }
        }
        mathExpression = new String(chars);
        start.labelExp.setText(mathExpression);
        equalsClick = 0;
        operation = op;
        accOperation = operation;
    }

    public void executeComplexCalculation(short op) {
        operation = op;
        accOperation = operation;
        equalsClick = 0; // registro da quantidade de cliques no botão igual é configurado para 0

        if (countOpClick == 0) {  // se o usuário clicou a primeira vez em um botão de operação aritmética         
            number = Double.valueOf(start.inputText.getText()); // entao o número digitado é salvo em number
            if (number < 0) {
                formatNegativeNumber(op);

            } else if (number >= 0) {
                formatPositiveNumber(op);
            }
            firstOpTyped = true;  // é registado que o usuário clicou a 1º vez no botão de operação
            numpadTyped = false;  // então é desativado o registro do clique no teclado numérico

        } else if (countOpClick == 1 && secondOpTyped == false) {  // se foi a 2º vez seguida que o usuário clicou no botão de operação, então ele está fazendo operações consecutivas, complexas
            aux = Double.valueOf(start.inputText.getText());  // o 2º operando é salvo na memória RAM para fazer a acumulação
            calculationSwitch(op);
            if (!start.inputText.getText().contains("Impossible") && !start.inputText.getText().contains("Exceed")) {
                boolean check = maxNumber(number); // depois é checado se o valor calculado não excedeu o limite do double
                if (check == true) { // senão excedeu o valor, então é feito a formatação do resultado para mostar nos displays
                    formatResult();  // formata o resultado final para exibir no Display
                    formatComplexOp(); // método que formata o resultado dos cálculos para mostar no 2º display
                }
                secondOpTyped = true; // é registrado que o usuário clicou a 2º no botão de operação
                numpadTyped = false; // é desativado o registro do clique do teclado numérico
            }
        }
        start.labelExp.setText(mathExpression); // depois de feitos os cálculos, o resultado formatado é exibido no 2º display
        countOpClick = 1;  // é registado que o usuário clicou 1 ou mais vezes em cima dos botões de operações aritméticas
    }

    public void calculationSwitch(short op) {
        switch (op) {
            case 1:
                number = number + Double.valueOf(start.inputText.getText()); // então são feitas as adições complexas, sucessivas
                break;
            case 2:
                number = number - Double.valueOf(start.inputText.getText()); // então são feitas as subtrações complexas, sucessivas
                break;
            case 3:
                number = number * Double.valueOf(start.inputText.getText()); // então são feitas as multiplicações complexas, sucessivas
                break;
            case 4:
                double dividend = Double.valueOf(start.inputText.getText());
                if (dividend != 0) {
                    number = number / dividend;
                } else {
                    formatImpossibleToDivideBy0();
                }
                break;
            case 5:
                number = (double) Math.pow(number, Double.valueOf(start.inputText.getText()));
                break;
            case 6:
                double num = Double.valueOf(start.inputText.getText());
                number = Math.pow(num, 1 / number);
                break;
        }
    }

    public void formatImpossibleToDivideBy0() {
        start.inputText.setText("ImpossibleToDivideBy0");
        cleanVariables(2);
        cleanVariables(4);
    }

    public void formatSimpleOp() {
        if (number == Math.floor(number) && number < 0) {
            long numInt = (long) number;
            mathExpression = mathExpression + " = (" + numInt + ") ";
            start.inputText.setText(String.valueOf(numInt));

        } else if (number == Math.floor(number) && number >= 0) {
            long numInt = (long) number;
            mathExpression = mathExpression + " = " + numInt;
            start.inputText.setText(String.valueOf(numInt));

        } else if (number > Math.floor(number) && number < 0) {
            mathExpression = mathExpression + " = (" + number + ") ";
            start.inputText.setText(String.valueOf(number));

        } else if (number > Math.floor(number) && number >= 0) {
            mathExpression = mathExpression + " = " + number;
            start.inputText.setText(String.valueOf(number));
        }
    }

    public void formatAcc() {
        if (number == Math.floor(number)) {
            long numInt = (long) number;
            start.inputText.setText(String.valueOf(numInt));
        } else {
            start.inputText.setText(String.valueOf(number));
        }
    }

    public void formatAnotherOperation(short op) {
        if (!start.inputText.getText().contains("Impossible") && !start.inputText.getText().contains("Exceed")) {
            switch (op) {
                case 1:
                    mathExpression = mathExpression + " + ";  // string registra o que acontece para ser exibido no 2º display JLabel
                    break;
                case 2:
                    mathExpression = mathExpression + " - ";  // string registra o que acontece para ser exibido no 2º display JLabel
                    break;
                case 3:
                    mathExpression = mathExpression + " x ";  // string registra o que acontece para ser exibido no 2º display JLabel
                    break;
                case 4:
                    mathExpression = mathExpression + " / ";  // string registra o que acontece para ser exibido no 2º display JLabel
                    break;
                case 5:
                    mathExpression = mathExpression + " ^ ";  // string registra o que acontece para ser exibido no 2º display JLabel
                    break;
                default:
                    mathExpression = mathExpression + " √ ";  // string registra o que acontece para ser exibido no 2º display JLabel
                    break;
            }
            start.labelExp.setText(mathExpression);  // então a string é exibida no 2º display
        }
    }

    public String formatPercent2Display(double number) {
        String num = "";
        if (number == Math.floor(number)) {
            long numInt = (long) number;
            num = String.valueOf(numInt);
        } else {
            num = String.format("%.2f", number);
        }
        return num;
    }

    public void formatPercent1Display(double numPerc) {

        if (numPerc == Math.floor(numPerc)) {
            long numInt = (long) numPerc;
            start.inputText.setText(String.valueOf(numInt));
        } else {
            start.inputText.setText(String.valueOf(numPerc));
        }
    }

    public void formatComplexOp() {
        String signal = "";
        if (operation == 1) {
            signal = " + ";
        } else if (operation == 2) {
            signal = " - ";
        } else if (operation == 3) {
            signal = " x ";
        } else if (operation == 4) {
            signal = " / ";
        } else if (operation == 5) {
            signal = " ^ ";
        } else {
            signal = " √ ";
        }
        if (number == Math.floor(number) && number < 0) {
            long numInt = (long) number;
            mathExpression = mathExpression + " = (" + numInt + ") " + signal;
            start.inputText.setText(String.valueOf(numInt));

        } else if (number == Math.floor(number) && number >= 0) {
            long numInt = (long) number;
            mathExpression = mathExpression + " = " + numInt + "" + signal;
            start.inputText.setText(String.valueOf(numInt));

        } else if (number > Math.floor(number) && number < 0) {
            mathExpression = mathExpression + " = (" + number + ") " + signal;
            start.inputText.setText(String.valueOf(number));

        } else if (number > Math.floor(number) && number >= 0) {
            mathExpression = mathExpression + " = " + number + "" + signal;
            start.inputText.setText(String.valueOf(number));
        }
    }

    public void formatResult() {
        if (Double.valueOf(start.inputText.getText()) < 0) {
            mathExpression = mathExpression + "(" + start.inputText.getText() + ") ";
        } else if (Double.valueOf(start.inputText.getText()) >= 0) {
            mathExpression = mathExpression + start.inputText.getText();
        }
    }

    public void formatNegativeNumber(short op) {
        switch (op) {
            case 1:
                mathExpression = mathExpression + "(" + start.inputText.getText() + ") + ";
                break;
            case 2:
                mathExpression = mathExpression + "(" + start.inputText.getText() + ") - ";
                break;
            case 3:
                mathExpression = mathExpression + "(" + start.inputText.getText() + ") x ";
                break;
            case 4:
                mathExpression = mathExpression + "(" + start.inputText.getText() + ") / ";
                break;
            case 5:
                mathExpression = mathExpression + "(" + start.inputText.getText() + ") ^ ";
                break;
            default:
                mathExpression = mathExpression + "(" + start.inputText.getText() + ") √ ";
                break;
        }
    }

    public void formatPositiveNumber(short op) {
        switch (op) {
            case 1:
                mathExpression = mathExpression + start.inputText.getText() + " + ";
                break;
            case 2:
                mathExpression = mathExpression + start.inputText.getText() + " - ";
                break;
            case 3:
                mathExpression = mathExpression + start.inputText.getText() + " x ";
                break;
            case 4:
                mathExpression = mathExpression + start.inputText.getText() + " / ";
                break;
            case 5:
                mathExpression = mathExpression + start.inputText.getText() + " ^ ";
                break;
            default:
                mathExpression = mathExpression + start.inputText.getText() + " √ ";
                break;
        }
    }

    // método para formatar a string do 2º display nos cenários abaixo: 
    public void formatPercentMultiCalculation() {
        // 0 % % 
        for (int i = 0; i <= 10; i++) {
            if (firstOpTyped == true && numpadTyped == true && number == 0 && operation == i) {
                cleanVariables(1);
            }
            if (firstOpTyped == true && numpadTyped == false && number == 0 && operation == i) {
                cleanVariables(1);
            }
        }
        // 6 % 10 %	
        if (firstOpTyped == false && numpadTyped == true && operation == 0) {
            cleanVariables(1);
        }
        // de 5 + 10 % %	
        if (firstOpTyped == true && numpadTyped == true && operation == 7) {
            cleanVariables(1);
            mathExpression = mathExpression + formatPercent2Display(number) + " + ";
        }
        // 5 + 25 % 50 %
        if (firstOpTyped == false && numpadTyped == true && operation == 7) {
            cleanVariables(1);
            mathExpression = mathExpression + formatPercent2Display(number) + " + ";
        }
        if (firstOpTyped == true && numpadTyped == true && operation == 8) {
            cleanVariables(1);
            mathExpression = mathExpression + formatPercent2Display(number) + " - ";
        }
        if (firstOpTyped == false && numpadTyped == true && operation == 8) {
            cleanVariables(1);
            mathExpression = mathExpression + formatPercent2Display(number) + " - ";
        }
        if (firstOpTyped == true && numpadTyped == true && operation == 9) {
            cleanVariables(1);
            mathExpression = mathExpression + formatPercent2Display(number) + " x ";
        }
        if (firstOpTyped == false && numpadTyped == true && operation == 9) {
            cleanVariables(1);
            mathExpression = mathExpression + formatPercent2Display(number) + " x ";
        }
        if (firstOpTyped == true && numpadTyped == true && operation == 10) {
            cleanVariables(1);
            mathExpression = mathExpression + formatPercent2Display(number) + " / ";
        }
        if (firstOpTyped == false && numpadTyped == true && operation == 10) {
            cleanVariables(1);
            mathExpression = mathExpression + formatPercent2Display(number) + " / ";
        }
    }

    public void formatZeroPercent() {
        if (start.labelExp.getText().equals("[0% of 0 = 0]")) {
            cleanVariables(1);
        }
    }

    public void formatLimit(int operation) {
        String signal = "";
        if (operation == 1 || accOperation == 1) {
            signal = " + ";
        } else if (operation == 2 || accOperation == 2) {
            signal = " - ";
        } else if (operation == 3 || accOperation == 3) {
            signal = " x ";
        } else if (operation == 4 || accOperation == 4) {
            signal = " / ";
        } else if (operation == 5 || accOperation == 5) {
            signal = " ^ ";
        } else if (operation == 6 || accOperation == 6) {
            signal = " √ ";
        }
        int size = mathExpression.length() - 1;
        if (size >= 37) {
            if (operation >= 7) {
                mathExpression = "";
                mathExpression = number + " " + signal + " [" + aux + "% = ";
                mathExpression = mathExpression + start.inputText.getText() + "]";
            } else {
                if (number == Math.floor(number) && number < 0) {
                    long numInt = (long) number;
                    mathExpression = "(" + String.valueOf(numInt) + ") " + signal;
                    start.inputText.setText(String.valueOf(numInt));

                } else if (number == Math.floor(number) && number >= 0) {
                    long numInt = (long) number;
                    mathExpression = String.valueOf(numInt) + signal;
                    start.inputText.setText(String.valueOf(numInt));

                } else if (number > Math.floor(number) && number < 0) {
                    mathExpression = "(" + String.valueOf(number) + ") " + signal;
                    start.inputText.setText(String.valueOf(number));

                } else if (number > Math.floor(number) && number >= 0) {
                    mathExpression = String.valueOf(number) + signal;
                    start.inputText.setText(String.valueOf(number));
                }
            }
        }
        start.labelExp.setText(mathExpression);
        firstOpTyped = true;
    }

    public void accSum() {
        number = Double.valueOf(start.inputText.getText());
        number = number + aux;
        boolean check = maxNumber(number);
        if (check == true) {
            formatAcc();
        }
    }

    public void simpleSum() {
        formatResult();
        aux = Double.valueOf(start.inputText.getText());
        number = number + Double.valueOf(start.inputText.getText());
        boolean check = maxNumber(number);
        if (check == true) {
            start.inputText.setText(String.valueOf(number));
            formatSimpleOp();
        }
    }

    public void accSub() {
        number = Double.valueOf(start.inputText.getText());
        number = number - aux;
        boolean check = maxNumber(number);
        if (check == true) {
            formatAcc();
        }
    }

    public void simpleSub() {
        formatResult();
        aux = Double.valueOf(start.inputText.getText());
        number = number - Double.valueOf(start.inputText.getText());
        boolean check = maxNumber(number);
        if (check == true) {
            start.inputText.setText(String.valueOf(number));
            formatSimpleOp();
        }
    }

    public void accMult() {
        number = Double.valueOf(start.inputText.getText());
        number = number * aux;
        boolean check = maxNumber(number);
        if (check == true) {
            formatAcc();
        }
    }

    public void simpleMult() {
        formatResult();
        aux = Double.valueOf(start.inputText.getText());
        number = number * Double.valueOf(start.inputText.getText());
        boolean check = maxNumber(number);
        if (check == true) {
            start.inputText.setText(String.valueOf(number));
            formatSimpleOp();
        }
    }

    public void accDiv() {
        if (Double.valueOf(start.inputText.getText()) != 0) {
            number = Double.valueOf(start.inputText.getText());
            number = number / aux;
            boolean check = maxNumber(number);
            if (check == true) {
                formatAcc();
            }
        } else {
            formatImpossibleToDivideBy0();
        }
    }

    public void simpleDiv() {
        if (Double.valueOf(start.inputText.getText()) != 0) {
            formatResult();
            aux = Double.valueOf(start.inputText.getText());
            number = number / Double.valueOf(start.inputText.getText());
            boolean check = maxNumber(number);
            if (check == true) {
                start.inputText.setText(String.valueOf(number));
                formatSimpleOp();
            }
        } else {
            formatImpossibleToDivideBy0();
        }
    }

    public void accPow() {
        number = Double.valueOf(start.inputText.getText());
        number = Math.pow(number, aux);
        boolean check = maxNumber(number);
        if (check == true) {
            formatAcc();
        }
    }

    public void simplePow() {
        formatResult();
        aux = Double.valueOf(start.inputText.getText());
        number = (double) Math.pow(number, Double.valueOf(start.inputText.getText()));
        boolean check = maxNumber(number);
        if (check == true) {
            formatSimpleOp();
        }
    }

    public void simpleRoot() {
        formatResult();
        aux = Double.valueOf(start.inputText.getText());
        number = Math.pow(Double.valueOf(start.inputText.getText()), 1 / number);
        boolean check = maxNumber(number);
        if (check == true) {
            formatSimpleOp();
        }
    }

    public void percentStart() {
        boolean check = validateNumber();
        if (check == true) {
            if (operation == 0 || operation == 1 || operation == 2
                    || operation == 3 || operation == 4
                    || operation == 7 || operation == 8
                    || operation == 9 || operation == 10) {
                maxNumber(number);
                switch (operation) {
                    case 1:
                        operation = 7;
                        break;
                    case 2:
                        operation = 8;
                        break;
                    case 3:
                        operation = 9;
                        break;
                    case 4:
                        operation = 10;
                        break;
                    default:
                        break;
                }
                formatPercentMultiCalculation();
                if (operation == 0) {
                    number = Double.valueOf(start.inputText.getText()) / 100;
                    formatPercent1Display(number);
                } else {
                    mathExpression = mathExpression + "[" + start.inputText.getText() + "% of " + formatPercent2Display(number) + " = ";
                    double numPerc = (number / 100) * Double.valueOf(start.inputText.getText());
                    aux = numPerc;
                    check = maxNumber(numPerc);
                    if (check == true) {
                        formatPercent1Display(numPerc);
                        mathExpression = mathExpression + formatPercent2Display(Double.valueOf(start.inputText.getText())) + "]";
                        start.labelExp.setText(mathExpression);
                        formatLimit(7);
                    }
                }
            }
            firstOpTyped = true;
        }
    }

    public void percentCalc() {
        switch (operation) {
            case 7:
                number = number + Double.valueOf(start.inputText.getText());
                break;
            case 8:
                number = number - Double.valueOf(start.inputText.getText());
                break;
            case 9:
                number = number * Double.valueOf(start.inputText.getText());
                break;
            case 10:
                double dividend = Double.valueOf(start.inputText.getText());
                if (dividend != 0) {
                    number = number / dividend;
                } else {
                    formatImpossibleToDivideBy0();
                }
                break;
            default:
                break;
        }
        if (!start.inputText.getText().contains("Impossible")) {
            boolean check = maxNumber(number);
            if (check == true) {
                formatAcc();
                mathExpression = mathExpression + " = " + start.inputText.getText();
                start.labelExp.setText(mathExpression);
            }
        }
    }

    public void focus() {
        start.inputText.requestFocus();
    }

    public void replaceZero() {
        if (!start.inputText.getText().isEmpty()) {
            String input = start.inputText.getText();
            int i = input.length() - 1;
            if (i == 0 && input.charAt(0) == '0') {
                start.inputText.setText("");
            }
        }
    }

    public void negativeNumber() {
        if (!start.inputText.getText().isEmpty()) {
            String input = start.inputText.getText();
            String signal = "";
            if (Double.valueOf(start.inputText.getText()) == 0) {
                // Se a input do usuário for igual a 0, o método não colocará o signal de -
            } else {
                if (!start.inputText.getText().contains("-")) {
                    start.inputText.setText("-" + start.inputText.getText());
                    signal = mathExpression + "(" + start.inputText.getText() + ")";
                } else {
                    input = start.inputText.getText();
                    StringBuilder str = new StringBuilder(input);
                    input = String.valueOf(str.delete(0, 1));
                    start.inputText.setText(input);
                    signal = mathExpression + input;
                }
                start.labelExp.setText(signal);
                firstOpTyped = false;
                secondOpTyped = false;
                numpadTyped = true;
            }
        }
        focus();
    }

    public void pressedOpButton() {
        if (firstOpTyped == true) {
            start.inputText.setText("");
            firstOpTyped = false;
        }
        if (secondOpTyped == true) {
            start.inputText.setText("");
            secondOpTyped = false;
        }
    }

    // método escreve 0 no display
    public void writeZero() {
        start.inputText.setText("0");
        numpadTyped = true;
        focus();
    }

    public void b0Action() {
        validateNumber();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "0");
        String input = "";
        input = input + "" + start.inputText.getText();
        int i = input.length() - 1;
        StringBuilder str = new StringBuilder(input);
        if (input.charAt(0) == '0' && i == 1 && input.charAt(1) != '.') {
            input = String.valueOf(str.deleteCharAt(input.length() - 1));
            start.inputText.setText(input);
        }
        start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        numpadTyped = true;
        focus();
    }

    public void b1Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "1");
        start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        numpadTyped = true;
        focus();
    }

    public void b2Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "2");
        start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        numpadTyped = true;
        focus();
    }

    public void b3Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "3");
        start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        numpadTyped = true;
        focus();
    }

    public void b4Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "4");
        start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        numpadTyped = true;
        focus();
    }

    public void b5Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "5");
        start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        numpadTyped = true;
        focus();
    }

    public void b6Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "6");
        start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        numpadTyped = true;
        focus();
    }

    public void b7Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "7");
        start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        numpadTyped = true;
        focus();
    }

    public void b8Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "8");
        start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        numpadTyped = true;
        focus();
    }

    public void b9Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "9");
        start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        numpadTyped = true;
        focus();
    }

    // método para o botão do backspace
    public void backSpaceAction() {
        boolean check = validateNumber();
        if (check == true) {
            if (operation == 0 || operation == 1 || operation == 2 // se as operações não forem de porcentagem
                    || operation == 3 || operation == 4
                    || operation == 5 || operation == 6) {

                String input = start.inputText.getText();      // salva a entrada do usuário em input
                StringBuilder str = new StringBuilder(input);  // transforma o objeto String em StringBuilder
                input = String.valueOf(str.deleteCharAt(input.length() - 1));  // deleta da última posição até a 1º
                start.inputText.setText(input);               // exibe a string no display principal 

                if (input.length() == 0 || start.inputText.getText().equals("-")) {  // se o tamanho da string for 0 ou se o número for negativo
                    input = "";    // não a deixa nula e apaga o -(número negativo)
                    writeZero();   // depois imprime o zero
                }
                if (numpadTyped == true) {          // se já foi digitado algum número  
                    start.labelExp.setText(mathExpression + input);  // mostra a string no 2º display
                }
                numpadTyped = true;
                firstOpTyped = false;
                secondOpTyped = false;
            }
            focus();
        }
    }

    public void bFloatAction() {
        boolean check = validateNumber();
        if (!start.inputText.getText().contains(".") && check == true) {
            start.inputText.setText(start.inputText.getText() + ".");
            firstOpTyped = false;
            secondOpTyped = false;
            numpadTyped = true;
            start.labelExp.setText(mathExpression + "" + start.inputText.getText());
        }
        focus();
    }

    public void bCleanNumAction() {
        String input = start.inputText.getText();
        StringBuilder str = new StringBuilder(input);
        input = String.valueOf(str.delete(0, str.length()));
        start.inputText.setText(input);
        start.labelExp.setText(mathExpression + input);
        writeZero();
    }

    public void inputTextKeyPressedAction(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER  ||
               !evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_EQUALS) {
            equalsAction();
        } else if (evt.getKeyCode() == KeyEvent.VK_DIVIDE
                || evt.getKeyCode() == KeyEvent.VK_SLASH
                || evt.getKeyCode() == KeyEvent.VK_BACK_SLASH
                || evt.getKeyCode() == KeyEvent.VK_D) {
            calculationHub((short) 4);
        } else if (evt.getKeyCode() == KeyEvent.VK_MULTIPLY
                || evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_8
                || evt.getKeyCode() == KeyEvent.VK_M) {
            calculationHub((short) 3);
        } else if (evt.getKeyCode() == KeyEvent.VK_SUBTRACT
                || evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_MINUS
                || evt.getKeyCode() == KeyEvent.VK_S) {
            calculationHub((short) 2);
        } else if (evt.getKeyCode() == KeyEvent.VK_ADD
                || evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_EQUALS
                || evt.getKeyCode() == KeyEvent.VK_A) {
            calculationHub((short) 1);
        } else if (evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_5) {
            percentStart();
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD0
                || evt.getKeyCode() == KeyEvent.VK_0) {
            b0Action();
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD1
                || evt.getKeyCode() == KeyEvent.VK_1) {
            b1Action();
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD2
                || evt.getKeyCode() == KeyEvent.VK_2) {
            b2Action();
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD3
                || evt.getKeyCode() == KeyEvent.VK_3) {
            b3Action();
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD4
                || evt.getKeyCode() == KeyEvent.VK_4) {
            b4Action();
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD5
                || evt.getKeyCode() == KeyEvent.VK_5) {
            b5Action();
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD6
                || evt.getKeyCode() == KeyEvent.VK_6) {
            b6Action();
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD7
                || evt.getKeyCode() == KeyEvent.VK_7) {
            b7Action();
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD8
                || evt.getKeyCode() == KeyEvent.VK_8) {
            b8Action();
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD9
                || evt.getKeyCode() == KeyEvent.VK_9) {
            b9Action();
        } else if (evt.getKeyCode() == KeyEvent.VK_DECIMAL
                || evt.getKeyCode() == KeyEvent.VK_PERIOD) {
            bFloatAction();
        } else if (evt.getKeyCode() == KeyEvent.VK_MINUS) {
            validateNumber();
            negativeNumber();
        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            backSpaceAction();
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            cleanVariables(2);
            cleanVariables(3);
            cleanVariables(4);
        } else if (evt.getKeyCode() == KeyEvent.VK_E) {
            bCleanNumAction();
        } else if (evt.getKeyCode() == KeyEvent.VK_P) {
            calculationHub((short) 5);
        } else if (evt.getKeyCode() == KeyEvent.VK_R) {
            calculationHub((short) 6);
        }
    }

    public boolean maxNumber(double num) {
        boolean check = true;
        double max = Math.pow(2, 63);
        if (num >= max || num <= -max
                || Double.valueOf(start.inputText.getText()) >= max
                || Double.valueOf(start.inputText.getText()) <= -max) {
            start.inputText.setText("Calculation Exceeded");
            start.labelExp.setText(mathExpression);
            cleanVariables(2);
            cleanVariables(4);
            check = false;
        }
        return check;
    }

    public short getOperation() {
        return operation;
    }

    public void setOperation(short operation) {
        this.operation = operation;
    }

    public short getAccOperation() {
        return accOperation;
    }

    public void setAccOperation(short accOperation) {
        this.accOperation = accOperation;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public double getAux() {
        return aux;
    }

    public void setAux(double aux) {
        this.aux = aux;
    }

    public short getCountOpClick() {
        return countOpClick;
    }

    public void setCountOpClick(short countOpClick) {
        this.countOpClick = countOpClick;
    }

    public short getEqualsClick() {
        return equalsClick;
    }

    public void setEqualsClick(short equalsClick) {
        this.equalsClick = equalsClick;
    }

    public boolean isNumpadTyped() {
        return numpadTyped;
    }

    public void setNumpadTyped(boolean numpadTyped) {
        this.numpadTyped = numpadTyped;
    }

    public boolean isFirstOpTyped() {
        return firstOpTyped;
    }

    public void setFirstOpTyped(boolean firstOpTyped) {
        this.firstOpTyped = firstOpTyped;
    }

    public boolean isSecondOpTyped() {
        return secondOpTyped;
    }

    public void setSecondOpTyped(boolean secondOpTyped) {
        this.secondOpTyped = secondOpTyped;
    }

    public String getMathExpression() {
        return mathExpression;
    }

    public void setMathExpression(String mathExpression) {
        this.mathExpression = mathExpression;
    }
}
