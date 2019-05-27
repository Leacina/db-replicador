
package br.com.dbreplicador.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.com.dbreplicador.image.MasterImage;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;

public class DirectionFormWindow extends AbstractWindowFrame {
	private static final long serialVersionUID = 2082839251104219643L;

	// Guarda os fields em uma lista para facilitar manipula��o em massa
	private List<Component> formFields = new ArrayList<Component>();
	
	// Componentes
	private JButton btnSearch, btnAdd, btnRemove, btnSave;
	private JPanel panelDiretion, panelOrigin, panelDestiny, panelPeriod;
	private JLabel lblProcess, lblAutoMan, lblDuration, lblRetention, lblDBOrigin, lblUserOrigin, lblPasswordOrigin,
			lblDBDestiny, lblPasswordDestiny, lblUserDestiny, lblYear, lblDay, lblMonth, lblSecond, lblMinute, lblHour;
	private JTextField txfProcess, txfDuration, txfRetention, txfDBOrigin, txfUserOrigin, txfPasswordOrigin,
			txfDBDestiny, txfPasswordDestiny, txfUserDestiny, txfYear, txfDay, txfMonth, txfSecond, txfMinute, txfHour;
	private JComboBox<String> cbxAutoMan;
	private JCheckBox cbxEnable;

	public DirectionFormWindow(JDesktopPane desktop) {
		super("Cadastro da Dire��o", 555, 510, desktop);

		setFrameIcon(MasterImage.direction_16x16);
		
		createComponents();

		// Por padr�o campos s�o desabilitados ao iniciar
		disableComponents(formFields);

		setButtonsActions();
	}

