package br.com.prog2.rh.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.prog2.rh.controller.ChaleController;
import br.com.prog2.rh.model.Chale;
import br.com.prog2.rh.persistencia.ConnectionFactory;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class FrmChale extends JFrame {

	private JPanel contentPane;
	private JTextField txtBaixaEst;
	private JTextField txtValAltaEst;
	private JTextField txtLoc;
	private JTextField txtCap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmChale frame = new FrmChale();
					frame.setTitle("Cadastro de Chalé");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmChale() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 555, 159);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JLabel lblValorFinal = new JLabel("Valor Baixa Est.");
		
		txtBaixaEst = new JTextField();
		txtBaixaEst.setColumns(10);
		
		JLabel lblDesconto = new JLabel("Valor Alta Est.");
		
		txtValAltaEst = new JTextField();
		txtValAltaEst.setColumns(10);
		
		JLabel lblEstado_1 = new JLabel("Localiza\u00E7\u00E3o");
		
		JLabel lblQntPessoas = new JLabel("Capacidade");
		
		txtLoc = new JTextField();
		txtLoc.setColumns(10);
		
		txtCap = new JTextField();
		txtCap.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblEstado_1)
							.addGap(25)
							.addComponent(txtLoc, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
							.addGap(26)
							.addComponent(lblQntPessoas)
							.addGap(23)
							.addComponent(txtCap, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
							.addGap(13))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDesconto)
							.addGap(11)
							.addComponent(txtValAltaEst, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
							.addGap(26)
							.addComponent(lblValorFinal)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtBaixaEst, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEstado_1))
						.addComponent(txtLoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblQntPessoas))
						.addComponent(txtCap, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtBaixaEst, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDesconto))
						.addComponent(txtValAltaEst, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblValorFinal)))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_2 = new JPanel();
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Connection con = ConnectionFactory.getConnection();
				if(con != null){
					System.out.println("OK");
					ConnectionFactory.close(con);
				}
				
				Chale emp = new Chale();
				ChaleController controller = new ChaleController();
				
				emp.setValorBaixaEst(Integer.parseInt(txtBaixaEst.getText()));
				emp.setValorAltaEst(Integer.parseInt(txtValAltaEst.getText()));
				emp.setLocalizacao(txtLoc.getText());
				emp.setCapacidade(Integer.parseInt(txtCap.getText()));
				
				controller.inserir(emp);
				
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Chale emp = new Chale();
				ChaleController controller = new ChaleController();
				ChaleController ec = new ChaleController();
				emp.setLocalizacao(txtLoc.getText());
				emp.setCapacidade(Integer.parseInt(txtCap.getText()));
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir esse chalé?", "Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
				if(JOptionPane.YES_OPTION == i){
					ec.excluir(emp);
					controller.excluir(emp);
				}
			}
		});
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtBaixaEst.setText("");
				txtValAltaEst.setText("");
				txtLoc.setText("");
				txtCap.setText("");
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmChale.this.dispose();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 538, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 538, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(111))
		);
		panel_2.setLayout(new GridLayout(0, 4, 0, 0));
		panel_2.add(btnInserir);
		panel_2.add(btnExcluir);
		panel_2.add(btnLimpar);
		panel_2.add(btnSair);
		contentPane.setLayout(gl_contentPane);
	}

}
