import java.sql.*;

public class TB_Localizacao {
	Conexao conecta = new Conexao();
	Connection conn;
	PreparedStatement pst, pst1, pst2, pst3;
	ResultSet rs, rs1, rs2, rs3;
	
	public TB_Localizacao() {
		conn = conecta.conecta();
	}
	
	public void adicionar(int patrimonio, int local, String data) {
			try {
			conn = conecta.conecta();		
			String sql = "insert into TB_Localizacao(PK_Patrimonio, PK_Local, PK_DataMovimentacao) values (?,?,?)";
			String sql1 = "select * from TB_Patrimonio where PK_Patrimonio = ?";
			
            pst = conn.prepareStatement(sql1);
            pst.setInt(1, patrimonio);
            rs = pst.executeQuery();
            
            String sql2 = "select * from TB_Local where PK_Local = ?";
			
            pst1 = conn.prepareStatement(sql2);
            pst1.setInt(1, local);
            rs1 = pst1.executeQuery();
            
            if(!rs.next()) {
            	System.out.println("O patrimônio digitado não foi adicionado à tabela de patrimônio");	
            } else if(!rs1.next()) {
            	System.out.println("O local digitado não foi adicionado à tabela de patrimônio");	
            }else {
            try {
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
	}catch(SQLException e) {
		System.out.println("Erro ao adicionar. Erro: " +e);
		
	}
}	
	public void Remover(int patrimonio) {
	conecta.conecta();
	conecta.executaSQL("delete from TB_Localizacao where PK_Patrimonio =" +patrimonio );
	System.out.println("localização excluída");
	conecta.desconecta();
}
	public void Editar(int patrimonio, int novoPatrimonio, int local, String dataMovimentacao) {
		try {
			conecta.conecta();
			String sql1 = "select * from TB_Patrimonio where PK_Patrimonio = ?";
			
            pst = conn.prepareStatement(sql1);
            pst.setInt(1, patrimonio);
            rs = pst.executeQuery();
            
            String sql2 = "select * from TB_Local where PK_Local = ?";
			
            pst1 = conn.prepareStatement(sql2);
            pst1.setInt(1, local);
            rs1 = pst1.executeQuery();
            
            String sql3 = "select * from TB_Patrimonio where PK_Patrimonio = ?";
            
            pst2 = conn.prepareStatement(sql3);
            pst2.setInt(1, novoPatrimonio);
            rs2 = pst2.executeQuery(); 
            
            String sql4 = "select * from TB_Localizacao where PK_Patrimonio = ?";
            
            pst3 = conn.prepareStatement(sql4);
            pst3.setInt(1, patrimonio);
            rs3 = pst3.executeQuery();
            
            if(!rs.next()) {
            System.out.println("O patrimônio digitado não foi adicionado à tabela de Patrimônio");	
            conecta.desconecta();
            }else if(!rs1.next()) {
            	System.out.println("O local digitado não foi adicionado à tabela de Local");
            	conecta.desconecta();
            }else if(!rs2.next()){
            	System.out.println("O novo patrimônio digitado não foi adicionado à tabela de Patrimônio");
            	conecta.desconecta();
            }else if(!rs3.next()) {
            	System.out.println("O patrimônio digitado não faz parte da tabela de Localização");
            	conecta.desconecta();
            }
            else {
            
            	String sql = "update TB_Localizacao set "				
            			+"PK_Patrimonio = '"+novoPatrimonio+"',"
            			+"PK_Local = '"+local+"',"
            			+"PK_DataMovimentacao = '"+dataMovimentacao+"'"
            			+"where PK_Patrimonio = "+patrimonio;
            	
            		pst = conn.prepareStatement(sql);
        			pst.execute();
        			System.out.println("A localização foi editada com sucesso!");	
        			conecta.desconecta();       			
            		
            
            }
            
            
            
		}catch(SQLException ex) {
			System.out.println("Erro na edição. Erro2: "+ex);
			conecta.desconecta();
		}
		
	}
	
}