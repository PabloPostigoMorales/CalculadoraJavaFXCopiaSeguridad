package com.example.calculadora;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable {
    private Calculadora calculadora = new Calculadora();
    @FXML
    private Label lblResult;
    @FXML
    private Label lblRecord;
    @FXML
    private Button btnDivide;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnDelLast;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btnMult;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button BtnMinus;
    @FXML
    private Button btn1;
    @FXML
    private Button btnPlus;
    @FXML
    private Button btnComma;
    @FXML
    private Button btnEquals;
    @FXML
    private Button btnTwo;
    @FXML
    private Button btnThree;
    @FXML
    private Button btnZero;

    public void number (MouseEvent mouseEvent) {
        Button buttonText =(Button) mouseEvent.getSource();
        String id = buttonText.getId();
        id = id.substring(3);
        System.out.println(id);

        if(Objects.equals(lblResult.getText(), "0") || calculadora.getEstado()){
            lblResult.setText(id);
            calculadora.startNum();
        }else lblResult.setText(lblResult.getText()+id);

    }


    @Override
    public void initialize (URL url, ResourceBundle resourceBundle) {

    }

    /**
     * Does a clear of lblResult and lblRecord
     * @param mouseEvent
     *
     */
    @FXML
    public void clearAll (MouseEvent mouseEvent) {
        lblResult.setText("0");
        lblRecord.setText(lblResult.getText());
        calculadora.reiniciar();
    }

    /**
     * Erase the last character input in lblResult
     * @param mouseEvent
     */
    @FXML
    public void eraseLast (MouseEvent mouseEvent) {
        if (lblResult.getText().length()>1){
            lblResult.setText(lblResult.getText().substring(0,lblResult.getText().length()-1));
        } else if (lblResult.getText().length()==1) {
            lblResult.setText("0");
        }
    }

    /**
     * Does a plus operation with the next number inputed
     * @param mouseEvent
     */
    @FXML
    public void plus (MouseEvent mouseEvent) {
        String numero = lblResult.getText();
        Double numeroD = Double.parseDouble(numero);
        if (numeroD.intValue()==numeroD){
            if (Objects.equals(lblRecord.getText(), "0") || calculadora.getEstado()){
                lblRecord.setText(numero+" + ");
            }else lblRecord.setText(lblRecord.getText()+numero+" + ");
        }else {
            if (Objects.equals(lblRecord.getText(), "0") || calculadora.getEstado()){
                lblRecord.setText(numeroD+" + ");
            }else lblRecord.setText(lblRecord.getText()+numeroD+" + ");
        }
        calculadora.sumar(numeroD);
        lblResult.setText("0");
    }
    /**
     * Does a minus operation with the next number inputed
     * @param mouseEvent
     */
    @FXML
    public void minus (MouseEvent mouseEvent) {
        String numero = lblResult.getText();
        Double numeroD = Double.parseDouble(numero);
        if (numeroD.intValue()==numeroD){
            if (Objects.equals(lblRecord.getText(), "0") || calculadora.getEstado()){
                lblRecord.setText(numero+" - ");
            }else lblRecord.setText(lblRecord.getText()+numero+" - ");
        }else {
            if (Objects.equals(lblRecord.getText(), "0") || calculadora.getEstado()){
                lblRecord.setText(numeroD+" - ");
            }else lblRecord.setText(lblRecord.getText()+numeroD+" - ");
        }
        calculadora.restar(numeroD);
        lblResult.setText("0");
    }
    /**
     * Does a multiply operation with the next number inputed
     * @param mouseEvent
     */
    @FXML
    public void multiply (MouseEvent mouseEvent) {
        String numero = lblResult.getText();
        Double numeroD = Double.parseDouble(numero);
        if (numeroD.intValue()==numeroD){
            if (Objects.equals(lblRecord.getText(), "0") || calculadora.getEstado()){
                lblRecord.setText(numero+" * ");
            }else lblRecord.setText(lblRecord.getText()+numero+" * ");
        }else {
            if (Objects.equals(lblRecord.getText(), "0") || calculadora.getEstado()){
                lblRecord.setText(numeroD+" * ");
            }else lblRecord.setText(lblRecord.getText()+numeroD+" * ");
        }
        calculadora.multiplicar(numeroD);
        lblResult.setText("0");
    }
    /**
     * Does a divide operation with the next number inputed
     * @param mouseEvent
     */
    @FXML
    public void divide (MouseEvent mouseEvent) {
        String numero = lblResult.getText();
        Double numeroD = Double.parseDouble(numero);
        if (numeroD.intValue()==numeroD){
            if (Objects.equals(lblRecord.getText(), "0") || calculadora.getEstado()){
                lblRecord.setText(numero+" / ");
            }else lblRecord.setText(lblRecord.getText()+numero+" / ");
        }else {
            if (Objects.equals(lblRecord.getText(), "0") || calculadora.getEstado()){
                lblRecord.setText(numeroD+" / ");
            }else lblRecord.setText(lblRecord.getText()+numeroD+" / ");
        }
        calculadora.dividir(numeroD);
        lblResult.setText("0");
    }

    /**
     * Does a Comma input in lblResult
     * @param mouseEvent
     */
    @FXML
    public void Comma (MouseEvent mouseEvent) {
        if (!lblResult.getText().contains(".")){
            lblResult.setText(lblResult.getText()+".");
        }
    }

    /**
     * Finish all the operations and gives the final result in both, lblResult and lblRecord
     * @param mouseEvent
     */
    @FXML
    public void equal (MouseEvent mouseEvent) {
        String numero = lblResult.getText();
        Double numeroD = Double.parseDouble(numero);
        calculadora.equals(numeroD);
        String result = String.valueOf(calculadora.getResult().intValue());
        String resultD = String.valueOf(calculadora.getResult());
        if ( Double.valueOf(numero).intValue()==numeroD){
            lblResult.setText(result);
            lblRecord.setText(result);
        }else {
            lblResult.setText(resultD);
            lblRecord.setText(resultD);
        }
        calculadora.reiniciar();
    }
}