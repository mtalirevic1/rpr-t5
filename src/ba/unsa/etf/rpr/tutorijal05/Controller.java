package ba.unsa.etf.rpr.tutorijal05;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Controller {

    public static final Double DIVIDER = 0.1;
    private SimpleStringProperty izlaz;
    public TextField display;

    public SimpleStringProperty izlazProperty(){ return izlaz; }
    public String getIzlaz() {
        if(izlaz.getValue().contains("infinity")) return izlaz.getValue();
        return Double.toString(Double.parseDouble(izlaz.getValue()));
    }

    private Integer brojPritisnut = -1;
    private Double prosliBroj = 0.;
    private Double djelioc = DIVIDER;
    String operation = null;
    private boolean tacka = false;

    @FXML
    public void initialize(){
        izlaz = new SimpleStringProperty("0");
        display.textProperty().bindBidirectional(izlazProperty());
        display.getStyleClass().add("mojiButtoni2");
    }
    /*private boolean doesntContainDecimals(){
        Double number = Double.parseDouble(izlaz.get());
        return (number - round(number, 0) == 0);
    }*/
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    private void executeOperation(){
        if (operation == null) {
            prosliBroj = Double.parseDouble(getIzlaz());
            izlaz.set("0");
            tacka = false;
            djelioc = DIVIDER;
            brojPritisnut = -1;
            return;
        }
        switch (operation){
            case "%":
                prosliBroj = prosliBroj % Double.parseDouble(getIzlaz());
                break;
            case "/":
                Double d= Double.parseDouble(getIzlaz());
                if(d==0) prosliBroj =null;
                else
                prosliBroj = prosliBroj / d;
                break;
            case "X":
                prosliBroj = prosliBroj * Double.parseDouble(getIzlaz());
                break;
            case "-":
                prosliBroj = prosliBroj - Double.parseDouble(getIzlaz());
                break;
            case "+":
                prosliBroj = prosliBroj + Double.parseDouble(getIzlaz());
                break;
        }
        tacka = false;
        djelioc = DIVIDER;
        operation = null;
        brojPritisnut = -1;
        izlaz.set("0");
    }

    private void writeNumber(){
        if(brojPritisnut != -1){
            if(tacka) {
                if(djelioc == 0.001) return;
                izlaz.set(Double.toString(round(Double.parseDouble(getIzlaz()) + brojPritisnut * djelioc, 2)));
                djelioc /= 10;
            }
            else izlaz.set(Double.toString(round((Double.parseDouble(getIzlaz()) * 10) + brojPritisnut, 2)));
        }
        brojPritisnut = -1;
    }

    private void reset(){
        if (operation == null) return;
        if(operation.equals("=")){
            izlaz.set("0");
            operation = null;
            prosliBroj = 0.;
        }
    }

    public void moduleClicked() {
        executeOperation();
        operation = "%";
    }

    public void divideClicked() {
        executeOperation();
        operation= "/";
    }

    public void multiplyClicked() {
        executeOperation();
        operation= "X";
    }

    public void minusClicked() {
        executeOperation();
        operation= "-";
    }

    public void plusClicked() {
        executeOperation();
        operation= "+";
    }

    public void equalsClicked() {
        executeOperation();
        if(prosliBroj ==null) izlaz.set("infinity"); else
        izlaz.set(Double.toString(round(prosliBroj, 2)));
        operation = "=";
    }

    public void dotClicked() {
        if(tacka) return;
        tacka = true;
    }

    public void sevenClicked() {
        reset();
        brojPritisnut = 7;
        writeNumber();
    }

    public void eightClicked() {
        reset();
        brojPritisnut = 8;
        writeNumber();
    }

    public void nineClicked() {
        reset();
        brojPritisnut = 9;
        writeNumber();
    }

    public void fourClicked() {
        reset();
        brojPritisnut = 4;
        writeNumber();
    }

    public void fiveClicked() {
        reset();
        brojPritisnut = 5;
        writeNumber();
    }

    public void sixClicked() {
        reset();
        brojPritisnut = 6;
        writeNumber();
    }

    public void oneClicked() {
        reset();
        brojPritisnut = 1;
        writeNumber();
    }

    public void twoClicked() {
        reset();
        brojPritisnut = 2;
        writeNumber();
    }

    public void threeClicked() {
        reset();
        brojPritisnut = 3;
        writeNumber();
    }

    public void zeroClicked() {
        reset();
        if(tacka) {
            if(djelioc == 0.001) return;
            djelioc /= 10;
        }
        else izlaz.set(Double.toString((Double.parseDouble(getIzlaz()) * 10) + 0));
    }


}
