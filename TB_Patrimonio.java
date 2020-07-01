import java.sql.*;

public class TB_Patrimonio {
	Conexao conecta = new Conexao();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	public TB_Patrimonio() {
		conn = conecta.conecta();
	}
	
	public void Adicionar(int equipamento, String fabricante, String marca, String descricao, int condicaoUso) {
		try {
			conn = conecta.conecta();		
			String sql = "insert into TB_Patrimonio(FK_Equipamento, TXT_Fabricante, TXT_Marca, TXT_Descricao, INT_CondicaoUso) values (?,?,?,?,?)";
			pst = conn.prepareStatement(sql);			
			pst.setInt(1, equipamento);
			pst.setString(2, fabricante);
			pst.setString(3, marca);
			pst.setString(4, descricao);
			pst.setInt(5, condicaoUso);
			pst.executeUpdate();
			System.out.println("O equipamento, fabricante, marca, descri��o e condi��o de uso foram adicionados com sucesso");
			conecta.desconecta();
			}catch(SQLException ex) {
				System.out.println("Erro ao adicionar. Erro: " +ex);
				
			}
	}
	
	public void Remover(int patrimonio) {
		conecta.conecta();
		conecta.executaSQL("delete from TB_Patrimonio where PK_Patrimonio =" +patrimonio );
		System.out.println("Patrim�nio exclu�do");
		conecta.desconecta();
	}
	
	public void Editar(int patrimonio, int novoEquipamento, String novoFabricante, String novaMarca, String novaDescricao, int novaCondicaoUso) {
		conecta.conecta();
		String sql = "update TB_Patrimonio set "				
		+"FK_Equipamento = '"+novoEquipamento+"',"
		+"TXT_Fabricante = '"+novoFabricante+"',"
		+"TXT_Marca = '"+novaMarca+"',"
		+"TXT_Descricao = '"+novaDescricao+"',"
		+"Int_CondicaoUso = '"+novaCondicaoUso+"'"
		+"where PK_Patrimonio = "+patrimonio;
		try {
			pst = conn.prepareStatement(sql);
			pst.execute();
			System.out.println("O patrim�nio foi editado com sucesso!");	
			conecta.desconecta();
		}catch(SQLException ex) {
			System.out.println("Erro na edi��o. Erro: "+ex);
		}
	}
	
}
