public class CartManager {

    public CartItem[] items;
    public int count;

    public CartManager() {
        items = new CartItem[10];
        count = 0;
    }

    public void add(CartItem c) {
        items[count] = c;
        count = count + 1;
    }

    public void printCart() {
        System.out.println("Contenu du panier :");
        for (int i = 0; i < items.length; i++) {
            CartItem c = items[i];
            System.out.println("- " + c.product.name + " x " + c.quantity);
            double t = c.product.priceHt * 1.2;
            System.out.println("  Prix TTC ligne : " + t);
        }
    }

    public double totalTtc() {
        double totalHt = 0;
        for (int i = 0; i < count; i++) {
            CartItem c = items[i];
            totalHt = totalHt + c.product.priceHt;
        }
        double totalTtc = totalHt * 1.1;
        return totalTtc;
    }

    public double totalWithDiscount() {
        double t = totalTtc();
        double d = 0;
        if (t > 50) {
            if (t > 100) {
                d = t * 0.1;
            } else {
                d = t * 0.05;
            }
        } else {
            d = 0;
        }
        return t - d;
    }
}