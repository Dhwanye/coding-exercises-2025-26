package behavioural.strategy;

interface PaymentStrategy { void pay(int amount); }

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) { System.out.println("Paid " + amount + " using Credit Card."); }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) { System.out.println("Paid " + amount + " using PayPal."); }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) { this.paymentStrategy = paymentStrategy; }
    public void checkout(int amount) {
        if (paymentStrategy == null) { System.out.println("No payment method selected!"); }
        else { paymentStrategy.pay(amount); }
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);
        cart.setPaymentStrategy(new PayPalPayment());
        cart.checkout(200);
    }
}