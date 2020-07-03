import java.sql.*;

public class TB_Equipamento {
	Conexao conecta = new Conexao();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	public TB_Equipamento() {
	conn = conecta.conecta();		
	}
	
	public void Adicionar(String descricao) {
		try {
			conn = conecta.conecta();		
			String sql = "insert into TB_Equipamento(Txt_Descricao) values (?)";
			pst = conn.prepareStatement(sql);			
			pst.setString(1, descricao);
			pst.executeUpdate();
			System.out.println("O equipamento e a descrição foram adicionados com sucesso à tabela de equipamento");
			conecta.desconecta();
			}catch(SQLException ex) {
				System.out.println("Erro ao adicionar. Erro: " +ex);
				
			}
	}
	
	public void Remover(int equipamento) {
		conecta.conecta();
		conecta.executaSQL("delete from TB_Equipamento where PK_Equipamento =" +equipamento );
		System.out.println("Equipamento excluído");
		conecta.desconecta();
	}
	
	public void Editar(int equipamento,String novaDescricao) {
		conecta.conecta();
		String sql = "update TB_Equipamento set "				
				+"Txt_Descricao = '"+novaDescricao+"'"
				+"where PK_Equipamento = "+equipamento;
		
		try {
			pst = conn.prepareStatement(sql);
			pst.execute();
			System.out.println("O equipamento foi editado com sucesso!");	
			conecta.desconecta();
		}catch(SQLException ex) {
			System.out.println("Erro na edição. Erro: "+ex);
		}
	}
	
	
}
