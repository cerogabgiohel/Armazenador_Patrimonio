import java.sql.*;

public class TB_Movimentacao {
	Conexao conecta = new Conexao();
	Connection conn;
	PreparedStatement pst, pst1, pst2;
	ResultSet rs, rs1, rs2;
	
	public TB_Movimentacao() {
		conn = conecta.conecta();
	}

	public void Adicionar(int patrimonio, String dataEntrada, int numeroGuia, String dataDevolucao) {
		try {
		conn = conecta.conecta();	
		String sql1 = "select * from TB_Patrimonio where PK_Patrimonio = ?";
		
        pst = conn.prepareStatement(sql1);
        pst.setInt(1, patrimonio);
        rs = pst.executeQuery();
         
        if(!rs.next()) {
        	System.out.println("O patrim�nio digitado n�o foi adicionado � tabela de patrim�nio");
        }else {
        	String sql = "insert into TB_Movimentacao(PK_Patrimonio, PK_DataEntrada, INT_NumeroGuia, DAT_DataDevolucao) values(?,?,?,?)";
        	
        	pst = conn.prepareStatement(sql);
        	pst.setInt(1, patrimonio);
        	pst.setString(2, dataEntrada);
        	pst.setInt(3, numeroGuia);
        	pst.setString(4, dataDevolucao);
        	pst.executeUpdate();
        	System.out.println("O patrim�nio, a data de entrada, o n�mero guia e a data de devolu��o foram inseridas na tabela de movimenta��o com sucesso");
        }
		}catch(SQLException ex) {
			System.out.println("Erro ao adicionar. Erro: "+ex);
		}
	}
	
	public void Remover(int numeroGuia) {
		conecta.conecta();
		conecta.executaSQL("delete from TB_Movimentacao where INT_NumeroGuia =" +numeroGuia);
		System.out.println("N�mero da Guia exclu�do da tabela de Movimenta��o");
		conecta.desconecta();
		
	}

	public void Editar(int patrimonio, int novoPatrimonio, String dataEntrada, int numeroGuia, String dataDevolucao) {
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
            
            String sql3 = "select * from TB_Movimentacao where PK_Patrimonio = ?";
            
            pst2 = conn.prepareStatement(sql3);
            pst2.setInt(1, patrimonio);
            rs2 = pst2.executeQuery();
            
            
            if(!rs.next()) {
            	System.out.println("O patrim�nio digitado n�o foi adicionado � tabela de Patrim�nio");
            	conecta.desconecta();
            }else if(!rs1.next()){
            	System.out.println("O novo patrim�nio digitado n�o foi adicionado � tabela de Patrim�nio");
            	conecta.desconecta();
            }else if(!rs2.next()) {
            	System.out.println("O patrim�nio digitado n�o faz parte da tabela de Movimenta��o");
            }
            else {	  	
        
		String sql = "update TB_Movimentacao set "				
		+"PK_Patrimonio = '"+novoPatrimonio+"',"
		+"PK_DataEntrada = '"+dataEntrada+"',"
		+"INT_NumeroGuia = '"+numeroGuia+"',"
		+"DAT_DataDevolucao = '"+dataDevolucao+"'"
		+"where PK_Patrimonio = "+patrimonio;
		
			pst = conn.prepareStatement(sql);
			pst.execute();
			System.out.println("A movimenta��o foi editado com sucesso!");	
			conecta.desconecta();			
		
		
          }		
            	            
	
}catch(SQLException e) {
	System.out.println("Erro na edi��o. Erro: "+e);
	conecta.desconecta();
}
	}


}
	
