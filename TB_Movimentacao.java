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
        	System.out.println("O patrimônio digitado não foi adicionado à tabela de patrimônio");
        }else {
        	String sql = "insert into TB_Movimentacao(PK_Patrimonio, PK_DataEntrada, INT_NumeroGuia, DAT_DataDevolucao) values(?,?,?,?)";
        	
        	pst = conn.prepareStatement(sql);
        	pst.setInt(1, patrimonio);
        	pst.setString(2, dataEntrada);
        	pst.setInt(3, numeroGuia);
        	pst.setString(4, dataDevolucao);
        	pst.executeUpdate();
        	System.out.println("O patrimônio, a data de entrada, o número guia e a data de devolução foram inseridas na tabela de movimentação com sucesso");
        }
		}catch(SQLException ex) {
			System.out.println("Erro ao adicionar. Erro: "+ex);
		}
	}

}
	
