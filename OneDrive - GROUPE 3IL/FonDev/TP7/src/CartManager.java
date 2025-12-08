public class CartManager {

    public CartItem[] items;
    public int count;

    public CartManager() {
        items = new CartItem[10];
        count = 0;
    }

    public void add(CartItem c) {
        if (count < items.length) {  
            items[count] = c;
            count++;
        }
    }

    public void printCart() {
        System.out.println("Contenu du panier :");
        for (int i = 0; i < count; i++) {
            CartItem cart = items[i];
            if (cart!=null) {
            System.out.println("- " + cart.product.name + " x " + cart.quantity);
            double priceWithTVA = cart.product.priceHt * 1.2 * cart.quantity;
            System.out.println("  Prix TTC ligne : " + priceWithTVA);
        }
            else {
            	System.out.println("Il n'y a pas d'item dans le panier");
            	break;
            }
        }
    }

    public double totalTtc() {
        double totalHt = 0;
        for (int i = 0; i < count; i++) {
            totalHt += (items[i].product.priceHt * items[i].quantity);
        }
        return totalHt * 1.2; 
    }

    public double totalWithDiscount() {
        double totalTtc = totalTtc();
        double totalWithDiscount = 0;
        if (totalTtc > 50) {
            if (totalTtc > 100) {
                totalWithDiscount = totalTtc * 0.9;
            } else {
                totalWithDiscount = totalTtc * 0.95;
            }
        } else {
            totalWithDiscount = 0;
        }
        return totalWithDiscount;
    }
}