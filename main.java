
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
