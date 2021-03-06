import java.sql.*;

public class TB_Patrimonio {
	Conexao conecta = new Conexao();
	Connection conn;
	PreparedStatement pst;
	ResultSet rs;
	
	public TB_Patrimonio() {
		conn = conecta.conecta();
	}
	
	public void Adicionar(int patrimonio, int equipamento, String fabricante, String marca, String descricao, int condicaoUso) {
		try {
			conn = conecta.conecta();	
			String sql1 = "select * from TB_Equipamento where PK_Equipamento = ?";
			
            pst = conn.prepareStatement(sql1);
            pst.setInt(1, equipamento);
            rs = pst.executeQuery();
          
            
            if(!rs.next()) {
            	System.out.println("O equipamento digitado n�o foi adicionado � tabela de equipamento");
            }else {           
			String sql = "insert into TB_Patrimonio(PK_Patrimonio, FK_Equipamento, TXT_Fabricante, TXT_Marca, TXT_Descricao, INT_CondicaoUso) values (?,?,?,?,?,?)";
			pst = conn.prepareStatement(sql);	
			pst.setInt(1, patrimonio);
			pst.setInt(2, equipamento);
			pst.setString(3, fabricante);
			pst.setString(4, marca);
			pst.setString(5, descricao);
			pst.setInt(6, condicaoUso);
			pst.executeUpdate();
			System.out.println("O patrim�nio, equipamento, fabricante, marca, descri��o e condi��o de uso foram adicionados com sucesso � tabela de patrim�nio");
			conecta.desconecta();
			
				
			}
          
		}catch(SQLException e) {
			System.out.println("Erro ao adicionar. Erro: " +e);
	 }
	}
	
	public void Remover(int patrimonio) {
		conecta.conecta();
		conecta.executaSQL("delete from TB_Patrimonio where PK_Patrimonio =" +patrimonio );
		System.out.println("Patrim�nio exclu�do");
		conecta.desconecta();
	}
	
	public void Editar(int patrimonio, int novoPatrimonio, int novoEquipamento, String novoFabricante, String novaMarca, String novaDescricao, int novaCondicaoUso) {
		try {
			conn = conecta.conecta();	
			String sql1 = "select * from TB_Patrimonio where PK_Patrimonio = ?";
			
            pst = conn.prepareStatement(sql1);
            pst.setInt(1, patrimonio);
            rs = pst.executeQuery();            
       
            
            if(!rs.next()) {
            	System.out.println("O patrim�nio digitado n�o foi adicionado � tabela de patrim�nio");
            	conecta.desconecta();
            }else {	
            
		
        			
    			sql1 = "select * from TB_Equipamento where PK_Equipamento = ?";
    			
                pst = conn.prepareStatement(sql1);
                pst.setInt(1, novoEquipamento);
                rs = pst.executeQuery(); 		
            
                
          if(!rs.next()) {
        	  System.out.println("O novo equipamento digitado n�o foi adicionado � tabela de equipamento");
          }else {
		
		String sql = "update TB_Patrimonio set "
		+"PK_Patrimonio = '"+novoPatrimonio+"',"		
		+"FK_Equipamento = '"+novoEquipamento+"',"
		+"TXT_Fabricante = '"+novoFabricante+"',"
		+"TXT_Marca = '"+novaMarca+"',"
		+"TXT_Descricao = '"+novaDescricao+"',"
		+"Int_CondicaoUso = '"+novaCondicaoUso+"'"
		+"where PK_Patrimonio = "+patrimonio;
		
			pst = conn.prepareStatement(sql);
			pst.execute();
			System.out.println("O patrim�nio foi editado com sucesso!");	
			conecta.desconecta();			
		
		}
          }		
            	            
	
}catch(SQLException e) {
	System.out.println("Erro na edi��o. Erro: "+e);
	conecta.desconecta();
}
	}
}
