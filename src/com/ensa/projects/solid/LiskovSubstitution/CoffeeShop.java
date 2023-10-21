package com.ensa.projects.solid.LiskovSubstitution;

interface TakeawayService {
    String takeaway();
}
public class CoffeeShop {
    //...
}
class A extends CoffeeShop implements TakeawayService {
    @Override
    public String takeaway() {
        return "Delivery at most 30 minutes";
    }
}
class B extends CoffeeShop {
    //...
}
