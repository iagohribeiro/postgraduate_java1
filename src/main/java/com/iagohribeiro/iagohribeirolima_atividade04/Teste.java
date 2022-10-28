 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.iagohribeiro.iagohribeirolima_atividade04;

import java.text.MessageFormat;

/**
 *
 * @author iagohribeiro
 */
public class Teste {
    
    private static Passeio newVeiculoPasseio = new Passeio();
    private static Carga newVeiculoCarga = new Carga();
    
    private static Carga[] carga = new Carga[5];
    private static Passeio[] passeio = new Passeio[5];
    
    private static Leitura entradaUsuario = new Leitura();
    
    private static boolean retornaMenu = false;

    public static void main(String[] args) {
        
        boolean executando = true;
        int escolha = 0;
        
        while (executando){
            
            System.out.println("""
                           \t\t\tSistema de Gestao de Veiculos - Menu Inicial\n
                           \t\t\t\t1. Cadastrar Veiculo de Passeio
                           \t\t\t\t2. Cadastrar Veiculo de Carga
                           \t\t\t\t3. Imprimir Todos os Veiculos de Passeio
                           \t\t\t\t4. Imprimir Todos os Veiculos de Carga
                           \t\t\t\t5. Imprimir Veiculo de Passeio pela Placa
                           \t\t\t\t6. Imprimir Veiculo de Carga pela Placa
                           \t\t\t\t7. Sair do Sistema
                           """);
            try{
                escolha = Integer.parseInt(entradaUsuario.entDados("\nEscolha uma opcao do Menu"));
            }
            catch(NumberFormatException e)
            {
                System.out.println("Erro: Por favor entre com um valor Inteiro. Aperte ENTER para tentar novamente.");
                entradaUsuario.entDados("");

                continue;
            }
            
            switch (escolha) {
                case 1:
                    for(int i=checaVetor(1); i<passeio.length; i++)
                    {
                        if(i == -1)
                        {
                            entradaUsuario.entDados("O Vetor de Veiculos de Passeio esta cheio. Aperte ENTER para voltar ao MENU.");
                            break;
                        }
                        
                        newVeiculoPasseio = new Passeio();
                        passeio[i] = preenchePasseio(newVeiculoPasseio);
                        
                        if (retornaMenu)
                        {
                            retornaMenu = false;
                            passeio[i] = null;
                            break;
                        }
                        
                        String mensagem = MessageFormat.format("Veiculo de Passeio cadastrado com Sucesso na posicao {0}. Aperte ENTER.", i);
                        entradaUsuario.entDados(mensagem);
                        
                        if (!(checaVetor(1) == -1))
                        {
                            String retorno = entradaUsuario.entDados("Deseja cadastrar outro Veiculo de Passeio? <s/n>");
                            
                            if(retorno.toLowerCase().equals("N".toLowerCase()) || !retorno.toLowerCase().equals("S".toLowerCase()))
                                break;
                        }
                        else
                        {
                            entradaUsuario.entDados("\nO Vetor de Veiculos de Passeio esta cheio. "
                                                    + "Nao ha possbilidade de adicionar outro veiculo desse tipo."
                                                    + " Aperte ENTER para voltar ao MENU.");
                            break;
                        }                        
                    }   break;
                    
                case 2:
                    for(int i=checaVetor(2); i<carga.length; i++)
                    {
                        if(i == -1)
                        {
                            entradaUsuario.entDados("O Vetor de Veiculos de Carga esta cheio. Aperte ENTER para voltar ao MENU.");
                            break;
                        }
                        
                        newVeiculoCarga = new Carga();
                        carga[i] = preencheCarga(newVeiculoCarga);
                        
                        if (retornaMenu)
                        {
                            retornaMenu = false;
                            carga[i] = null;
                            break;
                        }
                        
                        String mensagem = MessageFormat.format("Veiculo de Passeio cadastrado com Sucesso na posicao {0}. Aperte ENTER.", i);
                        entradaUsuario.entDados(mensagem);
                        
                        if (!(checaVetor(2) == -1))
                        {
                            String retorno = entradaUsuario.entDados("Deseja cadastrar outro Veiculo de Carga? <s/n>");
                            
                            if(retorno.toLowerCase().equals("N".toLowerCase()))
                                break;
                        }
                        else
                        {
                            entradaUsuario.entDados("\nO Vetor de Veiculos de Carga esta cheio. "
                                                    + "Nao ha possbilidade de adicionar outro veiculo desse tipo."
                                                    + " Aperte ENTER para voltar ao MENU.");
                            break;
                        }                        
                    }   break;
                    
                case 3:
                    for (Passeio passeioElem : passeio) {
                        if (passeioElem!= null)
                        {
                            impPasseio(passeioElem);
                        }
                    }
                    break;
                    
                case 4:
                    for (Carga cargaElem : carga) {
                        if (cargaElem!= null)
                        {
                            impCarga(cargaElem);
                        }
                    }
                    break;
                    
                case 5:      
                    String placa = entradaUsuario.entDados("Digite a placa do Veiculo de Passeio.");
                    
                    for (Passeio passeioElem : passeio) {
                        if (passeioElem!= null)
                        {
                            if (passeioElem.getPlaca().toLowerCase().equals(placa.toLowerCase()))
                            {
                                impPasseio(passeioElem);
                                break;
                            }
                        }
                    }
                    System.out.println("\nNao foi encontrado Veiculo com a placa fornecida.\n");
                    break;
                    
                case 6:      
                    String placaCarga = entradaUsuario.entDados("Digite a placa do Veiculo de Carga.");
                    
                    for (Carga cargaElem : carga) {
                        if (cargaElem!= null)
                        {
                            if (cargaElem.getPlaca().toLowerCase().equals(placaCarga.toLowerCase()))
                            {
                                impCarga(cargaElem);
                                break;
                            }
                        }
                    }
                    System.out.println("\nNao foi encontrado Veiculo com a placa fornecida.\n");
                    break;
                    
                case 7:
                    executando = false;
                    break;
                    
                default:
                    System.out.println("\nPor favor digite um número entre 1 e 7\n");
                    break;
            }
            
            
        }
        
    }
    
