import java.sql.*;
import java.util.*;

public class main {
	
	
	public static void main(String [] args) {
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		TB_Equipamento tbequipamento = new TB_Equipamento();
		TB_Local tblocal = new TB_Local();
		TB_Patrimonio tbpatrimonio = new TB_Patrimonio();
		TB_Localizacao tblocalizacao = new TB_Localizacao();
		Integer opcao, equipamento, novoEquipamento, local, patrimonio, condicaoUso;	    
		String descricao,novaDescricao, fabricante, marca, data;
		
		System.out.println("1- Adicionar na tabela de Equipamento");
		System.out.println("2- Remover na tabela de Equipamento");
		System.out.println("3- Editar na tabela de Equipamento");
		System.out.println("4- Adicionar na tabela de Local");
		System.out.println("5- Remover na tabela de Local");
		System.out.println("6- Editar na tabela de Local");
		System.out.println("7- Adicionar na tabela de Patrimônio");
		System.out.println("8- Remover na tabela de Patrimônio");
		System.out.println("9- Editar na tabela de Patrimônio");
		System.out.println("10- Adicionar na tabela de Localização");
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
		}else if(opcao==4) {
			System.out.println("Digite a descrição do Local que será adicionado: ");
			descricao = teclado.nextLine();				
			tblocal.adicionar(descricao);
		}else if(opcao==5) {
			System.out.println("Digite o número do Local que será removido: ");
			local = Integer.parseInt(teclado.nextLine());
			tblocal.Remover(local);
		}else if(opcao==6) {
			System.out.println("Digite o número do Local que será editado: ");
			local = Integer.parseInt(teclado.nextLine());							
			System.out.println("Digite a nova descrição do Local: ");
			novaDescricao = teclado.nextLine();
			tblocal.Editar(local, novaDescricao);	
		}else if(opcao==7) {
			System.out.println("Digite o número do equipamento que será adicionado: ");
			equipamento = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite o nome da fabricante: ");
			fabricante = teclado.nextLine();
			System.out.println("Digite o nome da marca: ");
			marca = teclado.nextLine();
			System.out.println("Digite a descrição: ");
			descricao = teclado.nextLine();
			System.out.println("Digite a condição de uso");
			condicaoUso = Integer.parseInt(teclado.nextLine());
			tbpatrimonio.Adicionar(equipamento, fabricante, marca, descricao, condicaoUso);
		}else if(opcao==8) {
			System.out.println("Digite o número do patrimônio que será removido: ");
			patrimonio = Integer.parseInt(teclado.nextLine());
			tbpatrimonio.Remover(patrimonio);
		}else if(opcao==9) {
			System.out.println("Digite o patrimônio que será editado: ");
			patrimonio = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite o novo equipamento: ");
			equipamento = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite a nova fabricante: ");
			fabricante = teclado.nextLine();
			System.out.println("Digite a nova marca:");
			marca = teclado.nextLine();
			System.out.println("Digite a nova descrição: ");
			descricao = teclado.nextLine();
			System.out.println("Digite a nova condição de uso: ");
			condicaoUso = Integer.parseInt(teclado.nextLine());
			tbpatrimonio.Editar(patrimonio, equipamento, fabricante, marca, descricao, condicaoUso);
		}else if(opcao==10) {
			System.out.println("Digite o patrimônio que será adicionado: ");
			patrimonio = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite o local que será adicionado: ");
			local = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite a data: ");
			data = teclado.nextLine();
			tblocalizacao.adicionar(patrimonio, local, data);
		}
	
	}
}