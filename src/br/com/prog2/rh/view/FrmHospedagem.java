package br.com.prog2.rh.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import br.com.prog2.rh.controller.HospedagemController;
import br.com.prog2.rh.model.Hospedagem;
import br.com.prog2.rh.persistencia.ConnectionFactory;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.GridLayout;

public class FrmHospedagem extends JFrame {

	private JPanel contentPane;
	private JTextField txtDesc;
	private JTextField txtQntP;
	private JTextField txtDiaF;
	private JTextField txtDiaI;
	private JTextField txtCodChale;
	private JTextField txtValorF;
	private JTextField txtCodCli;
	private JTextField txtUF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmHospedagem frame = new FrmHospedagem();
					frame.setTitle("Cadastro de Hospedagem");
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
	public FrmHospedagem() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 493, 274);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(contentPane_1, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		
		JLabel lblDesconto = new JLabel("Desconto");
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		
		JLabel lblEstado_1 = new JLabel("Dia Ini.");
		
		JLabel lblQntPessoas = new JLabel("Qnt. Pessoas");
		
		txtQntP = new JTextField();
		txtQntP.setColumns(10);
		
		JLabel lblDiaFim = new JLabel("Dia Fim");
		
		txtDiaF = new JTextField();
		txtDiaF.setColumns(10);
		
		txtDiaI = new JTextField();
		txtDiaI.setColumns(10);
		
		JLabel lblValorFinal = new JLabel("Valor Final");
		
		JLabel lblCodigoDoCliente = new JLabel("Codigo do Cliente");
		
		JLabel lblCodigoDoChal = new JLabel("Codigo do Chal\u00E9");
		
		txtCodChale = new JTextField();
		txtCodChale.setColumns(10);
		
		txtValorF = new JTextField();
		txtValorF.setColumns(10);
		
		txtCodCli = new JTextField();
		txtCodCli.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado (UF)");
		
		txtUF = new JTextField();
		txtUF.setColumns(10);
		
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
				
				Hospedagem emp = new Hospedagem();
				HospedagemController controller = new HospedagemController();
				
				emp.setEstado(txtUF.getText());
				emp.setQntPessoas(Integer.parseInt(txtQntP.getText()));
				emp.setDesconto(Integer.parseInt(txtDesc.getText()));
				emp.setValorFinal(Integer.parseInt(txtValorF.getText()));
				emp.setCodCliente(Integer.parseInt(txtCodCli.getText()));
				emp.setCodChale(Integer.parseInt(txtCodChale.getText()));
				emp.setDataInicio(Integer.parseInt(txtDiaI.getText()));
				emp.setDataFim(Integer.parseInt(txtDiaF.getText()));
				
				controller.inserir(emp);
			}
		});
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Hospedagem emp = new Hospedagem();
				HospedagemController controller = new HospedagemController();
				HospedagemController ec = new HospedagemController();
				emp.setCodChale(Integer.parseInt(txtCodChale.getText()));
				emp.setCodCliente(Integer.parseInt(txtCodCli.getText()));
				Object[] opcoes = { "Sim", "Não" };
				int i = JOptionPane.showOptionDialog(null, "Deseja excluir essa hospedagem?", "Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
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
				txtDesc.setText("");
				txtQntP.setText("");
				txtDiaF.setText("");
				txtDiaI.setText("");
				txtCodChale.setText("");
				txtValorF.setText("");
				txtCodCli.setText("");
				txtUF.setText("");
				
			}
		});
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmHospedagem.this.dispose();
			}
		});
		panel_2.setLayout(new GridLayout(0, 4, 0, 0));
		panel_2.add(btnInserir);
		panel_2.add(btnExcluir);
		panel_2.add(btnLimpar);
		panel_2.add(btnSair);
		GroupLayout gl_contentPane_1 = new GroupLayout(contentPane_1);
		gl_contentPane_1.setHorizontalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addGroup(gl_contentPane_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane_1.createSequentialGroup()
							.addGap(10)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane_1.setVerticalGroup(
			gl_contentPane_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(50))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblEstado_1)
							.addGap(60)
							.addComponent(txtDiaI, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblDiaFim)
							.addGap(33)
							.addComponent(txtDiaF, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblQntPessoas)
							.addGap(30)
							.addComponent(txtQntP, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblEstado)
							.addGap(10)
							.addComponent(txtUF, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblDesconto)
							.addGap(49)
							.addComponent(txtDesc, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblValorFinal)
							.addGap(45)
							.addComponent(txtValorF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCodigoDoCliente)
							.addGap(10)
							.addComponent(txtCodCli, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblCodigoDoChal)
							.addGap(16)
							.addComponent(txtCodChale, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEstado_1))
						.addComponent(txtDiaI, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDiaFim))
						.addComponent(txtDiaF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblQntPessoas))
						.addComponent(txtQntP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblEstado))
						.addComponent(txtUF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblDesconto))
						.addComponent(txtDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblValorFinal))
						.addComponent(txtValorF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCodigoDoCliente))
						.addComponent(txtCodCli, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(lblCodigoDoChal))
						.addComponent(txtCodChale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
		);
		panel.setLayout(gl_panel);
		contentPane_1.setLayout(gl_contentPane_1);
	}
}
