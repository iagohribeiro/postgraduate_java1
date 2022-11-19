 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.iagohribeiro.iagohribeirolima_atividade06;

import java.text.MessageFormat;

/**
 *
 * @author iagohribeiro
 */
public class Teste {
    
    private static Passeio newVeiculoPasseio = new Passeio();
    private static Carga newVeiculoCarga = new Carga();
    
    private static final BDVeiculos veiculos = new BDVeiculos();
    
    private static final Leitura entradaUsuario = new Leitura();
    
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
                escolha = Integer.parseInt(entradaUsuario.entDados("\nEscolha uma opcao do Menu:"));
            }
            catch(NumberFormatException e)
            {
                System.out.println("Erro: Por favor entre com um valor Inteiro. Aperte ENTER para tentar novamente.");
                entradaUsuario.entDados("");

                continue;
            }
            
            switch (escolha) {
                case 1:
                    for(int i=checaVetor(1); i<veiculos.getTamanhoListaPasseio(); i++)
                    {
                        if(i == -1)
                        {
                            entradaUsuario.entDados("O Vetor de Veiculos de Passeio esta cheio. Aperte ENTER para voltar ao MENU.");
                            break;
                        }
                        
                        newVeiculoPasseio = new Passeio();
                        
                        try{
                            veiculos.setPasseio(preenchePasseio(newVeiculoPasseio), i);
                        }
                        catch (VeicExistException e)
                        {
                            break;
                        }
                        
                        String mensagem = MessageFormat.format("Veiculo de Passeio cadastrado com Sucesso na posicao {0}. Aperte ENTER.", i);
                        entradaUsuario.entDados(mensagem);
                        
                        if (!(checaVetor(1) == -1))
                        {
                            String retorno = entradaUsuario.entDados("Deseja cadastrar outro Veiculo de Passeio? <sim/nao>");
                            
                            if(retorno.toLowerCase().equals("nao".toLowerCase()) || !retorno.toLowerCase().equals("sim".toLowerCase()))
                                break;
                        }
                        else
                        {
                            entradaUsuario.entDados("""
                                                    
                                                            Veiculo de Passeio cadastrado anteriormente foi o ultimo a ser adicionado.
                                                            O Vetor de Veiculos de Passeio esta cheio. Aperte ENTER para voltar ao MENU.
                                                    
                                                    """);
                            break;
                        }                        
                    }   break;
                    
                case 2:
                    for(int i=checaVetor(2); i<veiculos.getTamanhoListaCarga(); i++)
                    {
                        if(i == -1)
                        {
                            entradaUsuario.entDados("O Vetor de Veiculos de Carga esta cheio. Aperte ENTER para voltar ao MENU.");
                            break;
                        }
                        
                        newVeiculoCarga = new Carga();
                        try{
                            veiculos.setCarga(preencheCarga(newVeiculoCarga), i);
                        }
                        catch (VeicExistException e)
                        {
                            break;
                        }
                        
                        String mensagem = MessageFormat.format("Veiculo de Carga cadastrado com Sucesso na posicao {0}. Aperte ENTER.", i);
                        entradaUsuario.entDados(mensagem);
                        
                        if (!(checaVetor(2) == -1))
                        {
                            String retorno = entradaUsuario.entDados("Deseja cadastrar outro Veiculo de Carga? <sim/nao>");
                            
                            if(retorno.toLowerCase().equals("nao".toLowerCase()) || !retorno.toLowerCase().equals("sim".toLowerCase()))
                                break;
                        }
                        else
                        {
                            entradaUsuario.entDados("""
                                                    
                                                            Veiculo de Carga cadastrado anteriormente foi o ultimo a ser adicionado.
                                                            O Vetor de Veiculos de Carga esta cheio. Aperte ENTER para voltar ao MENU.
                                                    
                                                    """);
                            break;
                        }                        
                    }   break;
                    
                case 3:
                    System.out.println("\n\n--------------------------------------");
                    System.out.println("Todos Veiculos de Passeio");
                    System.out.println("--------------------------------------");
                    
                    boolean temPasseio = false;
                    
                    for (Passeio passeioElem : veiculos.getPasseio()) {
                        if (passeioElem != null)
                        {
                            impPasseio(passeioElem);
                            temPasseio = true;
                        }
                    }
                    
                    if(!temPasseio)
                        entradaUsuario.entDados("\nNao ha veiculos de passeio cadastrado. Aperte ENTER.");
                    
                    break;
                    
                case 4:
                    System.out.println("\n\n--------------------------------------");
                    System.out.println("Todos Veiculos de Carga");
                    System.out.println("--------------------------------------");
                    
                    boolean temCarga = false;
                    
                    for (Carga cargaElem : veiculos.getCarga()) {
                        if (cargaElem != null)
                        {
                            impCarga(cargaElem);
                            temCarga = true;
                        }
                    }
                    
                    if(!temCarga)
                        entradaUsuario.entDados("\nNao ha veiculos de carga cadastrado. Aperte ENTER.");
                    
                    break;
                    
                case 5:      
                    String placa = entradaUsuario.entDados("Digite a placa do Veiculo de Passeio.");
                    boolean temPlacaPasseio = false;
                    
                    //Verifica se existe e imprime o veiculo a partir da placa fornecida
                    for (Passeio passeioElem : veiculos.getPasseio()) {
                        if (passeioElem!= null)
                        {
                            if (passeioElem.getPlaca().toLowerCase().equals(placa.toLowerCase()))
                            {
                                impPasseio(passeioElem);
                                temPlacaPasseio = true;
                                break;
                            }
                        }
                    }
                    
                    if (!temPlacaPasseio)
                        System.out.println("\nNao foi encontrado Veiculo com a placa fornecida.\n");
                    
                    break;
                    
                case 6:      
                    String placaCarga = entradaUsuario.entDados("Digite a placa do Veiculo de Carga.");
                    boolean temPlaca = false;
                    //Verifica se existe e imprime o veiculo a partir da placa fornecida
                    for (Carga cargaElem : veiculos.getCarga()) {
                        if (cargaElem != null)
                        {
                            if (cargaElem.getPlaca().toLowerCase().equals(placaCarga.toLowerCase()))
                            {
                                impCarga(cargaElem);
                                temPlaca = true;
                                break;
                            }
                        }
                    }
                    
                    if (!temPlaca)
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
    
    //Metodo para verificar os vetores 
    public static int checaVetor (int opcaoMenu)
    {
        return veiculos.verificaListas(opcaoMenu);
    }
    
    //Metodo para preencher o objeto de pasaseio
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
        
        try{
            veiculo.setVelocMax(Integer.parseInt(entradaUsuario.entDados("Velocidade Maxima.:")));
        }
        catch(VelocException e)
        {
            try
            {
                veiculo.setVelocMax(100f);
            }
            catch(VelocException ez){}
        }
        
        veiculo.getMotor().setQtdPist(Integer.parseInt(entradaUsuario.entDados("Quantidade Pistoes do motor.:")));
        veiculo.getMotor().setPotencia(Integer.parseInt(entradaUsuario.entDados("Potencia do motor..:")));
        
        return veiculo;
    }
    
    //Metodo para imprimir objetos de veiculos de passeio
    public static void impPasseio(Passeio passeio){
        System.out.println("----------------------------------------");
        System.out.println("Placa..: "+ passeio.getPlaca());
        System.out.println("Marca........: "+ passeio.getMarca());
        System.out.println("Modelo...................: "+ passeio.getModelo());
        System.out.println("Cor..................: "+ passeio.getCor());
        System.out.println("VelocidadeMaxima........: "+ passeio.getVelocMax());
        System.out.println("Qtd de Rodas.............: "+ passeio.getQtdRodas());
        System.out.println("Qtd Pistoes de motor...: "+ passeio.getMotor().getQtdPist());
        System.out.println("Potencia do motor.......: "+ passeio.getMotor().getPotencia());
        System.out.println("Qtd de Passageiros......: "+ passeio.getQtdPassageiros());
        System.out.println("Qtd. total de Letras....: "+ passeio.calcular());
        System.out.println("Calc Vel Maxima em meter/hour: " + passeio.calcVel(passeio.getVelocMax())+"\n");
        System.out.println("----------------------------------------\n");
    }
    
    //Metodo para preencher o objeto de carga
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
        
        try{
            veiculo.setVelocMax(Integer.parseInt(entradaUsuario.entDados("Velocidade Maxima.:")));
        }
        catch(VelocException e)
        {
            try
            {
                veiculo.setVelocMax(90f);
            }
            catch(VelocException ez){}
        }
        
        veiculo.getMotor().setQtdPist(Integer.parseInt(entradaUsuario.entDados("Quantidade Pistoes do motor.:")));
        veiculo.getMotor().setPotencia(Integer.parseInt(entradaUsuario.entDados("Potencia do motor..:")));
        
        return veiculo;
    }
    
    //Metodo para imprimir objetos de veiculos de carga
    public static void impCarga(Carga carga){
        System.out.println("----------------------------------------");
        System.out.println("Placa..: "+ carga.getPlaca());
        System.out.println("Marca........: "+ carga.getMarca());
        System.out.println("Modelo...................: "+ carga.getModelo());
        System.out.println("Cor..................: "+ carga.getCor());
        System.out.println("VelocidadeMaxima........: "+ carga.getVelocMax());
        System.out.println("Qtd de Rodas.............: "+ carga.getQtdRodas());
        System.out.println("Qtd Pistoes de motor...: "+ carga.getMotor().getQtdPist());
        System.out.println("Potencia do motor.......: "+ carga.getMotor().getPotencia());
        System.out.println("Carga Maxima......: "+ carga.getCargaMax());
        System.out.println("Tara......: "+ carga.getTara());
        System.out.println("Qtd. total atributos Numericos....: "+ carga.calcular());
        System.out.println("Calc Vel Maxima em cetimetro/hour: " + carga.calcVel(carga.getVelocMax()));
        System.out.println("----------------------------------------\n");
    }
}
