/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iagohribeiro.iagohribeirolima_atividade08;

/**
 *
 * @author iagohribeiro
 */
final public class Passeio extends Veiculo implements Calcular {
    
    private int qtdPassageiros;

    public Passeio(String placa, String marca, String modelo, String cor, float velocMax, int qtdRodas, int qtdPist, int potencia, int qtdPassageiros) {
        super(placa, marca, modelo, cor, velocMax, qtdRodas, qtdPist, potencia);
        this.qtdPassageiros = qtdPassageiros;
    }

    public Passeio(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    public Passeio() {
        qtdPassageiros = 0;
    }

    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    final public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }
    
    @Override
    public String toString()
    {
        String veiculoPasseioOutput;
        
        veiculoPasseioOutput = super.toString() + "\n"
        + "Quantidade de Passageiros: " + this.getQtdPassageiros() + "\n"
        + "Calc Vel Maxima em meter/hour: " + this.calcVel(this.getVelocMax()) + "\n"
        + "----------------------------------------";
        
        return veiculoPasseioOutput;
    }

    @Override
    public float calcVel(float velocMax) {
        return velocMax*1000.0F;
    }
    
    @Override
    public int calcular(){
        int sumStrings =0;
        
        sumStrings += getPlaca().length();
        sumStrings += getMarca().length();
        sumStrings += getModelo().length();
        sumStrings += getCor().length();
        
        return sumStrings;
    }
    
}
