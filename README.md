# estudoBot
## estudos sobre Bot em java (Robot)

### https://www.devmedia.com.br/utilizando-a-classe-robot-em-java/2363

Utilizando a classe Robot em Java

A classe Java.awt.Robot é usada para pegar o controle do mouse e do teclado. Uma vez que você obtém o controle, você pode fazer qualquer tipo de operação relacionado com o mouse e com o teclado através de seu código java. Esta classe é usada geralmente para a automatização de testes.

Este código mostra o uso da classe Robot para manipular os eventos do teclado. Se você rodar este código e abrir um notepad então este código escreverá “OI MUNDO” no notepad.

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotExp {
    
    public static void main(String[] args) {
        
        try {
            
            Robot robot = new Robot();
            // Cria um delay de 5 segundos de modo que você possa abrir o notepad antes da execução do código a seguir
            // Robot começa a escrever
            robot.delay(5000);
            robot.keyPress(KeyEvent.VK_O);
            robot.keyPress(KeyEvent.VK_I);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_M);
            robot.keyPress(KeyEvent.VK_U);
            robot.keyPress(KeyEvent.VK_N);
            robot.keyPress(KeyEvent.VK_D);

            robot.keyPress(KeyEvent.VK_O);
            
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
}
