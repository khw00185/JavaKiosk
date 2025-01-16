package com.example.kiosk5;

import com.example.kiosk5.item.AbstractItem;
import com.example.kiosk5.item.CartItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Cart <T extends AbstractItem> {
    private final List<T> cartItems = new ArrayList<>();
    private double discount;

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void addItem(T item) {
        boolean flag = true;

        for (T cartItem1 : cartItems) {
            if (cartItem1.getName().equals(item.getName())) {
                cartItem1.setQuantity(cartItem1.getQuantity() + 1);
                flag = false;
            }
        }
        if(flag) {
            CartItem cartItem = new CartItem(item.getName(), item.getPrice(), item.getDescription(), 1);
            cartItems.add((T) cartItem);
        }
    }


    public void removeItem(String itemName) {
        T cartItem = cartItems.stream()
                .filter(item -> item.getName().equals(itemName))
                .findFirst()
                .orElse(null);

        if (cartItem != null) {
            if (cartItem.getQuantity() > 1) {
                cartItem.setQuantity(cartItem.getQuantity() - 1);
            } else {
                cartItems.remove(cartItem);
            }
            System.out.println(itemName + " 한개를 장바구니에서 뻈습니다.");
        } else {
            System.out.println("해당 아이템을 찾을 수 없습니다.");
        }
    }

    public List<T> getCartItems() {
        return cartItems;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (T cartItem : cartItems) {
            if(cartItem.getQuantity() > 1){
                totalPrice += (cartItem.getPrice() * cartItem.getQuantity());
            } else {
                totalPrice += cartItem.getPrice();
            }
        }
        return totalPrice;
    }
    public double discountedPrice() {
        double totalPrice = getTotalPrice() - (getTotalPrice() * discount);
        return totalPrice;
    }

    public void printCart() {
        IntStream.range(0, cartItems.size())
                .forEach(index -> {
                    cartItems.get(index).print();
                });
    }
}
