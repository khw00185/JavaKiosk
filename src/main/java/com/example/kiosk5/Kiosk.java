package com.example.kiosk5;

import com.example.kiosk5.item.AbstractItem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu<AbstractItem>> menus;
    private final Cart<AbstractItem> cart = new Cart();
    boolean flag = false;


    public Kiosk(List<Menu<AbstractItem>> menus) {
        this.menus = menus;
    }

    public void start() throws InputMismatchException {
        Scanner scanner = new Scanner(System.in);

        int categoryChoice, menuChoice;
        while (true) {
            System.out.println("[ MAIN MENU ] ");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println(i+1 + ". " +menus.get(i).getCategory());
            }
            System.out.println("0. 종료");
            if(cart.getTotalPrice() > 0){
                System.out.println();
                System.out.println("[ ORDER MENU ]");
                System.out.println("4. Orders");
                System.out.println("5. Cancel");
                System.out.println("6. Remove Item");
            }

            while(true) {
                try {
                    categoryChoice = scanner.nextInt();
                    if(categoryChoice == 0) {
                        System.out.println("종료");
                        return;
                    } else if(categoryChoice > 0 && categoryChoice <= this.menus.size()) {
                        menus.get(categoryChoice-1).printMenu();
                        flag = true;
                        break;
                    } else if(categoryChoice == 4){
                        order();
                        break;
                    } else if(categoryChoice == 5){
                        cart.getCartItems().clear();
                        System.out.println("장바구니를 엎었습니다.");
                        break;
                    } else if(categoryChoice == 6){
                        System.out.println("어떤 상품을 제거하겠습니까?");
                        cart.printCart();
                        removeItemFromCart();
                        cart.printCart();
                        break;
                    } else {
                        System.out.println("잘못된 입력입니다.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력해주세요.");
                    scanner.nextLine();
                }
            }
            if(flag) {
                flag = false;
                while(true) {
                    try {
                        menuChoice = scanner.nextInt();
                        if(menuChoice == 0) {
                            System.out.println("프로그램을 종료합니다.");
                            return;
                        } else if (menuChoice >0 && menuChoice <= menus.get(categoryChoice-1).getMenuItemSize()) {
                            AbstractItem menuItem = menus.get(categoryChoice-1).getMenuItems().get(menuChoice - 1);
                            System.out.print("선택하신 메뉴: ");
                            menuItem.print();
                            System.out.println();

                            addToCart(menuItem);
                            break;
                        } else {
                            System.out.println("잘못된 입력입니다.");
                        }
                    }catch (InputMismatchException e) {
                        System.out.println("숫자를 입력해주세요.");
                        scanner.nextLine();
                    }
                }
            }


        }
    }

    public void removeItemFromCart(){
        Scanner scanner = new Scanner(System.in);
        String selectToDelete = scanner.nextLine();
        cart.removeItem(selectToDelete);
    }

    public void addToCart(AbstractItem menuItem) {
        Scanner scanner = new Scanner(System.in);
        menuItem.print();
        System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
        System.out.println("1. 확인        2. 취소");
        while(true) {
            try {
                int option = scanner.nextInt();
                if(option == 1){
                    cart.addItem(menuItem);
                    System.out.println(menuItem.getName()+"가 장바구니에 추가되었습니다.");
                } else {
                    System.out.println("선택이 취소되었습니다.");
                }
                System.out.println();
                System.out.println("아래 메뉴를판을 보시고 메뉴를 골라 입력해주세요.");
                System.out.println();
                break;
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
                scanner.nextLine();
            }
        }
    }

    public void order() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("아래와 같이 주문 하시겠습니까?");
        System.out.println();
        System.out.println("[ Orders ]");

        cart.printCart();
        System.out.println();
        System.out.println("[ Total Price ]");
        System.out.println("W "+cart.getTotalPrice());
        System.out.println();
        System.out.println("1. 주문     2. 메뉴판");
        int option = scanner.nextInt();
        if(option == 1){
            discountPolicy();
            System.out.println("주문이 완료되었습니다. 금액은 "+ cart.discountedPrice() +" 입니다.");
            System.out.println();
            cart.getCartItems().clear();
        }
    }

    public void discountPolicy() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("[ 할인정보를 입력해주세요. ]");
        System.out.println("1. 국가유공자 : 10%");
        System.out.println("2. 군인 : 5%");
        System.out.println("3. 학생 : 3%");
        System.out.println("4. 일반 : 0%");

        while(true) {
            try{
                int option = scanner.nextInt();
                Discount discount = Discount.getDiscountBySimbol(option);
                double discountRate = 0.0;
                if(discount == Discount.국가유공자) { //"국가유공자".equals(discount)이런식의 비교는 discount가 열거형 객체이기 때문에 문자열을 직접 비교하려하면 항상 false가 된다.
                    discountRate = 0.1;
                } else if(discount == Discount.군인) {
                    discountRate = 0.05;
                } else if(discount == Discount.학생) {
                    discountRate = 0.03;
                }
                cart.setDiscount(discountRate);
                break;
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }

    }
}
