/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.iagohribeiro.iagohribeirolima_atividade08;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author iagohribeiro
 */
public class BDVeiculos {
    private List<Passeio> listaPasseio = new ArrayList<Passeio>();
    private List<Carga> listaCarga = new ArrayList<Carga>();
    
    public BDVeiculos() {
    }
    
    public void setPasseio (Passeio veiculo) throws VeicExistException{
        
        for (Passeio passeioElem : listaPasseio) {
            if (passeioElem!= null)
            {
                if (passeioElem.getPlaca().toLowerCase().equals(veiculo.getPlaca().toLowerCase())) {
                    throw new VeicExistException();
                }
            }
        }
        listaPasseio.add(veiculo);
    }
    
    public void setCarga (Carga veiculo) throws VeicExistException{
        for (Carga cargaElem : listaCarga) {
            if (cargaElem!= null)
            {
                if (cargaElem.getPlaca().toLowerCase().equals(veiculo.getPlaca().toLowerCase())) {
                    throw new VeicExistException();
                }
            }
        }
        listaCarga.add(veiculo);
    }
    
    public void excluiPasseio(Passeio veiculo)
    {
        listaPasseio.remove(veiculo);
    }
    
    public void excluiCarga(Carga veiculo)
    {
        listaCarga.remove(veiculo);
    }
    
    public List<Passeio> getPasseio()
    {
        return listaPasseio;
    }
    
    public List<Carga> getCarga()
    {
        return listaCarga;
    }
}
