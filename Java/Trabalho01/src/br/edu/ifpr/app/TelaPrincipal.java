package br.edu.ifpr.app;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Vector;
import java.util.concurrent.Executor;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import br.edu.ifpr.app.banco.ConnectionFactory;
import br.edu.ifpr.app.banco.Join;
import br.edu.ifpr.app.banco.TableCreator;
import br.edu.ifpr.app.banco.cliente.ClienteDB;
import br.edu.ifpr.app.banco.cliente.ClienteDao;
import br.edu.ifpr.app.banco.fornecedor.FornecedorDB;
import br.edu.ifpr.app.banco.fornecedor.FornecedorDao;
import br.edu.ifpr.app.banco.produto.ProdutoDB;
import br.edu.ifpr.app.banco.produto.ProdutoDao;
import br.edu.ifpr.app.banco.venda.VendaDB;
import br.edu.ifpr.app.banco.venda.VendaDao;
import br.edu.ifpr.app.banco.vendedor.VendedorDB;
import br.edu.ifpr.app.banco.vendedor.VendedorDao;
import br.edu.ifpr.app.janelas.Ajuda;
import br.edu.ifpr.app.janelas.Cliente;
import br.edu.ifpr.app.janelas.Fornecedor;
import br.edu.ifpr.app.janelas.Produto;
import br.edu.ifpr.app.janelas.Venda;
import br.edu.ifpr.app.janelas.Vendedor;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;

import java.awt.Toolkit;

import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;


public class TelaPrincipal extends JFrame{

	/**
	 * feito por Gabriel Marques
	 */
	private static final long serialVersionUID = 1L;
	
	
//	ADD O TRATADOR DE ACAO
	TrataBotao tratador = new TrataBotao();
	
	//MENU PRINCIPAL
	JMenuBar mainMenu = new JMenuBar();
	
	// CADASTRO
	JMenu mnCadastros = new JMenu("Cadastrar");
	
		//MENUITENS CADASTRO
		JMenuItem mniProduto = new JMenuItem("Produto");
		JMenuItem mniCliente = new JMenuItem("Cliente");
		JMenuItem mniVendedor = new JMenuItem("Vendedor");
		JMenuItem mniFornecedor = new JMenuItem("Fornecedor");
		JMenuItem mniVenda = new JMenuItem("Vendas");
		
//	TABELAS
	private final JMenu mnTabelas = new JMenu("Tabelas");
//		MENUITEM TABELAS
		private final JMenuItem mniGerarTabelas = new JMenuItem("Gerar Tabelas");
		
//	 AJUDA
	JMenu mnAjuda = new JMenu("Ajuda");
		JMenuItem mniSobre = new JMenuItem("Sobre");
		
//	TOOLBAR
	JToolBar toolbar = new JToolBar();
		
//	label relogio
	Calendar time = Calendar.getInstance();
	JLabel clock = new JLabel("" +time.getTime());
	
	private final JToolBar toolBar = new JToolBar();
	private final JButton btClienteToolbar = new JButton("Cliente");
	private final JButton btVendedorToolbar = new JButton("Vendedor");
	private final JButton btFornecedorToolbar = new JButton("Fornecedor");
	private final JButton btProdutoToolbar = new JButton("Produto");
	private final JButton btVendasToolbar = new JButton("Vendas");
	
	private final JTextField txfSearch = new JTextField();
	
	
//	IREI INSTANCIAR A TABELA DEPOIS
	private JTable tbresultado = null;
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable tbtb = new JTable(){
		public boolean isCellEditable(int row, int column) {                
            return false;               
		};
	};
//	IREI INSTANCIAR A TABELA DEPOIS
	
//	BOTOES ALTERAR E EXCLUIR
	JButton btnEditar = new JButton("Editar");
	JButton btnApagar = new JButton("Apagar");
//	FIM BOTOES ALTERAR E EXCLUIR
//	BOTAO DE PROCURA
	JButton btnSearch = new JButton("");
//	BOTAO DE PROCURA
	
//	RADIO BUTTONS
	JRadioButton rbProduto = new JRadioButton("Produto");
	JRadioButton rbCliente = new JRadioButton("Cliente");
	JRadioButton rbVendedor = new JRadioButton("Vendedor");
	JRadioButton rbFornecedor = new JRadioButton("Fornecedor");
	private final JMenu mnJoins = new JMenu("Joins");
	private final JMenuItem mniJoin1 = new JMenuItem("Produtos por Cliente");
	private final JMenuItem mniJoin2 = new JMenuItem("Produtos por Fornecedor");
	private final JMenuItem mniJoin3 = new JMenuItem("Fornecedor dos Produto que Cliente Comprou");
//	RADIO BUTTONS
	
