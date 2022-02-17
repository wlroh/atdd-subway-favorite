package nextstep.member.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByMember(final Member member);

    void deleteByIdAndMemberId(Long favoriteId, Long memberId);
}
