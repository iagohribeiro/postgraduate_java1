 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.iagohribeiro.iagohribeirolima_atividade08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author iagohribeiro
 */
public class Teste implements ActionListener {
    
    private static Teste testeClass = new Teste();
    private static Passeio newVeiculoPasseio = new Passeio();
    private static Carga newVeiculoCarga = new Carga();
    
    private static final BDVeiculos veiculos = new BDVeiculos();
    
    private static final Leitura entradaUsuario = new Leitura();
    
    
    //JFrame Elements
    private static int larg = 300, alt =250;
    private static JFrame janelaPrincipal = new JFrame("Gestao de Veiculos");
    private static JFrame janelaVeiculoPasseio = new JFrame("");
    private static JFrame janelaVeiculoCarga = new JFrame("");
    private static JFrame janelaCadastros = new JFrame("");
    private static JFrame janelaConsultaExcluiVeiculos = new JFrame("");
    private static JFrame janelaImprimeExcluiVeiculos = new JFrame("");
    
    //JButton Elements
    private static JButton btPasseio = new JButton("Passeio");
    private static JButton btCarga = new JButton("Carga");
    
    private static JButton btCadastrarPasseio = new JButton("Cadastrar");
    private static JButton btConsultarPasseio = new JButton("Consultar / Excluir pela placa");
    private static JButton btImprimirPasseio = new JButton("Imprimir / Excluir Todos");
    private static JButton btSairPasseio = new JButton("Sair");
    
    private static JButton btCadastrarCarga = new JButton("Cadastrar");
    private static JButton btConsultarCarga = new JButton("Consultar / Excluir pela placa");
    private static JButton btImprimirCarga = new JButton("Imprimir / Excluir Todos");
    private static JButton btSairCarga = new JButton("Sair");
    
    
    public static void main(String[] args) throws VeicExistException, VelocException{
        
        boolean executando = true;
        int escolha = 0;
        carregaJanelaPrincipal();
        
        while (executando){
            
            /*System.out.println("""
                           \t\t\tSistema de Gestao de Veiculos - Menu Inicial\n
                           \t\t\t\t1. Cadastrar Veiculo de Passeio
                           \t\t\t\t2. Cadastrar Veiculo de Carga
                           \t\t\t\t3. Imprimir Todos os Veiculos de Passeio
                           \t\t\t\t4. Imprimir Todos os Veiculos de Carga
                           \t\t\t\t5. Imprimir Veiculo de Passeio pela Placa
                           \t\t\t\t6. Imprimir Veiculo de Carga pela Placa
                           \t\t\t\t7. Excluir Veiculo de Passeio pela Placa
                           \t\t\t\t8. Excluir Veiculo de Carga pela Placa
                           \t\t\t\t9. Sair do Sistema
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
                    while (true)
                    {
                        newVeiculoPasseio = new Passeio();

                        try{
                            veiculos.setPasseio(preenchePasseio(newVeiculoPasseio));
                        }
                        catch (VeicExistException e)
                        {
                            break;
                        }

                        entradaUsuario.entDados("Veiculo de Passeio cadastrado com Sucesso. Aperte ENTER.");


                        String retorno = entradaUsuario.entDados("Deseja cadastrar outro Veiculo de Passeio? <sim/nao>");

                        if(retorno.toLowerCase().equals("nao".toLowerCase()) || !retorno.toLowerCase().equals("sim".toLowerCase()))
                            break;
                    }
                    break;
                case 2:
                    while (true)
                    {
                        newVeiculoCarga = new Carga();
                        try{
                            veiculos.setCarga(preencheCarga(newVeiculoCarga));
                        }
                        catch (VeicExistException e)
                        {
                            break;
                        }

                        entradaUsuario.entDados("Veiculo de Carga cadastrado com Sucesso. Aperte ENTER.");


                        String retornoCarga = entradaUsuario.entDados("Deseja cadastrar outro Veiculo de Carga? <sim/nao>");

                        if(retornoCarga.toLowerCase().equals("nao".toLowerCase()) || !retornoCarga.toLowerCase().equals("sim".toLowerCase()))
                            break;
                    }
                    break;
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
                    String placaPasseioExcluir = entradaUsuario.entDados("Digite a placa do Veiculo de Passeio.");
                    boolean existePlacaPasseio = false;
                    
                    for (Passeio passeioElem : veiculos.getPasseio()) {
                        if (passeioElem!= null)
                        {
                            if (passeioElem.getPlaca().toLowerCase().equals(placaPasseioExcluir.toLowerCase()))
                            {
                                veiculos.excluiPasseio(passeioElem);
                                existePlacaPasseio = true;
                                break;
                            }
                        }
                    }
                    
                    if (!existePlacaPasseio)
                        System.out.println("\nNao foi encontrado Veiculo com a placa fornecida.\n");
                    
                    break;
                case 8:
                    String placaCargaExcluir = entradaUsuario.entDados("Digite a placa do Veiculo de Carga.");
                    boolean existePlacaCarga = false;
                    //Verifica se existe e imprime o veiculo a partir da placa fornecida
                    for (Carga cargaElem : veiculos.getCarga()) {
                        if (cargaElem != null)
                        {
                            if (cargaElem.getPlaca().toLowerCase().equals(placaCargaExcluir.toLowerCase()))
                            {
                                veiculos.excluiCarga(cargaElem);
                                existePlacaCarga = true;
                                break;
                            }
                        }
                    }
                    
                    if (!existePlacaCarga)
                        System.out.println("\nNao foi encontrado Veiculo com a placa fornecida.\n");
                    
                    break;
                case 9:
                    executando = false;
                    break;
                default:
                    System.out.println("\nPor favor digite um número entre 1 e 9\n");
                    break;
            } */ 
        }
    }
    
