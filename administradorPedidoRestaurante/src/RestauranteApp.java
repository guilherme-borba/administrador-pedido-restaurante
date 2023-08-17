import java.util.ArrayList;
import java.util.Scanner;

public class RestauranteApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<MenuItem> menu = criarCardapio();
        
        while (true) {
            System.out.println("1 - Fazer pedido");
            System.out.println("2 - Sair");
            int opcao = scanner.nextInt();
            
            if (opcao == 1) {
                fazerPedido(scanner, menu);
            } else if (opcao == 2) {
                System.out.println("Programa encerrado.");
                break;
            }
        }
        
        scanner.close();
    }
    
    public static ArrayList<MenuItem> criarCardapio() {
        ArrayList<MenuItem> menu = new ArrayList<>();
        menu.add(new MenuItem("Pizza portuguesa", 16.0));
        menu.add(new MenuItem("Pizza queijo", 18.0));
        menu.add(new MenuItem("Pizza napolitana", 21.0));
        
        return menu;
    }
    
    public static void fazerPedido(Scanner scanner, ArrayList<MenuItem> menu) {
        Pedido pedido = new Pedido();
        
        System.out.print("Digite o nome do cliente: ");
        exibirCardapio(menu);
        
        while (true) {
            System.out.print("Digite o número do item (ou 0 para finalizar o pedido): ");
            int numeroItem = scanner.nextInt();
            
            if (numeroItem == 0) {
                break;
            }
            
            if (numeroItem >= 1 && numeroItem <= menu.size()) {
                pedido.addItem(menu.get(numeroItem - 1));
            } else {
                System.out.println("Número de item inválido.");
            }
        }
        
        System.out.print("Digite a taxa de serviço (%): ");
        double taxaServico = scanner.nextDouble();
        pedido.setTaxaServico(taxaServico);
        
        double total = pedido.calcularTotal();
        System.out.println("\nNota Fiscal:");
        for (MenuItem item : pedido.getItems()) {
            System.out.println(item.getName() + " - R$" + item.getPrice());
        }
        System.out.println("Taxa de serviço: " + taxaServico + "%");
        System.out.println("Total: R$" + total);
        
        System.out.print("Digite o valor recebido em dinheiro: ");
        double valorRecebido = scanner.nextDouble();
        
        double troco = valorRecebido - total;
        System.out.println("Troco: R$" + troco);
    }
    
    public static void exibirCardapio(ArrayList<MenuItem> menu) {
        System.out.println("\nCardápio:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + " - " + menu.get(i).getName() + " - R$" + menu.get(i).getPrice());
        }
    }
}
