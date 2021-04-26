package application;

import javafx.beans.property.StringProperty;

public class TableData {
	private StringProperty name_Table;
	private StringProperty nickname_Table;
	private StringProperty kind_Table;

	public TableData(StringProperty name_Table, StringProperty nickname_Table,StringProperty kind_Table) {
		this.name_Table = name_Table;
		this.nickname_Table = nickname_Table;
		this.kind_Table = kind_Table;
	}

	public StringProperty name() {
		return name_Table;
	}
	public StringProperty nickname() {
		return nickname_Table;
	}
	public StringProperty kind() {
		return kind_Table;
	}

}

