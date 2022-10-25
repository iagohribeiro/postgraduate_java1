/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.iagohribeiro.iagohribeirolima_atividade01;

/**
 *
 * @author iagohribeiro
 */
public class Teste {
    
    public static void printVeiculo(Veiculo veiculo)
    {
        System.out.println("Placa: " + veiculo.getPlaca());
        System.out.println("Marca: " + veiculo.getMarca());
        System.out.println("Modelo: " + veiculo.getModelo());
        System.out.println("Cor: " + veiculo.getCor());
        System.out.println("Velocidade Maxima: " + veiculo.getVelocMax());
        System.out.println("Quantidade de Rodas: " + veiculo.getQtdRodas());
        System.out.println("Quantidade de Pistao: " + veiculo.getMotor().getQtdPist());
        System.out.println("Potencia: " + veiculo.getMotor().getPotencia());
        System.out.println("----------------------------------------");
        
    }

    public static void main(String[] args) {
        
        //Using arrays to store the data that will be used to the objects
        String[] placa = {"MVF-2850", "NBW-6382", "AGW-2392", "IWV-4419", "MIX-0361"};       
        String[] marca = {"Fibravan", "CHANGAN", "Saturn", "Mercedes-Benz", "Isuzu"};
        String[] modelo = {"Buggy Plus 1.6 8V", "MINI STAR CE 1.0 8V 53cv (Pick-Up)",
                            "SL-2 1.9", "Sprinter 312 Van Std Lota", "Amigo 2.3 4x2/4x4"};
        String[] cor = {"Prata", "Azul", "Vermelho", "Verde", "Laranja"};
        float[] velocMax = {300.0F, 290.0F, 400.1F, 500.1F, 299.9F};
        int[] qtdRodas = {4, 6, 8, 10, 12};
        int[] qtdPist = {1, 2, 3, 4, 5};
        int[] potencia = {100, 200, 300, 400, 500};

        for (int i=0; i<5; i++)
        {
            Veiculo newVeiculo;
            
            if (i<3)
            {
                //Using the constructor that receive the complete parameters
                newVeiculo = new Veiculo (placa[i], marca[i], modelo[i], cor[i], velocMax[i],
                                            qtdRodas[i], qtdPist[i], potencia[i]);
            }
            else
            {
                //Using the Default Constructors
                newVeiculo = new Veiculo ();
                
                newVeiculo.setPlaca(placa[i]);
                newVeiculo.setMarca(marca[i]); 
                newVeiculo.setModelo(modelo[i]); 
                newVeiculo.setCor(cor[i]);
                newVeiculo.setVelocMax(velocMax[i]);
                newVeiculo.setQtdRodas(qtdRodas[i]);
                newVeiculo.setMotor(qtdPist[i], potencia[i]);
            }
          
            printVeiculo (newVeiculo);
        }
    }
}
