package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    //TODO: 에러수정
    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
