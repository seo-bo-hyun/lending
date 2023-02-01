package bohyun.JDBCTest.repository;

import bohyun.JDBCTest.connection.DBConnectionUtility;
import bohyun.JDBCTest.domain.Member;
import lombok.extern.slf4j.Slf4j;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class MemberRepository
{
    public Member save(Member member)
    {
        String sql = "insert into lending(member_id, chicken, pizza, taco, ramen, udong, firstmoney, totalmoney, " +
                "chickencount, pizzacount, tacocount, ramencount, udongcount, borrowmoney, payoff, unpaid, lendmoney) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try
        {
            Connection connection = null;
            PreparedStatement prepareStatement = null;
            connection = getConnection();
            prepareStatement = connection.prepareStatement(sql);

            prepareStatement.setInt(1, member.getMemberId());
            prepareStatement.setInt(2, member.getChicken());
            prepareStatement.setInt(3, member.getPizza());
            prepareStatement.setInt(4, member.getTaco());
            prepareStatement.setInt(5, member.getRamen());
            prepareStatement.setInt(6, member.getUdong());
            prepareStatement.setInt(7, member.getFirstmoney());
            prepareStatement.setInt(8, member.getMoney());
            prepareStatement.setInt(9, member. getChickencount());
            prepareStatement.setInt(10, member. getPizzacount());
            prepareStatement.setInt(11, member.getTacocount());
            prepareStatement.setInt(12, member.getRamencount());
            prepareStatement.setInt(13, member.getUdongcount());
            prepareStatement.setInt(14, member.getBorrowmoney());
            prepareStatement.setInt(15, member.getPayoff());
            prepareStatement.setInt(16, member.getUnpaid());
            prepareStatement.setInt(17, member.getLendmoney());

            prepareStatement.executeUpdate();

            return member;
        }
        catch (SQLException e)
        {
            log.error("데이터 오류 입니다", e);
        }
        return member;
    }

    public Member findById(Integer memberId)
    {
        String sql = "select * from lending where member_id = ?";

        try
        {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, memberId);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next())
            {
                Member member = new Member();
                member.setMemberId(rs.getInt("member_id"));
                member.setChicken(rs.getInt("chicken"));
                member.setPizza(rs.getInt("pizza"));
                member.setTaco(rs.getInt("taco"));
                member.setRamen(rs.getInt("ramen"));
                member.setUdong(rs.getInt("udong"));
                member.setFirstmoney(rs.getInt("firstmoney"));
                member.setMoney(rs.getInt("totalmoney"));
                member.setChickencount(rs.getInt("chickencount"));
                member.setPizzacount(rs.getInt("pizzacount"));
                member.setTacocount(rs.getInt("tacocount"));
                member.setRamencount(rs.getInt("ramencount"));
                member.setUdongcount(rs.getInt("udongcount"));
                member.setBorrowmoney(rs.getInt("borrowmoney"));
                member.setPayoff(rs.getInt("payoff"));
                member.setUnpaid(rs.getInt("unpaid"));
                member.setLendmoney(rs.getInt("lendmoney"));
                return member;
            }
            else
            {
                System.out.println("없는 정보입니다.");
            }
        }
        catch (SQLException e)
        {
            log.error("데이터 오류 입니다", e);
        }
        return null;

    }

    public void deleteMember(Integer memberId)
    {
        // public void로 하면 굳이 memberService 에서 memberRepository로 return을 해줄 필요가 없다
        String sql = "delete from lending where member_id = ?";

        try
        {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, memberId);
            preparedStatement.executeUpdate();

            System.out.println("삭제 되었습니다");

        }
        catch (SQLException e)
        {
            System.out.println("데이터 오류 입니다" + e);
        }
    }

    public void updateMember(Integer memberId, int chicken, int pizza, int taco, int ramen, int udong, int firstmoney, int money, int chickencount,
                             int pizzacount, int tacocount, int ramencount, int udongcount, int borrowmoney, int payoff, int unpaid, int lendmoney)
    {
        String sql = "update lending set chicken = ?, pizza = ?, taco = ?, ramen = ?, udong = ?, firstmoney = ?, totalmoney = ?, " +
                "chickencount = ?, pizzacount = ?, tacocount = ?, ramencount = ?, udongcount = ?, borrowmoney = ?, payoff = ?, unpaid = ?, lendmoney = ? where member_id = ?";

        try
        {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, chicken);
            preparedStatement.setInt(2, pizza);
            preparedStatement.setInt(3, taco);
            preparedStatement.setInt(4, ramen);
            preparedStatement.setInt(5, udong);
            preparedStatement.setInt(6, firstmoney);
            preparedStatement.setInt(7, money);
            preparedStatement.setInt(8, chickencount);
            preparedStatement.setInt(9, pizzacount);
            preparedStatement.setInt(10, tacocount);
            preparedStatement.setInt(11, ramencount);
            preparedStatement.setInt(12, udongcount);
            preparedStatement.setInt(13, borrowmoney);
            preparedStatement.setInt(14, payoff);
            preparedStatement.setInt(15, unpaid);
            preparedStatement.setInt(16, lendmoney);
            preparedStatement.setInt(17, memberId);


            int resultSize = preparedStatement.executeUpdate();
            log.info("resultSize = {}", resultSize);
            // resultSize가 1이 나오면 성공적으로 수정, 0이 나오면 실패
        }
        catch (SQLException e)
        {
            System.out.println("데이터 오류 입니다" + e);
        }
    }
    private Connection getConnection()
    {
        return DBConnectionUtility.getConnection();
    }
}
