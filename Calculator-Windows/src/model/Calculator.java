package model;

import view.CalculatorGUI;
import java.awt.event.KeyEvent;

/**
 * @author Alex Bonadio Total Code Lines: 2012 Classe: 1341 Methods: 74 Sem o
 * Construtor e os getters and setters: 54
 */
public class Calculator {

    private short operation = 0;             // 0 ainda não foi escolhido uma operação, 1 adição, 2 subtração, 3 multiplicacao, 4 divisão, 5 potenciação, 6 radiciação 7 a 10 porcentagem
    private short accOperation = 0;          // mantém salvo na memória a última operação aritmética realizada para ser usada no acumulador
    private double number = 0.0;             // armazena o valor digitado pelo usuário e também o resultado de cada operação aritmética
    private double memory = 0.0;             // armazena o número na memória da Calculadora
    private double aux = 0.0;                // armazena e mantém salvo na memória o 2º operando para fazer a acumulação 
    private short countOpClick = 0;          // armazena a quantidade de vezes que o usuário clicou em um dos botões das operações aritméticas (nenhuma vez, 1 vez)
    private short equalsClick = 0;           // armazena a quantidade de vezes que o usuário clicou no sinal de = (nenhuma vez, 1 vez)
    private boolean numpadTyped = false;     // muda para true quando o usuário clicar no teclado numérico
    private boolean firstOpTyped = false;    // muda para true quando o usuário clicar a 1º vez em um dos botões de operações aritiméticas
    private boolean secondOpTyped = false;   // muda para true quando o usuário clicar a 2º vez em um dos botões de operações aritiméticas
    private String mathExpression = "";      // é a string que armazena o que o usuário está fazendo na calculadora, para exibir no JLabel abaixo do Display principal
    private CalculatorGUI calcGUI;           // é uma cópia da variável de referência do objeto da Classe CalculatorGUI para manipular os componentes gráficos da Calculadora

    public Calculator() {
    }

    // método recebe a cópia da variável de referência do objeto calcGUI instanciado na classe CalculatorGUI
    public void takeReferenceVariable(CalculatorGUI calcGUI) {
        this.calcGUI = calcGUI;  // salva a variável de referência e a torna global
    }

    // método adiciona o número na memória da Calculadora
    public void memorise() {
        boolean tested = validateNumber();  // método verifica se só tem números no 1º display
        if (tested == true) { // se a entrada está correta, ou seja, possui apenas números ou o E, então é true
            boolean validated = maxNumber(memory); // Verifica se resultado do cálculo não ultrapassou o limite da calculadora 
            if (validated == true) {
                double temporaryNumber = Double.valueOf(calcGUI.inputText.getText());
                if (temporaryNumber != 0) {
                    memory = Double.valueOf(calcGUI.inputText.getText());

                    if (memory == Math.floor(memory)) {
                        long numInt = (long) memory;
                        calcGUI.displayMem.setText("Memory: " + String.valueOf(numInt));
                    } else {
                        calcGUI.displayMem.setText("Memory: " + String.valueOf(memory));
                    }
                }
            } else {
                calcGUI.displayMem.setText("Memory: Maximum number exceeded");
                cleanVariables(5);
            }

        }
        focus();
    }

    // método escreve Memória no Display da Memória
    public void writeMemory() {
        calcGUI.displayMem.setText("Memory");
    }

    // método que chama o número salvo na memória
    public void memoryRecall() {
        pressedOpButton(); //   configura para false as variáveis globais que registram se o usuário já clicou uma ou mais vezes no botão de operações aritméticas e apaga a string no 1º Display para que seja impresso o número escolhido pelo usuário
        boolean tested = validateNumber();  // método verifica se só tem números no 1º display
        if (tested == true) { // se a entrada está correta, ou seja, possui apenas números ou o E, então é true
            formatAcc(memory);//    formata o double para não aparecer o ponto flutuante quando o número é inteiro
            boolean check = formatDynamicallyNegativeNumber(); // coloca parênteses em volta de um número negativo
            if (check == false) {  // se o número não for negativo
                calcGUI.labelExp.setText(mathExpression + " " + calcGUI.inputText.getText());  // imprime o número no 2º display
            }
            numpadTyped = true;  // registra que o usuário já clicou em algum número
            focus(); // mantem o cursor no 1º display
        }
    }

    // método valida a entrada do usuário, permitindo apenas números e o char E do euler 
    public boolean validateNumber() {
        boolean check = true;  // se a entrada está correta, ou seja, possui apenas números ou o E, então é true
        if (!calcGUI.inputText.getText().isEmpty()) {
            if (calcGUI.inputText.getText().contains("Impossible")
                    || calcGUI.inputText.getText().contains("Exceeded")) {
                cleanVariables(2);  // Se no 1º Display (Principal) tiver as palavras Impossible ou Exceeded
                cleanVariables(3); // então várias variáveis são apagadas e reinicializadas
                writeZero();      // depois de apagá-las é impresso 0 no Display Principal 
                check = false;   // false significa que não passou no teste, tem caracteres inválidos
            } else {
                // calcGUI.inputText.getText().matches("^[-0.0-9.0]*$");
                check = true;  // true significa que passou na validação, não tem caracteres inválidos
            }
        }
        if (calcGUI.displayMem.getText().contains("Maximum")) { // se no display da memória contém Maximum
            writeMemory();     // então imprime Memory nele
            cleanVariables(5); // zera a variável memory
        }
        return check;
    }

