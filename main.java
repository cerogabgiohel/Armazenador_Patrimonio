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
		
		System.out.println("1- Adicionar � tabela de Equipamento");
		System.out.println("2- Remover da tabela de Equipamento");
		System.out.println("3- Editar na tabela de Equipamento");
		System.out.println("4- Adicionar � tabela de Local");
		System.out.println("5- Remover da tabela de Local");
		System.out.println("6- Editar na tabela de Local");
		System.out.println("7- Adicionar � tabela de Patrim�nio");
		System.out.println("8- Remover da tabela de Patrim�nio");
		System.out.println("9- Editar na tabela de Patrim�nio");
		System.out.println("10- Adicionar � tabela de Localiza��o");
		System.out.println("11- Remover da tabela de Localiza��o");
		System.out.println("12- Editar na tabela de Localiza��o");
		System.out.println("13- Adicionar � tabela de Movimenta��o");
	
		System.out.println("Escolha uma das op��es acima: ");
		
		opcao = Integer.parseInt(teclado.nextLine());
		if(opcao==1) {			
			System.out.println("Digite a descri��o do Equipamento que ser� adicionada � tabela de Equipamento: ");
			descricao = teclado.nextLine();
			
			tbequipamento.Adicionar(descricao);
		}else if(opcao==2) {
			System.out.println("Digite o n�mero do Equipamento que ser� removido da tablea de Equipamento: ");
			equipamento = Integer.parseInt(teclado.nextLine());
			tbequipamento.Remover(equipamento);
		}else if(opcao==3) {
			System.out.println("Digite o n�mero do equipamento que ser� editado na tabela de Equipamento: ");
			equipamento = Integer.parseInt(teclado.nextLine());							
			System.out.println("Digite a nova descri��o do Equipamento: ");
			novaDescricao = teclado.nextLine();
			tbequipamento.Editar(equipamento, novaDescricao);
		}else if(opcao==4) {
			System.out.println("Digite a descri��o do Local que ser� adicionado � tabela de Local: ");
			descricao = teclado.nextLine();				
			tblocal.adicionar(descricao);
		}else if(opcao==5) {
			System.out.println("Digite o n�mero do Local que ser� removido da tabela de Local: ");
			local = Integer.parseInt(teclado.nextLine());
			tblocal.Remover(local);
		}else if(opcao==6) {
			System.out.println("Digite o n�mero do Local que ser� editado na tabela de Local: ");
			local = Integer.parseInt(teclado.nextLine());							
			System.out.println("Digite a nova descri��o do Local: ");
			novaDescricao = teclado.nextLine();
			tblocal.Editar(local, novaDescricao);	
		}else if(opcao==7) {
			System.out.println("Digite o n�mero do equipamento que ser� adicionado � tabela de Patrim�nio: ");
			equipamento = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite o nome da fabricante: ");
			fabricante = teclado.nextLine();
			System.out.println("Digite o nome da marca: ");
			marca = teclado.nextLine();
			System.out.println("Digite a descri��o: ");
			descricao = teclado.nextLine();
			System.out.println("Digite a condi��o de uso");
			condicaoUso = Integer.parseInt(teclado.nextLine());
			tbpatrimonio.Adicionar(equipamento, fabricante, marca, descricao, condicaoUso);
		}else if(opcao==8) {
			System.out.println("Digite o n�mero do patrim�nio que ser� removido da tabela de Patrim�nio: ");
			patrimonio = Integer.parseInt(teclado.nextLine());
			tbpatrimonio.Remover(patrimonio);
		}else if(opcao==9) {
			System.out.println("Digite o patrim�nio que ser� editado na tabela de Patrim�nio: ");
			patrimonio = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite o novo patrim�nio: ");
			novoPatrimonio = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite o novo equipamento: ");
			equipamento = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite a nova fabricante: ");
			fabricante = teclado.nextLine();
			System.out.println("Digite a nova marca:");
			marca = teclado.nextLine();
			System.out.println("Digite a nova descri��o: ");
			descricao = teclado.nextLine();
			System.out.println("Digite a nova condi��o de uso: ");
			condicaoUso = Integer.parseInt(teclado.nextLine());
			tbpatrimonio.Editar(patrimonio,novoPatrimonio, equipamento, fabricante, marca, descricao, condicaoUso);
		}else if(opcao==10) {
			System.out.println("Digite o patrim�nio que ser� adicionado � tabela de Localiza��o: ");
			patrimonio = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite o local que ser� adicionado: ");
			local = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite a data de movimenta��o: ");
			data = teclado.nextLine();
			tblocalizacao.adicionar(patrimonio, local, data);
		}else if(opcao==11) {
			System.out.println("Digite o patrim�nio que ser� removido da tabela de Localiza��o: ");
			patrimonio = Integer.parseInt(teclado.nextLine());
			tblocalizacao.Remover(patrimonio);
		}else if(opcao==12) {
			System.out.println("Digite o patrim�nio que ser� editado na tabela de Localiza��o: ");
			patrimonio = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite o novo patrim�nio: ");
			novoPatrimonio = Integer.parseInt(teclado.nextLine());			
			System.out.println("Digite o novo local: ");
			local = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite a nova data de movimenta��o:");
			data = teclado.nextLine();
			tblocalizacao.Editar(patrimonio, novoPatrimonio, local, data);
		}else if(opcao==13) {
			System.out.println("Digite o patrim�nio que ser� adicionado � tabela de Movimenta��o: ");
			patrimonio = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite a data de entrada: ");
			dataEntrada = teclado.nextLine();
			System.out.println("Digite o n�mero da guia: ");
			numeroGuia = Integer.parseInt(teclado.nextLine());
			System.out.println("Digite a data de devolu��o: ");
			dataDevolucao = teclado.nextLine();
			tbmovimentacao.Adicionar(patrimonio, dataEntrada, numeroGuia, dataDevolucao);			
		}else {
			System.out.println("Op��o inv�lida");
		}
	}
}