    //Metodo para preencher o objeto de pasaseio
    public static Passeio preenchePasseio(Passeio veiculo) throws VelocException
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
            veiculo.setVelocMax(Float.parseFloat(entradaUsuario.entDados("Velocidade Maxima.:")));
        }
        catch(VelocException e)
        {
            veiculo.setVelocMax(100f);
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
    public static Carga preencheCarga(Carga veiculo) throws VelocException
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
            veiculo.setVelocMax(Float.parseFloat(entradaUsuario.entDados("Velocidade Maxima.:")));
        }
        catch(VelocException e)
        {
            veiculo.setVelocMax(90f);
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
    
    //Carrega todas Janelas do Software
    public static void carregaJanelaPrincipal() {
        //Janela Principal
        janelaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaPrincipal.setLayout(new GridLayout(2,1,10,10));
        janelaPrincipal.setSize(larg,alt);
        janelaPrincipal.getContentPane().setBackground(Color.WHITE);
        
        janelaPrincipal.add(btPasseio);
        btPasseio.setMnemonic('P');
        btPasseio.setBackground(new Color(0, 162, 232));
        btPasseio.addActionListener(testeClass);
        btPasseio.setOpaque(true);
        btPasseio.setBorderPainted(false);
        
        janelaPrincipal.add(btCarga);
        btCarga.setMnemonic('C');
        btCarga.setBackground(new Color(34, 177, 75));
        btCarga.addActionListener(testeClass);
        btCarga.setOpaque(true);
        btCarga.setBorderPainted(false);


        janelaPrincipal.setVisible(true);
        
    }
    public static void carregaVeiculoPasseio() {
        
        //Janela Veiculos passeio
        janelaVeiculoPasseio.setLayout(new GridLayout(4,1,10,10));
        janelaVeiculoPasseio.setTitle("Veiculos de Passeio");
        janelaVeiculoPasseio.setSize(larg,alt);
        janelaVeiculoPasseio.getContentPane().setBackground(Color.WHITE);
        
        janelaVeiculoPasseio.add(btCadastrarPasseio);
        btCadastrarPasseio.setBackground(new Color(0, 162, 232));
        btCadastrarPasseio.addActionListener(testeClass);
        btCadastrarPasseio.setOpaque(true);
        btCadastrarPasseio.setBorderPainted(false);
        
        janelaVeiculoPasseio.add(btConsultarPasseio);
        btConsultarPasseio.setBackground(new Color(0, 162, 232));
        btConsultarPasseio.addActionListener(testeClass);
        btConsultarPasseio.setOpaque(true);
        btConsultarPasseio.setBorderPainted(false);
        
        janelaVeiculoPasseio.add(btImprimirPasseio);
        btImprimirPasseio.setBackground(new Color(0, 162, 232));
        btImprimirPasseio.addActionListener(testeClass);
        btImprimirPasseio.setOpaque(true);
        btImprimirPasseio.setBorderPainted(false);
        
        janelaVeiculoPasseio.add(btSairPasseio);
        btSairPasseio.setBackground(new Color(237, 28, 36));
        btSairPasseio.addActionListener(testeClass);
        btSairPasseio.setOpaque(true);
        btSairPasseio.setBorderPainted(false);

        janelaVeiculoPasseio.setVisible(true);
        
    }
    
    public static void carregaVeiculoCarga() {
        
        //Janela Veiculos passeio
        janelaVeiculoCarga.setLayout(new GridLayout(4,1,10,10));
        janelaVeiculoCarga.setTitle("Veiculos de Carga");
        janelaVeiculoCarga.setSize(larg,alt);
        janelaVeiculoCarga.getContentPane().setBackground(Color.WHITE);
        
        janelaVeiculoCarga.add(btCadastrarCarga);
        btCadastrarCarga.setBackground(new Color(34, 177, 75));
        btCadastrarCarga.addActionListener(testeClass);
        btCadastrarCarga.setOpaque(true);
        btCadastrarCarga.setBorderPainted(false);
        
        janelaVeiculoCarga.add(btConsultarCarga);
        btConsultarCarga.setBackground(new Color(34, 177, 75));
        btConsultarCarga.addActionListener(testeClass);
        btConsultarCarga.setOpaque(true);
        btConsultarCarga.setBorderPainted(false);
        
        janelaVeiculoCarga.add(btImprimirCarga);
        btImprimirCarga.setBackground(new Color(34, 177, 75));
        btImprimirCarga.addActionListener(testeClass);
        btImprimirCarga.setOpaque(true);
        btImprimirCarga.setBorderPainted(false);
        
        janelaVeiculoCarga.add(btSairCarga);
        btSairCarga.setBackground(new Color(237, 28, 36));
        btSairCarga.addActionListener(testeClass);
        btSairCarga.setOpaque(true);
        btSairCarga.setBorderPainted(false);

        janelaVeiculoCarga.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(btPasseio)){
            carregaVeiculoPasseio();
        }
        else if(e.getSource().equals(btCarga)){
            carregaVeiculoCarga();
        }
        else if(e.getSource().equals(btSairPasseio)){
            janelaVeiculoPasseio.dispose();
        }
        else if(e.getSource().equals(btSairCarga)){
            janelaVeiculoCarga.dispose();
        }
    }
}
