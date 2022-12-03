 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.iagohribeiro.iagohribeirolima_atividade08;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
    private static JFrame janelaCadastroCarga;
    private static JFrame janelaCadastroPasseio;
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
    
    private static JButton btCadastrarNewCarga = new JButton("Cadastrar");
    private static JButton btLimparCarga = new JButton("Limpar");
    private static JButton btNovoCarga = new JButton("Novo");
    private static JButton btSairTelaCadastarCarga = new JButton("Sair");
    
    private static JButton btCadastrarNewPasseio= new JButton("Cadastrar");
    private static JButton btLimparPasseio = new JButton("Limpar");
    private static JButton btNovoPasseio = new JButton("Novo");
    private static JButton btSairTelaCadastarPasseio = new JButton("Sair");
    
    //JTextFields
    private static JTextField taraTexto = new JTextField();
    private static JTextField cargaMaxTexto = new JTextField();
    private static JTextField placaTexto = new JTextField();
    private static JTextField marcaTexto = new JTextField();
    private static JTextField modeloTexto = new JTextField();
    private static JTextField corTexto = new JTextField();
    private static JTextField qtdRodasTexto = new JTextField();
    private static JTextField velocidadeMaxTexto = new JTextField();
    private static JTextField qtdPistoesTexto = new JTextField();
    private static JTextField potenciaTexto = new JTextField();
    private static JTextField qtdPassageiroTexto = new JTextField();
    
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
    public static Passeio preenchePasseio(Passeio veiculo)
    {
        try{
            veiculo.setQtdPassageiros(Integer.parseInt(qtdPassageiroTexto.getText()));
            veiculo.setPlaca(placaTexto.getText());              
            veiculo.setMarca(marcaTexto.getText());
            veiculo.setModelo(modeloTexto.getText());
            veiculo.setCor(corTexto.getText());
            veiculo.setQtdRodas(Integer.parseInt(qtdRodasTexto.getText()));

            try{
                veiculo.setVelocMax(Float.parseFloat(velocidadeMaxTexto.getText()));
            }
            catch(VelocException e)
            {
                try{
                    veiculo.setVelocMax(100f);
                }
                catch(VelocException exception){}
            }

            veiculo.getMotor().setQtdPist(Integer.parseInt(qtdPistoesTexto.getText()));
            veiculo.getMotor().setPotencia(Integer.parseInt(potenciaTexto.getText()));
        }
        catch(NumberFormatException exception){
            JOptionPane.showMessageDialog(new JFrame(),
            "Erro de Conversão. O veiculo não foi registrado.",
            "Erro",
            JOptionPane.ERROR_MESSAGE);
        }
        
        return veiculo;
    }
    
    public static void cadastraVeiculoPasseio()
    {
        newVeiculoPasseio = new Passeio();
        
        try{
            veiculos.setPasseio(preenchePasseio(newVeiculoPasseio));
            //Custom button text
            Object[] options = {"Sim",
                                "Nao"};
            int retornoCarga = JOptionPane.showOptionDialog(new JFrame(),
                "Veiculo de Passeio cadastrado com Sucesso. "
                + "Deseja cadastrar outro Veiculo de Passeio?",
                "Cadastro de novo Veiculo de Passeio",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

            System.out.println(retornoCarga);
            
            if(retornoCarga == 1)
            {
                cleanTextFields();
                janelaCadastroPasseio.dispose();
            }
          
        }
        catch (VeicExistException e)
        {
            janelaCadastroPasseio.dispose();
        }
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
        try{
            veiculo.setTara(Integer.parseInt(taraTexto.getText()));
            veiculo.setCargaMax(Integer.parseInt(cargaMaxTexto.getText()));
            veiculo.setPlaca(placaTexto.getText());              
            veiculo.setMarca(marcaTexto.getText());
            veiculo.setModelo(modeloTexto.getText());
            veiculo.setCor(corTexto.getText());
            veiculo.setQtdRodas(Integer.parseInt(qtdRodasTexto.getText()));

            try{
                veiculo.setVelocMax(Float.parseFloat(velocidadeMaxTexto.getText()));
            }
            catch(VelocException e)
            {
                try{
                    veiculo.setVelocMax(90f);
                }
                catch(VelocException exception){}
            }

            veiculo.getMotor().setQtdPist(Integer.parseInt(qtdPistoesTexto.getText()));
            veiculo.getMotor().setPotencia(Integer.parseInt(potenciaTexto.getText()));
        }
        catch(NumberFormatException exception){
            JOptionPane.showMessageDialog(new JFrame(),
            "Erro de Conversão. O veiculo não foi registrado.",
            "Erro",
            JOptionPane.ERROR_MESSAGE);
        }
        
        return veiculo;
    }
    
    public static void cadastraVeiculoCarga()
    {
        newVeiculoCarga = new Carga();
        
        try{
            veiculos.setCarga(preencheCarga(newVeiculoCarga));
            //Custom button text
            Object[] options = {"Sim",
                                "Nao"};
            int retornoCarga = JOptionPane.showOptionDialog(new JFrame(),
                "Veiculo de Carga cadastrado com Sucesso. "
                + "Deseja cadastrar outro Veiculo de Carga?",
                "Cadastro de novo Veiculo de Carga",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);

            System.out.println(retornoCarga);
            
            if(retornoCarga == 1)
            {
                cleanTextFields();
                janelaCadastroCarga.dispose();
            }
          
        }
        catch (VeicExistException e)
        {
            janelaCadastroCarga.dispose();
        }
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
    
    public static void carregaCadastroCarga() {
        janelaCadastroCarga = new JFrame("Cadastro de Carga");
        janelaCadastroCarga.setLayout(new GridBagLayout());
        janelaCadastroCarga.setSize(400,500);
        janelaCadastroCarga.getContentPane().setBackground(new Color(230, 230, 230));
        
        GridBagConstraints contraints = new GridBagConstraints();
        
        JLabel tara = new JLabel("Tara: ");
        JLabel cargaMax = new JLabel("Carga Max.: ");
        JLabel placa = new JLabel("Placa: ");
        JLabel marca = new JLabel("Marca: ");
        JLabel modelo = new JLabel("Modelo: ");
        JLabel cor = new JLabel("Cor: ");
        JLabel qtdRodas = new JLabel("Qtd. Rodas: ");
        JLabel velocidadeMax = new JLabel("Velocidade Max.:");
        JLabel qtdPistoes = new JLabel("Qtd. Pistoes: ");
        JLabel portencia = new JLabel("Potencia: ");
        
        cleanTextFields();
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 0;
        contraints.anchor = GridBagConstraints.FIRST_LINE_START;
        janelaCadastroCarga.add(tara, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 0;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.FIRST_LINE_END;
        janelaCadastroCarga.add(taraTexto, contraints);

        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 1;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroCarga.add(cargaMax, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 1;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroCarga.add(cargaMaxTexto, contraints);

        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 2;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroCarga.add(placa, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 2;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroCarga.add(placaTexto, contraints);

        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 3;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroCarga.add(marca, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 3;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroCarga.add(marcaTexto, contraints);

        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 4;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroCarga.add(modelo, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 4;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroCarga.add(modeloTexto, contraints);
        
        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 5;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroCarga.add(cor, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 5;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroCarga.add(corTexto, contraints);
        
        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 6;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroCarga.add(qtdRodas, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 6;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroCarga.add(qtdRodasTexto, contraints);
        
        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 7;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroCarga.add(velocidadeMax, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 7;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroCarga.add(velocidadeMaxTexto, contraints);
        
        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 8;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroCarga.add(qtdPistoes, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 8;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroCarga.add(qtdPistoesTexto, contraints);
        
        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 9;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroCarga.add(portencia, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 9;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroCarga.add(potenciaTexto, contraints);

        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 10;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btCadastrarNewCarga.addActionListener(testeClass);
        janelaCadastroCarga.add(btCadastrarNewCarga, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 2;
        contraints.gridy = 10;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btLimparCarga.addActionListener(testeClass);
        janelaCadastroCarga.add(btLimparCarga, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 3;
        contraints.gridy = 10;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btNovoCarga.addActionListener(testeClass);
        janelaCadastroCarga.add(btNovoCarga, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 4;
        contraints.gridy = 10;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btSairTelaCadastarCarga.setBackground(new Color(237, 28, 36));
        btSairTelaCadastarCarga.addActionListener(testeClass);
        janelaCadastroCarga.add(btSairTelaCadastarCarga, contraints);
        
        janelaCadastroCarga.setVisible(true); 
    }
    
        public static void carregaCadastroPasseio() {
        janelaCadastroPasseio = new JFrame("Cadastro de Passeio");
        janelaCadastroPasseio.setLayout(new GridBagLayout());
        janelaCadastroPasseio.setSize(400,500);
        janelaCadastroPasseio.getContentPane().setBackground(new Color(230, 230, 230));
        
        GridBagConstraints contraints = new GridBagConstraints();
        
        JLabel qtdPassageiro = new JLabel("Qtd. Passageiros: ");
        JLabel placa = new JLabel("Placa: ");
        JLabel marca = new JLabel("Marca: ");
        JLabel modelo = new JLabel("Modelo: ");
        JLabel cor = new JLabel("Cor: ");
        JLabel qtdRodas = new JLabel("Qtd. Rodas: ");
        JLabel velocidadeMax = new JLabel("Velocidade Max.:");
        JLabel qtdPistoes = new JLabel("Qtd. Pistoes: ");
        JLabel portencia = new JLabel("Potencia: ");
        
        cleanTextFields();
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 0;
        contraints.anchor = GridBagConstraints.FIRST_LINE_START;
        janelaCadastroPasseio.add(qtdPassageiro, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 0;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.FIRST_LINE_END;
        janelaCadastroPasseio.add(qtdPassageiroTexto, contraints);

        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 2;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroPasseio.add(placa, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 2;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroPasseio.add(placaTexto, contraints);

        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 3;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroPasseio.add(marca, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 3;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroPasseio.add(marcaTexto, contraints);

        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 4;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroPasseio.add(modelo, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 4;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroPasseio.add(modeloTexto, contraints);
        
        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 5;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroPasseio.add(cor, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 5;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroPasseio.add(corTexto, contraints);
        
        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 6;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroPasseio.add(qtdRodas, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 6;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroPasseio.add(qtdRodasTexto, contraints);
        
        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 7;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroPasseio.add(velocidadeMax, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 7;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroPasseio.add(velocidadeMaxTexto, contraints);
        
        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 8;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroPasseio.add(qtdPistoes, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 8;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroPasseio.add(qtdPistoesTexto, contraints);
        
        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 9;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaCadastroPasseio.add(portencia, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 9;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaCadastroPasseio.add(potenciaTexto, contraints);

        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 10;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btCadastrarNewPasseio.addActionListener(testeClass);
        janelaCadastroPasseio.add(btCadastrarNewPasseio, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 2;
        contraints.gridy = 10;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btLimparPasseio.addActionListener(testeClass);
        janelaCadastroPasseio.add(btLimparPasseio, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 3;
        contraints.gridy = 10;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btNovoPasseio.addActionListener(testeClass);
        janelaCadastroPasseio.add(btNovoPasseio, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 4;
        contraints.gridy = 10;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btSairTelaCadastarPasseio.setBackground(new Color(237, 28, 36));
        btSairTelaCadastarPasseio.addActionListener(testeClass);
        janelaCadastroPasseio.add(btSairTelaCadastarPasseio, contraints);
        
        janelaCadastroPasseio.setVisible(true); 
    }
    
    public static void cleanTextFields(){
        taraTexto.setText("");
        cargaMaxTexto.setText("");
        placaTexto.setText("");
        marcaTexto.setText("");
        modeloTexto.setText("");
        corTexto.setText("");
        qtdRodasTexto.setText("");
        velocidadeMaxTexto.setText("");
        qtdPistoesTexto.setText("");
        potenciaTexto.setText("");
        qtdPassageiroTexto.setText("");
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
        else if(e.getSource().equals(btCadastrarCarga)){
            carregaCadastroCarga();
        }
        else if(e.getSource().equals(btSairTelaCadastarCarga)){
            janelaCadastroCarga.dispose();
        }
        else if(e.getSource().equals(btLimparCarga) || e.getSource().equals(btLimparPasseio)){
            cleanTextFields();
        }
        else if(e.getSource().equals(btCadastrarNewCarga)){
           cadastraVeiculoCarga();
        }
        else if(e.getSource().equals(btCadastrarPasseio)){
            carregaCadastroPasseio();
        }
        else if(e.getSource().equals(btSairTelaCadastarPasseio)){
            janelaCadastroPasseio.dispose();
        }
        else if(e.getSource().equals(btCadastrarNewPasseio)){
           cadastraVeiculoPasseio();
        }
        
    }
}
