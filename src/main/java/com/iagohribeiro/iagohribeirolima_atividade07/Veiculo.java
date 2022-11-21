/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iagohribeiro.iagohribeirolima_atividade07;

/**
 *
 * @author iagohribeiro
 */
public abstract class Veiculo {
    
    private String placa;       
    private String marca;
    private String modelo;
    private String cor;
    private float velocMax;
    private int qtdRodas;
    private Motor motor;

    public Veiculo() {
        placa = " ";       
        marca = " ";
        modelo = " ";
        cor = " ";
        velocMax = 0;
        qtdRodas = 0;
        motor = new Motor();
    }

    public Veiculo(String placa, String marca, String modelo, String cor,
                    float velocMax, int qtdRodas, int qtdPist, int potencia) {
        
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.velocMax = velocMax;
        this.qtdRodas = qtdRodas;
        this.motor = new Motor (qtdPist, potencia);
    }
    
    public String getPlaca() {
        return placa;
    }

    final public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    final public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    final public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    final public void setCor(String cor) {
        this.cor = cor;
    }

    public float getVelocMax() {
        return velocMax;
    }

    final public void setVelocMax(float velocMax) throws VelocException{
        
        if (velocMax<80 || velocMax>110)
            throw new VelocException();
        
        this.velocMax = velocMax;
    }

    public int getQtdRodas() {
        return qtdRodas;
    }

    final public void setQtdRodas(int qtdRodas) {
        this.qtdRodas = qtdRodas;
    }

    public Motor getMotor() {
        return motor;
    }

    final public void setMotor(Motor motor) {
        this.motor = motor;

    }
    final public void setMotor(int qtdPist, int potencia) {
        this.motor.setQtdPist(qtdPist);
        this.motor.setPotencia(potencia);
    }
    
    public abstract float calcVel (float velocMax);
    
    @Override
    public String toString (){
        String veiculoOutput;
        
        veiculoOutput = "Placa: " + this.getPlaca() + "\n"
        + "Marca: " + this.getMarca() + "\n"
        + "Modelo: " + this.getModelo() + "\n"
        + "Cor: " + this.getCor() + "\n"
        + "Velocidade Maxima Km/h: " + this.getVelocMax() + "\n"
        + "Quantidade de Rodas: " + this.getQtdRodas() + "\n"
        + "Quantidade de Pistao: " + this.getMotor().getQtdPist() + "\n"
        + "Potencia: " + this.getMotor().getPotencia();
        
        return veiculoOutput;
    }
}

