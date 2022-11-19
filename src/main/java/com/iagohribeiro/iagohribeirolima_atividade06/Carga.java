/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iagohribeiro.iagohribeirolima_atividade06;

/**
 *
 * @author iagohribeiro
 */
final public class Carga extends Veiculo implements Calcular {
    
    private int cargaMax;
    private int tara;

    public Carga(int cargaMax, int tara) {
        this.cargaMax = cargaMax;
        this.tara = tara;
    }

    public Carga(String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, int qtdPist, int potencia, int cargaMax, int tara) {
        super(placa, marca, modelo, cor, velocMax, qtdRodas, qtdPist, potencia);
        this.cargaMax = cargaMax;
        this.tara = tara;
    }

    public Carga() {
        cargaMax = 0;
        tara = 0;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    final public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    final public void setTara(int tara) {
        this.tara = tara;
    }
    
    @Override
    public String toString()
    {
        String veiculoCargaOutput;
        
        veiculoCargaOutput = super.toString() + "\n"
        + "Carga Maxima: " + this.getCargaMax() + "\n"
        + "Tara: " + this.getTara() + "\n"
        + "Calc Vel Maxima em centimeter/hour: " + this.calcVel(this.getVelocMax()) + "\n"
        +"----------------------------------------";
        
        return veiculoCargaOutput;
    }

    @Override
    public float calcVel(float velocMax) {
        return velocMax*100000.0F;
    }
    
    @Override
    public int calcular(){
        int somaInteiros = 0;
        
        somaInteiros += getMotor().getQtdPist();
        somaInteiros += getMotor().getPotencia();
        somaInteiros += getQtdRodas();
        somaInteiros += getVelocMax();
        somaInteiros += getTara();
        somaInteiros += getCargaMax();
        
        return somaInteiros;
    }
    
}
