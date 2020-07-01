import java.sql.*;

public class TB_Local {
	Conexao conecta = new Conexao();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	public TB_Local(){
		conn = conecta.conecta();
	}
	
	public void adicionar(String descricao) {
		try {
			conn = conecta.conecta();		
			String sql = "insert into TB_Local(TXT_Descricao) values (?)";
			pst = conn.prepareStatement(sql);			
			pst.setString(1, descricao);
			pst.executeUpdate();
			System.out.println("O equipamento e a descrição foram adicionados com sucesso");
			conecta.desconecta();
			}catch(SQLException ex) {
				System.out.println("Erro ao adicionar. Erro: " +ex);
				
			}
	}
	
	public void Remover(int local) {
		conecta.conecta();
		conecta.executaSQL("delete from TB_Local where PK_Local =" +local );
		System.out.println("local excluído");
		conecta.desconecta();
	}
	
	public void Editar(int local,String novaDescricao) {
		conecta.conecta();
		String sql = "update TB_Local set "				
				+"TXT_Descricao = '"+novaDescricao+"'"
				+"where PK_Local = "+local;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.execute();
			System.out.println("O local foi editado com sucesso!");	
			conecta.desconecta();
		}catch(SQLException ex) {
			System.out.println("Erro na edição. Erro: "+ex);
		}
	}

}
