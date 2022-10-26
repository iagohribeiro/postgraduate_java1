/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iagohribeiro.iagohribeirolima_atividade04;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author iagohribeiro
 */
public class Leitura {
    public String entDados (String dados){
        
        Scanner entry = new Scanner(System.in);
        
        try{
            entry.nextLine();
        }
        catch(InputMismatchException e)
        {
            System.out.print("\nErro na entrada de dados: " + e);
        
        }
        
        return entry.toString();
    }
}
