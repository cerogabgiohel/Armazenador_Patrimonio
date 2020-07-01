import java.sql.*;

public class TB_Localizacao {
	Conexao conecta = new Conexao();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	public TB_Localizacao() {
		conn = conecta.conecta();
	}
	
	public void adicionar(int patrimonio, int local, String data) {
		try {
			conn = conecta.conecta();		
			String sql = "insert into TB_Localizacao(PK_Patrimonio, PK_Local, PK_DataMovimentacao) values (?,?,?)";
			pst = conn.prepareStatement(sql);			
			pst.setInt(1, patrimonio);
			pst.setInt(2,  local);
			pst.setString(3, data);
			pst.executeUpdate();
			System.out.println("O equipamento e a descrição foram adicionados com sucesso");
			conecta.desconecta();
			}catch(SQLException ex) {
				System.out.println("Erro ao adicionar. Erro: " +ex);
				
			}
	}
}
