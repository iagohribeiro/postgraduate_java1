/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.iagohribeiro.iagohribeirolima_atividade03;

/**
 *
 * @author iagohribeiro
 */
public class Teste {

    public static void main(String[] args) {
        
        //Using arrays to store the data that will be used to the objects
        String[] placa = {"MVF-2850", "NBW-6382", "AGW-2392", "IWV-4419", "MIX-0361",
                            "KUJ-5524", "NEK-1840", "NAA-7075", "JFL-1238", "NEM-9817"};       
        String[] marca = {"Fibravan", "CHANGAN", "Saturn", "Mercedes-Benz", "Isuzu",
                            "Daihatsu", "Plymouth", "VW - VolksWagen", "Daewoo", "FOTON"};
        String[] modelo = {"Buggy Plus 1.6 8V", "MINI STAR CE 1.0 8V 53cv (Pick-Up)",
                            "SL-2 1.9", "Sprinter 312 Van Std Lota", "Amigo 2.3 4x2/4x4",
                            "AUMARK 3.50AK", "Master 4.0", "LINK 1.3 16V 5p", "Engesa 4x4", "207 X-Line"};
        String[] cor = {"Prata", "Azul", "Vermelho", "Verde", "Laranja",
                        "Dourado", "Bege", "Preto", "Marrom", "Branco"};
        float[] velocMax = {300.0F, 290.0F, 400.1F, 500.1F, 299.9F,
                            350.0F, 250.0F, 450.1F, 550.1F, 259.9F};
        int[] qtdRodas = {4, 6, 8, 10, 12, 14, 16, 18, 20, 22};
        int[] qtdPist = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] potencia = {100, 200, 300, 400, 500, 600, 700, 800, 900, 950};
        int[] qtdPassageiros = {2, 5, 7, 8, 10};
        int[] cargaMax = {200, 300, 400, 500, 600};
        int[] tara = {10, 20, 30, 40, 50};

        for (int i=0; i<10; i++)
        {
            if (i<5)
            {
                if (i == 0)
                {
                    System.out.println("----------Veiculos de Passeio----------");
                }
                
                Passeio newVeiculoPasseio;
                //Using the constructor that receive the complete parameters
                newVeiculoPasseio = new Passeio (placa[i], marca[i], modelo[i], cor[i], velocMax[i],
                                            qtdRodas[i], qtdPist[i], potencia[i], qtdPassageiros[i]);
                
                System.out.println(newVeiculoPasseio);
            }
            else
            {   
                if (i == 5)
                {
                    System.out.println("\n\n----------Veiculos de Carga----------");
                }
                
                Carga newVeiculoCarga;
                
                //Using the Default Constructors
                newVeiculoCarga = new Carga ();
                
                newVeiculoCarga.setPlaca(placa[i]);
                newVeiculoCarga.setMarca(marca[i]); 
                newVeiculoCarga.setModelo(modelo[i]); 
                newVeiculoCarga.setCor(cor[i]);
                newVeiculoCarga.setVelocMax(velocMax[i]);
                newVeiculoCarga.setQtdRodas(qtdRodas[i]);
                newVeiculoCarga.setMotor(qtdPist[i], potencia[i]);
                newVeiculoCarga.setCargaMax(cargaMax[i-5]);
                newVeiculoCarga.setTara(tara[i-5]);
                
                System.out.println(newVeiculoCarga);
            }
        }
    }
}