	private void setButtonsActions() {
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Ac�o Buscar
			}
		});

		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Ativa campos
				enableComponents(formFields);

				btnRemove.setEnabled(false);
				btnSave.setEnabled(true);
			}
		});

		btnRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Ac�o Remover
			}
		});

		btnSave.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO A��o Salvar
			}
		});
	}

	private void createComponents() {

		// Toolbar
		btnSearch = new JButton("Buscar", MasterImage.search_22x22);
		btnSearch.setToolTipText("Clique aqui para buscar");
		btnAdd = new JButton("Adicionar", MasterImage.add_22x22);
		btnAdd.setToolTipText("Clique aqui para adicionar");
		btnRemove = new JButton("Remover", MasterImage.remove_22x22);
		btnRemove.setToolTipText("Clique aqui para remover");
		btnRemove.setEnabled(false);
		btnSave = new JButton("Salvar", MasterImage.save_22x22);
		btnSave.setToolTipText("Clique aqui para salvar");
		btnSave.setEnabled(false);

		/********************* PAINEL DIRE��O ***********************************/
		panelDiretion = new JPanel();
		panelDiretion.setBorder(
				new TitledBorder(null, "Dire\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup()
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup().addGap(15)
								.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(panelDiretion,
								GroupLayout.PREFERRED_SIZE, 519, Short.MAX_VALUE)))
				.addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(5)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnSearch, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnRemove, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addComponent(panelDiretion, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(40, Short.MAX_VALUE)));
		// COMPONENTES
		lblProcess = new JLabel("Processo:");
		lblAutoMan = new JLabel("Auto / Man:");
		lblDuration = new JLabel("Dura\u00E7\u00E3o:");
		lblRetention = new JLabel("Reten\u00E7\u00E3o:");
		txfProcess = new JTextField("Teclar F9");
		txfProcess.setColumns(10);
		txfProcess.setBackground(Color.yellow);
		txfProcess.setEnabled(false);
		cbxAutoMan = new JComboBox<String>();
		formFields.add(cbxAutoMan);
		txfDuration = new JTextField();
		txfDuration.setColumns(10);
		formFields.add(txfDuration);
		txfRetention = new JTextField();
		txfRetention.setColumns(10);
		formFields.add(txfRetention);
		cbxEnable = new JCheckBox("Habilitado");
		formFields.add(cbxEnable);

		/********************* PAINEL ORIGEM ***********************************/
		panelOrigin = new JPanel();
		panelOrigin.setBorder(new TitledBorder(null, "Origem", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblDBOrigin = new JLabel("Database:");
		lblUserOrigin = new JLabel("Usu\u00E1rio:");
		lblPasswordOrigin = new JLabel("Senha:");
		txfDBOrigin = new JTextField("Teclar F9");
		txfDBOrigin.setColumns(10);
		txfDBOrigin.setBackground(Color.yellow);
		txfDBOrigin.setEnabled(false);
		txfUserOrigin = new JTextField();
		txfUserOrigin.setColumns(10);
		formFields.add(txfUserOrigin);
		txfPasswordOrigin = new JTextField();
		txfPasswordOrigin.setColumns(10);
		formFields.add(txfPasswordOrigin);
		
		/********************* PAINEL DESTINO ***********************************/
		panelDestiny = new JPanel();
		panelDestiny.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Destino",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblDBDestiny = new JLabel("Database:");
		lblPasswordDestiny = new JLabel("Senha:");
		lblUserDestiny = new JLabel("Usu\u00E1rio:");
		txfDBDestiny = new JTextField("Teclar F9");
		txfDBDestiny.setColumns(10);
		txfDBDestiny.setBackground(Color.yellow);
		txfDBDestiny.setEnabled(false);
		txfPasswordDestiny = new JTextField();
		txfPasswordDestiny.setColumns(10);
		formFields.add(txfPasswordDestiny);
		txfUserDestiny = new JTextField();
		txfUserDestiny.setColumns(10);
		formFields.add(txfUserDestiny);

		GroupLayout gl_panelDestiny = new GroupLayout(panelDestiny);
		gl_panelDestiny.setHorizontalGroup(gl_panelDestiny.createParallelGroup(Alignment.LEADING)
				.addGap(0, 246, Short.MAX_VALUE)
				.addGroup(gl_panelDestiny.createSequentialGroup()
						.addGroup(gl_panelDestiny.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelDestiny.createSequentialGroup().addComponent(lblDBDestiny)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txfDBDestiny, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
								.addGroup(gl_panelDestiny.createSequentialGroup().addContainerGap()
										.addGroup(gl_panelDestiny.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblPasswordDestiny).addComponent(lblUserDestiny))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_panelDestiny.createParallelGroup(Alignment.LEADING)
												.addComponent(txfPasswordDestiny, GroupLayout.DEFAULT_SIZE, 170,
														Short.MAX_VALUE)
												.addComponent(txfUserDestiny, GroupLayout.DEFAULT_SIZE, 170,
														Short.MAX_VALUE))))
						.addContainerGap()));
		gl_panelDestiny.setVerticalGroup(gl_panelDestiny.createParallelGroup(Alignment.LEADING)
				.addGap(0, 100, Short.MAX_VALUE)
				.addGroup(gl_panelDestiny.createSequentialGroup()
						.addGroup(gl_panelDestiny.createParallelGroup(Alignment.BASELINE).addComponent(lblDBDestiny)
								.addComponent(txfDBDestiny, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelDestiny.createParallelGroup(Alignment.BASELINE).addComponent(lblUserDestiny)
								.addComponent(txfUserDestiny, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(
								gl_panelDestiny.createParallelGroup(Alignment.BASELINE).addComponent(lblPasswordDestiny)
										.addComponent(txfPasswordDestiny, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		panelDestiny.setLayout(gl_panelDestiny);

		/********************* PAINEL PER�ODO ***********************************/
		panelPeriod = new JPanel();
		panelPeriod.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Per\u00EDodo",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		lblYear = new JLabel("Ano:");
		lblDay = new JLabel("Dia:");
		lblMonth = new JLabel("M\u00EAs:");
		lblSecond = new JLabel("Segundo:");
		lblMinute = new JLabel("Minuto:");
		lblHour = new JLabel("Hora:");
		txfYear = new JTextField();
		txfYear.setColumns(10);
		formFields.add(txfYear);
		txfDay = new JTextField();
		txfDay.setColumns(10);
		formFields.add(txfDay);
		txfMonth = new JTextField();
		txfMonth.setColumns(10);
		formFields.add(txfMonth);
		txfSecond = new JTextField();
		txfSecond.setColumns(10);
		formFields.add(txfSecond);
		txfMinute = new JTextField();
		txfMinute.setColumns(10);
		formFields.add(txfMinute);
		txfHour = new JTextField();
		txfHour.setColumns(10);
		formFields.add(txfHour);
		
		GroupLayout gl_panelPeriod = new GroupLayout(panelPeriod);
		gl_panelPeriod
				.setHorizontalGroup(gl_panelPeriod.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_panelPeriod.createSequentialGroup().addGap(6)
								.addGroup(gl_panelPeriod.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panelPeriod.createSequentialGroup().addComponent(lblYear)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(
														txfYear, GroupLayout.PREFERRED_SIZE, 189,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panelPeriod.createSequentialGroup()
												.addGroup(gl_panelPeriod.createParallelGroup(Alignment.TRAILING)
														.addComponent(lblMonth).addComponent(lblDay))
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_panelPeriod.createParallelGroup(Alignment.LEADING, false)
														.addComponent(txfMonth).addComponent(txfDay,
																GroupLayout.PREFERRED_SIZE, 189,
																GroupLayout.PREFERRED_SIZE))))
								.addGap(18)
								.addGroup(gl_panelPeriod.createParallelGroup(Alignment.TRAILING).addComponent(lblSecond)
										.addComponent(lblMinute).addComponent(lblHour))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelPeriod.createParallelGroup(Alignment.LEADING)
										.addComponent(txfHour, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
										.addComponent(txfMinute, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
										.addComponent(txfSecond, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
								.addContainerGap()));
		gl_panelPeriod.setVerticalGroup(gl_panelPeriod.createParallelGroup(Alignment.LEADING).addGroup(gl_panelPeriod
				.createSequentialGroup()
				.addGroup(gl_panelPeriod.createParallelGroup(Alignment.TRAILING).addGroup(gl_panelPeriod
						.createSequentialGroup()
						.addGroup(gl_panelPeriod.createParallelGroup(Alignment.TRAILING).addGroup(gl_panelPeriod
								.createSequentialGroup()
								.addGroup(gl_panelPeriod.createParallelGroup(Alignment.BASELINE)
										.addComponent(txfHour, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblHour))
								.addPreferredGap(ComponentPlacement.RELATED).addComponent(txfMinute,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
								.addComponent(lblMinute))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelPeriod.createParallelGroup(Alignment.BASELINE).addComponent(lblSecond)
								.addComponent(txfSecond, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panelPeriod.createSequentialGroup()
								.addGroup(gl_panelPeriod.createParallelGroup(Alignment.BASELINE)
										.addComponent(txfYear, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblYear))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelPeriod.createParallelGroup(Alignment.BASELINE).addComponent(lblMonth)
										.addComponent(txfMonth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelPeriod.createParallelGroup(Alignment.BASELINE).addComponent(lblDay)
										.addComponent(txfDay, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(98, Short.MAX_VALUE)));
		panelPeriod.setLayout(gl_panelPeriod);
		GroupLayout gl_panelDiretion = new GroupLayout(panelDiretion);
		gl_panelDiretion.setHorizontalGroup(gl_panelDiretion.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDiretion.createSequentialGroup().addGap(14)
						.addGroup(gl_panelDiretion.createParallelGroup(Alignment.TRAILING).addComponent(lblProcess)
								.addComponent(lblAutoMan).addComponent(lblDuration).addComponent(lblRetention))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_panelDiretion.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txfRetention).addComponent(txfDuration)
								.addComponent(cbxAutoMan, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(txfProcess, GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
								.addComponent(cbxEnable))
						.addContainerGap())
				.addGroup(gl_panelDiretion.createSequentialGroup().addGroup(gl_panelDiretion
						.createParallelGroup(Alignment.LEADING)
						.addComponent(panelPeriod, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panelDiretion.createSequentialGroup()
								.addComponent(panelOrigin, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(panelDestiny,
										GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)))
						.addGap(5)));
		gl_panelDiretion
				.setVerticalGroup(gl_panelDiretion.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDiretion.createSequentialGroup()
								.addGroup(gl_panelDiretion.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblProcess).addComponent(txfProcess, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(4)
								.addGroup(gl_panelDiretion.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblAutoMan).addComponent(cbxAutoMan, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelDiretion.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblDuration).addComponent(txfDuration, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelDiretion.createParallelGroup(Alignment.BASELINE)
										.addComponent(txfRetention, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblRetention))
								.addGap(7).addComponent(cbxEnable).addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panelDiretion.createParallelGroup(Alignment.LEADING)
										.addComponent(panelOrigin, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(panelDestiny, GroupLayout.PREFERRED_SIZE, 100,
												GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(panelPeriod, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(20, Short.MAX_VALUE)));

		GroupLayout gl_panelOrigin = new GroupLayout(panelOrigin);
		gl_panelOrigin.setHorizontalGroup(gl_panelOrigin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelOrigin.createSequentialGroup().addComponent(lblDBOrigin)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txfDBOrigin, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE).addContainerGap())
				.addGroup(
						gl_panelOrigin.createSequentialGroup().addContainerGap()
								.addGroup(gl_panelOrigin.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblPasswordOrigin).addComponent(lblUserOrigin))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelOrigin.createParallelGroup(Alignment.LEADING)
										.addComponent(txfPasswordOrigin, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
										.addComponent(txfUserOrigin, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
								.addContainerGap()));
		gl_panelOrigin.setVerticalGroup(gl_panelOrigin.createParallelGroup(Alignment.LEADING).addGroup(gl_panelOrigin
				.createSequentialGroup()
				.addGroup(gl_panelOrigin.createParallelGroup(Alignment.BASELINE).addComponent(lblDBOrigin).addComponent(
						txfDBOrigin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panelOrigin
						.createParallelGroup(Alignment.BASELINE).addComponent(lblUserOrigin).addComponent(txfUserOrigin,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_panelOrigin.createParallelGroup(Alignment.BASELINE).addComponent(lblPasswordOrigin)
						.addComponent(txfPasswordOrigin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(22, Short.MAX_VALUE)));
		panelOrigin.setLayout(gl_panelOrigin);
		panelDiretion.setLayout(gl_panelDiretion);
		getContentPane().setLayout(groupLayout);
	}

//		private boolean validateFields() {
//			//TODO: Validar campos
//			return true;
//		}
}