    public static int checaVetor (int opcaoMenu)
    {
        if(opcaoMenu == 1)
        {
            for(int i=0; i<passeio.length; i++)
            {
                if(passeio[i] == null)
                {
                    return i;
                }
            }
        }
        else
        {
            for(int i=0; i<carga.length; i++)
            {
                if(carga[i] == null)
                {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public static Passeio preenchePasseio(Passeio veiculo)
    {
        System.out.println("\n\n--------------------------------------");
        System.out.println("Cadastro de Veiculos de Passeio");
        System.out.println("--------------------------------------");
        veiculo.setQtdPassageiros(Integer.parseInt(entradaUsuario.entDados("Quantidade de Passageiros.:")));
        veiculo.setPlaca(entradaUsuario.entDados("\nPlaca............:"));              
        veiculo.setMarca(entradaUsuario.entDados("Marca............:"));
        veiculo.setModelo(entradaUsuario.entDados("Modelo..............:"));
        veiculo.setCor(entradaUsuario.entDados("Cor..............:"));
        veiculo.setQtdRodas(Integer.parseInt(entradaUsuario.entDados("Quantidade de Rodas..:")));
        veiculo.setVelocMax(Integer.parseInt(entradaUsuario.entDados("Velocidade Maxima.:")));
        veiculo.getMotor().setQtdPist(Integer.parseInt(entradaUsuario.entDados("Quantidade Pistoes do motor.:")));
        veiculo.getMotor().setPotencia(Integer.parseInt(entradaUsuario.entDados("Potencia do motor..:")));
        
        for (Passeio passeioElem : passeio) {
            if (passeioElem!= null)
            {
                if (passeioElem.getPlaca().toLowerCase().equals(veiculo.getPlaca().toLowerCase())) {
                    System.out.println(MessageFormat.format("Ja foi cadastrado um Veiculo com mesma placa {0}",veiculo.getPlaca()));
                    retornaMenu = true;
                }
                break;
            }
        }
        
        return veiculo;
    }
    
    public static void impPasseio(Passeio passeio){
        System.out.println("Qtd de Passageiros......: "+ passeio.getQtdPassageiros());
        System.out.println("Placa..: "+ passeio. getPlaca());
        System.out.println("Marca........: "+ passeio.getMarca());
        System.out.println("Modelo...................: "+ passeio.getModelo());
        System.out.println("Cor..................:"+ passeio.getCor());
        System.out.println("Qtd de Rodas............."+ passeio.getQtdRodas());
        System.out.println("VelocidadeMaxima........"+ passeio.getVelocMax());
        System.out.println("Qtd Pistoes de motor...: "+ passeio.getMotor().getQtdPist());
        System.out.println("Potencia do motor.......:"+ passeio.getMotor().getPotencia());
        System.out.println("Qtd. total de Letras....:"+ passeio.calcular());
        System.out.println("Calc Vel Maxima em meter/hour: " + passeio.calcVel(passeio.getVelocMax()));
    }
    
    public static Carga preencheCarga(Carga veiculo)
    {
        System.out.println("\n\n--------------------------------------");
        System.out.println("Cadastro de Veiculos de Carga");
        System.out.println("--------------------------------------");
        veiculo.setTara(Integer.parseInt(entradaUsuario.entDados("Tara.....:")));
        veiculo.setCargaMax(Integer.parseInt(entradaUsuario.entDados("Carga Maxima.....:")));
        veiculo.setPlaca(entradaUsuario.entDados("\nPlaca............:"));              
        veiculo.setMarca(entradaUsuario.entDados("Marca............:"));
        veiculo.setModelo(entradaUsuario.entDados("Modelo..............:"));
        veiculo.setCor(entradaUsuario.entDados("Cor..............:"));
        veiculo.setQtdRodas(Integer.parseInt(entradaUsuario.entDados("Quantidade de Rodas..:")));
        veiculo.setVelocMax(Integer.parseInt(entradaUsuario.entDados("Velocidade Maxima.:")));
        veiculo.getMotor().setQtdPist(Integer.parseInt(entradaUsuario.entDados("Quantidade Pistoes do motor.:")));
        veiculo.getMotor().setPotencia(Integer.parseInt(entradaUsuario.entDados("Potencia do motor..:")));
        
        for (Carga cargaElem : carga) {
            if (cargaElem!= null)
            {
                if (cargaElem.getPlaca().toLowerCase().equals(veiculo.getPlaca().toLowerCase())) {
                    System.out.println(MessageFormat.format("Ja foi cadastrado um Veiculo com mesma placa {0}",veiculo.getPlaca()));
                    retornaMenu = true;
                }
                break;
            }
        }
        
        return veiculo;
    }
    public static void impCarga(Carga carga){
        System.out.println("Tara......: "+ carga.getTara());
        System.out.println("Carga Maxima......: "+ carga.getCargaMax());
        System.out.println("Placa..: "+ carga. getPlaca());
        System.out.println("Marca........: "+ carga.getMarca());
        System.out.println("Modelo...................: "+ carga.getModelo());
        System.out.println("Cor..................:"+ carga.getCor());
        System.out.println("Qtd de Rodas............."+ carga.getQtdRodas());
        System.out.println("VelocidadeMaxima........"+ carga.getVelocMax());
        System.out.println("Qtd Pistoes de motor...: "+ carga.getMotor().getQtdPist());
        System.out.println("Potencia do motor.......:"+ carga.getMotor().getPotencia());
        System.out.println("Qtd. total atributos Numericos....:"+ carga.calcular());
        System.out.println("Calc Vel Maxima em cetimetro/hour: " + carga.calcVel(carga.getVelocMax()));
    }
}
