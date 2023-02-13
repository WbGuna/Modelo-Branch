package br.com.wb.exp2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaFilaThread extends JDialog{

	private static final long serialVersionUID = 1L;

	private JPanel jPanel = new JPanel(new GridBagLayout());

	private JLabel descricaoNome = new JLabel("Nome:");
	private JTextField mostraNome = new JTextField();

	private JLabel descricaoEmail = new JLabel("Email:");
	private JTextField mostraEmail = new JTextField();

	private JButton jButton = new JButton("Add Lista");
	private JButton jButton2 = new JButton("Stop");
	
	private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

	public TelaFilaThread() {

		setTitle("Tela Time Thread.");// Titulo
		setSize(new Dimension(240, 240));// Dimensão
		setLocationRelativeTo(null);// Centraliza no meio da tela
		setResizable(false);// Não permite mudar o tamanho manualmente

		GridBagConstraints gridBagConstraints = new GridBagConstraints();// Controlador de posicionamento
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(5, 10, 5, 5);
		gridBagConstraints.anchor = GridBagConstraints.WEST;

		// Componentes
		descricaoNome.setPreferredSize(new Dimension(200, 25));
		jPanel.add(descricaoNome, gridBagConstraints);

		mostraNome.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(mostraNome, gridBagConstraints);

		descricaoEmail.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(descricaoEmail, gridBagConstraints);

		mostraEmail.setPreferredSize(new Dimension(200, 25));
		gridBagConstraints.gridy++;
		jPanel.add(mostraEmail, gridBagConstraints);

		gridBagConstraints.gridwidth = 1;

		jButton.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridy++;
		jPanel.add(jButton, gridBagConstraints);

		jButton2.setPreferredSize(new Dimension(92, 25));
		gridBagConstraints.gridx++;
		jPanel.add(jButton2, gridBagConstraints);

		jButton.addActionListener(new ActionListener() {

			@SuppressWarnings("static-access")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(fila == null) {
					fila = new ImplementacaoFilaThread();
					fila.start();
				}
				
				for(int i = 0; i < 10; i++) {					
					ObjetoFilaThread filaThread = new ObjetoFilaThread();
					filaThread.setNome(mostraNome.getText());
					filaThread.setEmail(mostraEmail.getText()+ "-" + (i+1));
					
					fila.add(filaThread);
				}
			}
		});

		jButton2.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				fila.stop();
				fila = null;
			}
		});
		
		fila.start();
		add(jPanel, BorderLayout.WEST);
		setVisible(true);// Torna a Tela visivel.
	}
}
