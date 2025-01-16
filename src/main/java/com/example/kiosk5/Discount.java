package com.example.kiosk5;

public enum Discount {
    국가유공자(1),
    군인(2),
    학생(3),
    일반(4);

    private final int simbol;
    Discount(int simbol) {
        this.simbol = simbol;
    }
    public int getSimbol() {
        return simbol;
    }
    public static Discount getDiscountBySimbol(int simbol) {
        for (Discount discount : Discount.values()) {
            if (discount.getSimbol() == simbol) {
                return discount;
            }
        }
        throw  new IllegalArgumentException("잘못된 입력입니다.");
    }
}
