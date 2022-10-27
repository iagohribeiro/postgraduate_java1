 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.iagohribeiro.iagohribeirolima_atividade04;

/**
 *
 * @author iagohribeiro
 */
public class Teste {
    
    private static Passeio newVeiculoPasseio = new Passeio();
    private static Carga newVeiculoCarga = new Carga();
    
    private static Carga[] carga = new Carga[10];
    private static Passeio[] passeio = new Passeio[10];
    
    private static Leitura entradaUsuario = new Leitura();

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
                        
                    }   break;
                case 7:
                    executando = false;
                    break;
                default:
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
        
        return veiculo;
    }
    
    public static Carga preenchePasseio(Carga veiculo)
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
        
        return veiculo;
    }
}
