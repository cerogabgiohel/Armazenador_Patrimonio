import java.sql.*;

public class TB_Patrimonio {
	Conexao conecta = new Conexao();
	Connection conn;
	PreparedStatement pst, pst1;
	ResultSet rs, rs1;
	
	public TB_Patrimonio() {
		conn = conecta.conecta();
	}
	
	public void Adicionar(int equipamento, String fabricante, String marca, String descricao, int condicaoUso) {
		try {
			conn = conecta.conecta();	
			String sql1 = "select * from TB_Equipamento where PK_Equipamento = ?";
			
            pst = conn.prepareStatement(sql1);
            pst.setInt(1, equipamento);
            rs = pst.executeQuery();
            
            if(!rs.next()) {
            	System.out.println("O equipamento digitado não foi adicionado à tabela de equipamento");
            }else {
            
			String sql = "insert into TB_Patrimonio(FK_Equipamento, TXT_Fabricante, TXT_Marca, TXT_Descricao, INT_CondicaoUso) values (?,?,?,?,?)";
			pst = conn.prepareStatement(sql);			
			pst.setInt(1, equipamento);
			pst.setString(2, fabricante);
			pst.setString(3, marca);
			pst.setString(4, descricao);
			pst.setInt(5, condicaoUso);
			pst.executeUpdate();
			System.out.println("O equipamento, fabricante, marca, descrição e condição de uso foram adicionados com sucesso");
			conecta.desconecta();
			
				
			}
          
		}catch(SQLException e) {
			System.out.println("Erro ao adicionar. Erro: " +e);
	 }
	}
	
	public void Remover(int patrimonio) {
		conecta.conecta();
		conecta.executaSQL("delete from TB_Patrimonio where PK_Patrimonio =" +patrimonio );
		System.out.println("Patrimônio excluído");
		conecta.desconecta();
	}
	
	public void Editar(int patrimonio, int novoPatrimonio, int novoEquipamento, String novoFabricante, String novaMarca, String novaDescricao, int novaCondicaoUso) {
		try {
			conn = conecta.conecta();	
			String sql1 = "select * from TB_Patrimonio where PK_Patrimonio = ?";
			
            pst = conn.prepareStatement(sql1);
            pst.setInt(1, patrimonio);
            rs = pst.executeQuery();            
            
            String sql2 = "select * from TB_Patrimonio where PK_Patrimonio = ?";
            
            pst1 = conn.prepareStatement(sql2);
            pst1.setInt(1, novoPatrimonio);
            rs1 = pst1.executeQuery();
            
            
            if(!rs.next()) {
            	System.out.println("O patrimônio digitado não foi adicionado à tabela de patrimônio");
            	conecta.desconecta();
            }else if(!rs1.next()){
            	System.out.println("O novo patrimônio digitado não foi adicionado à tabela de patrimônio");
            	conecta.desconecta();
            }else {	
            
		
        			
    			sql1 = "select * from TB_Equipamento where PK_Equipamento = ?";
    			
                pst = conn.prepareStatement(sql1);
                pst.setInt(1, novoEquipamento);
                rs = pst.executeQuery(); 		
            
                
          if(!rs.next()) {
        	  System.out.println("O novo equipamento digitado não foi adicionado à tabela de equipamento");
          }else {
		
		String sql = "update TB_Patrimonio set "				
		+"FK_Equipamento = '"+novoEquipamento+"',"
		+"TXT_Fabricante = '"+novoFabricante+"',"
		+"TXT_Marca = '"+novaMarca+"',"
		+"TXT_Descricao = '"+novaDescricao+"',"
		+"Int_CondicaoUso = '"+novaCondicaoUso+"'"
		+"where PK_Patrimonio = "+patrimonio;
		
			pst = conn.prepareStatement(sql);
			pst.execute();
			System.out.println("O patrimônio foi editado com sucesso!");	
			conecta.desconecta();			
		
		}
          }		
            	            
	
}catch(SQLException e) {
	System.out.println("Erro na edição. Erro: "+e);
	conecta.desconecta();
}
	}
}
