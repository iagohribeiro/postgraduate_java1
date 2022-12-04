/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iagohribeiro.iagohribeirolima_atividade08;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author iagohribeiro
 */
public class VeicExistException extends Exception{
    
    public VeicExistException(){
        JOptionPane.showMessageDialog(new JFrame(),
        "Já existe um veículo com esta placa.",
        "Erro",
        JOptionPane.ERROR_MESSAGE);
    }
    
}
