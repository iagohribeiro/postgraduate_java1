/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iagohribeiro.iagohribeirolima_atividade06;

import java.text.MessageFormat;

/**
 *
 * @author iagohribeiro
 */
public class BDVeiculos {
    private Passeio[] listaPasseio = new Passeio[5];
    private Carga[] listaCarga = new Carga[5];
    
    public BDVeiculos() {
    }
    
    public void setPasseio (Passeio veiculo, int posicao) throws VeicExistException{
        
        for (Passeio passeioElem : listaPasseio) {
            if (passeioElem!= null)
            {
                if (passeioElem.getPlaca().toLowerCase().equals(veiculo.getPlaca().toLowerCase())) {
                    throw new VeicExistException();
                }
            }
        }
        listaPasseio[posicao] = veiculo;
    }
    
    public void setCarga (Carga veiculo, int posicao) throws VeicExistException{
        for (Carga cargaElem : listaCarga) {
            if (cargaElem!= null)
            {
                if (cargaElem.getPlaca().toLowerCase().equals(veiculo.getPlaca().toLowerCase())) {
                    throw new VeicExistException();
                }
            }
        }
        listaCarga[posicao] = veiculo;
    }

    public int getTamanhoListaCarga (){
        return listaCarga.length;
    }
    
    public int getTamanhoListaPasseio (){
        return listaPasseio.length;
    }
    
    public Passeio[] getPasseio()
    {
        return listaPasseio;
    }
    
    public Carga[] getCarga()
    {
        return listaCarga;
    }
    
    public int verificaListas (int opcaoMenu)
    {
        /*Se for a opcao 1 do menu, o vertor passeio sera analisado.
           Caso contrario, sera o de carga*/
        if(opcaoMenu == 1)
        {
            for(int i=0; i<listaPasseio.length; i++)
            {
                if(listaPasseio[i] == null)
                {
                    return i;
                }
            }
        }
        else
        {
            for(int i=0; i<listaCarga.length; i++)
            {
                if(listaCarga[i] == null)
                {
                    return i;
                }
            }
        }
        return -1;
    }
}