	public TelaPrincipal(){
		super("Inicio");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/br/edu/ifpr/images/control.png")));
		
//		ADD DOS TRATADORES AOS COMPONENTES
		mniProduto.addActionListener(tratador);
		mniCliente.addActionListener(tratador);
		mniVendedor.addActionListener(tratador);
		mniFornecedor.addActionListener(tratador);
		mniVenda.addActionListener(tratador);
		
		mniGerarTabelas.addActionListener(tratador);
		
		mniJoin1.addActionListener(tratador);
		mniJoin2.addActionListener(tratador);
		mniJoin3.addActionListener(tratador);
		
		mniSobre.addActionListener(tratador);
		
		btProdutoToolbar.addActionListener(tratador);
		btClienteToolbar.addActionListener(tratador);
		
		btnApagar.addActionListener(tratador);
		btnEditar.addActionListener(tratador);
		
		//ADICIONANDO MENU A TELA E ITENS AO MENU
//		this.add(mainMenu);
			mainMenu.add(mnCadastros);
				mnCadastros.add(mniProduto);
				mnCadastros.add(mniCliente);
				mnCadastros.add(mniVendedor);
				mnCadastros.add(mniFornecedor);
				mnCadastros.add(mniVenda);
				
				mnCadastros.add(mniVenda);
			
			mainMenu.add(mnTabelas);
			
			mnTabelas.add(mniGerarTabelas);
			
			mainMenu.add(mnJoins);
			
			mnJoins.add(mniJoin1);
			
			mnJoins.add(mniJoin2);
			
			mnJoins.add(mniJoin3);
			mainMenu.add(mnAjuda);
				mnAjuda.add(mniSobre);
		getContentPane().setLayout(null);
		clock.setBounds(0, 277, 494, 25);
		
		clock.setVerticalAlignment(SwingConstants.BOTTOM);
		
		getContentPane().add(clock);
		toolBar.setBounds(0, 0, 594, 25);
		
//		ADICIONA O CAMINHO DAS IMAGENS
		getContentPane().add(toolBar);
		btProdutoToolbar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/edu/ifpr/images/basket.png")));
		
		toolBar.add(btProdutoToolbar);
		btClienteToolbar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/edu/ifpr/images/user.png")));
		
		toolBar.add(btClienteToolbar);
		btVendedorToolbar.addActionListener(tratador);
		btVendedorToolbar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/edu/ifpr/images/user_suit.png")));
		
		toolBar.add(btVendedorToolbar);
		btFornecedorToolbar.addActionListener(tratador);
		btFornecedorToolbar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/edu/ifpr/images/user_orange.png")));
		
//		 adiciona o toolbar
		toolBar.add(btFornecedorToolbar);
		btVendasToolbar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/edu/ifpr/images/lorry.png")));
		
		toolBar.add(btVendasToolbar);
		
//		RADIO BUTTONS
		rbProduto.setBounds(0, 26, 78, 23);
		getContentPane().add(rbProduto);
		
		rbCliente.setBounds(90, 26, 78, 23);
		getContentPane().add(rbCliente);
		
		rbVendedor.setBounds(170, 26, 98, 23);
		getContentPane().add(rbVendedor);
		
		rbFornecedor.setBounds(270, 26, 98, 23);
		getContentPane().add(rbFornecedor);
//		FIM RADIO BUTTONS
		
//		GRUPO DE BOTAO
		ButtonGroup bg = new ButtonGroup();
		bg.add(rbProduto);
		bg.add(rbCliente);
		bg.add(rbVendedor);
		bg.add(rbFornecedor);
		
//		botao editar
		btnEditar.setBounds(505, 56, 89, 23);
		getContentPane().add(btnEditar);
		
//		botao apagar
		btnApagar.setBounds(505, 90, 89, 23);
		getContentPane().add(btnApagar);
		
//		txf procurar
		txfSearch.setBounds(359, 26, 203, 23);
		getContentPane().add(txfSearch);
		txfSearch.setHorizontalAlignment(SwingConstants.LEFT);
		txfSearch.setColumns(10);
		
//		botao procurar
		btnSearch.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/edu/ifpr/images/magnifier.png")));
		btnSearch.setBounds(565, 26, 23, 23);
		getContentPane().add(btnSearch);
		btnSearch.addActionListener(tratador);
		
		btVendasToolbar.addActionListener(tratador);
		
//		SCROLLPANE
		scrollPane.setBounds(10, 62, 484, 210);		
		getContentPane().add(scrollPane);		
		tbtb.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tbtb);
//		
		
//		ADD MENUBAR NO PARANAUE	
		this.setJMenuBar(mainMenu);
		
