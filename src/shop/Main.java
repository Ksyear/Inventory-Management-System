package shop;

import java.util.Scanner;

public class Main {
    static void main() {
        ShopManager shopManager = new ShopManager();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("1. 상품 추가\n" +
                    "2. 상품 삭제\n" +
                    "3. 상품명 수정\n" +
                    "4. 카테고리 수정\n" +
                    "5. 상품 가격 수정\n" +
                    "6. 상품 재고 수정\n" +
                    "7. 품절 여부 수정(품절 여부 설정)\n" +
                    "8. 전체 상품 정보 출력\n" +
                    "9. 상품명으로 검색\n" +
                    "10. 카테고리로 검색\n" +
                    "11. 상품 가격으로 검색\n" +
                    "12. 상품 재고로 검색\n" +
                    "13. 품절로 검색\n" +
                    "14. 카테고리별 상품 정보 출력\n" +
                    "15. 가격 낮은 순으로 정렬해서 출력\n" +
                    "16. 재고가 n개 이하인 상품 정보 출력\n" +
                    "17. 카테고리별 상품 가격 평균 출력\n" +
                    "기능을 선택하세요: ");
            try{
                int num = scanner.nextInt();
                switch (num) {
                    case 1:
                        System.out.println("추가할 상품을 입력하시오: 상품_Id 상품명 카테고리 가격 재고_수량 품절_여부");
                        shopManager.addProduct(scanner.next(), scanner.next(), scanner.next(), scanner.nextInt(), scanner.nextInt(), scanner.nextBoolean());
                        break;
                    case 2:
                        System.out.print("삭제할 상품명을 입력하시오: ");
                        shopManager.removeProduct(scanner.next());
                        break;
                    case 3:
                        shopManager.setName();
                        break;
                    case 4:
                        shopManager.setCategory();
                        break;
                    case 5:
                        shopManager.setPrice();
                        break;
                    case 6:
                        shopManager.setStock();
                        break;
                    case 7:
                        shopManager.setSoldOut();
                        break;
                    case 8:
                        shopManager.printAll();
                        break;
                    case 9:
                        System.out.println(shopManager.getName());
                        break;
                    case 10:
                        shopManager.getCategory();
                        break;
                    case 11:
                        System.out.println(shopManager.getPrice());
                        break;
                    case 12:
                        shopManager.getStock();
                        break;
                    case 13:
                        System.out.println(shopManager.getSoldOut());
                        break;
                    case 14:
                        shopManager.category();
                        break;
                    case 15:
                        shopManager.price();
                        break;
                    case 16:
                        shopManager.stock();
                        break;
                    case 17:
                        shopManager.averagePrice();
                        break;
                    default:
                        System.out.println("값을 잘못 입력 하셨습니다.");
                }
            } catch (Exception e) {
                System.err.println("값을 잘못 입력 하셨습니다.");
                break;
            }
        }
    }
}
