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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

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
    private static JFrame janelaConsultaExcluiVeiculosPasseio;
    private static JFrame janelaConsultaExcluiVeiculosCarga;
    private static JFrame janelaImprimeExcluiVeiculosPasseio;
    private static JFrame janelaImprimeExcluiVeiculosCarga;
    
    //-------------------------------JButton Elements
    //Botoes Tela Principal
    private static JButton btPasseio = new JButton("Passeio");
    private static JButton btCarga = new JButton("Carga");
    
    //Botoes Tela Passeio
    private static JButton btCadastrarPasseio = new JButton("Cadastrar");
    private static JButton btConsultarPasseio = new JButton("Consultar / Excluir pela placa");
    private static JButton btImprimirPasseio = new JButton("Imprimir / Excluir Todos");
    private static JButton btSairPasseio = new JButton("Sair");
    
    //Botoes Tela Carga
    private static JButton btCadastrarCarga = new JButton("Cadastrar");
    private static JButton btConsultarCarga = new JButton("Consultar / Excluir pela placa");
    private static JButton btImprimirCarga = new JButton("Imprimir / Excluir Todos");
    private static JButton btSairCarga = new JButton("Sair");
    
    //Botoes Tela Cadastrar Carga
    private static JButton btCadastrarNewCarga = new JButton("Cadastrar");
    private static JButton btLimparCarga = new JButton("Limpar");
    private static JButton btNovoCarga = new JButton("Novo");
    private static JButton btSairTelaCadastarCarga = new JButton("Sair");
    
    //Botoes Tela Cadastrar Passeio
    private static JButton btCadastrarNewPasseio= new JButton("Cadastrar");
    private static JButton btLimparPasseio = new JButton("Limpar");
    private static JButton btNovoPasseio = new JButton("Novo");
    private static JButton btSairTelaCadastarPasseio = new JButton("Sair");
    
    //Botoes Tela Consultar Passeio
    private static JButton btConsultarPlacaPasseio= new JButton("Consultar");
    private static JButton btExcluirPasseio = new JButton("Exluir");
    private static JButton btSairTelaConsultarPasseio = new JButton("Sair");
    
    //Botoes Tela Consultar Carga
    private static JButton btConsultarPlacaCarga= new JButton("Consultar");
    private static JButton btExcluirCarga = new JButton("Exluir");
    private static JButton btSairTelaConsultarCarga = new JButton("Sair");
    
    //Botoes Tela Imprimir Passeio
    private static JButton btImprimirTodosPasseio= new JButton("Imprimir Todos");
    private static JButton btExcluirTodosPasseio = new JButton("Exluir Todos");
    private static JButton btSairTelaImprimirPasseio = new JButton("Sair");
    
    //Botoes Tela Imprimir Carga
    private static JButton btImprimirTodosCarga= new JButton("Imprimir Todos");
    private static JButton btExcluirTodosCarga = new JButton("Exluir Todos");
    private static JButton btSairTelaImprimirCarga= new JButton("Sair");
    
    //-------------------------------JTextFields
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
    private static JTextField velMaxConvetidoTexto = new JTextField();
    private static JTextField qtdAtributoNumericoTexto = new JTextField();
    private static JTextField qtdLetrasTexto = new JTextField();
    
    //JTables
    private static JTable tabelaPasseio;
    private static JTable tabelaCarga;
    private static JScrollPane barraRolagem;
    
    public static void main(String[] args) throws VeicExistException, VelocException{
        carregaJanelaPrincipal();
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

    public static void carregaConsultaPasseio() {
        janelaConsultaExcluiVeiculosPasseio = new JFrame("Consultar / Excluir pela placa");
        janelaConsultaExcluiVeiculosPasseio.setLayout(new GridBagLayout());
        janelaConsultaExcluiVeiculosPasseio.setSize(600,800);
        janelaConsultaExcluiVeiculosPasseio.getContentPane().setBackground(new Color(230, 230, 230));

        GridBagConstraints contraints = new GridBagConstraints();

        JLabel qtdPassageiro = new JLabel("Qtd. Passageiros: ");
        JLabel placa = new JLabel("Informe a Placa: ");
        JLabel marca = new JLabel("Marca: ");
        JLabel modelo = new JLabel("Modelo: ");
        JLabel cor = new JLabel("Cor: ");
        JLabel qtdRodas = new JLabel("Qtd. Rodas: ");
        JLabel velocidadeMax = new JLabel("Velocidade Max.:");
        JLabel qtdPistoes = new JLabel("Qtd. Pistoes: ");
        JLabel portencia = new JLabel("Potencia: ");
        JLabel qtdLetras = new JLabel("Qtd. total de Letras: ");
        JLabel velConvertida = new JLabel("Calc Vel Maxima em meter/hour: ");

        cleanTextFields();

        placa.setForeground(Color.red);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 0;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosPasseio.add(placa, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 0;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaConsultaExcluiVeiculosPasseio.add(placaTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 1;
        contraints.anchor = GridBagConstraints.FIRST_LINE_START;
        janelaConsultaExcluiVeiculosPasseio.add(qtdPassageiro, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 1;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.FIRST_LINE_END;
        qtdPassageiroTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosPasseio.add(qtdPassageiroTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 3;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosPasseio.add(marca, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 3;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        marcaTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosPasseio.add(marcaTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 4;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosPasseio.add(modelo, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 4;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        modeloTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosPasseio.add(modeloTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 5;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosPasseio.add(cor, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 5;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        corTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosPasseio.add(corTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 6;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosPasseio.add(qtdRodas, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 6;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        qtdRodasTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosPasseio.add(qtdRodasTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 7;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosPasseio.add(velocidadeMax, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 7;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        velocidadeMaxTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosPasseio.add(velocidadeMaxTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 8;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosPasseio.add(qtdPistoes, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 8;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        qtdPistoesTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosPasseio.add(qtdPistoesTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 9;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosPasseio.add(portencia, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 9;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        potenciaTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosPasseio.add(potenciaTexto, contraints);

        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 10;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosPasseio.add(qtdLetras, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 10;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        qtdLetrasTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosPasseio.add(qtdLetrasTexto, contraints);

        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 11;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosPasseio.add(velConvertida, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 11;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        velMaxConvetidoTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosPasseio.add(velMaxConvetidoTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 2;
        contraints.gridy = 12;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btConsultarPlacaPasseio.addActionListener(testeClass);
        janelaConsultaExcluiVeiculosPasseio.add(btConsultarPlacaPasseio, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 3;
        contraints.gridy = 12;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btExcluirPasseio.addActionListener(testeClass);
        janelaConsultaExcluiVeiculosPasseio.add(btExcluirPasseio, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 4;
        contraints.gridy = 12;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btSairTelaConsultarPasseio.setBackground(new Color(237, 28, 36));
        btSairTelaConsultarPasseio.addActionListener(testeClass);
        janelaConsultaExcluiVeiculosPasseio.add(btSairTelaConsultarPasseio, contraints);

        janelaConsultaExcluiVeiculosPasseio.setVisible(true); 
    }
    
    public static void buscaPasseio(){
        boolean temPlacaPasseio = false;

        //Verifica se existe e imprime o veiculo a partir da placa fornecida
        for (Passeio passeioElem : veiculos.getPasseio()) {
            if (passeioElem!= null)
            {
                if (passeioElem.getPlaca().toLowerCase().equals(placaTexto.getText().toLowerCase()))
                {
                    marcaTexto.setText(passeioElem.getMarca());
                    modeloTexto.setText(passeioElem.getModelo());
                    corTexto.setText(passeioElem.getCor());
                    qtdRodasTexto.setText(String.valueOf(passeioElem.getQtdRodas()));
                    velocidadeMaxTexto.setText(String.valueOf(passeioElem.getVelocMax()));
                    qtdPistoesTexto.setText(String.valueOf(passeioElem.getMotor().getQtdPist()));
                    potenciaTexto.setText(String.valueOf(passeioElem.getMotor().getPotencia()));
                    qtdPassageiroTexto.setText(String.valueOf(passeioElem.getQtdPassageiros()));
                    qtdLetrasTexto.setText(String.valueOf(passeioElem.calcular()));
                    velMaxConvetidoTexto.setText(String.valueOf(passeioElem.calcVel(passeioElem.getVelocMax())));
                    temPlacaPasseio = true;
                    break;
                }
            }
        }

        if (!temPlacaPasseio)
            JOptionPane.showMessageDialog(new JFrame(),
        "Nao foi encontrado Veiculo com a placa fornecida.",
        "Warning",
        JOptionPane.WARNING_MESSAGE);
    }
    
    public static void excluiPasseio(){
        boolean existePlacaPasseio = false;

        for (Passeio passeioElem : veiculos.getPasseio()) {
            if (passeioElem!= null)
            {
                if (passeioElem.getPlaca().toLowerCase().equals(placaTexto.getText().toLowerCase()))
                {
                    veiculos.excluiPasseio(passeioElem);
                    existePlacaPasseio = true;
                    break;
                }
            }
        }

        if (!existePlacaPasseio)
            JOptionPane.showMessageDialog(new JFrame(),
        "Nao foi encontrado Veiculo com a placa fornecida.",
        "Warning",
        JOptionPane.WARNING_MESSAGE);
    }
    
    public static void carregaConsultaCarga() {
        janelaConsultaExcluiVeiculosCarga = new JFrame("Consultar / Excluir pela placa");
        janelaConsultaExcluiVeiculosCarga.setLayout(new GridBagLayout());
        janelaConsultaExcluiVeiculosCarga.setSize(600,800);
        janelaConsultaExcluiVeiculosCarga.getContentPane().setBackground(new Color(230, 230, 230));

        GridBagConstraints contraints = new GridBagConstraints();

        JLabel tara = new JLabel("Tara: ");
        JLabel cargaMax = new JLabel("Carga Max.: ");
        JLabel placa = new JLabel("Informe a Placa: ");
        JLabel marca = new JLabel("Marca: ");
        JLabel modelo = new JLabel("Modelo: ");
        JLabel cor = new JLabel("Cor: ");
        JLabel qtdRodas = new JLabel("Qtd. Rodas: ");
        JLabel velocidadeMax = new JLabel("Velocidade Max.:");
        JLabel qtdPistoes = new JLabel("Qtd. Pistoes: ");
        JLabel portencia = new JLabel("Potencia: ");
        JLabel qtdAtributoNumerico = new JLabel("Qtd. total atributos Numericos: ");
        JLabel velConvertida = new JLabel("Calc Vel Maxima em cetimetro/hour: ");

        cleanTextFields();

        placa.setForeground(Color.red);
        
        /**/

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 0;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosCarga.add(placa, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 0;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        janelaConsultaExcluiVeiculosCarga.add(placaTexto, contraints);

        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 1;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosCarga.add(tara, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 1;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        taraTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosCarga.add(taraTexto, contraints);

        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 2;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosCarga.add(cargaMax, contraints);
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 2;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        cargaMaxTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosCarga.add(cargaMaxTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 3;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosCarga.add(marca, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 3;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        marcaTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosCarga.add(marcaTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 4;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosCarga.add(modelo, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 4;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        modeloTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosCarga.add(modeloTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 5;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosCarga.add(cor, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 5;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        corTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosCarga.add(corTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 6;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosCarga.add(qtdRodas, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 6;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        qtdRodasTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosCarga.add(qtdRodasTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 7;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosCarga.add(velocidadeMax, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 7;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        velocidadeMaxTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosCarga.add(velocidadeMaxTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 8;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosCarga.add(qtdPistoes, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 8;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        qtdPistoesTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosCarga.add(qtdPistoesTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 9;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosCarga.add(portencia, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 9;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        potenciaTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosCarga.add(potenciaTexto, contraints);

        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 10;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosCarga.add(qtdAtributoNumerico, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 10;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        qtdAtributoNumericoTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosCarga.add(qtdAtributoNumericoTexto, contraints);

        contraints.gridwidth = 1;
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 11;
        contraints.anchor = GridBagConstraints.LINE_START;
        janelaConsultaExcluiVeiculosCarga.add(velConvertida, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 1;
        contraints.gridy = 11;
        contraints.gridwidth = 4;
        contraints.anchor = GridBagConstraints.LINE_END;
        velMaxConvetidoTexto.setEnabled(false);
        janelaConsultaExcluiVeiculosCarga.add(velMaxConvetidoTexto, contraints);

        contraints.gridwidth = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 2;
        contraints.gridy = 12;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btConsultarPlacaCarga.addActionListener(testeClass);
        janelaConsultaExcluiVeiculosCarga.add(btConsultarPlacaCarga, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 3;
        contraints.gridy = 12;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btExcluirCarga.addActionListener(testeClass);
        janelaConsultaExcluiVeiculosCarga.add(btExcluirCarga, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 4;
        contraints.gridy = 12;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btSairTelaConsultarCarga.setBackground(new Color(237, 28, 36));
        btSairTelaConsultarCarga.addActionListener(testeClass);
        janelaConsultaExcluiVeiculosCarga.add(btSairTelaConsultarCarga, contraints);

        janelaConsultaExcluiVeiculosCarga.setVisible(true); 
    }
    
    public static void buscaCarga(){
        boolean temPlacaCarga = false;

        //Verifica se existe e imprime o veiculo a partir da placa fornecida
        for (Carga CargaElem : veiculos.getCarga()) {
            if (CargaElem!= null)
            {
                if (CargaElem.getPlaca().toLowerCase().equals(placaTexto.getText().toLowerCase()))
                {
                    marcaTexto.setText(CargaElem.getMarca());
                    modeloTexto.setText(CargaElem.getModelo());
                    corTexto.setText(CargaElem.getCor());
                    qtdRodasTexto.setText(String.valueOf(CargaElem.getQtdRodas()));
                    velocidadeMaxTexto.setText(String.valueOf(CargaElem.getVelocMax()));
                    qtdPistoesTexto.setText(String.valueOf(CargaElem.getMotor().getQtdPist()));
                    potenciaTexto.setText(String.valueOf(CargaElem.getMotor().getPotencia()));
                    qtdAtributoNumericoTexto.setText(String.valueOf(CargaElem.calcular()));
                    velMaxConvetidoTexto.setText(String.valueOf(CargaElem.calcVel(CargaElem.getVelocMax())));
                    taraTexto.setText(String.valueOf(CargaElem.getTara()));
                    cargaMaxTexto.setText(String.valueOf(CargaElem.getCargaMax()));
                    temPlacaCarga = true;
                    break;
                }
            }
        }

        if (!temPlacaCarga)
            JOptionPane.showMessageDialog(new JFrame(),
        "Nao foi encontrado Veiculo com a placa fornecida.",
        "Warning",
        JOptionPane.WARNING_MESSAGE);
    }
    
    public static void excluiCarga(){
        boolean existePlacaCarga = false;

        for (Carga cargaElem : veiculos.getCarga()) {
            if (cargaElem!= null)
            {
                if (cargaElem.getPlaca().toLowerCase().equals(placaTexto.getText().toLowerCase()))
                {
                    veiculos.excluiCarga(cargaElem);
                    existePlacaCarga = true;
                    break;
                }
            }
        }

        if (!existePlacaCarga)
            JOptionPane.showMessageDialog(new JFrame(),
        "Nao foi encontrado Veiculo com a placa fornecida.",
        "Warning",
        JOptionPane.WARNING_MESSAGE);
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
        velMaxConvetidoTexto.setText("");
        qtdAtributoNumericoTexto.setText("");
        qtdLetrasTexto.setText("");
        
        taraTexto.setEnabled(true);
        cargaMaxTexto.setEnabled(true);
        placaTexto.setEnabled(true);
        marcaTexto.setEnabled(true);
        modeloTexto.setEnabled(true);
        corTexto.setEnabled(true);
        qtdRodasTexto.setEnabled(true);
        velocidadeMaxTexto.setEnabled(true);
        qtdPistoesTexto.setEnabled(true);
        potenciaTexto.setEnabled(true);
        qtdPassageiroTexto.setEnabled(true);
        velMaxConvetidoTexto.setEnabled(true);
        qtdAtributoNumericoTexto.setEnabled(true);
        qtdLetrasTexto.setEnabled(true);
    }
    
    public static void carregaImprimirPasseio() {
        janelaImprimeExcluiVeiculosPasseio = new JFrame("Imprimir / Excluir todos");
        janelaImprimeExcluiVeiculosPasseio.setLayout(new GridBagLayout());
        janelaImprimeExcluiVeiculosPasseio.setSize(600,800);
        janelaImprimeExcluiVeiculosPasseio.getContentPane().setBackground(new Color(230, 230, 230));

        GridBagConstraints contraints = new GridBagConstraints();
        
        cleanTextFields();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Placa");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Cor");
        model.addColumn("Qtd. Rodas");
        model.addColumn("Veloc Max");
        model.addColumn("Qtd.Pist");
        model.addColumn("Potencia");
        model.addColumn("Qtd. Passageiro");
        model.addColumn("Qtd. Letras");
        model.addColumn("Vel. Convertida");
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 0;
        contraints.gridwidth = 11;
        contraints.gridheight = 11;
        tabelaPasseio = new JTable(model);
        barraRolagem = new JScrollPane(tabelaPasseio);
        janelaImprimeExcluiVeiculosPasseio.add(barraRolagem, contraints);

        contraints.gridwidth = 1;
        contraints.gridheight = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 2;
        contraints.gridy = 12;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btImprimirTodosPasseio.addActionListener(testeClass);
        janelaImprimeExcluiVeiculosPasseio.add(btImprimirTodosPasseio, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 3;
        contraints.gridy = 12;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btExcluirTodosPasseio.addActionListener(testeClass);
        janelaImprimeExcluiVeiculosPasseio.add(btExcluirTodosPasseio, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 4;
        contraints.gridy = 12;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btSairTelaImprimirPasseio.setBackground(new Color(237, 28, 36));
        btSairTelaImprimirPasseio.addActionListener(testeClass);
        janelaImprimeExcluiVeiculosPasseio.add(btSairTelaImprimirPasseio, contraints);

        janelaImprimeExcluiVeiculosPasseio.setVisible(true); 
    }
    
    public static void imprimirPasseio() {
        DefaultTableModel model = (DefaultTableModel) tabelaPasseio.getModel();
        
        boolean temPasseio = false;
        
        while(model.getRowCount() > 0)
        {
            model.removeRow(0);
        }
        
        for (Passeio passeioElem : veiculos.getPasseio()) {
            if (passeioElem != null)
            {
                model.addRow(new Object[]{
                passeioElem.getPlaca(),
                passeioElem.getMarca(),
                passeioElem.getModelo(),
                passeioElem.getCor(),
                passeioElem.getQtdRodas(),
                passeioElem.getVelocMax(),
                passeioElem.getMotor().getQtdPist(),
                passeioElem.getMotor().getPotencia(),
                passeioElem.getQtdPassageiros(),
                passeioElem.calcular(),
                passeioElem.calcVel(passeioElem.getVelocMax())});
                temPasseio = true;
            }
        }

        if(!temPasseio)
            JOptionPane.showMessageDialog(new JFrame(),
          "Nao ha veiculos cadastrados.",
            "Warning",
        JOptionPane.WARNING_MESSAGE);
    }
    
    public static void excluirTodosPasseio(){

        boolean existePlacaPasseio = false;

        if (!veiculos.getPasseio().isEmpty())
        {
            for (Passeio passeioElem : veiculos.getPasseio()) {
                if (passeioElem!= null)
                {
                    veiculos.excluiPasseio(passeioElem);
                    existePlacaPasseio = true;
                }
            }
        }
        
        DefaultTableModel model = (DefaultTableModel) tabelaPasseio.getModel();
        
        while(model.getRowCount() > 0)
        {
            model.removeRow(0);
        }

        if (!existePlacaPasseio)
            JOptionPane.showMessageDialog(new JFrame(),
        "Nao ha veiculos cadastrados.",
          "Warning",
      JOptionPane.WARNING_MESSAGE);
    }
    
    public static void carregaImprimirCarga() {
        janelaImprimeExcluiVeiculosCarga = new JFrame("Imprimir / Excluir todos");
        janelaImprimeExcluiVeiculosCarga.setLayout(new GridBagLayout());
        janelaImprimeExcluiVeiculosCarga.setSize(600,800);
        janelaImprimeExcluiVeiculosCarga.getContentPane().setBackground(new Color(230, 230, 230));

        GridBagConstraints contraints = new GridBagConstraints();
        
        cleanTextFields();
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Placa");
        model.addColumn("Marca");
        model.addColumn("Modelo");
        model.addColumn("Cor");
        model.addColumn("Qtd. Rodas");
        model.addColumn("Veloc Max");
        model.addColumn("Qtd.Pist");
        model.addColumn("Potencia");
        model.addColumn("Tara");
        model.addColumn("Carga Max");
        model.addColumn("Qtd. atributos Numericos");
        model.addColumn("Vel. Convertida");
        
        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 0;
        contraints.gridy = 0;
        contraints.gridwidth = 12;
        contraints.gridheight = 12;
        tabelaCarga = new JTable(model);
        barraRolagem = new JScrollPane(tabelaCarga);
        janelaImprimeExcluiVeiculosCarga.add(barraRolagem, contraints);

        contraints.gridwidth = 1;
        contraints.gridheight = 1;

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 2;
        contraints.gridy = 12;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btImprimirTodosCarga.addActionListener(testeClass);
        janelaImprimeExcluiVeiculosCarga.add(btImprimirTodosCarga, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 3;
        contraints.gridy = 12;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btExcluirTodosCarga.addActionListener(testeClass);
        janelaImprimeExcluiVeiculosCarga.add(btExcluirTodosCarga, contraints);

        contraints.fill = GridBagConstraints.HORIZONTAL;
        contraints.gridx = 4;
        contraints.gridy = 12;
        contraints.anchor = GridBagConstraints.PAGE_END;
        btSairTelaImprimirCarga.setBackground(new Color(237, 28, 36));
        btSairTelaImprimirCarga.addActionListener(testeClass);
        janelaImprimeExcluiVeiculosCarga.add(btSairTelaImprimirCarga, contraints);

        janelaImprimeExcluiVeiculosCarga.setVisible(true); 
    }
    
    public static void imprimirCarga() {
        DefaultTableModel model = (DefaultTableModel) tabelaCarga.getModel();
        
        boolean temCarga = false;
        
        while(model.getRowCount() > 0)
        {
            model.removeRow(0);
        }
        
        for (Carga CargaElem : veiculos.getCarga()) {
            if (CargaElem != null)
            {
                model.addRow(new Object[]{
                CargaElem.getPlaca(),
                CargaElem.getMarca(),
                CargaElem.getModelo(),
                CargaElem.getCor(),
                CargaElem.getQtdRodas(),
                CargaElem.getVelocMax(),
                CargaElem.getMotor().getQtdPist(),
                CargaElem.getMotor().getPotencia(),
                CargaElem.getTara(),
                CargaElem.getCargaMax(),
                CargaElem.calcular(),
                CargaElem.calcVel(CargaElem.getVelocMax())});
                temCarga = true;
            }
        }

        if(!temCarga)
            JOptionPane.showMessageDialog(new JFrame(),
          "Nao ha veiculos cadastrados.",
            "Warning",
        JOptionPane.WARNING_MESSAGE);
    }
    
    public static void excluirTodosCarga(){

        boolean existeCarga = false;

        if (!veiculos.getCarga().isEmpty())
        {
            for (Carga CargaElem : veiculos.getCarga()) {
                if (CargaElem!= null)
                {
                    veiculos.excluiCarga(CargaElem);
                    existeCarga = true;
                }
            }
        }
        
        DefaultTableModel model = (DefaultTableModel) tabelaCarga.getModel();
        
        while(model.getRowCount() > 0)
        {
            model.removeRow(0);
        }

        if (!existeCarga)
            JOptionPane.showMessageDialog(new JFrame(),
        "Nao ha veiculos cadastrados.",
          "Warning",
      JOptionPane.WARNING_MESSAGE);
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
        else if(e.getSource().equals(btConsultarPasseio)){
           carregaConsultaPasseio();
        }
        else if(e.getSource().equals(btConsultarPlacaPasseio)){
           buscaPasseio();
        }
        else if(e.getSource().equals(btExcluirPasseio)){
           excluiPasseio();
        }
        else if(e.getSource().equals(btSairTelaConsultarPasseio)){
            janelaConsultaExcluiVeiculosPasseio.dispose();
        }
        else if(e.getSource().equals(btConsultarCarga)){
           carregaConsultaCarga();
        }
        else if(e.getSource().equals(btConsultarPlacaCarga)){
           buscaCarga();
        }
        else if(e.getSource().equals(btExcluirCarga)){
           excluiCarga();
        }
        else if(e.getSource().equals(btSairTelaConsultarCarga)){
            janelaConsultaExcluiVeiculosCarga.dispose();
        }
        else if(e.getSource().equals(btImprimirPasseio)){
            carregaImprimirPasseio();
        }
        else if(e.getSource().equals(btImprimirTodosPasseio)){
            imprimirPasseio();
        }
        else if(e.getSource().equals(btExcluirTodosPasseio)){
            excluirTodosPasseio();
        }
        else if(e.getSource().equals(btSairTelaImprimirPasseio)){
            janelaImprimeExcluiVeiculosPasseio.dispose();
        }
        else if(e.getSource().equals(btImprimirCarga)){
            carregaImprimirCarga();
        }
        else if(e.getSource().equals(btImprimirTodosCarga)){
            imprimirCarga();
        }
        else if(e.getSource().equals(btExcluirTodosCarga)){
            excluirTodosCarga();
        }
        else if(e.getSource().equals(btSairTelaImprimirCarga)){
            janelaImprimeExcluiVeiculosCarga.dispose();
        }
    }
}