		this.setSize(600, 350);
		this.setResizable(false);
		this.setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
//	POPULA TABLEA CLIENTE
	public void populaTabelaCliente(){
		ClienteDao clientedao = new ClienteDao();
		List<ClienteDB> lista = clientedao.getLista();
		
		DefaultTableModel dtm ;
		
		Vector pai = new Vector();
		Vector filho;
		Vector nomeColunas = new Vector();
		
		nomeColunas.add("Nome");
		nomeColunas.add("CPF");
		nomeColunas.add("Telefone");
		nomeColunas.add("endereco");
		
		for(ClienteDB c : lista ){
			filho = new Vector();
			filho.add(c.getNome());
			filho.add(c.getCpf());
			filho.add(c.getTelefone());
			filho.add(c.getEndereco());
			
			pai.add(filho);
		}
		dtm = new DefaultTableModel( pai, nomeColunas);
		tbtb.setModel(dtm);
	}
//	FIM POPULA TABELA CLIENTE
//	POPULA TABELA PRODUTO
	public void populaTabelaProduto(){
		ProdutoDao produtodao = new ProdutoDao();
		List<ProdutoDB> lista = produtodao.getLista();
		
		DefaultTableModel dtm ;
		
		Vector<Object> pai = new Vector<>();
		Vector<Object> filho;
		Vector<Object> nomeColunas = new Vector<>();
		
		nomeColunas.add("Id");
		nomeColunas.add("Nome");
		nomeColunas.add("Preco");
		nomeColunas.add("Fornecedor");
		
		for(ProdutoDB p : lista){
			filho = new Vector<>();
			filho.add(p.getId());
			filho.add(p.getNome());
			filho.add(p.getPreco());
			filho.add(p.getFornecedor());
			
			pai.add(filho);
		}
		dtm = new DefaultTableModel( pai, nomeColunas);
		tbtb.setModel(dtm);
	}
//	FIM PRODUTO
//	POPULA TABLEA FORNECEDOR
	public void populaTabelaFornecedor(){
		FornecedorDao fornecedordao = new FornecedorDao();
		List<FornecedorDB> lista = fornecedordao.getLista();
		
		DefaultTableModel dtm ;
		
		Vector pai = new Vector();
		Vector filho;
		Vector nomeColunas = new Vector();
		
		nomeColunas.add("Nome");
		nomeColunas.add("CNPJ");
		nomeColunas.add("Telefone");
		nomeColunas.add("endereco");
		
		for(FornecedorDB f : lista){
			filho = new Vector();
			filho.add(f.getNome());
			filho.add(f.getCnpj());
			filho.add(f.getTelefone());
			filho.add(f.getEndereco());
			
			pai.add(filho);
		}
		dtm = new DefaultTableModel( pai, nomeColunas);		
		tbtb.setModel(dtm);
		rbFornecedor.setSelected(true);
	}
//	FIM POPULA TABELA FORNECEDOR
//	VENDEDOR
	public void populaTabelaVendedor(){
		VendedorDao vendedordao = new VendedorDao();
		List<VendedorDB> lista = vendedordao.getLista();
		
		DefaultTableModel dtm ;
		
		Vector pai = new Vector();
		Vector filho;
		Vector nomeColunas = new Vector();
		
		nomeColunas.add("ID");
		nomeColunas.add("Nome");
		
		for(VendedorDB l : lista){
			filho = new Vector();
			filho.add(l.getId());
			filho.add(l.getNome());
			
			pai.add(filho);
		}
		dtm = new DefaultTableModel( pai, nomeColunas);		
		tbtb.setModel(dtm);
		rbVendedor.setSelected(true);
	}
//	FIM VENDEDOR
//	VENDAAAAAAAAAS
	public void populaTabelaVendas(){
		VendaDao vendadao = new VendaDao();
		List <VendaDB> lista = vendadao.getLista();
		
		DefaultTableModel dtm ;
		
		Vector pai = new Vector();
		Vector filho;
		Vector nomeColunas = new Vector();
		
		nomeColunas.add("ID");
		nomeColunas.add("CPF_Cliente");
		nomeColunas.add("ID_Produto");
		nomeColunas.add("Vendedor");
		
		for(VendaDB l : lista){
			filho = new Vector();
			filho.add(l.getId());
			filho.add(l.getCliente().getCpf());
			filho.add(l.getProduto().getId());
			filho.add(l.getVendedor().getId());
			
			
			pai.add(filho);
		}
		dtm = new DefaultTableModel( pai, nomeColunas);		
		tbtb.setModel(dtm);
	}
//	FIM VENDAS
	private class TrataBotao implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()== mniProduto){
				Produto telaProduto = new Produto();
				telaProduto.estadoInserir();
			}
			if(e.getSource()== mniCliente){
				Cliente telaCliente = new Cliente();
				telaCliente.estadoInserir();
			}
			if(e.getSource()== mniVendedor){
				Vendedor telaVendedor = new Vendedor();
			}
			if(e.getSource()== mniFornecedor){
				Fornecedor telaFornecedor = new Fornecedor();
			}
			if(e.getSource()==mniVenda){
				Venda telaVenda = new Venda();
				System.out.println("ENTROU AQUI");
			}
			if(e.getSource()==mniGerarTabelas){
				TableCreator geradorDeTabelas = new TableCreator();
				geradorDeTabelas.criaCliente();
				geradorDeTabelas.criaFornecedor();
				geradorDeTabelas.criaVendedor();
				geradorDeTabelas.criaProduto();
				geradorDeTabelas.criaVenda();
			}
			if(e.getSource()==mniJoin1){
				Join join = new Join();
				tbtb.setModel(join.produtosPorCliente());
			}
			if(e.getSource()==mniJoin2){
				Join join = new Join();
				tbtb.setModel(join.produtosPorFornecedor());
			}
			if(e.getSource()==mniJoin3){
				Join join = new Join();
				tbtb.setModel(join.fornecedorDeProdutoPorCliente());
			}
			if(e.getSource()== mniSobre){
				Ajuda telaAjuda = new Ajuda();
			}
			
