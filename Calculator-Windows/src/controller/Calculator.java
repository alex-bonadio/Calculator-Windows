package controller;

import view.Start;
import java.awt.event.KeyEvent;

/**
 * @author Alex Bonadio Code Lines: 1714 Classe: 1261 Methods: 77
 */
public class Calculator {

    private short operation = 0;             // 1 adição 2 subtração 3 multiplicacao 4 divisão 5 potenciacao 6 radiciação 7 a 10 porcentagem
    private short accOperation = 0;          // mantém salvo na memória a última operação aritmética realizada para ser usada no acumulador
    private double number = 0.0;             // armazena o valor digitado pelo usuário e também o resultado de cada operação aritmética
    private double aux = 0.0;                // armazena e mantém salvo na memória o 2º operando para fazer a acumulação 
    private short countOpClick = 0;          // armazena a quantidade de vezes que o usuário clicou em um dos botões das operações aritméticas (nenhuma vez, 1 vez)
    private short equalsClick = 0;           // armazena a quantidade de vezes que o usuário clicou no sinal de = (nenhuma vez, 1 vez)
    private boolean numpadTyped = false;     // muda para true quando o usuário clicar no teclado numérico
    private boolean firstOpTyped = false;    // muda para true quando o usuário clicar a 1º vez em um dos botões de operações aritiméticas
    private boolean secondOpTyped = false;   // muda para true quando o usuário clicar a 2º vez em um dos botões de operações aritiméticas
    private String mathExpression = "";      // é a string que armazena o que o usuário está fazendo na calculadora, para exibir no JLabel abaixo do Display principal
    private Start start;                     // é uma cópia da variável de referência do objeto da Classe Start para manipular os componentes gráficos da Calculadora

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
            if (start.inputText.getText().contains("Impossible")
                    || start.inputText.getText().contains("Exceed")) {
                cleanVariables(2);  // Se no 1º Display (Principal) tiver as palavras Impossible ou Exceed 
                cleanVariables(3); // então várias variáveis são apagadas e reinicializadas
                writeZero();      // depois de apagá-las é impresso 0 no Display Principal 
                check = false;  // false significa que não passou no teste, tem caracteres inválidos
            } else {
                // start.inputText.getText().matches("^[-0.0-9.0]*$");
                check = true;  // true significa que passou na validação, não tem caracteres inválidos
            }
        }
        return check;
    }

    // método limpa as variáveis de instância de acordo com o nível escolhido
    public void cleanVariables(int level) {
        switch (level) {
            case 1:
                mathExpression = ""; // apaga a mensagem que é exibida no 2º display
                start.labelExp.setText(""); // apaga o 2º display
                break;
            case 2: // apaga váriaveis e reseta valores de outras
                start.labelExp.setText("");
                mathExpression = "";
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
        if (check == true) {  // se o número digitado está OK, ou seja, não são letras ou não é nulo
            switch (operation) { // operação aritmética Simples escolhida pelo usuário
                case 1:  // caso 1 Adição Simples, exemplo: 2 + 2 = 4
                    simpleSum();
                    break;
                case 2:  // caso 2 Subtração Simples, exemplo: 2 - 2 = 0
                    simpleSub();
                    break;
                case 3:  // Multiplicação
                    simpleMult();
                    break;
                case 4: // Divisão
                    simpleDiv();
                    break;
                case 5: 
                    simplePow(); // Potenciação
                    break;
                case 6:
                    simpleRoot(); // raiz quadrada
                    break;
                case 7:               // caso 7, chama o método que calcula utilizando porcentagem
                    percentCalc();   // com soma
                    break;
                case 8:
                    percentCalc(); // com subtração
                    break;
                case 9:
                    percentCalc(); // com Multiplicação
                    break;
                case 10:
                    percentCalc(); // Divisão
                    break;
            }
        }
    }

    // método do botão de igual
    public void equalsAction() { // chama os métodos que fazem os cálculos
        boolean check = validateNumber(); // verifica se o resultado do cálculo não ultrapassou o limite da calculadora ou se tem algum caractere, ao invés de números
        if (check == true) { // TRUE significa que o número está OK
            maxNumber(number); // Verifica se resultado do cálculo não ultrapassou o limite da calculadora 
            arithmetic();  // este método chama os métodos de operação aritmética simples, ex: 2 + 2, 4-2, 10 * 2 ... 
            formatLimit(operation); // este método verifica se o tamanho da string do 2º display é maior do que o tamanho do próprio jLabel que mostra a expressão matemática, e a apaga totalmente se ultrapassar o seu limite, e só exibe o resultado do último cálculo realizado
            if (equalsClick == 1) { // se o usuário clicou mais de uma vez no igual, então é feito a acumulação do resultado
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
                        accPow(); // função acumuladora de potenciação
                        break;
                    default:
                        break;
                }
            }
            cleanVariables(2);     // apaga váriaveis e reseta valores de outras
            firstOpTyped = true;  // mantém registrado que o usuário clicou uma vez em algo botão de Operação Aritmética 
            numpadTyped = true;  // mantém registrado que o usuário clicou em algum algarismo
            equalsClick = 1;    // registra que o usuário clicou 1 vez no botão de igual
        }
        focus();
    }

    // método analisa se os botões de operação aritmética devem fazer o papel do botão igual, ou trocar o sinal de operação, 
    // ou fazer uma operação complexa, exemplo: (2+5+9+6+8+) de acordo com a escolha do usuário
    public void calculationHub(short op) {  // Operação Complexa (2+6+9+10+256+986)
        formatZeroPercent();  // apagará a string "[0% of 0 = 0]" do Segundo Display
        boolean check = validateNumber();  // a entrada do usuário é validada
        if (check == true) {  // se passou no teste de validação
            maxNumber(number);  // verifica se o número digitado ou calculado não passou do limite do double
            if (operation != op && operation != 0 // se não é a mesma operação escolhida anteriormente e não é a primeira operação [0], então o botão de operação faz o papel do igual
                    && numpadTyped == true) {  // o usuário já digitou um número, mas a operação escolhida anteriormente não é a mesma que a atual
                executeAnotherOperation(op);  // então é chamado o método para fazer o cálculo de outra operação
            }
            if (operation != op && operation != 0 && secondOpTyped == true // se a operação escolhida não for a mesma da anterior e o usuário já clicou em algum botão das operações aritmétcas 1 ou 2 vezes
                    || operation != op && operation != 0 && firstOpTyped == true) { // então ele trocou de operação, escolheru outra
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

    // método que faz a operação aritmética da opção anterior do usuário
    public void executeAnotherOperation(short op) {
        arithmetic();  // chama o método arithmetic que direciona para o método de operação simples de acordo com a operação escolhida pelo usuário
        formatAnotherOperation(op);
        operation = op;  // depois que foi feito o cálculo de outra operação, por ex., o botão de soma fez o papel do igual, a operação agora será exemplo: [1 - soma], não mais a anterior escolhida pelo usuário 
        accOperation = operation;  // agora o número da operação é salvo na memória RAM, para ser usado no acumulador
        countOpClick = 1; // como é a primeira vez que o usuário clicou no botão de operação, a contagem de clique aumenta para 1
        equalsClick = 0;  // a contagem da quantidade de clicks em cima do = é configurado para 0
        numpadTyped = false;  // o registro do clique do mouse em cima do teclado numérico é configurado como falso
        firstOpTyped = true;  // o registro do clique do mouse em cima do botão de operação é configurado como verdadeiro
    }

    // método faz a troca de sinal, quando o usuário decidir fazer outra operação aritmética
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

    // método que formata a expressão matemática no 2º display, trocando o sinal de operação nela
    public void formatAnotherOperation(short op) {
        if (!start.inputText.getText().contains("Impossible")
                && !start.inputText.getText().contains("Exceed")) {
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

    // método prepara as variáveis para ser feita a operação complexa, por ex: 2 + 6 + 8 * 9 /12 - 5
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

    // método faz o cálculo complexo, ex: 2 + 9 + 5 * 6 / 8 - 9 ^ 2
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

    // caso o número seja dividido por zero, aparecerá a mensagem no 1º Display
    public void formatImpossibleToDivideBy0() {
        start.inputText.setText("Impossible to Divide by 0");
        cleanVariables(2);
        cleanVariables(4);
    }

    // formata o número durante as operações simples, ex: 2 + 2 = 4
    // para nao aparecer o ponto flutuante se o número for inteiro
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

    // método que formata a string no display principal, para não exibir o ponto flutuante, 
    // caso não seja um número decimal, por ex: 100, exibiria apenas 100, e não 100.0 
    public void formatAcc() {
        if (number == Math.floor(number)) {
            long numInt = (long) number;
            start.inputText.setText(String.valueOf(numInt));
        } else {
            start.inputText.setText(String.valueOf(number));
        }
    }

    // método que formata o número no 2º display, sem o ponto flutuante, caso seja um inteiro
    // caso seja um decimal, exibe apenas 2 casas após a vírgula
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

    // formata o número do 1º display, quando é um cálculo com porcentagem
    public void formatPercent1Display(double numPerc) {

        if (numPerc == Math.floor(numPerc)) {
            long numInt = (long) numPerc;
            start.inputText.setText(String.valueOf(numInt));
        } else {
            start.inputText.setText(String.valueOf(numPerc));
        }
    }

    // método formata a string do 2º display, durante as opereção aritméticas complexas
    // ex: 2 + 9 = 11 * 5 = 605
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

    // se o resultado da operação aritmética gerar um número negativo
    // o método o imprimirá entre parênteses no 2º display
    public void formatResult() {
        if (Double.valueOf(start.inputText.getText()) < 0) {
            mathExpression = mathExpression + "(" + start.inputText.getText() + ") ";
        } else if (Double.valueOf(start.inputText.getText()) >= 0) {
            mathExpression = mathExpression + start.inputText.getText();
        }
    }
    // método coloca dinamicamente em parênteses um número negativo, enquanto 
    // estiver sendo digitado, incluindo sendo apagado também, digito, por digito

    public boolean formatNegativeNumberDynamically() {
        boolean check = false;
        if (!start.inputText.getText().isEmpty()) {
            if (Double.valueOf(start.inputText.getText()) < 0) {
                // Se número for menor que 0, o método colocará () ao redor do número negativo
                start.labelExp.setText(mathExpression + "(" + start.inputText.getText() + ")");
                check = true;
            }
        }
        return check;
    }

    // caso o número seja negativo, o método o coloca em parênteses, e em seguida, a operação escolhida 
    // pelo usuário após o ), ex: se escolheu soma imprime ) + no 2º display
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

    // método formata a string do 2º display, caso o resultado seja um número positivo
    // e depois do número imprime o sintal da operação escolhida, ex:  256 + 
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

    // método formata a string do 2º display quando for 0%
    public void formatZeroPercent() {
        if (start.labelExp.getText().equals("[0% of 0 = 0]")) {
            cleanVariables(1);
        }
    }

    // método formata a string do 2º display, apagando toda a string, caso atinge o 
    // tamanho limite do jLabel, substituindo toda a expressão anterior por apenas o resultado dela
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
        int size = mathExpression.length();
        if (size >= 40) { // tamanho maximo permitido na string, 40 posições
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

    // método faz os cálculos sucessivos de acumulação, da operação de Soma
    // quando o usuário ficar clicando sucessivamente no botão de igual
    public void accSum() {
        number = Double.valueOf(start.inputText.getText());
        number = number + aux;
        boolean check = maxNumber(number);
        if (check == true) {
            formatAcc();
        }
    }

    // método faz a soma simples, ex: 2 + 2
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

    // método faz os cálculos sucessivos de acumulação, da operação de subtração
    // quando o usuário ficar clicando sucessivamente no botão de igual
    public void accSub() {
        number = Double.valueOf(start.inputText.getText());
        number = number - aux;
        boolean check = maxNumber(number);
        if (check == true) {
            formatAcc();
        }
    }

    // método faz a subtração simples, ex: 4-2
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

    // método faz os cálculos sucessivos de acumulação, da operação de Multiplicação
    // quando o usuário ficar clicando sucessivamente no botão de igual
    public void accMult() {
        number = Double.valueOf(start.inputText.getText());
        number = number * aux;
        boolean check = maxNumber(number);
        if (check == true) {
            formatAcc();
        }
    }

    // método faz a multiplicação simples, ex: 4*4
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

    // método faz os cálculos sucessivos de acumulação, da operação de Divisão
    // quando o usuário ficar clicando sucessivamente no botão de igual
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

    // método faz divisão simples, ex: 10/2 e se for uma divisão por zero, exibe
    // que é impossível dividir por zero
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

    // método faz os cálculos sucessivos de acumulação, da operação de Potenciação
    // quando o usuário ficar clicando sucessivamente no botão de igual
    public void accPow() {
        number = Double.valueOf(start.inputText.getText());
        number = Math.pow(number, aux);
        boolean check = maxNumber(number);
        if (check == true) {
            formatAcc();
        }
    }

    // método faz o calculo de potenciação simples, ex: 2^62 
    public void simplePow() {
        formatResult();
        aux = Double.valueOf(start.inputText.getText());
        number = (double) Math.pow(number, Double.valueOf(start.inputText.getText()));
        boolean check = maxNumber(number);
        if (check == true) {
            formatSimpleOp();
        }
    }

    // método faz o calculo de raiz quadrada
    public void simpleRoot() {
        formatResult();
        aux = Double.valueOf(start.inputText.getText());
        number = Math.pow(Double.valueOf(start.inputText.getText()), 1 / number);
        boolean check = maxNumber(number);
        if (check == true) {
            formatSimpleOp();
        }
    }

    // método prepara as variavies para poder ser feito os cálculos de porcentagem
    // misturados com as operações aritméticas básicas
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

    // método faz os cálculos de porcentagem misturados com as operações aritméticas básicas
    // e chama os métodos de formatação do resultado no 2º display
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

    // método coloca o cursor no 1º display, caso ele seja desbloqueado para escrita direta
    public void focus() {
        start.inputText.requestFocus();
    }

    // método sobrepõe o zero por outro número no 1º display 
    public void replaceZero() {
        if (!start.inputText.getText().isEmpty()) {
            String input = start.inputText.getText();
            int i = input.length() - 1;
            if (i == 0 && input.charAt(0) == '0') {
                start.inputText.setText("");
            }
        }
    }
    // método coloca o sinal de negativo no número, e o retira, se o usuário clicar no botão novamente
    public void negativeNumber() {
        if (!start.inputText.getText().isEmpty()) {
            String input = "";  // String input = start.inputText.getText();
            String signal = "";
            if (Double.valueOf(start.inputText.getText()) == 0) {
                // Se a entrada do usuário for igual a 0, o método não colocará o signal de -
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

    // método altera para FALSE as variáveis que salvam se o usuário
    // deu o primeiro ou segundo click nos botõe de operação
    public void pressedOpButton() {
        if (firstOpTyped == true) {  // se já deu o 1º clique no botão de operação
            start.inputText.setText("");
            firstOpTyped = false;    // então volta para FALSE;
        }
        if (secondOpTyped == true) { // se já deu o 2º clique no botão de operação
            start.inputText.setText("");
            secondOpTyped = false;   // então volta para FALSE;
        }
    }

    // método escreve 0 no display
    public void writeZero() {
        start.inputText.setText("0");
        numpadTyped = true;
        focus();
    }

    // // método do botão 0
    public void b0Action() {
        validateNumber();
        pressedOpButton();
        if (!start.inputText.getText().equals("0")) {
            start.inputText.setText(start.inputText.getText() + "0");
            boolean check = formatNegativeNumberDynamically();
            if (check == false) { // se o número não for negativo
                start.labelExp.setText(mathExpression + " " + start.inputText.getText());
            }
            numpadTyped = true;
            focus();
        } else if (start.inputText.getText().equals("0")) { // se o número escolhido for 0, então ele é impresso no 2º display
            start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        }
    }

    // // método do botão 1
    public void b1Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "1");
        boolean check = formatNegativeNumberDynamically();
        if (check == false) {
            start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        }
        numpadTyped = true;
        focus();
    }

    // método do botão 2
    public void b2Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "2");
        boolean check = formatNegativeNumberDynamically();
        if (check == false) {
            start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        }
        numpadTyped = true;
        focus();
    }

    // método do botão 3
    public void b3Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "3");
        boolean check = formatNegativeNumberDynamically();
        if (check == false) {
            start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        }
        numpadTyped = true;
        focus();
    }

    // método do botão 4
    public void b4Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "4");
        boolean check = formatNegativeNumberDynamically();
        if (check == false) {
            start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        }
        numpadTyped = true;
        focus();
    }

    // método do botão 5
    public void b5Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "5");
        boolean check = formatNegativeNumberDynamically();
        if (check == false) {
            start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        }
        numpadTyped = true;
        focus();
    }

    // método do botão 6
    public void b6Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "6");
        boolean check = formatNegativeNumberDynamically();
        if (check == false) {
            start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        }
        numpadTyped = true;
        focus();
    }

    // método do botão 7
    public void b7Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "7");
        boolean check = formatNegativeNumberDynamically();
        if (check == false) {
            start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        }
        numpadTyped = true;
        focus();
    }

    // método do botão 8
    public void b8Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "8");
        boolean check = formatNegativeNumberDynamically();
        if (check == false) {
            start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        }
        numpadTyped = true;
        focus();
    }

    // método do botão 9
    public void b9Action() {
        validateNumber();
        replaceZero();
        pressedOpButton();
        start.inputText.setText(start.inputText.getText() + "9");
        boolean check = formatNegativeNumberDynamically();
        if (check == false) {
            start.labelExp.setText(mathExpression + " " + start.inputText.getText());
        }
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

                if (start.inputText.getText().equals("-0")) {
                    input = "";    // não a deixa nula e apaga o -(número negativo)
                    writeZero();   // depois imprime o zero
                }

                if (input.length() == 0 || start.inputText.getText().equals("-")) {  // se o tamanho da string for 0 ou se o número for negativo
                    input = "";    // não a deixa nula e apaga o -(número negativo)
                    writeZero();   // depois imprime o zero
                }

                if (numpadTyped == true && equalsClick == 0) {          // se já foi digitado algum número  
                    boolean checagem = formatNegativeNumberDynamically();
                    if (checagem == false) { // se não é número negativo
                        start.labelExp.setText(mathExpression + input);  // mostra a string no 2º display
                    }
                }
                if (numpadTyped == true && equalsClick == 1 && firstOpTyped == false) {
                    boolean checagem = formatNegativeNumberDynamically();
                    if (checagem == false) { // se não é número negativo
                        start.labelExp.setText(mathExpression + input);  // mostra a string no 2º display
                    }
                }
                focus();
            }
        }
    }

    // método imprime o . no número, para os números se tornarem decimais
    public void bFloatAction() {
        boolean check = validateNumber();
        if (!start.inputText.getText().contains(".") && check == true) {
            start.inputText.setText(start.inputText.getText() + ".");
            firstOpTyped = false;
            secondOpTyped = false;
            numpadTyped = true;
            boolean checagem = formatNegativeNumberDynamically();
            if (checagem == false) { // se não é número negativo
                start.labelExp.setText(mathExpression + "" + start.inputText.getText());
            }
        }
        focus();
    }

    // método do botão CE, apaga o último número digitado
    public void bCleanNumAction() {
        String input = start.inputText.getText();
        StringBuilder str = new StringBuilder(input);
        input = String.valueOf(str.delete(0, str.length()));
        start.inputText.setText(input);
        start.labelExp.setText(mathExpression + input);
        writeZero(); // depois de apagar, escreve zero no display principal
    }

    // método que captura a ação de pressionar as teclas do teclado físico
    public void inputTextKeyPressedAction(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER // enter, aciona o método do botão igual
                || !evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_EQUALS) {
            equalsAction(); // tecla =, aciona o método do botão de igual
        } else if (evt.getKeyCode() == KeyEvent.VK_DIVIDE
                || evt.getKeyCode() == KeyEvent.VK_SLASH
                || evt.getKeyCode() == KeyEvent.VK_BACK_SLASH
                || evt.getKeyCode() == KeyEvent.VK_D) {
            calculationHub((short) 4); // divisão
        } else if (evt.getKeyCode() == KeyEvent.VK_MULTIPLY
                || evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_8
                || evt.getKeyCode() == KeyEvent.VK_M) {
            calculationHub((short) 3); // multiplicação 
        } else if (evt.getKeyCode() == KeyEvent.VK_SUBTRACT
                || evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_MINUS
                || evt.getKeyCode() == KeyEvent.VK_S) {
            calculationHub((short) 2); // subtração
        } else if (evt.getKeyCode() == KeyEvent.VK_ADD
                || evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_EQUALS
                || evt.getKeyCode() == KeyEvent.VK_A) {
            calculationHub((short) 1); // adição
        } else if (evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_5) {
            percentStart(); // porcentagem
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD0
                || evt.getKeyCode() == KeyEvent.VK_0) {
            b0Action(); // 0
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD1
                || evt.getKeyCode() == KeyEvent.VK_1) {
            b1Action(); // 1
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD2
                || evt.getKeyCode() == KeyEvent.VK_2) {
            b2Action(); // 2
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD3
                || evt.getKeyCode() == KeyEvent.VK_3) {
            b3Action(); // 3
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD4
                || evt.getKeyCode() == KeyEvent.VK_4) {
            b4Action(); // 4
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD5
                || evt.getKeyCode() == KeyEvent.VK_5) {
            b5Action(); // 5
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD6
                || evt.getKeyCode() == KeyEvent.VK_6) {
            b6Action(); // 6
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD7
                || evt.getKeyCode() == KeyEvent.VK_7) {
            b7Action(); // 7
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD8
                || evt.getKeyCode() == KeyEvent.VK_8) {
            b8Action(); // 8
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD9
                || evt.getKeyCode() == KeyEvent.VK_9) {
            b9Action(); // 9
        } else if (evt.getKeyCode() == KeyEvent.VK_DECIMAL
                || evt.getKeyCode() == KeyEvent.VK_PERIOD) {
            bFloatAction(); // .
        } else if (evt.getKeyCode() == KeyEvent.VK_MINUS) {
            validateNumber();
            negativeNumber(); // sinal de negativo
        } else if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            backSpaceAction(); // backspace
        } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) { // botão C de apagar a memória
            cleanVariables(2);  // apaga as variáveis
            cleanVariables(3);
            cleanVariables(4);
            writeZero(); // depois de apagar a memória, escreve o 0 no display principal
        } else if (evt.getKeyCode() == KeyEvent.VK_E) {
            bCleanNumAction(); // botão de apagar o último número digitado
        } else if (evt.getKeyCode() == KeyEvent.VK_P
                || evt.isShiftDown() && evt.getKeyCode() == KeyEvent.VK_DEAD_TILDE) {
            calculationHub((short) 5); // Potenciação
        } else if (evt.getKeyCode() == KeyEvent.VK_R) {
            calculationHub((short) 6); // raiz quadrada
        }
    }

    // método que configura o maior número que a calculadora suporta, ((2^63)-2) positivo ou negativo)
    public boolean maxNumber(double num) {
        boolean check = true;
        double max = Math.pow(2, 63);
        if (num >= max || num <= -max // se o número chegou ao limite da calculadora
                || Double.valueOf(start.inputText.getText()) >= max
                || Double.valueOf(start.inputText.getText()) <= -max) {
            start.inputText.setText("Calculation Exceeded"); // então exibe Cálculo Excedido
            //        start.labelExp.setText(mathExpression);
            cleanVariables(2); // apaga as variaveis, se excedeu o número máximo
            cleanVariables(4);
            check = false;
        }
        return check;
    }

    // seção de todos os Getters e Setters
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
