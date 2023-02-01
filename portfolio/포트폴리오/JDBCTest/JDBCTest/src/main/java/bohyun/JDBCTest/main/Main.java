package bohyun.JDBCTest.main;

import bohyun.JDBCTest.domain.Member;
import bohyun.JDBCTest.service.MemberService;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner enter = new Scanner(System.in);
        MemberService memberService = new MemberService();
        Member member;

        int people[] = new int[100];
        int money[] = {20000, 20000, 20000, 20000, 20000, 10000, 10000, 10000, 10000, 10000, 0, 0, 0, 0, 0};
        int firstmoney[] = new int[100];
        String food[] = {"치킨", "피자", "타코야키", "라면", "우동"};
        String menuselect;
        String refund;
        int refundcnt;
        int fund;
        int returnloan, returnloan1;
        int bank = 0, bankreturn;
        int bank2 = 0;
        int menu, menu1;
        int input;
        int human, humanchoice;
        int humancount[] = new int[100];
        int humancount1[] = new int[100];
        int chicken[] = new int[100];
        int pizza[] = new int[100];
        int taco[] = new int[100];
        int ramen[] = new int[100];
        int udong[] = new int[100];
        int chickenmoney[] = new int[100];
        int pizzamoney[] = new int[100];
        int tacomoney[] = new int[100];
        int ramenmoney[] = new int[100];
        int udongmoney[] = new int[100];
        int chickencount = 0, pizzacount = 0, tacocount = 0, ramencount = 0, udongcount = 0;
        int chickenprice, pizzaprice, tacoprice, ramenprice, udongprice;
        int hwanbul[] = new int[100];
        int customer = 0, customer1;
        int choice, minab, aaa;
        int numbercount = 0;

        // 빚진 금액
        int borrowmoney[] = new int[100];
        int borrowmoney1[] = new int[100];
        // 빚 청산 후 남은 금액
        int payoff[] = new int[100];
        // 미납된 금액
        int unpaid[] = new int[100];
        // 빌려준 금액
        int lendmoney[] = new int[100];

        // 종료 카운트
        int exitcount[] = new int[100];

        // equals 변수
        String equalschicken = "치킨";
        String equalspizza = "피자";
        String equalstaco = "타코야키";
        String equalsramen = "라면";
        String equalsudong = "우동";
        String equalshwanbul = "환불";
        String equalsloan = "대출";
        String equalspayback = "상환";
        String equalsnext = "다음손님";
        String equalsexit = "종료";
        String equalscheck = "조회";
        String equalsupdate = "수정";
        String equalsdelete = "삭제";
        String equalschoice = "손님선택";
        String equalsback = "돌아가기";

        // 조회 입력 변수
        int check;
        // 삭제 입력 변수
        int delete;
        // 마지막 메뉴 선택
        String lastmenu;

        for (int i = 10; i <= 14; i++)
        {
            System.out.print(i + " 번째 손님 금액 입력 : ");
            input = enter.nextInt();

            money[i] = input;
            firstmoney[i] = money[i];
        }

        System.out.println();

        for (int i = 0; i <= 14; i++)
        {
            System.out.println((i + 1) + " 번 손님이 가진 금액 : " + money[i]);
            firstmoney[i] = money[i];
        }

        System.out.println("몇 번째 손님을 선택 하시겠습니까?");
        human = enter.nextInt();

        for (int i = human - 1; i <= 99; i++)
        {
            while (true)
            {
                System.out.println("현재 손님 번호 = " + human);
                humancount[i] = humancount [i] + 1;
                System.out.println((i + 1) + " 번째 손님이 쇼핑 중입니다");
                System.out.println("메뉴를 선택하세요");
                System.out.println("[1. 치킨, 2. 피자, 3. 타코야키, 4. 라면, 5. 우동, 6. 환불, 7. 대출, 8. 상환, 9. 다음 손님, 10. 손님 선택, 11. 종료(조회, 수정, 삭제)]");
                menuselect = enter.next();

                if (menuselect.equals(equalschicken) == true)
                {
                    money[i] = money[i] - 5000;
                    //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                    chicken[i] = chicken[i] + 1;
                    chickenmoney[i] = chickenmoney[i] + 5000;
                    //System.out.printf("\nchicken[%d] = %d\n", i + 1, chicken[i]);
                    //System.out.printf("\nchickenmoney[%d] = %d\n", i + 1, chickenmoney[i]);
                    chickencount = chickencount + 1;
                    //System.out.printf("\nchicount = %d\n", chickencount);

                    if (money[i] <= 0)
                    {
                        humancount1[i] = humancount1[i] + 1;
                        exitcount[i] = exitcount[i] + 1;
                        money[i] = money[i] + 5000;
                        //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                        chicken[i] = chicken[i] - 1;
                        chickenmoney[i] = chickenmoney[i] - 5000;
                        //System.out.printf("\nchicken[%d] = %d\n", i + 1, chicken[i]);
                        //System.out.printf("\nchickenmoney[%d] = %d\n", i + 1, chickenmoney[i]);
                        chickencount = chickencount - 1;
                        //System.out.printf("\nchicount = %d\n", chickencount);

                        System.out.println((i + 1) + " 번 손님 현재 가지고 있는 돈이 부족해서 대출 받으셔야 합니다");
                        System.out.println("치킨 구매를 실패해서 현재 남은 금액 " + money[i] + " 원 입니다");

                        System.out.println();
                        System.out.println("자동으로 대출메뉴로 넘어갑니다");
                        System.out.println();

                        System.out.println((i + 1) + " 번 손님의 다음 손님에게 대출 받습니다");
                        System.out.println((i + 1) + " 번 손님 대출 받으실 금액을 입력하세요");
                        bank = enter.nextInt();

                        customer = i + 2;
                        System.out.println();
                        //System.out.println("i = " + i);
                        //System.out.println("customer = " + customer);
                        System.out.println();
                        humancount[customer - 1] = humancount[customer - 1] + 1;
                        money[i] = money[i] + bank;
                        money[customer - 1] = money[customer - 1] - bank;
                        borrowmoney[i] = borrowmoney[i] + bank;
                        borrowmoney1[i] = borrowmoney1[i] + bank;
                        lendmoney[customer - 1] = lendmoney[customer - 1] + bank;
                        unpaid[customer - 1] = lendmoney[customer - 1];
                        //System.out.printf("\nborrowmoney (빚 진 금액 ) [%d] = %d\n", i + 1, borrowmoney[i]);
                        //System.out.printf("\nlendmoney (빌려준 금액 ) [%d] = %d\n", customer, lendmoney[customer - 1]);
                        //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank);

                        //System.out.println("이전손님");
                        //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                        //System.out.println("다음 손님");
                        //System.out.printf("\nmoney[%d] = %d\n", customer, money[customer - 1]);

                        System.out.println();
                        System.out.printf("\n%d번 손님이 %d번 손님에게 %d원을 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer, bank, money[i]);
                        System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer, i + 1, bank, money[customer - 1]);

                        while (true)
                        {
                            System.out.println("1. 더 빌린다, 2. 빌리지 않는다");
                            choice = enter.nextInt();

                            if (choice == 1)
                            {
                                customer1 = i + 3;
                                System.out.println();
                                //System.out.println("customer1 = " + customer1);
                                System.out.println();
                                humancount[customer1 - 1] = humancount[customer1 - 1] + 1;
                                System.out.println("자동으로 " + customer1 + " 번 손님에게 대출 받습니다");
                                System.out.println();
                                System.out.println((i + 1) + " 번 손님 추가로 대출 받으실 금액을 입력하세요");
                                bank2 = enter.nextInt();

                                money[i] = money[i] + bank2;
                                borrowmoney[i] = borrowmoney[i] + bank2;
                                borrowmoney1[i] = borrowmoney1[i] + bank2;
                                money[customer1 - 1] = money[customer1 - 1] - bank2;
                                lendmoney[customer1 - 1] = lendmoney[customer1 - 1] + bank2;
                                unpaid[customer1 - 1] = lendmoney[customer1 - 1];

                                //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank2);

                                //System.out.println("이전손님");
                                //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                //System.out.println("다음 손님");
                                //System.out.printf("\nmoney[%d] = %d\n", customer1, money[customer1 - 1]);

                                System.out.printf("\n%d번 손님이 %d번 손님에게 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer1, money[i]);
                                System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer1, i + 1, bank2, money[customer1 - 1]);
                            }

                            if (choice == 2)
                            {
                                System.out.println();
                                System.out.println("대출 시스템을 종료하고 메인 메뉴로 돌아갑니다");
                                System.out.println();
                                break;
                            }
                        }
                    }

                    System.out.println();
                    System.out.println((i + 1) + " 번째 손님이 치킨을 구매해서 현재 남은 금액 " + money[i] + " 원 입니다");
                }

                if (menuselect.equals(equalspizza) == true)
                {
                    money[i] = money[i] - 5000;
                    //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                    pizza[i] = pizza[i] + 1;
                    pizzamoney[i] = pizzamoney[i] + 5000;
                    //System.out.printf("\npizza[%d] = %d\n", i + 1, pizza[i]);
                    //System.out.printf("\npizzamoney[%d] = %d\n", i + 1, pizzamoney[i]);
                    pizzacount = pizzacount + 1;
                    //System.out.printf("pizzacount = %d\n", pizzacount);

                    if (money[i] <= 0)
                    {
                        humancount1[i] = humancount1[i] + 1;
                        exitcount[i] = exitcount[i] + 1;
                        money[i] = money[i] + 5000;
                        pizza[i] = pizza[i] - 1;
                        pizzamoney[i] = pizzamoney[i] - 5000;
                        pizzacount = pizzacount - 1;

                        System.out.println((i + 1) + " 번 손님 현재 가지고 있는 돈이 부족해서 대출 받으셔야 합니다");
                        System.out.println("피자 구매를 실패해서 현재 남은 금액 " + money[i] + " 원 입니다");

                        System.out.println();
                        System.out.println("자동으로 대출메뉴로 넘어갑니다");
                        System.out.println();

                        System.out.println((i + 1) + " 번 손님의 다음 손님에게 대출 받습니다");
                        System.out.println((i + 1) + " 번 손님 대출 받으실 금액을 입력하세요");
                        bank = enter.nextInt();

                        customer = i + 2;
                        humancount[customer - 1] = humancount[customer - 1] + 1;
                        money[i] = money[i] + bank;
                        money[customer - 1] = money[customer - 1] - bank;
                        borrowmoney[i] = borrowmoney[i] + bank;
                        borrowmoney1[i] = borrowmoney1[i] + bank;
                        lendmoney[customer - 1] = lendmoney[customer - 1] + bank;
                        unpaid[customer - 1] = lendmoney[customer - 1];
                        //System.out.printf("\nborrowmoney (빚 진 금액 ) [%d] = %d\n", i + 1, borrowmoney[i]);
                        //System.out.printf("\nlendmoney (빌려준 금액 ) [%d] = %d\n", customer, lendmoney[customer - 1]);
                        //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank);

                        //System.out.println("이전손님");
                        //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                        //System.out.println("다음 손님");
                        //System.out.printf("\nmoney[%d] = %d\n", customer, money[customer - 1]);

                        System.out.printf("\n%d번 손님이 %d번 손님에게 %d원을 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer, bank, money[i]);
                        System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer, i + 1, bank, money[customer - 1]);

                        while (true)
                        {
                            System.out.println("1. 더 빌린다, 2. 빌리지 않는다");
                            choice = enter.nextInt();

                            if (choice == 1)
                            {
                                customer1 = i + 3;
                                humancount[customer1 - 1] = humancount[customer1 - 1] + 1;
                                System.out.println("자동으로 " + customer1 + " 번 손님에게 대출 받습니다");
                                System.out.println();
                                System.out.println((i + 1) + " 번 손님 추가로 대출 받으실 금액을 입력하세요");
                                bank2 = enter.nextInt();

                                money[i] = money[i] + bank2;
                                borrowmoney[i] = borrowmoney[i] + bank2;
                                borrowmoney1[i] = borrowmoney1[i] + bank2;
                                money[customer1 - 1] = money[customer1 - 1] - bank2;
                                lendmoney[customer1 - 1] = lendmoney[customer1 - 1] + bank2;
                                unpaid[customer1 - 1] = lendmoney[customer1 - 1];

                                //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank2);

                                //System.out.println("이전손님");
                                //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                //System.out.println("다음 손님");
                                //System.out.printf("\nmoney[%d] = %d\n", customer1, money[customer1 - 1]);

                                System.out.printf("\n%d번 손님이 %d번 손님에게 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer1, money[i]);
                                System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer1, i + 1, bank2, money[customer1 - 1]);
                            }

                            if (choice == 2)
                            {
                                System.out.println();
                                System.out.println("대출 시스템을 종료하고 메인 메뉴로 돌아갑니다");
                                System.out.println();
                                break;
                            }
                        }
                    }

                    System.out.println();
                    System.out.println((i + 1) + " 번째 손님이 피자를 구매해서 현재 남은 금액 " + money[i] + " 원 입니다");
                }

                if (menuselect.equals(equalstaco) == true)
                {
                    money[i] = money[i] - 3000;
                    //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                    taco[i] = taco[i] + 1;
                    tacomoney[i] = tacomoney[i] + 3000;
                    //System.out.printf("\ntaco[%d] = %d\n", i + 1, taco[i]);
                    //System.out.printf("\ntacomoney[%d] = %d\n", i + 1, tacomoney[i]);
                    tacocount = tacocount + 1;
                    //System.out.printf("\ntacocount = %d\n", tacocount);

                    if (money[i] <= 0)
                    {
                        humancount1[i] = humancount1[i] + 1;
                        exitcount[i] = exitcount[i] + 1;
                        money[i] = money[i] + 3000;
                        taco[i] = taco[i] - 1;
                        tacomoney[i] = tacomoney[i] - 3000;
                        tacocount = tacocount - 1;

                        System.out.println((i + 1) + " 번 손님 현재 가지고 있는 돈이 부족해서 대출 받으셔야 합니다");
                        System.out.println("타코야키 구매를 실패해서 현재 남은 금액 " + money[i] + " 원 입니다");

                        System.out.println();
                        System.out.println("자동으로 대출메뉴로 넘어갑니다");
                        System.out.println();

                        System.out.println((i + 1) + " 번 손님의 다음 손님에게 대출 받습니다");
                        System.out.println((i + 1) + " 번 손님 대출 받으실 금액을 입력하세요");
                        bank = enter.nextInt();

                        customer = i + 2;
                        humancount[customer - 1] = humancount[customer - 1] + 1;
                        money[i] = money[i] + bank;
                        money[customer - 1] = money[customer - 1] - bank;
                        borrowmoney[i] = borrowmoney[i] + bank;
                        borrowmoney1[i] = borrowmoney1[i] + bank;
                        lendmoney[customer - 1] = lendmoney[customer - 1] + bank;
                        unpaid[customer - 1] = lendmoney[customer - 1];
                        //System.out.printf("\nborrowmoney (빚 진 금액 ) [%d] = %d\n", i + 1, borrowmoney[i]);
                        //System.out.printf("\nlendmoney (빌려준 금액 ) [%d] = %d\n", customer, lendmoney[customer - 1]);
                        //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank);

                        //System.out.println("이전손님");
                        //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                        //System.out.println("다음 손님");
                        //System.out.printf("\nmoney[%d] = %d\n", customer, money[customer - 1]);

                        System.out.printf("\n%d번 손님이 %d번 손님에게 %d원을 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer, bank, money[i]);
                        System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer, i + 1, bank, money[customer - 1]);

                        while (true)
                        {
                            System.out.println("1. 더 빌린다, 2. 빌리지 않는다");
                            choice = enter.nextInt();

                            if (choice == 1)
                            {
                                customer1 = i + 3;
                                humancount[customer1 - 1] = humancount[customer1 - 1] + 1;
                                System.out.println("자동으로 " + customer1 + " 번 손님에게 대출 받습니다");
                                System.out.println();
                                System.out.println((i + 1) + " 번 손님 추가로 대출 받으실 금액을 입력하세요");
                                bank2 = enter.nextInt();

                                money[i] = money[i] + bank2;
                                borrowmoney[i] = borrowmoney[i] + bank2;
                                borrowmoney1[i] = borrowmoney1[i] + bank2;
                                money[customer1 - 1] = money[customer1 - 1] - bank2;
                                lendmoney[customer1 - 1] = lendmoney[customer1 - 1] + bank2;
                                unpaid[customer1 - 1] = lendmoney[customer1 - 1];

                                //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank2);

                                //System.out.println("이전손님");
                                //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                //System.out.println("다음 손님");
                                //System.out.printf("\nmoney[%d] = %d\n", customer1, money[customer1 - 1]);

                                System.out.printf("\n%d번 손님이 %d번 손님에게 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer1, money[i]);
                                System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer1, i + 1, bank2, money[customer1 - 1]);
                            }

                            if (choice == 2)
                            {
                                System.out.println();
                                System.out.println("대출 시스템을 종료하고 메인 메뉴로 돌아갑니다");
                                System.out.println();
                                break;
                            }
                        }
                    }

                    System.out.println();
                    System.out.println((i + 1) + " 번째 손님이 타코야키를 구매해서 현재 남은 금액 " + money[i] + " 원 입니다");
                }

                if (menuselect.equals(equalsramen) == true)
                {
                    money[i] = money[i] - 3000;
                    //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                    ramen[i] = ramen[i] + 1;
                    ramenmoney[i] = ramenmoney[i] + 3000;
                    //System.out.printf("\nramen[%d] = %d\n", i + 1, ramen[i]);
                    //System.out.printf("\nramenmoney[%d] = %d\n", i + 1, ramenmoney[i]);
                    ramencount = ramencount + 1 ;
                    //System.out.printf("\nramencount = %d\n", ramencount);

                    if (money[i] <= 0)
                    {
                        humancount1[i] = humancount1[i] + 1;
                        exitcount[i] = exitcount[i] + 1;
                        money[i] = money[i] + 3000;
                        ramen[i] = ramen[i] - 1;
                        ramenmoney[i] = ramenmoney[i] - 3000;
                        ramencount = ramencount - 1;

                        System.out.println((i + 1) + " 번 손님 현재 가지고 있는 돈이 부족해서 대출을 받으셔야 합니다");
                        System.out.println("라면 구매를 실패해서 현재 남은 금액 " + money[i] + " 원 입니다");

                        System.out.println();
                        System.out.println("자동으로 대출메뉴로 넘어갑니다");
                        System.out.println();

                        System.out.println((i + 1) + " 번 손님의 다음 손님에게 대출 받습니다");
                        System.out.println((i + 1) + " 번 손님 대출 받으실 금액을 입력하세요");
                        bank = enter.nextInt();

                        customer = i + 2;
                        humancount[customer - 1] = humancount[customer - 1] + 1;
                        money[i] = money[i] + bank;
                        money[customer - 1] = money[customer - 1] - bank;
                        borrowmoney[i] = borrowmoney[i] + bank;
                        borrowmoney1[i] = borrowmoney1[i] + bank;
                        lendmoney[customer - 1] = lendmoney[customer - 1] + bank;
                        unpaid[customer - 1] = lendmoney[customer - 1];
                        //System.out.printf("\nborrowmoney (빚 진 금액 ) [%d] = %d\n", i + 1, borrowmoney[i]);
                        //System.out.printf("\nlendmoney (빌려준 금액 ) [%d] = %d\n", customer, lendmoney[customer - 1]);
                        //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank);

                        //System.out.println("이전손님");
                        //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                        //System.out.println("다음 손님");
                        //System.out.printf("\nmoney[%d] = %d\n", customer, money[customer - 1]);

                        System.out.printf("\n%d번 손님이 %d번 손님에게 %d원을 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer, bank, money[i]);
                        System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer, i + 1, bank, money[customer - 1]);

                        while (true)
                        {
                            System.out.println("1. 더 빌린다, 2. 빌리지 않는다");
                            choice = enter.nextInt();

                            if (choice == 1)
                            {
                                customer1 = i + 3;
                                humancount[customer1 - 1] = humancount[customer1 - 1] + 1;
                                System.out.println("자동으로 " + customer1 + " 번 손님에게 대출 받습니다");
                                System.out.println();
                                System.out.println((i + 1) + " 번 손님 추가로 대출 받으실 금액을 입력하세요");
                                bank2 = enter.nextInt();

                                money[i] = money[i] + bank2;
                                borrowmoney[i] = borrowmoney[i] + bank2;
                                borrowmoney1[i] = borrowmoney1[i] + bank2;
                                money[customer1 - 1] = money[customer1 - 1] - bank2;
                                lendmoney[customer1 - 1] = lendmoney[customer1 - 1] + bank2;
                                unpaid[customer1 - 1] = lendmoney[customer1 - 1];

                                //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank2);

                                //System.out.println("이전손님");
                                //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                //System.out.println("다음 손님");
                                //System.out.printf("\nmoney[%d] = %d\n", customer1, money[customer1 - 1]);

                                System.out.printf("\n%d번 손님이 %d번 손님에게 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer1, money[i]);
                                System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer1, i + 1, bank2, money[customer1 - 1]);
                            }

                            if (choice == 2)
                            {
                                System.out.println();
                                System.out.println("대출 시스템을 종료하고 메인 메뉴로 돌아갑니다");
                                System.out.println();
                                break;
                            }
                        }
                    }

                    System.out.println();
                    System.out.println((i + 1) + " 번째 손님이 라면을 구매해서 현재 남은 금액 " + money[i] + " 원 입니다");
                }

                if (menuselect.equals(equalsudong) == true)
                {
                    money[i] = money[i] - 3000;
                    //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                    udong[i] = udong[i] + 1;
                    udongmoney[i] = udongmoney[i] + 3000;
                    //System.out.printf("\nudong[%d] = %d\n", i + 1, udong[i]);
                    //System.out.printf("\nudongmoney[%d] = %d\n", i + 1, udongmoney[i]);
                    udongcount = udongcount + 1;
                    //System.out.printf("\nudongcount = %d\n", udongcount);

                    if (money[i] <= 0)
                    {
                        humancount1[i] = humancount1[i] + 1;
                        exitcount[i] = exitcount[i] + 1;
                        money[i] = money[i] + 3000;
                        udong[i] = udong[i] - 1;
                        udongmoney[i] = udongmoney[i] - 3000;
                        udongcount = udongcount - 1;

                        System.out.println((i + 1) + " 번 손님 현재 가지고 있는 돈이 부족해서 대출 받으셔야 합니다");
                        System.out.println("우동 구매를 실패해서 현재 남은 금액 " + money[i] + " 원 입니다");

                        System.out.println();
                        System.out.println("자동으로 대출메뉴로 넘어갑니다");
                        System.out.println();

                        System.out.println((i + 1) + " 번 손님의 다음 손님에게 대출 받습니다");
                        System.out.println((i + 1) + " 번 손님 대출 받으실 금액을 입력하세요");
                        bank = enter.nextInt();

                        customer = i + 2;
                        humancount[customer - 1] = humancount[customer - 1] + 1;
                        money[i] = money[i] + bank;
                        money[customer - 1] = money[customer - 1] - bank;
                        borrowmoney[i] = borrowmoney[i] + bank;
                        borrowmoney1[i] = borrowmoney1[i] + bank;
                        lendmoney[customer - 1] = lendmoney[customer - 1] + bank;
                        unpaid[customer - 1] = lendmoney[customer - 1];
                        //System.out.printf("\nborrowmoney (빚 진 금액 ) [%d] = %d\n", i + 1, borrowmoney[i]);
                        //System.out.printf("\nlendmoney (빌려준 금액 ) [%d] = %d\n", customer, lendmoney[customer - 1]);
                        //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank);

                        //System.out.println("이전손님");
                        //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                        //System.out.println("다음 손님");
                        //System.out.printf("\nmoney[%d] = %d\n", customer, money[customer - 1]);

                        System.out.printf("\n%d번 손님이 %d번 손님에게 %d원을 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer, bank, money[i]);
                        System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer, i + 1, bank, money[customer - 1]);

                        while (true)
                        {
                            System.out.println("1. 더 빌린다, 2. 빌리지 않는다");
                            choice = enter.nextInt();

                            if (choice == 1)
                            {
                                customer1 = i + 3;
                                humancount[customer1 - 1] = humancount[customer1 - 1] + 1;
                                System.out.println("자동으로 " + customer1 + " 번 손님에게 대출 받습니다");
                                System.out.println();
                                System.out.println((i + 1) + " 번 손님 추가로 대출 받으실 금액을 입력하세요");
                                bank2 = enter.nextInt();

                                money[i] = money[i] + bank2;
                                borrowmoney[i] = borrowmoney[i] + bank2;
                                borrowmoney1[i] = borrowmoney1[i] + bank2;
                                money[customer1 - 1] = money[customer1 - 1] - bank2;
                                lendmoney[customer1 - 1] = lendmoney[customer1 - 1] + bank2;
                                unpaid[customer1 - 1] = lendmoney[customer1 - 1];

                                //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank2);

                                //System.out.println("이전손님");
                                //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                //System.out.println("다음 손님");
                                //System.out.printf("\nmoney[%d] = %d\n", customer1, money[customer1 - 1]);

                                System.out.printf("\n%d번 손님이 %d번 손님에게 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer1, money[i]);
                                System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer1, i + 1, bank2, money[customer1 - 1]);
                            }

                            if (choice == 2)
                            {
                                System.out.println();
                                System.out.println("대출 시스템을 종료하고 메인 메뉴로 돌아갑니다");
                                System.out.println();
                                break;
                            }
                        }
                    }

                    System.out.println();
                    System.out.println((i + 1) + " 번째 손님이 우동을 구매해서 현재 남은 금액 " + money[i] + " 원 입니다");
                }

                if (menuselect.equals(equalshwanbul) == true)
                {
                    System.out.println();
                    System.out.println("환불 할 메뉴를 선택하세요");
                    System.out.println();
                    System.out.println("1. 치킨, 2. 피자, 3. 타코야키, 4. 라면, 5. 우동");
                    refund = enter.next();

                    if (refund.equals(equalschicken) == true)
                    {
                        System.out.println("치킨 몇 개를 환불 하시겠습니까?");
                        refundcnt = enter.nextInt();

                        fund = refundcnt * 5000;

                        money[i] = money[i] + fund;

                        System.out.println((i + 1) + " 번 손님 치킨 " + refundcnt + " 개를 환불해서 현재 남은 금액 " + money[i] + " 원 입니다");
                    }

                    if (refund.equals(equalspizza) == true)
                    {
                        System.out.println("피자 몇 개를 환불 하시겠습니까?");
                        refundcnt = enter.nextInt();

                        fund = refundcnt * 5000;

                        money[i] = money[i] + fund;

                        System.out.println((i + 1) + " 번 손님 피자 " + refundcnt + " 개를 환불해서 현재 남은 금액 " + money[i] + " 원 입니다");
                    }

                    if (refund.equals(equalstaco) == true)
                    {
                        System.out.println("타코야키 몇 개를 환불 하시겠습니까?");
                        refundcnt = enter.nextInt();

                        fund = refundcnt * 3000;

                        money[i] = money[i] + fund;

                        System.out.println((i + 1) + " 번 손님 타코야키 " + refundcnt + " 개를 환불해서 현재 남은 금액 " + money[i] + " 원 입니다");
                    }

                    if (refund.equals(equalsramen) == true)
                    {
                        System.out.println("라면 몇 개를 환불 하시겠습니까?");
                        refundcnt = enter.nextInt();

                        fund = refundcnt * 3000;

                        money[i] = money[i] + fund;

                        System.out.println((i + 1) + " 번 손님 라면 " + refundcnt + " 개를 환불해서 현재 남은 금액 " + money[i] + " 원 입니다");
                    }

                    if (refund.equals(equalsudong) == true)
                    {
                        System.out.println("우동 몇 개를 환불 하시겠습니까?");
                        refundcnt = enter.nextInt();

                        fund = refundcnt * 3000;

                        money[i] = money[i] + fund;
                        System.out.println((i + 1) + " 번 손님 우동 " + refundcnt + " 개를 환불해서 현재 남은 금액 " + money[i] + " 원 입니다");
                    }
                }

                if (menuselect.equals(equalsloan) == true)
                {
                    System.out.println((i + 1) + " 번 손님의 다음 손님에게 대출 받습니다");
                    System.out.println((i + 1) + " 번 손님 대출 받으실 금액을 입력하세요");
                    bank = enter.nextInt();

                    humancount1[i] = humancount1[i] + 1;
                    exitcount[i] = exitcount[i] + 1;
                    customer = i + 2;
                    humancount[customer - 1] = humancount[customer - 1] + 1;
                    money[i] = money[i] + bank;
                    money[customer - 1] = money[customer - 1] - bank;
                    borrowmoney[i] = borrowmoney[i] + bank;
                    borrowmoney1[i] = borrowmoney1[i] + bank;
                    lendmoney[customer - 1] = lendmoney[customer - 1] + bank;
                    unpaid[customer - 1] = lendmoney[customer - 1];
                    //System.out.printf("\nborrowmoney (빚 진 금액 ) [%d] = %d\n", i + 1, borrowmoney[i]);
                    //System.out.printf("\nlendmoney (빌려준 금액 ) [%d] = %d\n", customer, lendmoney[customer - 1]);
                    //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank);

                    //System.out.println("이전손님");
                    //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                    //System.out.println("다음 손님");
                    //System.out.printf("\nmoney[%d] = %d\n", customer, money[customer - 1]);

                    System.out.printf("\n%d번 손님이 %d번 손님에게 %d원을 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer, bank, money[i]);
                    System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer, i + 1, bank, money[customer - 1]);

                    while (true)
                    {
                        System.out.println("1. 더 빌린다, 2. 빌리지 않는다");
                        choice = enter.nextInt();

                        if (choice == 1)
                        {
                            customer1 = i + 3;
                            humancount[customer1 - 1] = humancount[customer1 - 1] + 1;
                            System.out.println("자동으로 " + customer1 + " 번 손님에게 대출 받습니다");
                            System.out.println();
                            System.out.println((i + 1) + " 번 손님 추가로 대출 받으실 금액을 입력하세요");
                            bank2 = enter.nextInt();

                            money[i] = money[i] + bank2;
                            borrowmoney[i] = borrowmoney[i] + bank2;
                            borrowmoney1[i] = borrowmoney1[i] + bank2;
                            money[customer1 - 1] = money[customer1 - 1] - bank2;
                            lendmoney[customer1 - 1] = lendmoney[customer1 - 1] + bank2;
                            unpaid[customer1 - 1] = lendmoney[customer1 - 1];

                            //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank2);

                            //System.out.println("이전손님");
                            //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                            //System.out.println("다음 손님");
                            //System.out.printf("\nmoney[%d] = %d\n", customer1, money[customer1 - 1]);

                            System.out.printf("\n%d번 손님이 %d번 손님에게 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer1, money[i]);
                            System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer1, i + 1, bank2, money[customer1 - 1]);
                        }

                        if (choice == 2)
                        {
                            System.out.println();
                            System.out.println("대출 시스템을 종료하고 메인 메뉴로 돌아갑니다");
                            System.out.println();
                            break;
                        }
                    }
                }

                if (menuselect.equals(equalspayback) == true)
                {
                    exitcount[i] = 0;
                    customer = i + 2;
                    customer1 = i + 3;
                    System.out.println("대출 상환 메뉴 입니다");
                    System.out.println((i + 1) + " 번 손님 " + customer + " 번 손님에게 상환힙니다");
                    System.out.println("얼마를 상환 하시겠습니까?");
                    returnloan = enter.nextInt();

                    //System.out.printf("\n\n(대출 받은 돈) bank = %d\n\n", bank);

                    money[i] = money[i] - returnloan;
                    //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                    money[customer - 1] = money[customer - 1] + returnloan;
                    //System.out.printf("\nmoney[%d] = %d\n", customer, money[customer - 1]);
                    borrowmoney1[i] = borrowmoney1[i] - returnloan;
                    payoff[i] = borrowmoney1[i];
                    //System.out.printf("\n(갚고 남은 금액) payoff[%d] = %d\n", i + 1, payoff[i]);
                    minab = bank - returnloan;
                    //System.out.printf("\n(미납금액) minab = %d\n", minab);
                    unpaid[customer - 1] = minab;
                    //System.out.printf("\n (미납금액) unpaid[%d] = %d\n", i + 1, unpaid[customer - 1]);

                    System.out.printf("\n%d번 손님 %d번 손님에게 %d원을 상환해서 %d원이 남았습니다다\n", i + 1, customer, returnloan, money[i]);
                    System.out.printf("\n%d번 손님 %d번 손님에게 %d원을 받아서 %d원이 남았습니다\n", customer, i + 1, returnloan, money[customer - 1]);

                    if (lendmoney[customer1 - 1] > 0)
                    {
                        customer = i + 2;
                        customer1 = i + 3;
                        //System.out.println("i = " + i);
                        System.out.println((i + 1) + " 번 손님 " + customer1 + " 번 손님에게도 대출 받은 이력이 있어서 상환 해야 됩니다");
                        System.out.println("얼마를 상환 하시겠습니까?");
                        returnloan1 = enter.nextInt();

                        money[i] = money[i] - returnloan1;
                        //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                        money[customer1 - 1] = money[customer1 - 1] + returnloan1;
                        //System.out.printf("\nmoney[%d] = %d\n", customer1, money[customer1 - 1]);
                        borrowmoney1[i] = borrowmoney1[i] - returnloan1;
                        payoff[i] = borrowmoney1[i];
                        //System.out.printf("\n(갚고 남은 금액) payoff[%d] = %d\n", i + 1, payoff[i]);
                        minab = bank2 - returnloan1;
                        //System.out.printf("\nminab = %d\n", minab);
                        unpaid[customer1 - 1] = minab;
                        //System.out.printf("\n(미납금액) unpaid[%d] = %d\n", customer1, unpaid[customer1 - 1]);

                        System.out.printf("\n%d번 손님 %d번 손님에게 %d원을 상환해서 %d원이 남았습니다\n", i + 1, customer1, returnloan1, money[i]);
                        System.out.printf("\n%d번 손님 %d번 손님에게 %d원을 받아서 %d원이 남았습니다\n", customer1, i + 1, returnloan1, money[customer1 - 1]);
                    }
                }

                if (menuselect.equals(equalsnext) == true)
                {
                    System.out.println((i + 1) + " 번 손님에서 다음 손님으로 넘어갑니다");
                    i = i + 1;
                    System.out.println((i + 1) + " 번 손님으로 넘어갑니다");
                }

                if (menuselect.equals(equalschoice) == true)
                {
                    System.out.println("몇 번째 손님을 선택 하시겠습니까?");
                    human = enter.nextInt();
                    System.out.println(human + " 번 손님으로 넘어갑니다");
                    i = human - 1;
                }


                if (menuselect.equals(equalsexit) == true)
                {
                    System.out.println("======= 주문표 =======");
                    System.out.println();

                    chickenprice = chickencount * 5000;

                    if (chickencount > 0)
                    {
                        System.out.printf("\n치킨 x %d = %d\n", chickencount, chickenprice);
                    }

                    pizzaprice = pizzacount * 5000;


                    if (pizzacount > 0)
                    {
                        System.out.printf("\n피자 x %d = %d\n", pizzacount, pizzaprice);
                    }

                    tacoprice = tacocount * 3000;

                    if (tacocount > 0)
                    {
                        System.out.printf("\n타코야키 x %d = %d\n", tacocount, tacoprice);
                    }

                    ramenprice = ramencount * 3000;

                    if (ramencount > 0)
                    {
                        System.out.printf("\n라면 x %d = %d\n", ramencount, ramenprice);
                    }

                    udongprice = udongcount * 3000;

                    if (udongcount > 0)
                    {
                        System.out.printf("\n우동 x %d = %d\n", udongcount, udongprice);
                    }

                    aaa = 1;

                    for (int q = 0; q <= 15; q++)
                    {
                        if (humancount[q] > 0)
                        {
                            System.out.println();
                            System.out.println("======= " + (aaa) + " 번째 손님 =======");
                            System.out.println("원래 가지고 있던 금액 = " + firstmoney[q]);

                            if (chicken[q] > 0)
                            {
                                System.out.printf("\n치킨 x %d = %d원\n", chicken[q], chickenmoney[q]);
                            }

                            if (pizza[q] > 0)
                            {
                                System.out.printf("\n피자 x %d = %d\n", pizza[q], pizzamoney[q]);
                            }

                            if (taco[q] > 0)
                            {
                                System.out.printf("\n타코야키 x %d = %d\n", taco[q], tacomoney[q]);
                            }

                            if (ramen[q] > 0)
                            {
                                System.out.printf("\n라면 x %d = %d\n", ramen[q], ramenmoney[q]);
                            }

                            if (udong[q] > 0)
                            {
                                System.out.printf("\n우동 x %d = %d\n", udong[q], udongmoney[q]);
                            }

                            System.out.println();
                            System.out.println("현재 가지고 있는 금액 = " + money[q] + " 원");
                            System.out.println("빚 진 금액 = " + borrowmoney[q] + " 원");
                            System.out.println("빚 진 금액에서 상환 후 남은 금액 = " + payoff[q] + " 원");
                            System.out.println("미납된 금액 = " + unpaid[q] + " 원");
                            System.out.println("빌려준 금액 = " + lendmoney[q] + " 원");


                            member = new Member(aaa, chickenmoney[q], pizzamoney[q], tacomoney[q], ramenmoney[q], udongmoney[q], firstmoney[q],
                                    money[q], chicken[q], pizza[q], taco[q], ramen[q], udong[q], borrowmoney[q], payoff[q], unpaid[q], lendmoney[q]);
                            member = memberService.save(member);
                            System.out.println(member.toString());

                            aaa++;
                        }
                    }

                    while (true)
                    {
                        System.out.println();
                        System.out.println("쇼핑이 끝났습니다 메뉴를 선택하세요");
                        System.out.println("1. 종료, 2. 조회, 3. 수정, 4. 삭제");
                        lastmenu = enter.next();

                        if (lastmenu.equals(equalsexit) == true)
                        {
                            System.out.println("프로그램을 종료합니다");
                            System.exit(1);
                        }

                        if (lastmenu.equals(equalscheck) == true)
                        {
                            System.out.println();
                            System.out.println("조회 할 고객 아이디 번호를 입력하세요");
                            check = enter.nextInt();

                            System.out.println("======= 조회 =======");
                            member = memberService.findById(check);
                            System.out.println(member.toString());

                        }

                        if (lastmenu.equals(equalsupdate) == true)
                        {
                            System.out.println();
                            System.out.println("수정 할 고객을 선택하세요");
                            human = enter.nextInt();
                            i = human - 1;
                            while (true)
                            {
                                System.out.println("메뉴를 선택하세요");
                                System.out.println("[1. 치킨, 2. 피자, 3. 타코야키, 4. 라면, 5. 우동, 6. 환불, 7. 돌아가기");
                                menuselect = enter.next();

                                if (menuselect.equals(equalschicken) == true)
                                {
                                    money[i] = money[i] - 5000;
                                    //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                    chicken[i] = chicken[i] + 1;
                                    chickenmoney[i] = chickenmoney[i] + 5000;
                                    //System.out.printf("\nchicken[%d] = %d\n", i + 1, chicken[i]);
                                    //System.out.printf("\nchickenmoney[%d] = %d\n", i + 1, chickenmoney[i]);
                                    chickencount = chickencount + 1;
                                    //System.out.printf("\nchicount = %d\n", chickencount);

                                    if (money[i] <= 0)
                                    {
                                        humancount1[i] = humancount1[i] + 1;
                                        money[i] = money[i] + 5000;
                                        //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                        chicken[i] = chicken[i] - 1;
                                        chickenmoney[i] = chickenmoney[i] - 5000;
                                        //System.out.printf("\nchicken[%d] = %d\n", i + 1, chicken[i]);
                                        //System.out.printf("\nchickenmoney[%d] = %d\n", i + 1, chickenmoney[i]);
                                        chickencount = chickencount - 1;
                                        //System.out.printf("\nchicount = %d\n", chickencount);

                                        System.out.println((i + 1) + " 번 손님 현재 가지고 있는 돈이 부족해서 대출 받으셔야 합니다");
                                        System.out.println("치킨 구매를 실패해서 현재 남은 금액 " + money[i] + " 원 입니다");

                                        System.out.println();
                                        System.out.println("자동으로 대출메뉴로 넘어갑니다");
                                        System.out.println();

                                        System.out.println((i + 1) + " 번 손님의 다음 손님에게 대출 받습니다");
                                        System.out.println((i + 1) + " 번 손님 대출 받으실 금액을 입력하세요");
                                        bank = enter.nextInt();

                                        customer = i + 2;
                                        humancount[customer - 1] = humancount[customer - 1] + 1;
                                        money[i] = money[i] + bank;
                                        money[customer - 1] = money[customer - 1] - bank;
                                        borrowmoney[i] = borrowmoney[i] + bank;
                                        lendmoney[customer - 1] = lendmoney[customer - 1] + bank;
                                        unpaid[customer - 1] = lendmoney[customer - 1];
                                        //System.out.printf("\nborrowmoney (빚 진 금액 ) [%d] = %d\n", i + 1, borrowmoney[i]);
                                        //System.out.printf("\nlendmoney (빌려준 금액 ) [%d] = %d\n", customer, lendmoney[customer - 1]);
                                        //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank);

                                        //System.out.println("이전손님");
                                        //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                        //System.out.println("다음 손님");
                                        //System.out.printf("\nmoney[%d] = %d\n", customer, money[customer - 1]);

                                        System.out.printf("\n%d번 손님이 %d번 손님에게 %d원을 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer, bank, money[i]);
                                        System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer, i + 1, bank, money[customer - 1]);

                                        while (true)
                                        {
                                            System.out.println("1. 더 빌린다, 2. 빌리지 않는다");
                                            choice = enter.nextInt();

                                            if (choice == 1)
                                            {
                                                customer1 = i + 3;
                                                humancount[customer1 - 1] = humancount[customer1 - 1] + 1;
                                                System.out.println("자동으로 " + customer1 + " 번 손님에게 대출 받습니다");
                                                System.out.println();
                                                System.out.println((i + 1) + " 번 손님 추가로 대출 받으실 금액을 입력하세요");
                                                bank2 = enter.nextInt();

                                                money[i] = money[i] + bank2;
                                                borrowmoney[i] = borrowmoney[i] + bank2;
                                                money[customer1 - 1] = money[customer1 - 1] - bank2;
                                                lendmoney[customer1 - 1] = lendmoney[customer1 - 1] + bank2;
                                                unpaid[customer1 - 1] = lendmoney[customer1 - 1];

                                                //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank2);

                                                //System.out.println("이전손님");
                                                //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                                //System.out.println("다음 손님");
                                                //System.out.printf("\nmoney[%d] = %d\n", customer1, money[customer1 - 1]);

                                                System.out.printf("\n%d번 손님이 %d번 손님에게 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer1, money[i]);
                                                System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer1, i + 1, bank2, money[customer1 - 1]);
                                            }

                                            if (choice == 2)
                                            {
                                                System.out.println();
                                                System.out.println("대출 시스템을 종료하고 메인 메뉴로 돌아갑니다");
                                                System.out.println();
                                                break;
                                            }
                                        }
                                    }

                                    System.out.println();
                                    System.out.println((i + 1) + " 번째 손님이 치킨을 구매해서 현재 남은 금액 " + money[i] + " 원 입니다");
                                }

                                if (menuselect.equals(equalspizza) == true)
                                {
                                    money[i] = money[i] - 5000;
                                    //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                    pizza[i] = pizza[i] + 1;
                                    pizzamoney[i] = pizzamoney[i] + 5000;
                                    //System.out.printf("\npizza[%d] = %d\n", i + 1, pizza[i]);
                                    //System.out.printf("\npizzamoney[%d] = %d\n", i + 1, pizzamoney[i]);
                                    pizzacount = pizzacount + 1;
                                    //System.out.printf("pizzacount = %d\n", pizzacount);

                                    if (money[i] <= 0)
                                    {
                                        humancount1[i] = humancount1[i] + 1;
                                        money[i] = money[i] + 5000;
                                        pizza[i] = pizza[i] - 1;
                                        pizzamoney[i] = pizzamoney[i] - 5000;
                                        pizzacount = pizzacount - 1;

                                        System.out.println((i + 1) + " 번 손님 현재 가지고 있는 돈이 부족해서 대출 받으셔야 합니다");
                                        System.out.println("피자 구매를 실패해서 현재 남은 금액 " + money[i] + " 원 입니다");

                                        System.out.println();
                                        System.out.println("자동으로 대출메뉴로 넘어갑니다");
                                        System.out.println();

                                        System.out.println((i + 1) + " 번 손님의 다음 손님에게 대출 받습니다");
                                        System.out.println((i + 1) + " 번 손님 대출 받으실 금액을 입력하세요");
                                        bank = enter.nextInt();

                                        customer = i + 2;
                                        humancount[customer - 1] = humancount[customer - 1] + 1;
                                        money[i] = money[i] + bank;
                                        money[customer - 1] = money[customer - 1] - bank;
                                        borrowmoney[i] = borrowmoney[i] + bank;
                                        lendmoney[customer - 1] = lendmoney[customer - 1] + bank;
                                        unpaid[customer - 1] = lendmoney[customer - 1];
                                        //System.out.printf("\nborrowmoney (빚 진 금액 ) [%d] = %d\n", i + 1, borrowmoney[i]);
                                        //System.out.printf("\nlendmoney (빌려준 금액 ) [%d] = %d\n", customer, lendmoney[customer - 1]);
                                        //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank);

                                        //System.out.println("이전손님");
                                        //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                        //System.out.println("다음 손님");
                                        //System.out.printf("\nmoney[%d] = %d\n", customer, money[customer - 1]);

                                        System.out.printf("\n%d번 손님이 %d번 손님에게 %d원을 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer, bank, money[i]);
                                        System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer, i + 1, bank, money[customer - 1]);

                                        while (true)
                                        {
                                            System.out.println("1. 더 빌린다, 2. 빌리지 않는다");
                                            choice = enter.nextInt();

                                            if (choice == 1)
                                            {
                                                customer1 = i + 3;
                                                humancount[customer1 - 1] = humancount[customer1 - 1] + 1;
                                                System.out.println("자동으로 " + customer1 + " 번 손님에게 대출 받습니다");
                                                System.out.println();
                                                System.out.println((i + 1) + " 번 손님 추가로 대출 받으실 금액을 입력하세요");
                                                bank2 = enter.nextInt();

                                                money[i] = money[i] + bank2;
                                                borrowmoney[i] = borrowmoney[i] + bank2;
                                                money[customer1 - 1] = money[customer1 - 1] - bank2;
                                                lendmoney[customer1 - 1] = lendmoney[customer1 - 1] + bank2;
                                                unpaid[customer1 - 1] = lendmoney[customer1 - 1];

                                                //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank2);

                                                //System.out.println("이전손님");
                                                //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                                //System.out.println("다음 손님");
                                                //System.out.printf("\nmoney[%d] = %d\n", customer1, money[customer1 - 1]);

                                                System.out.printf("\n%d번 손님이 %d번 손님에게 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer1, money[i]);
                                                System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer1, i + 1, bank2, money[customer1 - 1]);
                                            }

                                            if (choice == 2)
                                            {
                                                System.out.println();
                                                System.out.println("대출 시스템을 종료하고 메인 메뉴로 돌아갑니다");
                                                System.out.println();
                                                break;
                                            }
                                        }
                                    }

                                    System.out.println();
                                    System.out.println((i + 1) + " 번째 손님이 피자를 구매해서 현재 남은 금액 " + money[i] + " 원 입니다");
                                }

                                if (menuselect.equals(equalstaco) == true)
                                {
                                    money[i] = money[i] - 3000;
                                    //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                    taco[i] = taco[i] + 1;
                                    tacomoney[i] = tacomoney[i] + 3000;
                                    //System.out.printf("\ntaco[%d] = %d\n", i + 1, taco[i]);
                                    //System.out.printf("\ntacomoney[%d] = %d\n", i + 1, tacomoney[i]);
                                    tacocount = tacocount + 1;
                                    //System.out.printf("\ntacocount = %d\n", tacocount);

                                    if (money[i] <= 0)
                                    {
                                        humancount1[i] = humancount1[i] + 1;
                                        money[i] = money[i] + 3000;
                                        taco[i] = taco[i] - 1;
                                        tacomoney[i] = tacomoney[i] - 3000;
                                        tacocount = tacocount - 1;

                                        System.out.println((i + 1) + " 번 손님 현재 가지고 있는 돈이 부족해서 대출 받으셔야 합니다");
                                        System.out.println("타코야키 구매를 실패해서 현재 남은 금액 " + money[i] + " 원 입니다");

                                        System.out.println();
                                        System.out.println("자동으로 대출메뉴로 넘어갑니다");
                                        System.out.println();

                                        System.out.println((i + 1) + " 번 손님의 다음 손님에게 대출 받습니다");
                                        System.out.println((i + 1) + " 번 손님 대출 받으실 금액을 입력하세요");
                                        bank = enter.nextInt();

                                        customer = i + 2;
                                        humancount[customer - 1] = humancount[customer - 1] + 1;
                                        money[i] = money[i] + bank;
                                        money[customer - 1] = money[customer - 1] - bank;
                                        borrowmoney[i] = borrowmoney[i] + bank;
                                        lendmoney[customer - 1] = lendmoney[customer - 1] + bank;
                                        unpaid[customer - 1] = lendmoney[customer - 1];
                                        //System.out.printf("\nborrowmoney (빚 진 금액 ) [%d] = %d\n", i + 1, borrowmoney[i]);
                                        //System.out.printf("\nlendmoney (빌려준 금액 ) [%d] = %d\n", customer, lendmoney[customer - 1]);
                                        //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank);

                                        //System.out.println("이전손님");
                                        //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                        //System.out.println("다음 손님");
                                        //System.out.printf("\nmoney[%d] = %d\n", customer, money[customer - 1]);

                                        System.out.printf("\n%d번 손님이 %d번 손님에게 %d원을 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer, bank, money[i]);
                                        System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer, i + 1, bank, money[customer - 1]);

                                        while (true)
                                        {
                                            System.out.println("1. 더 빌린다, 2. 빌리지 않는다");
                                            choice = enter.nextInt();

                                            if (choice == 1)
                                            {
                                                customer1 = i + 3;
                                                humancount[customer1 - 1] = humancount[customer1 - 1] + 1;
                                                System.out.println("자동으로 " + customer1 + " 번 손님에게 대출 받습니다");
                                                System.out.println();
                                                System.out.println((i + 1) + " 번 손님 추가로 대출 받으실 금액을 입력하세요");
                                                bank2 = enter.nextInt();

                                                money[i] = money[i] + bank2;
                                                borrowmoney[i] = borrowmoney[i] + bank2;
                                                money[customer1 - 1] = money[customer1 - 1] - bank2;
                                                lendmoney[customer1 - 1] = lendmoney[customer1 - 1] + bank2;
                                                unpaid[customer1 - 1] = lendmoney[customer1 - 1];

                                                //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank2);

                                                //System.out.println("이전손님");
                                                //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                                //System.out.println("다음 손님");
                                                //System.out.printf("\nmoney[%d] = %d\n", customer1, money[customer1 - 1]);

                                                System.out.printf("\n%d번 손님이 %d번 손님에게 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer1, money[i]);
                                                System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer1, i + 1, bank2, money[customer1 - 1]);
                                            }

                                            if (choice == 2)
                                            {
                                                System.out.println();
                                                System.out.println("대출 시스템을 종료하고 메인 메뉴로 돌아갑니다");
                                                System.out.println();
                                                break;
                                            }
                                        }
                                    }

                                    System.out.println();
                                    System.out.println((i + 1) + " 번째 손님이 타코야키를 구매해서 현재 남은 금액 " + money[i] + " 원 입니다");
                                }

                                if (menuselect.equals(equalsramen) == true)
                                {
                                    money[i] = money[i] - 3000;
                                    //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                    ramen[i] = ramen[i] + 1;
                                    ramenmoney[i] = ramenmoney[i] + 3000;
                                    //System.out.printf("\nramen[%d] = %d\n", i + 1, ramen[i]);
                                    //System.out.printf("\nramenmoney[%d] = %d\n", i + 1, ramenmoney[i]);
                                    ramencount = ramencount + 1;
                                    //System.out.printf("\nramencount = %d\n", ramencount);

                                    if (money[i] <= 0)
                                    {
                                        humancount1[i] = humancount1[i] + 1;
                                        money[i] = money[i] + 3000;
                                        ramen[i] = ramen[i] - 1;
                                        ramenmoney[i] = ramenmoney[i] - 3000;
                                        ramencount = ramencount - 1;

                                        System.out.println((i + 1) + " 번 손님 현재 가지고 있는 돈이 부족해서 대출을 받으셔야 합니다");
                                        System.out.println("라면 구매를 실패해서 현재 남은 금액 " + money[i] + " 원 입니다");

                                        System.out.println();
                                        System.out.println("자동으로 대출메뉴로 넘어갑니다");
                                        System.out.println();

                                        System.out.println((i + 1) + " 번 손님의 다음 손님에게 대출 받습니다");
                                        System.out.println((i + 1) + " 번 손님 대출 받으실 금액을 입력하세요");
                                        bank = enter.nextInt();

                                        customer = i + 2;
                                        humancount[customer - 1] = humancount[customer - 1] + 1;
                                        money[i] = money[i] + bank;
                                        money[customer - 1] = money[customer - 1] - bank;
                                        borrowmoney[i] = borrowmoney[i] + bank;
                                        lendmoney[customer - 1] = lendmoney[customer - 1] + bank;
                                        unpaid[customer - 1] = lendmoney[customer - 1];
                                        //System.out.printf("\nborrowmoney (빚 진 금액 ) [%d] = %d\n", i + 1, borrowmoney[i]);
                                        //System.out.printf("\nlendmoney (빌려준 금액 ) [%d] = %d\n", customer, lendmoney[customer - 1]);
                                        //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank);

                                        //System.out.println("이전손님");
                                        //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                        //System.out.println("다음 손님");
                                        //System.out.printf("\nmoney[%d] = %d\n", customer, money[customer - 1]);

                                        System.out.printf("\n%d번 손님이 %d번 손님에게 %d원을 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer, bank, money[i]);
                                        System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer, i + 1, bank, money[customer - 1]);

                                        while (true)
                                        {
                                            System.out.println("1. 더 빌린다, 2. 빌리지 않는다");
                                            choice = enter.nextInt();

                                            if (choice == 1)
                                            {
                                                customer1 = i + 3;
                                                humancount[customer1 - 1] = humancount[customer1 - 1] + 1;
                                                System.out.println("자동으로 " + customer1 + " 번 손님에게 대출 받습니다");
                                                System.out.println();
                                                System.out.println((i + 1) + " 번 손님 추가로 대출 받으실 금액을 입력하세요");
                                                bank2 = enter.nextInt();

                                                money[i] = money[i] + bank2;
                                                borrowmoney[i] = borrowmoney[i] + bank2;
                                                money[customer1 - 1] = money[customer1 - 1] - bank2;
                                                lendmoney[customer1 - 1] = lendmoney[customer1 - 1] + bank2;
                                                unpaid[customer1 - 1] = lendmoney[customer1 - 1];

                                                //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank2);

                                                //System.out.println("이전손님");
                                                //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                                //System.out.println("다음 손님");
                                                //System.out.printf("\nmoney[%d] = %d\n", customer1, money[customer1 - 1]);

                                                System.out.printf("\n%d번 손님이 %d번 손님에게 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer1, money[i]);
                                                System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer1, i + 1, bank2, money[customer1 - 1]);
                                            }

                                            if (choice == 2)
                                            {
                                                System.out.println();
                                                System.out.println("대출 시스템을 종료하고 메인 메뉴로 돌아갑니다");
                                                System.out.println();
                                                break;
                                            }
                                        }
                                    }

                                    System.out.println();
                                    System.out.println((i + 1) + " 번째 손님이 라면을 구매해서 현재 남은 금액 " + money[i] + " 원 입니다");
                                }

                                if (menuselect.equals(equalsudong) == true)
                                {
                                    money[i] = money[i] - 3000;
                                    //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                    udong[i] = udong[i] + 1;
                                    udongmoney[i] = udongmoney[i] + 3000;
                                    //System.out.printf("\nudong[%d] = %d\n", i + 1, udong[i]);
                                    //System.out.printf("\nudongmoney[%d] = %d\n", i + 1, udongmoney[i]);
                                    udongcount = udongcount + 1;
                                    //System.out.printf("\nudongcount = %d\n", udongcount);

                                    if (money[i] <= 0)
                                    {
                                        humancount1[i] = humancount1[i] + 1;
                                        money[i] = money[i] + 3000;
                                        udong[i] = udong[i] - 1;
                                        udongmoney[i] = udongmoney[i] - 3000;
                                        udongcount = udongcount - 1;

                                        System.out.println((i + 1) + " 번 손님 현재 가지고 있는 돈이 부족해서 대출 받으셔야 합니다");
                                        System.out.println("우동 구매를 실패해서 현재 남은 금액 " + money[i] + " 원 입니다");

                                        System.out.println();
                                        System.out.println("자동으로 대출메뉴로 넘어갑니다");
                                        System.out.println();

                                        System.out.println((i + 1) + " 번 손님의 다음 손님에게 대출 받습니다");
                                        System.out.println((i + 1) + " 번 손님 대출 받으실 금액을 입력하세요");
                                        bank = enter.nextInt();

                                        customer = i + 2;
                                        humancount[customer - 1] = humancount[customer - 1] + 1;
                                        money[i] = money[i] + bank;
                                        money[customer - 1] = money[customer - 1] - bank;
                                        borrowmoney[i] = borrowmoney[i] + bank;
                                        lendmoney[customer - 1] = lendmoney[customer - 1] + bank;
                                        unpaid[customer - 1] = lendmoney[customer - 1];
                                        //System.out.printf("\nborrowmoney (빚 진 금액 ) [%d] = %d\n", i + 1, borrowmoney[i]);
                                        //System.out.printf("\nlendmoney (빌려준 금액 ) [%d] = %d\n", customer, lendmoney[customer - 1]);
                                        //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank);

                                        //System.out.println("이전손님");
                                        //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                        //System.out.println("다음 손님");
                                        //System.out.printf("\nmoney[%d] = %d\n", customer, money[customer - 1]);

                                        System.out.printf("\n%d번 손님이 %d번 손님에게 %d원을 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer, bank, money[i]);
                                        System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer, i + 1, bank, money[customer - 1]);

                                        while (true)
                                        {
                                            System.out.println("1. 더 빌린다, 2. 빌리지 않는다");
                                            choice = enter.nextInt();

                                            if (choice == 1)
                                            {
                                                customer1 = i + 3;
                                                humancount[customer1 - 1] = humancount[customer1 - 1] + 1;
                                                System.out.println("자동으로 " + customer1 + " 번 손님에게 대출 받습니다");
                                                System.out.println();
                                                System.out.println((i + 1) + " 번 손님 추가로 대출 받으실 금액을 입력하세요");
                                                bank2 = enter.nextInt();

                                                money[i] = money[i] + bank2;
                                                borrowmoney[i] = borrowmoney[i] + bank2;
                                                money[customer1 - 1] = money[customer1 - 1] - bank2;
                                                lendmoney[customer1 - 1] = lendmoney[customer1 - 1] + bank2;
                                                unpaid[customer1 - 1] = lendmoney[customer1 - 1];

                                                //System.out.printf("\n\n (대출 받은 돈) bank = %d\n\n", bank2);

                                                //System.out.println("이전손님");
                                                //System.out.printf("\nmoney[%d] = %d\n", i + 1, money[i]);
                                                //System.out.println("다음 손님");
                                                //System.out.printf("\nmoney[%d] = %d\n", customer1, money[customer1 - 1]);

                                                System.out.printf("\n%d번 손님이 %d번 손님에게 대출 받아서 현재 남은 금액 %d원 입니다\n", i + 1, customer1, money[i]);
                                                System.out.printf("\n%d번 손님은 %d번 손님에게 %d원을 빌려줘서 현재 남은 금액 %d원 입니다\n", customer1, i + 1, bank2, money[customer1 - 1]);
                                            }

                                            if (choice == 2)
                                            {
                                                System.out.println();
                                                System.out.println("대출 시스템을 종료하고 메인 메뉴로 돌아갑니다");
                                                System.out.println();
                                                break;
                                            }
                                        }
                                    }

                                    System.out.println();
                                    System.out.println((i + 1) + " 번째 손님이 우동을 구매해서 현재 남은 금액 " + money[i] + " 원 입니다");
                                }

                                if (menuselect.equals(equalshwanbul) == true)
                                {
                                    System.out.println();
                                    System.out.println("환불 할 메뉴를 선택하세요");
                                    System.out.println();
                                    System.out.println("1. 치킨, 2. 피자, 3. 타코야키, 4. 라면, 5. 우동");
                                    refund = enter.next();

                                    if (refund.equals(equalschicken) == true)
                                    {
                                        System.out.println("치킨 몇 개를 환불 하시겠습니까?");
                                        refundcnt = enter.nextInt();

                                        fund = refundcnt * 5000;

                                        money[i] = money[i] + fund;

                                        System.out.println((i + 1) + " 번 손님 치킨 " + refundcnt + " 개를 환불해서 현재 남은 금액 " + money[i] + " 원 입니다");
                                    }

                                    if (refund.equals(equalspizza) == true)
                                    {
                                        System.out.println("피자 몇 개를 환불 하시겠습니까?");
                                        refundcnt = enter.nextInt();

                                        fund = refundcnt * 5000;

                                        money[i] = money[i] + fund;

                                        System.out.println((i + 1) + " 번 손님 피자 " + refundcnt + " 개를 환불해서 현재 남은 금액 " + money[i] + " 원 입니다");
                                    }

                                    if (refund.equals(equalstaco) == true)
                                    {
                                        System.out.println("타코야키 몇 개를 환불 하시겠습니까?");
                                        refundcnt = enter.nextInt();

                                        fund = refundcnt * 3000;

                                        money[i] = money[i] + fund;

                                        System.out.println((i + 1) + " 번 손님 타코야키 " + refundcnt + " 개를 환불해서 현재 남은 금액 " + money[i] + " 원 입니다");
                                    }

                                    if (refund.equals(equalsramen) == true)
                                    {
                                        System.out.println("라면 몇 개를 환불 하시겠습니까?");
                                        refundcnt = enter.nextInt();

                                        fund = refundcnt * 3000;

                                        money[i] = money[i] + fund;

                                        System.out.println((i + 1) + " 번 손님 라면 " + refundcnt + " 개를 환불해서 현재 남은 금액 " + money[i] + " 원 입니다");
                                    }

                                    if (refund.equals(equalsudong) == true)
                                    {
                                        System.out.println("우동 몇 개를 환불 하시겠습니까?");
                                        refundcnt = enter.nextInt();

                                        fund = refundcnt * 3000;

                                        money[i] = money[i] + fund;
                                        System.out.println((i + 1) + " 번 손님 우동 " + refundcnt + " 개를 환불해서 현재 남은 금액 " + money[i] + " 원 입니다");
                                    }
                                }


                                if (menuselect.equals(equalsback) == true)
                                {
                                    memberService.updateMember(human, chickenmoney[i], pizzamoney[i], tacomoney[i], ramenmoney[i], udongmoney[i], firstmoney[i], money[i],
                                            chicken[i], pizza[i], taco[i], ramen[i], udong[i], borrowmoney[i], payoff[i], unpaid[i], lendmoney[i]);
                                    System.out.println("======= 데이터 수정 완료 =======");
                                    System.out.println("메뉴로 돌아갑니다");
                                    break;
                                }
                            }
                        }

                        if (lastmenu.equals(equalsdelete) == true)
                        {
                            System.out.println();
                            System.out.println("삭제 할 고객 아이디 번호를 입력하세요");
                            delete = enter.nextInt();

                            memberService.deleteMember(delete);
                            System.out.println("======= 데이터 삭제 완료 =======");
                            System.out.println();
                        }
                    }
                }
            }
        }
    }
}
