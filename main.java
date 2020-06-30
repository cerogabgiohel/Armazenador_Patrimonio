import java.sql.*;
import java.util.*;

public class main {
	
	
	public static void main(String [] args) {
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		TB_Equipamento tbequipamento = new TB_Equipamento();
		Integer opcao, equipamento, novoEquipamento;	    
		String descricao,novaDescricao;
		
		System.out.println("1- Adicionar na tabela de Equipamento");
		System.out.println("2- Remover na tabela de Equipamento");
		System.out.println("3- Editar na tabela de Equipamento");
		System.out.println("Escolha uma das opções acima: ");
		
		opcao = Integer.parseInt(teclado.nextLine());
		if(opcao==1) {			
			System.out.println("Digite a descrição do Equipamento que será adicionado: ");
			descricao = teclado.nextLine();
			
			tbequipamento.Adicionar(descricao);
		}else if(opcao==2) {
			System.out.println("Digite o número do Equipamento que será removido: ");
			equipamento = Integer.parseInt(teclado.nextLine());
			tbequipamento.Remover(equipamento);
		}else if(opcao==3) {
			System.out.println("Digite o número do equipamento que será editado: ");
			equipamento = Integer.parseInt(teclado.nextLine());							
			System.out.println("Digite a nova descrição do Equipamento: ");
			novaDescricao = teclado.nextLine();
			tbequipamento.Editar(equipamento, novaDescricao);
		}		
	
	}
}