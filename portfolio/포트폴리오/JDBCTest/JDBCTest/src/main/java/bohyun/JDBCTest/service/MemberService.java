package bohyun.JDBCTest.service;

import bohyun.JDBCTest.domain.Member;
import bohyun.JDBCTest.repository.MemberRepository;

import java.sql.SQLException;

public class MemberService
{
    MemberRepository memberRepository = new MemberRepository();

    public Member save(Member member)
    {
        return memberRepository.save(member);
    }

    public Member findById(Integer memberId)
    {
        return memberRepository.findById(memberId);
    }

    public void deleteMember(Integer memberId)
    {
        memberRepository.deleteMember(memberId);
    }

    public void updateMember(Integer memberId, int chicken, int pizza, int taco, int ramen, int udong, int firstmoney, int money, int chickencount,
                             int pizzacount, int tacocount, int ramencount, int udongcount, int borrowmoney, int payoff, int unpaid, int lendmoney)
    {
        memberRepository.updateMember(memberId, chicken, pizza, taco, ramen, udong, firstmoney, money, chickencount, pizzacount,
                tacocount, ramencount, udongcount, borrowmoney, payoff, unpaid, lendmoney);
    }
}