    // método limpa as variáveis de instância de acordo com o nível escolhido
    public void cleanVariables(int level) {
        switch (level) {
            case 1:
                mathExpression = ""; // apaga a mensagem que é exibida no 2º display
                calcGUI.labelExp.setText(""); // apaga o 2º display
                break;
            case 2: // apaga váriaveis e reseta valores de outras
                calcGUI.labelExp.setText("");
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
                calcGUI.inputText.setText("");
                focus();
                break;
            case 4:
                accOperation = 0;
                aux = 0;
                focus();
                break;
            case 5:
                memory = 0.0;
                focus();
                break;
            default:
                break;
        }
    }

    // método faz o direcionamento para os métodos de cálculo de acordo com a escolha do usuário
    public void arithmeticSwitch() {
        boolean check = validateNumber();
        if (check == true) {  // se o número digitado está OK, ou seja, não tem letras ou não é nulo
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
                    simpleRoot(); // raiz enésima
                    break;
                case 7:               // caso 7, chama o método que calcula porcentagem
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
            boolean validado = maxNumber(number); // Verifica se resultado do cálculo não ultrapassou o limite da calculadora 
            if (validado == true) {
                arithmeticSwitch();  // este método chama os métodos de operação aritmética simples, ex: 2 + 2, 4-2, 10 * 2 ... 
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
                            accMult(); // função acumuladora de Multiplicação da Calculadora 
                            break;
                        case 4:
                            accDiv();  // função acumuladora de Divisão da Calculadora 
                            break;
                        case 5:
                            accPow(); // função acumuladora de potenciação
                            break;
                        default:
                            break;
                    }
                }
                cleanVariables(2);     // apaga váriaveis e reseta valores de outras
                firstOpTyped = true;  //  configura a variável para true para que o resultado do cálculo possa ser aproveitado para mais um novo cálculo 
                numpadTyped = true;  //   configura a variável para true para que o resultado do cálculo possa ser aproveitado para mais um novo cálculo 
                equalsClick = 1;    //    registra que o usuário clicou 1 vez no botão de igual
            }
        }
        focus();
    }

    // método analisa se os botões de operação aritmética devem fazer o papel do botão igual, ou trocar o sinal de operação, 
    // ou fazer uma operação complexa, exemplo: (2+5+9+6+8+) de acordo com a escolha do usuário
    public void calculationHub(short op) {  // Operação Complexa (2+6+9+10+256+986)

        System.out.println("\ncalculationHub(" + op + ")");

        formatZeroPercent();  // apagará a string "[0% of 0 = 0]" do Segundo Display
        boolean check = validateNumber();  // a entrada do usuário é validada
        if (check == true) {  // se passou no teste de validação
            maxNumber(number);  // verifica se o número digitado ou calculado não passou do limite do double
            if (operation != op && operation != 0 // se não é a mesma operação escolhida anteriormente e não é a primeira operação [0], então o botão de operação faz o papel do igual
                    && numpadTyped == true) {  // o usuário já digitou um número, mas a operação escolhida anteriormente não é a mesma que a atual

                System.out.println("[1º IF] Se a operação anterior " + operation + " é != ");
                System.out.println("[1º IF] da operação atual [op: " + op + "]");
                System.out.println("[1º IF] e não é a 1ª operação escolhida");
                System.out.println("[1º IF] e já foi digitado um número: " + numpadTyped + "");
                System.out.println("[1º IF] então foi chamado o método executeAnotherOperation(" + op + ")");

                executeAnotherOperation(op);  // então é chamado o método para fazer o cálculo de outra operação
            }
            if (operation != op && operation != 0 && secondOpTyped == true // se a operação escolhida não for a mesma da anterior e o usuário já clicou em algum botão das operações aritmétcas 1 ou 2 vezes
                    || operation != op && operation != 0 && firstOpTyped == true) { // então ele trocou de operação, escolheu outra

                System.out.println("[2º IF] Se a operação anterior " + operation + " é != ");
                System.out.println("[2º IF] da operação atual [op: " + op + "]");
                System.out.println("[2º IF] Ou se não é a 1ª operação escolhida");
                System.out.println("[2º IF] e firstOpTyped " + firstOpTyped + " ou secondOpTyped " + secondOpTyped);
                System.out.println("[2º IF] então foi chamado o método executeChangeSignal(" + op + ")");

                executeSignalChange(op);  // método que troca de sinal, de + para - por exemplo
            }
            if (operation == op && numpadTyped == true // se a operação escolhida foi adição, por ex: e o usuário já digitou o número no display
                    || operation == 0 && numpadTyped == true) { // então será feito a operação 

                System.out.println("[3º IF] Se a operação anterior " + operation + " é = ");
                System.out.println("[3º IF] a operação atual [op: " + op + "]");
                System.out.println("[3º IF] ou se é a 1ª operação escolhida");
                System.out.println("[3º IF] e já foi digitado um número: " + numpadTyped + "");
                System.out.println("[3º IF] então foi chamado o método executeComplexCalculation(" + op + ")");

                executeComplexCalculation(op);  // faz o cálculo escolhido
            }
            formatLimit(operation);  // o método limpa a string que é exibida no 2º display, caso ultrapasse o tamanho do próprio display, exibindo apenas o último resultado

        }
        focus();  // faz o cursor ficar em cima do display principal
    }

    // método que faz a operação aritmética da opção anterior do usuário
    public void executeAnotherOperation(short op) {

        System.out.println("\nexecuteAnotherOperation(" + op + ")");
        System.out.println("Chamou o método arithmetic");
        System.out.println("e o formatAnotherOperation(" + op + ")");

        arithmeticSwitch();  // chama o método arithmeticSwitch que direciona para o método de operação simples de acordo com a operação escolhida pelo usuário
        formatAnotherOperation(op); // método que formata a expressão matemática no 2º display, trocando o sinal de operação nela
        operation = op;  // depois que foi feito o cálculo de outra operação, por ex., o botão de soma fez o papel do igual, a operação agora será exemplo: [1 - soma], não mais a anterior escolhida pelo usuário 
        accOperation = operation;  // agora o número da operação é salvo na memória RAM, para ser usado no acumulador
        countOpClick = 1; // como é a primeira vez que o usuário clicou no botão de operação, a contagem de clique aumenta para 1
        equalsClick = 0;  // a contagem da quantidade de clicks em cima do = é configurada para 0
        numpadTyped = false;  // o registro do clique do mouse em cima do teclado numérico é configurado como falso
        firstOpTyped = true;  // o registro do clique do mouse em cima do botão de operação é configurado como verdadeiro
        secondOpTyped = true; // é registrado que o usuário deu o 2º clique em um botão de operação aritmética

        System.out.println("Configurou as variáveis");
        System.out.println("operation(" + operation + ") = op(" + op + ")");
        System.out.println("accOperation(" + accOperation + ") = operation(" + operation + ")");
        System.out.println("countOpClick(" + countOpClick + ")");
        System.out.println("equalsClick(" + equalsClick + ")");
        System.out.println("numpadTyped(" + numpadTyped + ")");
        System.out.println("firstOpTyped(" + firstOpTyped + ")");
        System.out.println("SecondOpTyped(" + secondOpTyped + ")");
    }

    // método faz a troca de sinal, quando o usuário decidir fazer outra operação aritmética
    public void executeSignalChange(short op) {

        System.out.println("\nexecuteSignalChange(" + op + ")");

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
        calcGUI.labelExp.setText(mathExpression); // o sinal da nova operação aritmetica é impressa no 2º display
        equalsClick = 0;
        operation = op;              // a nova operação aritmética escolhida é salva na variável global operation                      
        accOperation = operation;   // e também é salva na variável global accOperation, caso o usuário faça acumulação pressionando várias vezes o botão de igual

        System.out.println("Configurou as variáveis");
        System.out.println("operation(" + operation + ") = op(" + op + ")");
        System.out.println("accOperation(" + accOperation + ") = accOperation(" + operation + ")");
        System.out.println("equalsClick(" + equalsClick + ")");
    }

    // método que formata a expressão matemática no 2º display, trocando o sinal de operação nela
    public void formatAnotherOperation(short op) {
        if (!calcGUI.inputText.getText().contains("Impossible")
                && !calcGUI.inputText.getText().contains("Exceed")) {
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
            calcGUI.labelExp.setText(mathExpression);  // então a string é exibida no 2º display
        }
    }

    // método prepara as variáveis para ser feita a operação complexa, por ex: 2 + 6 + 8 * 9 /12 - 5
    public void executeComplexCalculation(short op) {

        System.out.println("\nexecuteComplexCalculation(" + op + ")");

        operation = op;
        accOperation = operation;
        equalsClick = 0; // registro da quantidade de cliques no botão igual é configurado para 0

        System.out.println("Configurou as variáveis");
        System.out.println("operation(" + operation + ") = op(" + op + ")");
        System.out.println("accOperation(" + accOperation + ") = operation(" + operation + ")");
        System.out.println("equalsClick(" + equalsClick + ")");

        if (countOpClick == 0) {  // se o usuário clicou a primeira vez em um botão de operação aritmética         
            number = Double.valueOf(calcGUI.inputText.getText()); // entao o número digitado é salvo em number
            if (number < 0) {
                formatNegativeNumber(op);

            } else if (number >= 0) {
                formatZero();
                formatPositiveNumber(op);
            }
            firstOpTyped = true;  // é registado que o usuário clicou a 1º vez no botão de operação
            numpadTyped = false;  // então é desativado o registro do clique no teclado numérico

            System.out.println("[1º IF] Se o countOpClick = " + countOpClick + " então");
            System.out.println("[1º IF] Configurou as variáveis");
            System.out.println("[1º IF] firstOpTyped " + firstOpTyped);
            System.out.println("[1º IF] numpadTyped " + numpadTyped);

        } else if (countOpClick == 1 && secondOpTyped == false) {  // se foi a 2º vez seguida que o usuário clicou no botão de operação, então ele está fazendo operações consecutivas, complexas
            aux = Double.valueOf(calcGUI.inputText.getText());  // o 2º operando é salvo na memória RAM para fazer a acumulação

            System.out.println("[2º IF] Se o countOpClick = " + countOpClick);
            System.out.println("[2º IF] e o secondOpTyped = " + secondOpTyped + " então");
            System.out.println("[2º IF] a variável auxliar recebeu o 2º operando = " + aux);
            System.out.println("Chamou o método calculationSwitch(" + op + ")");

            calculationSwitch(op);

            if (!calcGUI.inputText.getText().contains("Impossible") && !calcGUI.inputText.getText().contains("Exceed")) {
                boolean check = maxNumber(number); // depois é checado se o valor calculado não excedeu o limite do double
                if (check == true) { // senão excedeu o valor, então é feito a formatação do resultado para mostar nos displays
                    formatResult();  // formata o resultado final para exibir no Display
                    formatComplexOp(); // método que formata o resultado dos cálculos para mostar no 2º display
                }
                secondOpTyped = true; // é registrado que o usuário clicou a 2º no botão de operação
                numpadTyped = false; // é desativado o registro do clique do teclado numérico
            }
            System.out.println("\n[2º IF] Voltou para o método executeComplexCalculation");
            System.out.println("[2º IF] Configurou as variáveis");
            System.out.println("[2º IF] secondOpTyped " + secondOpTyped);
            System.out.println("[2º IF] numpadTyped " + numpadTyped);
            System.out.println("[2º IF] Estado  das variáveis");
            System.out.println("[2º IF] firstOpTyped " + firstOpTyped);

        }
        calcGUI.labelExp.setText(mathExpression); // depois de feitos os cálculos, o resultado formatado é exibido no 2º display
        countOpClick = 1;  // é registado que o usuário clicou 1 ou mais vezes em cima dos botões de operações aritméticas

        System.out.println("[Final do método]");
        System.out.println("countOpClick " + countOpClick);

    }

    // método faz o cálculo complexo, ex: 2 + 9 + 5 * 6 / 8 - 9 ^ 2
    public void calculationSwitch(short op) {

        System.out.println("\ncalculationSwitch(" + op + ")");
        System.out.println("Realizou o Cálculo: (" + op + ")");

        switch (op) {
            case 1:
                number = number + Double.valueOf(calcGUI.inputText.getText()); // então são feitas as adições complexas, sucessivas
                break;
            case 2:
                number = number - Double.valueOf(calcGUI.inputText.getText()); // então são feitas as subtrações complexas, sucessivas
                break;
            case 3:
                number = number * Double.valueOf(calcGUI.inputText.getText()); // então são feitas as multiplicações complexas, sucessivas
                break;
            case 4:
                double dividend = Double.valueOf(calcGUI.inputText.getText());
                if (dividend != 0) {
                    number = number / dividend;
                } else {
                    formatImpossibleToDivideBy0();
                }
                break;
            case 5:
                number = (double) Math.pow(number, Double.valueOf(calcGUI.inputText.getText()));
                break;
            case 6:
                double num = Double.valueOf(calcGUI.inputText.getText());
                number = Math.pow(num, 1 / aux);
                break;
        }
    }

    // caso o número seja dividido por zero, aparecerá a mensagem no 1º Display
    public void formatImpossibleToDivideBy0() {
        calcGUI.inputText.setText("Impossible to Divide by 0");
        cleanVariables(2);
        cleanVariables(4);
    }

    // formata o número durante as operações simples, ex: 2 + 2 = 4
    // para nao aparecer o ponto flutuante se o número for inteiro
    public void formatSimpleOp() {
        if (number == Math.floor(number) && number < 0) {
            long numInt = (long) number;
            mathExpression = mathExpression + " = (" + numInt + ") ";
            calcGUI.inputText.setText(String.valueOf(numInt));

        } else if (number == Math.floor(number) && number >= 0) {
            long numInt = (long) number;
            mathExpression = mathExpression + " = " + numInt;
            calcGUI.inputText.setText(String.valueOf(numInt));

        } else if (number > Math.floor(number) && number < 0) {
            mathExpression = mathExpression + " = (" + number + ") ";
            calcGUI.inputText.setText(String.valueOf(number));

        } else if (number > Math.floor(number) && number >= 0) {
            mathExpression = mathExpression + " = " + number;
            calcGUI.inputText.setText(String.valueOf(number));
        }
    }

    // método que formata a string no display principal, para não exibir o ponto flutuante, 
    // caso não seja um número decimal, por ex: 100, exibiria apenas 100, e não 100.0 
    public void formatAcc(double number) {
        if (number == Math.floor(number)) {
            long numInt = (long) number;
            calcGUI.inputText.setText(String.valueOf(numInt));
        } else {
            calcGUI.inputText.setText(String.valueOf(number));
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
            //  num = String.format("%.2f", number);
            num = String.valueOf(number); // se for um número decimal a variável number é convertida em String
        }
        return num;
    }

    // formata o número do 1º display, quando é um cálculo com porcentagem
    public void formatPercent1Display(double numPerc) {

        if (numPerc == Math.floor(numPerc)) {
            long numInt = (long) numPerc;
            calcGUI.inputText.setText(String.valueOf(numInt));
        } else {
            calcGUI.inputText.setText(String.valueOf(numPerc));
        }
    }

    // método formata a string do 2º display, durante as operação aritméticas complexas
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
            calcGUI.inputText.setText(String.valueOf(numInt));

        } else if (number == Math.floor(number) && number >= 0) {
            long numInt = (long) number;
            mathExpression = mathExpression + " = " + numInt + "" + signal;
            calcGUI.inputText.setText(String.valueOf(numInt));

        } else if (number > Math.floor(number) && number < 0) {
            mathExpression = mathExpression + " = (" + number + ") " + signal;
            calcGUI.inputText.setText(String.valueOf(number));

        } else if (number > Math.floor(number) && number >= 0) {

            mathExpression = mathExpression + " = " + number + "" + signal;
            calcGUI.inputText.setText(String.valueOf(number));
        }
    }

    // se o resultado da operação aritmética gerar um número negativo
    // o método o imprimirá entre parênteses no 2º display
    public void formatResult() {
        if (Double.valueOf(calcGUI.inputText.getText()) < 0) {
            mathExpression = mathExpression + "(" + calcGUI.inputText.getText() + ") ";
        } else if (Double.valueOf(calcGUI.inputText.getText()) == 0) {
            mathExpression = mathExpression + "0";
        } else if (Double.valueOf(calcGUI.inputText.getText()) > 0) {
            mathExpression = mathExpression + calcGUI.inputText.getText();
        }
    }
    // método coloca dinamicamente em parênteses um número negativo, enquanto 
    // estiver sendo digitado, incluindo sendo apagado também, digito, por digito

    public boolean formatDynamicallyNegativeNumber() {
        boolean check = false;
        if (!calcGUI.inputText.getText().isEmpty()) {
            if (Double.valueOf(calcGUI.inputText.getText()) < 0 || calcGUI.inputText.getText().contains("-")) {
                // Se número for menor que 0, o método colocará () ao redor do número negativo
                calcGUI.labelExp.setText(mathExpression + "(" + calcGUI.inputText.getText() + ")");
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
                mathExpression = mathExpression + "(" + calcGUI.inputText.getText() + ") + ";
                break;
            case 2:
                mathExpression = mathExpression + "(" + calcGUI.inputText.getText() + ") - ";
                break;
            case 3:
                mathExpression = mathExpression + "(" + calcGUI.inputText.getText() + ") x ";
                break;
            case 4:
                mathExpression = mathExpression + "(" + calcGUI.inputText.getText() + ") / ";
                break;
            case 5:
                mathExpression = mathExpression + "(" + calcGUI.inputText.getText() + ") ^ ";
                break;
            default:
                mathExpression = mathExpression + "(" + calcGUI.inputText.getText() + ") √ ";
                break;
        }
    }

    // método formata a string do 2º display, caso o resultado seja um número positivo
    // e depois do número imprime o sintal da operação escolhida, ex:  256 + 
    public void formatPositiveNumber(short op) {
        switch (op) {
            case 1:
                mathExpression = mathExpression + calcGUI.inputText.getText() + " + ";
                break;
            case 2:
                mathExpression = mathExpression + calcGUI.inputText.getText() + " - ";
                break;
            case 3:
                mathExpression = mathExpression + calcGUI.inputText.getText() + " x ";
                break;
            case 4:
                mathExpression = mathExpression + calcGUI.inputText.getText() + " / ";
                break;
            case 5:
                mathExpression = mathExpression + calcGUI.inputText.getText() + " ^ ";
                break;
            default:
                mathExpression = mathExpression + calcGUI.inputText.getText() + " √ ";
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
        if (calcGUI.labelExp.getText().equals("[0% of 0 = 0]")) {
            cleanVariables(1);
        }
    }

    // se o tamanho da string do 1º display ultrapassar 40 algarismos, os botões númericos serão bloqueados
    public boolean formatMaxSize() {
        boolean maxsize = false;
        int size = calcGUI.inputText.getText().length();  // é salvo em size o tamanho da string
        if (size >= 40) {  // se a quant. de algarismos digitados pelo usuário for maior ou igual a 40
            maxsize = true; // maxsize é configurado para true, então o usuário não conseguirá mais digitar algarismos
        }
        return maxsize;
    }

    // método imprime zero no 1º display e apaga a expressão matemática que aparece no 2º display
    public void formatZero() {
        if (Double.valueOf(calcGUI.inputText.getText()) == 0) {
            calcGUI.inputText.setText("0");
            mathExpression = "";
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
        if (size >= 40) { // tamanho máximo permitido na string, 40 posições
            if (operation >= 7) {
                mathExpression = "";
                mathExpression = number + " " + signal + " [" + aux + "% = ";
                mathExpression = mathExpression + calcGUI.inputText.getText() + "]";
            } else {
                if (number == Math.floor(number) && number < 0) {
                    long numInt = (long) number;
                    mathExpression = "(" + String.valueOf(numInt) + ") " + signal;
                    calcGUI.inputText.setText(String.valueOf(numInt));

                } else if (number == Math.floor(number) && number >= 0) {
                    long numInt = (long) number;
                    mathExpression = String.valueOf(numInt) + signal;
                    calcGUI.inputText.setText(String.valueOf(numInt));

                } else if (number > Math.floor(number) && number < 0) {
                    mathExpression = "(" + String.valueOf(number) + ") " + signal;
                    calcGUI.inputText.setText(String.valueOf(number));

                } else if (number > Math.floor(number) && number >= 0) {
                    mathExpression = String.valueOf(number) + signal;
                    calcGUI.inputText.setText(String.valueOf(number));
                }
            }
        }
        calcGUI.labelExp.setText(mathExpression);
        firstOpTyped = true;
    }

    // método faz os cálculos sucessivos de acumulação, da operação de Soma
    // quando o usuário ficar clicando sucessivamente no botão de igual
    public void accSum() {
        number = Double.valueOf(calcGUI.inputText.getText());
        number = number + aux;
        boolean check = maxNumber(number);
        if (check == true) {
            formatAcc(number);
        }
    }

    // método faz a soma simples, ex: 2 + 2
    public void simpleSum() {
        formatResult();
        aux = Double.valueOf(calcGUI.inputText.getText());
        number = number + Double.valueOf(calcGUI.inputText.getText());
        boolean check = maxNumber(number);
        if (check == true) {
            calcGUI.inputText.setText(String.valueOf(number));
            formatSimpleOp();
        }
    }

    // método faz os cálculos sucessivos de acumulação, da operação de subtração
    // quando o usuário ficar clicando sucessivamente no botão de igual
    public void accSub() {
        number = Double.valueOf(calcGUI.inputText.getText());
        number = number - aux;
        boolean check = maxNumber(number);
        if (check == true) {
            formatAcc(number);
        }
    }

    // método faz a subtração simples, ex: 4-2
    public void simpleSub() {
        formatResult();
        aux = Double.valueOf(calcGUI.inputText.getText());
        number = number - Double.valueOf(calcGUI.inputText.getText());
        boolean check = maxNumber(number);
        if (check == true) {
            calcGUI.inputText.setText(String.valueOf(number));
            formatSimpleOp();
        }
    }

    // método faz os cálculos sucessivos de acumulação, da operação de Multiplicação
    // quando o usuário ficar clicando sucessivamente no botão de igual
    public void accMult() {
        number = Double.valueOf(calcGUI.inputText.getText());
        number = number * aux;
        boolean check = maxNumber(number);
        if (check == true) {
            formatAcc(number);
        }
    }

    // método faz a multiplicação simples, ex: 4*4
    public void simpleMult() {
        formatResult();
        aux = Double.valueOf(calcGUI.inputText.getText());
        number = number * Double.valueOf(calcGUI.inputText.getText());
        boolean check = maxNumber(number);
        if (check == true) {
            calcGUI.inputText.setText(String.valueOf(number));
            formatSimpleOp();
        }
    }

    // método faz os cálculos sucessivos de acumulação, da operação de Divisão
    // quando o usuário ficar clicando sucessivamente no botão de igual
    public void accDiv() {
        if (Double.valueOf(calcGUI.inputText.getText()) != 0) {
            number = Double.valueOf(calcGUI.inputText.getText());
            number = number / aux;
            boolean check = maxNumber(number);
            if (check == true) {
                formatAcc(number);
            }
        } else {
            formatImpossibleToDivideBy0();
        }
    }

    // método faz divisão simples, ex: 10/2 e se for uma divisão por zero, exibe
    // que é impossível dividir por zero
    public void simpleDiv() {
        if (Double.valueOf(calcGUI.inputText.getText()) != 0) {
            formatResult();
            aux = Double.valueOf(calcGUI.inputText.getText());
            number = number / Double.valueOf(calcGUI.inputText.getText());
            boolean check = maxNumber(number);
            if (check == true) {
                calcGUI.inputText.setText(String.valueOf(number));
                formatSimpleOp();
            }
        } else {
            formatImpossibleToDivideBy0();
        }
    }

    // método faz os cálculos sucessivos de acumulação, da operação de Potenciação
    // quando o usuário ficar clicando sucessivamente no botão de igual
    public void accPow() {
        number = Double.valueOf(calcGUI.inputText.getText());
        number = Math.pow(number, aux);
        boolean check = maxNumber(number);
        if (check == true) {
            formatAcc(number);
        }
    }

    // método faz o calculo de potenciação simples, ex: 2^62 
    public void simplePow() {
        formatResult();
        aux = Double.valueOf(calcGUI.inputText.getText());
        number = (double) Math.pow(number, Double.valueOf(calcGUI.inputText.getText()));
        boolean check = maxNumber(number);
        if (check == true) {
            formatSimpleOp();
        }
    }

    // método faz o cálculo de raiz enésima
    public void simpleRoot() {
        formatResult();
        aux = Double.valueOf(calcGUI.inputText.getText());
        number = Math.pow(Double.valueOf(calcGUI.inputText.getText()), 1 / number);
        boolean check = maxNumber(number);
        if (check == true) {
            formatSimpleOp();
        }
    }

    // método prepara as variáveis para poder ser feito os cálculos de porcentagem
    // misturados com as operações aritméticas básicas
    public void percentStart() {
        boolean check = validateNumber();  // verifica se a entrada do usuário tem apenas números
        if (check == true) {              // true significa que só tem números
            boolean test = maxNumber(number); // verifica se o número não ultrapassou o limite do double
            if (test == true) {              // true significa que não ultrapassou
                if (operation == 0 || operation == 1 || operation == 2
                        || operation == 3 || operation == 4
                        || operation == 7 || operation == 8
                        || operation == 9 || operation == 10) {
                    switch (operation) {
                        case 0:
                            accOperation = 11; // é salvo na memória como 11 uma operação inicial de porcentagem, ex: (150 % = 1.50), sem as operações básicas (+ - * /)
                            equalsClick = 0;  //  configurado a quantidade de cliques no botão de igual para 0, para ser possível utilizar o backspace após uma operação de porcentagem inicial, de número 11
                            break;
                        case 1:             // adição sem porcentagem
                            operation = 7; // se tornará a adição usada juntamente com a porcentagem
                            break;
                        case 2:            // subtração 
                            operation = 8;
                            break;
                        case 3:           // multiplicação
                            operation = 9;
                            break;
                        case 4:          // divisão
                            operation = 10;
                            break;
                        default:
                            break;
                    }
                    formatPercentMultiCalculation(); // formata a expressão matemática com porcentagem impressa no 2º display
                    if (operation == 0) {  // se não foi escolhido nenhuma operação, então o usuário digitou um número e depois clicou no botão de porcentagem, assim o número será dividido por 100
                        number = Double.valueOf(calcGUI.inputText.getText()) / 100;
                        formatPercent1Display(number);
                    } else {
                        mathExpression = mathExpression + "[" + calcGUI.inputText.getText() + "% of " + formatPercent2Display(number) + " = ";
                        double numPerc = (number / 100) * Double.valueOf(calcGUI.inputText.getText());
                        aux = numPerc;
                        check = maxNumber(numPerc);
                        if (check == true) {
                            formatPercent1Display(numPerc);
                            mathExpression = mathExpression + formatPercent2Display(Double.valueOf(calcGUI.inputText.getText())) + "]";
                            calcGUI.labelExp.setText(mathExpression);
                            formatLimit(7);
                        }
                    }
                }
                firstOpTyped = true;
                numpadTyped = true;
            }
        }
    }

    // método faz os cálculos de porcentagem misturados com as operações aritméticas básicas
    // e chama os métodos de formatação do resultado para apresentá-lo no 2º display
    public void percentCalc() {
        switch (operation) {
            case 7:
                number = number + Double.valueOf(calcGUI.inputText.getText());
                break;
            case 8:
                number = number - Double.valueOf(calcGUI.inputText.getText());
                break;
            case 9:
                number = number * Double.valueOf(calcGUI.inputText.getText());
                break;
            case 10:
                double dividend = Double.valueOf(calcGUI.inputText.getText());
                if (dividend != 0) {
                    number = number / dividend;
                } else {
                    formatImpossibleToDivideBy0();
                }
                break;
            default:
                break;
        }
        if (!calcGUI.inputText.getText().contains("Impossible")) {
            boolean check = maxNumber(number);
            if (check == true) {
                formatAcc(number);
                mathExpression = mathExpression + " = " + calcGUI.inputText.getText();
                calcGUI.labelExp.setText(mathExpression);
            }
        }
    }

    // método coloca o cursor no 1º display, caso ele seja desbloqueado para escrita direta, que atualmente não é, a caixa de texto está bloqueada para escrita
    public void focus() {
        calcGUI.inputText.requestFocus();
    }

    // método sobrepõe o zero por outro número no 1º display 
    public void replaceZero() {
        if (!calcGUI.inputText.getText().isEmpty()) {
            String input = calcGUI.inputText.getText();
            int i = input.length();
            if (i == 1 && input.charAt(0) == '0') {
                calcGUI.inputText.setText("");
            }
        }
    }

    // método coloca o sinal de negativo no número, e o retira, se o usuário clicar no botão novamente
    public void negativeNumber() {
        if (!calcGUI.inputText.getText().isEmpty()) {
            boolean maxsize = formatMaxSize();
            // if (maxsize == false && equalsClick == 0) {
            if (maxsize == false/* && equalsClick == 0*/) {
                String input = "";  // String input = calcGUI.inputText.getText();
                String signal = "";
                if (Double.valueOf(calcGUI.inputText.getText()) == 0) {
                    // Se a entrada do usuário for igual a 0, o método não colocará o signal de -
                } else {
                    if (!calcGUI.inputText.getText().contains("-")) {
                        calcGUI.inputText.setText("-" + calcGUI.inputText.getText());
                        signal = mathExpression + "(" + calcGUI.inputText.getText() + ")";
                    } else {
                        input = calcGUI.inputText.getText();
                        StringBuilder str = new StringBuilder(input);
                        input = String.valueOf(str.delete(0, 1));
                        calcGUI.inputText.setText(input);
                        signal = mathExpression + input;
                    }
                    calcGUI.labelExp.setText(signal);
                    firstOpTyped = false;
                    secondOpTyped = false;
                    numpadTyped = true;
                }
            }
        }
        focus();
    }

    // método altera para FALSE as variáveis que salvam se o usuário
    // deu o primeiro ou segundo click nos botõe de operação
    public void pressedOpButton() {
        if (firstOpTyped == true) {  // se já deu o 1º clique no botão de operação
            calcGUI.inputText.setText(""); // apaga o 1º display
            firstOpTyped = false;    // então volta para FALSE;
        }
        if (secondOpTyped == true) { // se já deu o 2º clique no botão de operação
            calcGUI.inputText.setText(""); // apaga o 1º display
            secondOpTyped = false;   // então volta para FALSE;
        }
        if (equalsClick == 1) {      // se já clicou uma vez no botão de igual
            calcGUI.inputText.setText(""); // apaga o 1º display
            equalsClick = 0;        // e reseta o registro do clique do mouse para 0
        }
    }

    // método escreve 0 no 1º display
    public void writeZero() {
        calcGUI.inputText.setText("0");
        numpadTyped = true;  // é registrado que o usuário clicou no botão zero
        focus();
    }

    // método do botão 0
    public void b0Action() {
        validateNumber();   // método valida a entrada do usuário, permitindo apenas números e o char E do euler 
        pressedOpButton(); // configura para false as variáveis globais que registram se o usuário já clicou uma ou mais vezes no botão de operações aritméticas e apaga a string no 1º Display para que seja impresso o número escolhido pelo usuário 
        boolean maxsize = formatMaxSize();  // verifica se a quantidade de algarismos digitados pelo usuário não ultrapassou 19 
        if (maxsize == false) { // se o número nao ultrapassou 19 caracteres
            if (!calcGUI.inputText.getText().equals("0")) { // se o número digitado anteriormente pelo usuário for diferente de zero
                calcGUI.inputText.setText(calcGUI.inputText.getText() + "0"); // então é impresso no 1º display, o algarismo zero
                boolean check = formatDynamicallyNegativeNumber(); // coloca parênteses em volta de um número negativo
                if (check == false) { // se o número não for negativo
                    calcGUI.labelExp.setText(mathExpression + " " + calcGUI.inputText.getText()); // imprime o número no 2º display
                }
                numpadTyped = true; // é registrado que o usuário clicou no botão zero
            } else if (calcGUI.inputText.getText().equals("0")) { // se o número escolhido for 0
                calcGUI.labelExp.setText(mathExpression + " " + calcGUI.inputText.getText()); // então ele é impresso no 2º display
            }
        }
        focus();  // mantem o cursor no 1º display
    }

    // método que imprime os números de 1 a 9 nos displays 
    public void numPadAction(int num) {
        validateNumber();    // método valida a entrada do usuário, permitindo apenas números e o char E do euler 
        replaceZero();      //  caso tenha apenas o algarismo zero na tela, apaga a string para imprimir o número digitado pelo usuário
        pressedOpButton(); //   configura para false as variáveis globais que registram se o usuário já clicou uma ou mais vezes no botão de operações aritméticas e apaga a string no 1º Display para que seja impresso o número escolhido pelo usuário
        boolean maxsize = formatMaxSize();  // verifica se a quantidade de algarismos digitados pelo usuário não ultrapassou 19
        if (maxsize == false) { // se não atingiu a quant. máxima de algarismos, é impresso o número digitado no 1º Display
            calcGUI.inputText.setText(calcGUI.inputText.getText() + num);  // imprime no 1ª display o número digitado
            boolean check = formatDynamicallyNegativeNumber(); // coloca parênteses em volta de um número negativo
            if (check == false) {  // se o número não for negativo
                calcGUI.labelExp.setText(mathExpression + " " + calcGUI.inputText.getText());  // imprime o número no 2º display
            }
            numpadTyped = true;  // registra que o usuário já clicou em algum número
        }
        focus(); // mantem o cursor no 1º display
    }

    // método para o botão do backspace
    public void backSpaceAction() {
        boolean check = validateNumber();
        if (check == true) {
            if (operation == 0 || operation == 1 || operation == 2 // se as operações não forem de porcentagem
                    || operation == 3 || operation == 4
                    || operation == 5 || operation == 6) {

                if (secondOpTyped == false && equalsClick == 0
                        && !calcGUI.inputText.getText().contains("E")) {
                    String input = calcGUI.inputText.getText();      // salva a entrada do usuário em input
                    StringBuilder str = new StringBuilder(input);  // transforma o objeto String em StringBuilder
                    input = String.valueOf(str.deleteCharAt(input.length() - 1));  // deleta da última posição até a 1º
                    calcGUI.inputText.setText(input);               // exibe a string no display principal 

                    if (calcGUI.inputText.getText().equals("-0")) {
                        input = "";    // não a deixa nula e apaga o -(número negativo)
                        writeZero();   // depois imprime o zero
                    }

                    if (input.length() == 0 || calcGUI.inputText.getText().equals("-")) {  // se o tamanho da string for 0 ou se o número for negativo
                        input = "";    // não a deixa nula e apaga o -(número negativo)
                        writeZero();   // depois imprime o zero
                    }
                    if (numpadTyped == true && equalsClick == 0) {          // se já foi digitado algum número  
                        boolean checagem = formatDynamicallyNegativeNumber();
                        if (checagem == false && accOperation != 11) { // se não é um número negativo e não for uma operação de porcentagem inicial, definida como 11, ex: (150 % = 1.50)
                            calcGUI.labelExp.setText(mathExpression + input);  // então mostra a string no 2º display
                        }
                    }
                    if (numpadTyped == true && equalsClick == 1 && firstOpTyped == false) {
                        boolean checagem = formatDynamicallyNegativeNumber();
                        if (checagem == false) { // se não é número negativo
                            calcGUI.labelExp.setText(mathExpression + input);  // mostra a string no 2º display
                        }
                    }
                }
            }
        }
        if (equalsClick == 0) {
            firstOpTyped = false;
        }
        focus();
    }

    // método imprime o . no número, para os números se tornarem decimais
    public void bFloatAction() {
        boolean check = validateNumber();
        boolean maxsize = formatMaxSize();
        if (maxsize == false && equalsClick == 0) {
            if (!calcGUI.inputText.getText().contains(".") && check == true) {
                calcGUI.inputText.setText(calcGUI.inputText.getText() + ".");
                firstOpTyped = false;
                secondOpTyped = false;
                numpadTyped = true;
                boolean checagem = formatDynamicallyNegativeNumber();
                if (checagem == false) { // se não é número negativo
                    calcGUI.labelExp.setText(mathExpression + "" + calcGUI.inputText.getText());
                }
            }
        }
        focus();
    }

    // método do botão CE, apaga o último número digitado
    public void bCleanNumAction() {
        String input = calcGUI.inputText.getText();
        StringBuilder str = new StringBuilder(input);
        input = String.valueOf(str.delete(0, str.length()));
        calcGUI.inputText.setText(input);
        calcGUI.labelExp.setText(mathExpression + input);
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
            numPadAction(1); // 1
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD2
                || evt.getKeyCode() == KeyEvent.VK_2) {
            numPadAction(2); // 1
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD3
                || evt.getKeyCode() == KeyEvent.VK_3) {
            numPadAction(3); // 3
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD4
                || evt.getKeyCode() == KeyEvent.VK_4) {
            numPadAction(4); // 4
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD5
                || evt.getKeyCode() == KeyEvent.VK_5) {
            numPadAction(5); // 5
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD6
                || evt.getKeyCode() == KeyEvent.VK_6) {
            numPadAction(6); // 6
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD7
                || evt.getKeyCode() == KeyEvent.VK_7) {
            numPadAction(7); // 7
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD8
                || evt.getKeyCode() == KeyEvent.VK_8) {
            numPadAction(8); // 8
        } else if (evt.getKeyCode() == KeyEvent.VK_NUMPAD9
                || evt.getKeyCode() == KeyEvent.VK_9) {
            numPadAction(9); // 9
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
        boolean check = true; // se o número não passou do limite 
        double max = Math.pow(2, 63);
        if (num >= max || num <= -max // se o número chegou ao limite da calculadora
                || Double.valueOf(calcGUI.inputText.getText()) >= max
                || Double.valueOf(calcGUI.inputText.getText()) <= -max) {
            calcGUI.inputText.setText("Calculation Exceeded"); // então exibe Cálculo Excedido
            //        calcGUI.labelExp.setText(mathExpression);
            cleanVariables(2); // apaga as variaveis, se excedeu o número máximo
            cleanVariables(4);
            check = false; // se passou do limite
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

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
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
