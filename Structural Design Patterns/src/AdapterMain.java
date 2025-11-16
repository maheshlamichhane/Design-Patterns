
public class AdapterMain {
    public static void main(String[] args) {
        PaymentProcessor processor =
                new RazorpayAdapter(new RazorpayGateway());

        processor.pay(5000);
    }
}

interface PaymentProcessor {
    void pay(int amount);
}


class RazorpayGateway {
    public void makePayment(int amt) {
        System.out.println("Payment of " + amt + " through Razorpay");
    }
}


class RazorpayAdapter implements PaymentProcessor {

    private RazorpayGateway gateway;

    public RazorpayAdapter(RazorpayGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(int amount) {
        amount = amount * 100;
        gateway.makePayment(amount);
    }
}
