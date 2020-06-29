import java.sql.*;

public class Editar {
	Conexao conecta = new Conexao();
	Connection conn;			
	PreparedStatement pst;
	ResultSet rs;
	
	public Editar() {
	conn = conecta.conecta();
	}
	
	public void EditarTB_Equipamento(int equipamento, int novoEquipamento, String novaDescricao) {
		String sql = "update TB_Equipamento set "
				+"PK_Equipamento = '"+novoEquipamento+"',"
				+"Txt_Descricao = '"+novaDescricao+"'"
				+"where PK_Equipamento = "+equipamento;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.execute();
			System.out.println("O equipamento foi editado com sucesso!");			
		}catch(SQLException ex) {
			System.out.println("Erro na edição. Erro: "+ex);
		}
	}
}
