package com.example.calculadora;


public class Calculadora {
    private Double antiguo;
    private Integer operacion=0;

    /**
     * Indicates the next operation is an addition
     * @param numero
     */
    public void sumar(Double numero){
        calculo(numero);
        operacion=1;
    }
    /**
     * Indicates the next operation is a minus
     * @param numero
     */
    public void restar(Double numero){
        calculo(numero);
        operacion=2;
    }
    /**
     * Indicates the next operation is a multiplication
     * @param numero
     */
    public void multiplicar (Double numero){
        calculo(numero);
        operacion=3;
    }
    /**
     * Indicates the next operation is a division
     * @param numero
     */
    public void dividir (Double numero){
        calculo(numero);
        operacion=4;
    }
    /**
     * Indicates the next operation is giving the result
     * @param numero
     */
    public void igual(Double numero){
        calculo(numero);
        operacion=0;
    }

    /**
     +Makes the operation taking the operacion value to determine what opertaion needs to be done, and then takes the number that was wrote before and the new one
     * @param num
     */
    private void calculo(Double num){
        if (operacion==0|| operacion==-1){
            antiguo=num;
        } else if (operacion==1) {
            antiguo+=num;
        } else if (operacion==2) {
            antiguo-=num;
        } else if (operacion==3) {
            antiguo*=num;
        } else if (operacion==4) {
            antiguo/=num;
        }
    }

    /**
     *Changes operation to -1 to avoid the numbers getting restarted at the start
     */
    public void startNum(){
        if (operacion<=0){
            this.operacion = -1;
        }
    }
    /**
     * Returns the Result of all the operations "antiguo"
     * @return
     */
    public Double getResult () {
        return antiguo;
    }

    /**
     * Makes the next operation
     * @param num
     */
    public void equals (Double num) {
        calculo(num);
    }

    /**
     *Resets all the values to start a new set of operations from zero
     */
    public void reiniciar(){
        antiguo=0.0;
        operacion=0;
    }

    /**
     * Makes the program knows the next value will reset the total value "antiguo"
     * @return
     */
    public Boolean getEstado(){
        return operacion==0 || operacion==-1;
    }
}
