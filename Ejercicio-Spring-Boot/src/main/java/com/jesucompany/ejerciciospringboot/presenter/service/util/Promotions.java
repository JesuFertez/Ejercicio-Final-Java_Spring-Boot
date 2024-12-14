package com.jesucompany.ejerciciospringboot.presenter.service.util;

public class Promotions {

    public int moreForLess(int plans){
        int descaunt;
        switch (plans) {
            case 2 -> descaunt = 20;
            case 3, 4 -> descaunt = 30;
            default -> {
                if (plans > 4) {
                    descaunt = 35;
                } else {
                    descaunt = 0;
                }
            }
        }
        return descaunt;
    }

    public void messagePromotional(int descaunt){
        System.out.println("Tienes un descuento de "+ descaunt);
    }

    public int totalToPay(int descaunt, int price){
        int totalFinal = descaunt * price /100;
        return totalFinal;
    }

}