//			BOTOES
			if(e.getSource()== btnApagar){
				if( rbCliente.isSelected() ){
					ClienteDB clientedb = new ClienteDB();
					ClienteDao clientedao = new ClienteDao();
					
					int linha = tbtb.getSelectedRow();
					int coluna = 1;
					String cpf = (String)tbtb.getValueAt(linha, coluna).toString();
					
					clientedb.setCpf(cpf);
					clientedao.remove(clientedb);
					JOptionPane.showMessageDialog(null, "Cliente Apagado com Sucesso!");
					populaTabelaCliente();
				}
				if(rbProduto.isSelected()){
					ProdutoDB produtodb = new ProdutoDB();
					ProdutoDao produtodao = new ProdutoDao(); 
					
					int linha = tbtb.getSelectedRow();
					int coluna = 0;
					
					int id = (int)tbtb.getValueAt(linha, coluna);
					produtodb.setId(id);
					produtodao.remove(produtodb);
					
					populaTabelaProduto();
				}
			}
			if(e.getSource()==btnEditar ){
				if(rbCliente.isSelected()){
					ClienteDB clientedb = new ClienteDB();
					ClienteDao clientedao = new ClienteDao();
					
					int linha = tbtb.getSelectedRow();
					int coluna = 1;
					
					String nome = (String)tbtb.getValueAt(linha, coluna-1);
					String cpf = (String)tbtb.getValueAt(linha, coluna).toString();
					String telefone = (String)tbtb.getValueAt(linha, coluna+1);
					String endereco = (String)tbtb.getValueAt(linha, coluna+2);
					
					
					Cliente telaCliente = new Cliente(nome, cpf, telefone, endereco);
					telaCliente.estadoAlterar();
				}
				else if(rbProduto.isSelected()){
					new ProdutoDB();
					new ProdutoDao(); 
					
					int linha = tbtb.getSelectedRow();
					int coluna = 0;
					
					int id = (int)tbtb.getValueAt(linha, coluna);
					String nome = (String)tbtb.getValueAt(linha, coluna+1);
					Double preco = (Double)tbtb.getValueAt(linha, coluna+2);
					String fornecedor = (String)tbtb.getValueAt(linha, coluna+3);
					
					Produto telaProduto = new Produto(id,nome,preco,fornecedor);
					populaTabelaProduto();
				}
				else if(rbFornecedor.isSelected()){
					FornecedorDao fornecedordao = new FornecedorDao();
					FornecedorDB fornecedordb = new FornecedorDB();
					
					int linha = tbtb.getSelectedRow();
					int coluna = 1;
					
					String nome = (String)tbtb.getValueAt(linha, coluna-1);
					String cnpj = (String)tbtb.getValueAt(linha, coluna).toString();
					String telefone = (String)tbtb.getValueAt(linha, coluna+1);
					String endereco = (String)tbtb.getValueAt(linha, coluna+2);
				}
			}
