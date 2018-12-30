package ba.unsa.etf.rpr.tutorijal05;

import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

@ExtendWith(ApplicationExtension.class)
class MainTest {

    private TextField display;

    @Start
    public void start (Stage stage) throws Exception {
        Parent mainNode = FXMLLoader.load(Main.class.getResource("digitron.fxml"));
        stage.setScene(new Scene(mainNode));
        stage.show();
        stage.toFront();
    }

    @Test
    public void startWithZero (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        assertEquals("0", display.getText());
    }

    @Test
    public void numberOne (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn1");
        assertEquals("1.0", display.getText());
    }

    @Test
    public void number123 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#btn3");
        assertEquals("123.0", display.getText());
    }

    @Test
    public void number123Plus456 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#btn3");
        robot.clickOn("#plusBtn");
        robot.clickOn("#btn4");
        robot.clickOn("#btn5");
        robot.clickOn("#btn6");
        assertEquals("456.0", display.getText());
    }

    @Test
    public void number123Plus456Equals (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#btn3");
        robot.clickOn("#plusBtn");
        robot.clickOn("#btn4");
        robot.clickOn("#btn5");
        robot.clickOn("#btn6");
        robot.clickOn("#equalsBtn");
        assertEquals("579.0", display.getText());
    }

    @Test
    public void dotBtn (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn8");
        robot.clickOn("#btn8");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn8");
        robot.clickOn("#btn8");
        robot.clickOn("#plusBtn");
        robot.clickOn("#btn1");
        robot.clickOn("#equalsBtn");
        assertEquals("89.88", display.getText());
    }

    @Test
    public void zeroBtn (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn0");
        robot.clickOn("#btn0");
        assertEquals("0.0", display.getText());
    }

    @Test
    public void zeroBtn2 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn0");
        robot.clickOn("#btn0");
        robot.clickOn("#btn1");
        robot.clickOn("#btn0");
        assertEquals("10.0", display.getText());
    }

    @Test
    public void divideWithZero (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn1");
        robot.clickOn("#divideBtn");
        robot.clickOn("#btn0");
        robot.clickOn("#equalsBtn");
        assertEquals("infinity", display.getText());
    }

    @Test
    public void divide12With2 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#divideBtn");
        robot.clickOn("#btn2");
        robot.clickOn("#equalsBtn");
        assertEquals("6.0", display.getText());
    }

    @Test
    public void multiply12With2 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#multiplyBtn");
        robot.clickOn("#btn2");
        robot.clickOn("#equalsBtn");
        assertEquals("24.0", display.getText());
    }

    @Test
    public void module12With2 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#moduleBtn");
        robot.clickOn("#btn2");
        robot.clickOn("#equalsBtn");
        assertEquals("0.0", display.getText());
    }

    @Test
    public void module12With5 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn1");
        robot.clickOn("#btn2");
        robot.clickOn("#moduleBtn");
        robot.clickOn("#btn5");
        robot.clickOn("#equalsBtn");
        assertEquals("2.0", display.getText());
    }

    @Test
    public void subtract237From537 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn5");
        robot.clickOn("#btn3");
        robot.clickOn("#btn7");
        robot.clickOn("#minusBtn");
        robot.clickOn("#btn2");
        robot.clickOn("#btn3");
        robot.clickOn("#btn7");
        robot.clickOn("#equalsBtn");
        assertEquals("300.0", display.getText());
    }

    @Test
    public void number237minus537 (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn2");
        robot.clickOn("#btn3");
        robot.clickOn("#btn7");
        robot.clickOn("#minusBtn");
        robot.clickOn("#btn5");
        robot.clickOn("#btn3");
        robot.clickOn("#btn7");
        robot.clickOn("#equalsBtn");
        assertEquals("-300.0", display.getText());
    }

    @Test
    public void dotAdd (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn2");
        robot.clickOn("#btn3");
        robot.clickOn("#btn7");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn5");
        robot.clickOn("#btn5");
        robot.clickOn("#plusBtn");
        robot.clickOn("#btn5");
        robot.clickOn("#btn3");
        robot.clickOn("#btn7");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn4");
        robot.clickOn("#btn4");
        robot.clickOn("#equalsBtn");
        assertEquals("774.99", display.getText());
    }

    @Test
    public void dotMinus (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn2");
        robot.clickOn("#btn3");
        robot.clickOn("#btn7");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn5");
        robot.clickOn("#btn5");
        robot.clickOn("#minusBtn");
        robot.clickOn("#btn5");
        robot.clickOn("#btn3");
        robot.clickOn("#btn7");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn4");
        robot.clickOn("#btn4");
        robot.clickOn("#equalsBtn");
        assertEquals("-299.89", display.getText());
    }

    @Test
    public void dotMultiply (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn0");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn5");
        robot.clickOn("#multiplyBtn");
        robot.clickOn("#btn0");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn5");
        robot.clickOn("#equalsBtn");
        assertEquals("0.25", display.getText());
    }

    @Test
    public void dotDivide (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn0");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn5");
        robot.clickOn("#divideBtn");
        robot.clickOn("#btn0");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn2");
        robot.clickOn("#equalsBtn");
        assertEquals("2.5", display.getText());
    }

    @Test
    public void dotModule (FxRobot robot) {
        display = robot.lookup("#display").queryAs(TextField.class);
        robot.clickOn("#btn5");
        robot.clickOn("#btn5");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn3");
        robot.clickOn("#moduleBtn");
        robot.clickOn("#btn5");
        robot.clickOn("#dotBtn");
        robot.clickOn("#btn5");
        robot.clickOn("#equalsBtn");
        assertEquals("0.3", display.getText());
    }

}