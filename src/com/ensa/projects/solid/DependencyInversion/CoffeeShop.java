package com.ensa.projects.solid.DependencyInversion;

interface PaymentProvider {
    void makePayment();
}

interface PaymentReceiver {
    void getPayment();
}

interface CoffeeReceiver {
    void receiveCoffee();
}

interface CoffeeProvider {
    void deliverCoffee();
}

class CoffeeShop implements PaymentReceiver, CoffeeProvider {
    public void getPayment() {
    }

    public void deliverCoffee() {
    }
}

class Customer implements PaymentProvider, CoffeeReceiver {
    public void makePayment() {
    }

    public void receiveCoffee() {
    }
}

class Delivery {

    PaymentProvider paymentProvider;
    PaymentReceiver paymentReceiver;
    CoffeeProvider coffeeProvider;
    CoffeeReceiver coffeeReceiver;

    Delivery(PaymentProvider paymentProvider, PaymentReceiver paymentReceiver,
             CoffeeProvider coffeeProvider, CoffeeReceiver coffeeReceiver) {
        this.paymentProvider = paymentProvider;
        this.paymentReceiver = paymentReceiver;
        this.coffeeProvider = coffeeProvider;
        this.coffeeReceiver = coffeeReceiver;
    }

    void deliver() {
        paymentProvider.makePayment();
        paymentReceiver.getPayment();
        coffeeProvider.deliverCoffee();
        coffeeReceiver.receiveCoffee();
    }
}
