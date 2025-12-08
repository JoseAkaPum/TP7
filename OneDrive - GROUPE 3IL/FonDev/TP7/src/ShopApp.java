public class ShopApp {

    public static void main(String[] args) {
        Product clavier = new Product("Clavier", 30);
        Product souris = new Product("Souris", 15);
        Product ecran = new Product("Écran", 200);

        CartManager m = new CartManager();
        m.add(new CartItem(clavier, 2));
        m.add(new CartItem(souris, 1));
        m.add(new CartItem(ecran, 1));

        m.printCart();

        double totalTtc = m.totalTtc();
        System.out.println("Total TTC (avant réduction) : " + totalTtc);

        double totalRemise = m.totalWithDiscount();
        System.out.println("Total TTC (après réduction) : " + totalRemise);
    }
}