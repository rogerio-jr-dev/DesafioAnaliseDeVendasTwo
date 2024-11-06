package application;

import entities.Sale;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.print("Entre o caminho do arquivo: ");
        String path = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            List<Sale> sales = new ArrayList<>();

            String line = br.readLine();

            while (line != null) {
                String[] fiels = line.split(",");
                int month = Integer.parseInt(fiels[0]);
                int year = Integer.parseInt(fiels[1]);
                String seller = fiels[2];
                int items = Integer.parseInt(fiels[3]);
                double total = Double.parseDouble(fiels[4]);

                sales.add(new Sale(month, year, seller, items, total));

                line = br.readLine();
            }

            // Mapeia cada vendedor ao total acumulado de vendas
            Map<String, Double> salesBySeller = new HashMap<>();

            for (Sale sale : sales) {
                // Obtém o nome do vendedor e o valor da venda
                String seller = sale.getSeller();
                Double total = sale.getTotal();

                // Atualiza o total acumulado no Map
                salesBySeller.put(seller, salesBySeller.getOrDefault(seller, 0.0) + total);
            }
            System.out.println();

            // Exibe o total de vendas por vendedor
            System.out.println("Total de vendas por vendedor:");
            salesBySeller.forEach((seller, total) ->
                    System.out.println( seller + " - R$ " + String.format("%.2f", total))
            );

        } catch (Exception e) {
            System.out.println("Erro: " + path + " (O sistema não pode encontrar o arquivo especificado)");
        }


    }
}