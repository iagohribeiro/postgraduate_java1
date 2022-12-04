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
public class VelocException extends Exception {

    public VelocException() {
        JOptionPane.showMessageDialog(new JFrame(),
        "A velocidade máxima está fora dos limites brasileiros.",
        "Warning",
        JOptionPane.WARNING_MESSAGE);
    }
}
