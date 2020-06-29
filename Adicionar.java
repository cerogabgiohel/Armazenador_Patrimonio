import java.sql.*;

public class Adicionar {
	Conexao conecta = new Conexao();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	public Adicionar() {
		conn = conecta.conecta();
	}
	
	public void AdicionarTB_Equipamento(int equipamento, String descricao) {
		try {
			
		
		String sql = "insert into TB_Equipamento(PK_Equipamento, Txt_Descricao) values (?,?)";
		pst = conn.prepareStatement(sql);
		pst.setInt(1, equipamento);
		pst.setString(2, descricao);
		pst.executeUpdate();
		System.out.println("O equipamento e a descrição foram adicionados com sucesso");
		}catch(SQLException ex) {
			System.out.println("Erro ao adicionar. Erro: " +ex);
			
		}
	}
	
	
}