//			FIM BOTOES
			
//			PROCURAAAAAAAAAAAAA
			if(e.getSource()==btnSearch && rbCliente.isSelected()){
				String nome = txfSearch.getText();
				ClienteDao clientedao = new ClienteDao();
				List<ClienteDB> lista = clientedao.pesquisa(nome);
				DefaultTableModel dtm ;
				
				Vector pai = new Vector();
				Vector filho;
				Vector nomeColunas = new Vector();
				
				nomeColunas.add("Nome");
				nomeColunas.add("CPF");
				nomeColunas.add("Telefone");
				nomeColunas.add("endereco");
				
				for(ClienteDB c : lista ){
					filho = new Vector();
					filho.add(c.getNome());
					filho.add(c.getCpf());
					filho.add(c.getTelefone());
					filho.add(c.getEndereco());
					
					pai.add(filho);
				}
				dtm = new DefaultTableModel( pai, nomeColunas);
				tbtb.setModel(dtm);	
			}
//			FIM PROCURAAAAAAA
			
//			TOOLBAR
			if(e.getSource()== btProdutoToolbar){
				rbProduto.setSelected(true);
				populaTabelaProduto();
			}
			if(e.getSource()== btClienteToolbar){
				rbCliente.setSelected(true);
				populaTabelaCliente();				
			}
			if(e.getSource()== btVendedorToolbar){
				rbVendedor.setSelected(true);
				populaTabelaVendedor();
			}
			if(e.getSource()== btFornecedorToolbar){
				rbFornecedor.setSelected(true);
				populaTabelaFornecedor();
			}
			if(e.getSource()==btVendasToolbar){
				populaTabelaVendas();
			}
		}

	}
}