package br.com.dbreplicador.view.tableModel;

import br.com.dbreplicador.model.ConnectionModel;
import br.com.dbreplicador.model.DirectionModel;

public class DirectionTableModel extends AbstractTableModel<DirectionModel> {
	private static final long serialVersionUID = 4546233939817239919L;

	public DirectionTableModel() {
		super(new String[] { "Processo", "Origem", "Destino" });
	}
	
	@Override
	protected void setObjectValueAt(int columnIndex, DirectionModel model, Object aValue) {
		switch (columnIndex) {
		case 0:
			model.setProcess(aValue.toString());
		case 1:
			model.setOriginConnectionModel((ConnectionModel) aValue);
		case 2:
			model.setDestinationConnectionModel((ConnectionModel) aValue);
		default:
			System.err.println("�ndice da coluna inv�lido");
		}
	}

	@Override
	protected Object getObjectValueAt(int columnIndex, DirectionModel model) {
		String valueObject = null;

		switch (columnIndex) {
		case 0:
			valueObject = model.getProcess();
			break;
		case 1:
			valueObject = (model.getOriginConnectionModel().getDatabase());
			break;
		case 2:
			valueObject = (model.getDestinationConnectionModel().getDatabase());
			break;	
		default:
			System.err.println("�ndice da coluna inv�lido");
		}

		return valueObject;
	}

}
