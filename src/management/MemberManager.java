package management;

import datastructures.interfaces.Map;
import datastructures.maps.CustomHashMap;
import library.Member;
import library.Transaction;

public class MemberManager {
    private Map<String, Member> members;

    public MemberManager() {
        this.members = new CustomHashMap<>();
    }

    public void addMember(Member member) {
        if (member == null)
            throw new NullPointerException("member must not be null");
        members.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) {
        return members.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        Member m = members.get(memberId);
        if (m != null)
            m.addTransaction(transaction);
    }

    public Transaction getLastTransaction(String memberId) {
        Member m = members.get(memberId);
        if (m == null)
            return null;
        else
            return m.getLastTransaction();
    }
}
