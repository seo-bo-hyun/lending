package bohyun.JDBCTest.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class Member
{
    // 키 값, 음식 구매 금액, 총 구매 금액
    private int memberId;
    private int chicken;
    private int pizza;
    private int taco;
    private int ramen;
    private int udong;
    private int firstmoney;
    private int money;

    // 음식 구매 횟수
    private int chickencount;
    private int pizzacount;
    private int tacocount;
    private int ramencount;
    private int udongcount;

    // 빚 진 금액
    private int borrowmoney;
    // 현재 빚에서 청산 후 남은 금액
    private int payoff;
    // 미납된 금액
    private int unpaid;
    // 빌려준 금액
    private int lendmoney;

    public int getMemberId()
    {
        return memberId;
    }

    public void setMemberId(int memberId)
    {
        this.memberId = memberId;
    }

    public int getChicken()
    {
        return chicken;
    }

    public void setChicken(int chicken)
    {
        this.chicken = chicken;
    }

    public int getPizza()
    {
        return pizza;
    }

    public void setPizza(int pizza)
    {
        this.pizza = pizza;
    }

    public int getTaco()
    {
        return taco;
    }

    public void setTaco(int taco)
    {
        this.taco = taco;
    }

    public int getRamen()
    {
        return ramen;
    }

    public void setRamen(int ramen)
    {
        this.ramen = ramen;
    }

    public int getUdong()
    {
        return udong;
    }

    public void setUdong(int udong)
    {
        this.udong = udong;
    }

    public int getFirstmoney()
    {
        return firstmoney;
    }

    public void setFirstmoney(int firstmoney)
    {
        this.firstmoney = firstmoney;
    }

    public int getMoney()
    {
        return money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }

    public int getChickencount()
    {
        return chickencount;
    }

    public void setChickencount(int chickencount)
    {
        this.chickencount = chickencount;
    }

    public int getPizzacount()
    {
        return pizzacount;
    }

    public void setPizzacount(int pizzacount)
    {
        this.pizzacount = pizzacount;
    }

    public int getTacocount()
    {
        return tacocount;
    }

    public void setTacocount(int tacocount)
    {
        this.tacocount = tacocount;
    }

    public int getRamencount()
    {
        return ramencount;
    }

    public void setRamencount(int ramencount)
    {
        this.ramencount = ramencount;
    }

    public int getUdongcount() {
        return udongcount;
    }

    public void setUdongcount(int udongcount)
    {
        this.udongcount = udongcount;
    }

    public int getBorrowmoney()
    {
        return borrowmoney;
    }

    public void setBorrowmoney(int borrowmoney)
    {
        this.borrowmoney = borrowmoney;
    }

    public int getPayoff()
    {
        return payoff;
    }

    public void setPayoff(int payoff)
    {
        this.payoff = payoff;
    }

    public int getUnpaid()
    {
        return unpaid;
    }

    public void setUnpaid(int unpaid)
    {
        this.unpaid = unpaid;
    }

    public int getLendmoney()
    {
        return lendmoney;
    }

    public void setLendmoney(int lendmoney)
    {
        this.lendmoney = lendmoney;
    }

    public Member(int memberId, int chicken, int pizza, int taco, int ramen, int udong, int firstmoney, int money, int chickencount,
                  int pizzacount, int tacocount, int ramencount, int udongcount, int borrowmoney, int payoff, int unpaid, int lendmoney)
    {
        this.memberId = memberId;
        this.chicken = chicken;
        this.pizza = pizza;
        this.taco = taco;
        this.ramen = ramen;
        this.udong = udong;
        this.firstmoney = firstmoney;
        this.money = money;
        this.chickencount = chickencount;
        this.pizzacount = pizzacount;
        this.tacocount = tacocount;
        this.ramencount = ramencount;
        this.udongcount = udongcount;
        this.borrowmoney = borrowmoney;
        this.payoff = payoff;
        this.unpaid = unpaid;
        this.lendmoney = lendmoney;
    }

    public Member()
    {

    }
}
