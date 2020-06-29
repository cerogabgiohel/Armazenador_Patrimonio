import java.sql.*;

public class Remover {
	Conexao conecta = new Conexao();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	public Remover() {
		conn = conecta.conecta();
	}
	
	
	public void RemoverTB_Equipamento(int equipamento) {
		conecta.executaSQL("delete from TB_Equipamento where PK_Equipamento =" +equipamento );
		System.out.println("Equipamento excluído");
	}
}
