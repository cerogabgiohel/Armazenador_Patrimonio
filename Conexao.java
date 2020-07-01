import java.sql.*;
public class Conexao {
	public Statement stm;
	public ResultSet rs;
	public String driver = "org.sqlite.JDBC";
	private String caminho = "jdbc:sqlite:C:\\Users\\Cerogabgiohel\\Desktop\\TRE-MG\\PatControl-Ver20.db";
	public Connection conn;
	
	public Connection conecta() {
		try {
			System.setProperty("jdbc.Drivers", driver);
			conn = DriverManager.getConnection(caminho);
			
			return conn;
		}catch(SQLException ex) {
			System.out.println("Erro na conexão");
		}
		return null;
	}
	
	public void desconecta() {
		try {
			conn.close();
			//System.out.println("Desconectado com sucesso");
		}catch(SQLException ex) {
			System.out.println("Erro na desconexão");
		}
	}
	
	public void executaSQL(String sql) {
		try {
			stm = conn.createStatement(rs.TYPE_FORWARD_ONLY, rs.CONCUR_READ_ONLY);
			int rs = stm.executeUpdate(sql);			
		}catch(SQLException ex) {
			System.out.println("Erro no executaSQL. Erro: " +ex);
		}
	}
}
