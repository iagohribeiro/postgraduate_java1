/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iagohribeiro.iagohribeirolima_atividade08;

/**
 *
 * @author iagohribeiro
 */
public class Motor {
    private int qtdPist;
    private int potencia;
    
    //Default Constructor for the Motor class
    public Motor() 
    {
        qtdPist = 0;
        potencia = 0;
    }
    
    //Constructor for the Motor class
    public Motor(int qtdPist, int potencia)
    {
        this.qtdPist = qtdPist;
        this.potencia = potencia;
    }

    public int getQtdPist() {
        return qtdPist;
    }

    final public void setQtdPist(int qtdPist) {
        this.qtdPist = qtdPist;
    }

    public int getPotencia() {
        return potencia;
    }

    final public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
}
