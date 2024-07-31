public interface PaymentProcessor {
    void processPayment(double amount);
}

public class PaypalGateway {
    public void makePayment(double amount) {
        System.out.println("Processing payment with PayPal: $" + amount);
    }
}

public class StripeGateway {
    public void charge(double amount) {
        System.out.println("Charging with Stripe: $" + amount);
    }
}

public class PaypalAdapter implements PaymentProcessor {
    private PaypalGateway paypalGateway;

    public PaypalAdapter(PaypalGateway paypalGateway) {
        this.paypalGateway = paypalGateway;
    }

    @Override
    public void processPayment(double amount) {
        paypalGateway.makePayment(amount);
    }
}

public class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.charge(amount);
    }
}

public class TestAdapterPattern {
    public static void main(String[] args) {
        PaypalGateway paypalGateway = new PaypalGateway();
        StripeGateway stripeGateway = new StripeGateway();

        PaymentProcessor paypalAdapter = new PaypalAdapter(paypalGateway);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeGateway);

        System.out.println("Using PayPal Adapter:");
        paypalAdapter.processPayment(150.0);

        System.out.println("\nUsing Stripe Adapter:");
        stripeAdapter.processPayment(200.0);
    }
}


