import java.util.*;

public class main {
	
	
	public static void main(String [] args) {
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		TB_Equipamento tbequipamento = new TB_Equipamento();
		TB_Local tblocal = new TB_Local();
		TB_Patrimonio tbpatrimonio = new TB_Patrimonio();
		TB_Localizacao tblocalizacao = new TB_Localizacao();
		TB_Movimentacao tbmovimentacao = new TB_Movimentacao();
		Integer opcao, equipamento,local, patrimonio, condicaoUso, novoPatrimonio, numeroGuia;	    
		String descricao,novaDescricao, fabricante, marca, data, dataEntrada, dataDevolucao;
		
		System.out.println("1- Adicionar à tabela de Equipamento");
		System.out.println("2- Remover da tabela de Equipamento");
		System.out.println("3- Editar na tabela de Equipamento");
		System.out.println("4- Adicionar à tabela de Local");
		System.out.println("5- Remover da tabela de Local");
		System.out.println("6- Editar na tabela de Local");
		System.out.println("7- Adicionar à tabela de Patrimônio");
		System.out.println("8- Remover da tabela de Patrimônio");
		System.out.println("9- Editar na tabela de Patrimônio");
		System.out.println("10- Adicionar à tabela de Localização");
		System.out.println("11- Remover da tabela de Localização");
		System.out.println("12- Editar na tabela de Localização");
		System.out.println("13- Adicionar à tabela de Movimentação");
	
		System.out.println("Escolha uma das opções acima: ");
		
		opcao = Integer.parseInt(teclado.nextLine());
		if(opcao==1) {			
			System.out.println("Digite a descrição do Equipamento que será adicionada à tabela de Equipamento: ");
			descricao = teclado.nextLine();
			
			tbequipamento.Adicionar(descricao);
		}else if(opcao==2) {
			System.out.println("Digite o número do Equipamento que será removido da tablea de Equipamento: ");
			equipamento = Integer.parseInt(teclado.nextLine());
			tbequipamento.Remover(equipamento);
		}else if(opcao==3) {
			System.out.println("Digite o número do equipamento que será editado na tabela de Equipamento: ");
			equipamento = Integer.parseInt(teclado.nextLine());							
			System.out.println("Digite a nova descrição do Equipamento: ");
			novaDescricao = teclado.nextLine();
			tbequipamento.Editar(equipamento, novaDescricao);
		}else if(opcao==4) {
			System.out.println("Digite a descrição do Local que será adicionado à tabela de Local: ");
			descricao = teclado.nextLine();				
			tblocal.adicionar(descricao);
		}else if(opcao==5) {
			System.out.println("Digite o número do Local que será removido da tabela de Local: ");
			local = Integer.parseInt(teclado.nextLine());
			tblocal.Remover(local);
		}else if(opcao==6) {
			System.out.println("Digite o número do Local que será editado na tabela de Local: ");
			local = Integer.parseInt(teclado.nextLine());							
			System.out.println("Digite a nova descrição do Local: ");
			novaDescricao = teclado.nextLine();
			tblocal.Editar(local, novaDescricao);	
		}else if(opcao==7) {
			System.out.println("Digite o número do equipamento que será adicionado à tabela de Patrimônio: ");
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
			System.out.println("Digite o número do patrimônio que será removido da tabela de Patrimônio: ");
			patrimonio = Integer.parseInt(teclado.nextLine());
			tbpatrimonio.Remover(patrimonio);
		}else if(opcao==9) {
			System.out.println("Digite o patrimônio que será editado na tabela de Patrimônio: ");
			patrimonio = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite o novo patrimônio: ");
			novoPatrimonio = Integer.parseInt(teclado.nextLine());
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
			tbpatrimonio.Editar(patrimonio,novoPatrimonio, equipamento, fabricante, marca, descricao, condicaoUso);
		}else if(opcao==10) {
			System.out.println("Digite o patrimônio que será adicionado à tabela de Localização: ");
			patrimonio = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite o local que será adicionado: ");
			local = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite a data de movimentação: ");
			data = teclado.nextLine();
			tblocalizacao.adicionar(patrimonio, local, data);
		}else if(opcao==11) {
			System.out.println("Digite o patrimônio que será removido da tabela de Localização: ");
			patrimonio = Integer.parseInt(teclado.nextLine());
			tblocalizacao.Remover(patrimonio);
		}else if(opcao==12) {
			System.out.println("Digite o patrimônio que será editado na tabela de Localização: ");
			patrimonio = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite o novo patrimônio: ");
			novoPatrimonio = Integer.parseInt(teclado.nextLine());			
			System.out.println("Digite o novo local: ");
			local = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite a nova data de movimentação:");
			data = teclado.nextLine();
			tblocalizacao.Editar(patrimonio, novoPatrimonio, local, data);
		}else if(opcao==13) {
			System.out.println("Digite o patrimônio que será adicionado à tabela de Movimentação: ");
			patrimonio = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite a data de entrada: ");
			dataEntrada = teclado.nextLine();
			System.out.println("Digite o número da guia: ");
			numeroGuia = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite a data de devolução: ");
			dataDevolucao = teclado.nextLine();
			tbmovimentacao.Adicionar(patrimonio, dataEntrada, numeroGuia, dataDevolucao);			
		}else {
			System.out.println("Opção inválida");
		}
	}
}