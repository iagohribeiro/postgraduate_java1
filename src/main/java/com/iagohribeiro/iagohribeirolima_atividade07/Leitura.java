/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iagohribeiro.iagohribeirolima_atividade07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author iagohribeiro
 */
public class Leitura {
    public String entDados (String dados){
        
        System.out.println(dados);
        
        InputStreamReader entrada = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(entrada);
        
        String retorno = "";
        
        try{
            retorno = buffer.readLine();
        }
        catch(IOException e)
        {
            System.out.print("\nErro na entrada de dados: " + e);
        
        }
        
        return retorno;
    }
}
