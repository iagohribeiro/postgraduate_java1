/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iagohribeiro.iagohribeirolima_atividade07;

/**
 *
 * @author iagohribeiro
 */
public class VeicExistException extends Exception{
    
    public VeicExistException(){
        System.out.println("\nJá existe um veículo com esta placa");
    }
    
}
