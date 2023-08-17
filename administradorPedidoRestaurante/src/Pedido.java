import java.util.ArrayList;

class Pedido {
    private ArrayList<MenuItem> items = new ArrayList<>();
    private double taxaServico;

    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void setTaxaServico(double taxaServico) {
        this.taxaServico = taxaServico;
    }

    public double calcularTotal() {
        double total = 0;
        for (MenuItem item : items) {
            total += item.getPrice();
        }
        total += total * (taxaServico / 100);
        return total;
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }
}
