import java.sql.*;
import java.util.*;

public class main {
	
	
	public static void main(String [] args) {
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		Conexao conecta = new Conexao();
		Adicionar add = new Adicionar();	
		Remover remove = new Remover();
		Editar edt = new Editar();
		int opcao, equipamento, novoEquipamento;	    
		String descricao,novaDescricao;
		
		System.out.println("1- Adicionar na tabela de Equipamento");
		System.out.println("2- Remover na tabela de Equipamento");
		System.out.println("3- Editar na tabela de Equipamento");
		System.out.println("Escolha uma das op��es acima: ");
		
		opcao = teclado.nextInt();
		if(opcao==1) {
			System.out.println("Digite o n�mero do Equipamento que ser� adicionado: ");
			equipamento = teclado.nextInt();
			System.out.println("Digite a descri��o do Equipamento que ser� adicionado: ");
			descricao = teclado.next();
			add.AdicionarTB_Equipamento(equipamento, descricao);
		}else if(opcao==2) {
			System.out.println("Digite o n�mero do Equipamento que ser� removido: ");
			equipamento = teclado.nextInt();
			remove.RemoverTB_Equipamento(equipamento);
		}else if(opcao==3) {
			System.out.println("Digite o n�mero do equipamento que ser� editado: ");
			equipamento = teclado.nextInt();
			System.out.println("Digite o novo n�mero do Equipamento: ");
			novoEquipamento = teclado.nextInt();
			System.out.println("Digite a nova descri��o do Equipamento: ");
			novaDescricao = teclado.next();
			edt.EditarTB_Equipamento(equipamento, novoEquipamento, novaDescricao);
		}		
	
	}
}