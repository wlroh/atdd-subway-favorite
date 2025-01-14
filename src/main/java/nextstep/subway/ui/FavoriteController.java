package nextstep.subway.ui;

import lombok.RequiredArgsConstructor;
import nextstep.auth.authorization.AuthenticationPrincipal;
import nextstep.auth.secured.Secured;
import nextstep.member.domain.LoginMember;
import nextstep.subway.applicaion.FavoriteService;
import nextstep.subway.applicaion.dto.FavoriteRequest;
import nextstep.subway.applicaion.dto.FavoriteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;

    @Secured({"ROLE_ADMIN", "ROLE_MEMBER"})
    @PostMapping
    public ResponseEntity<Void> createLine(@AuthenticationPrincipal LoginMember loginMember, @RequestBody FavoriteRequest favoriteRequest) {
        FavoriteResponse favoriteResponse = favoriteService.save(loginMember, favoriteRequest);
        return ResponseEntity.created(URI.create("/favorites/" + favoriteResponse.getId())).build();
    }

    @Secured({"ROLE_ADMIN", "ROLE_MEMBER"})
    @GetMapping("/{id}")
    public ResponseEntity<FavoriteResponse> createLine(@AuthenticationPrincipal LoginMember loginMember, @PathVariable Long id) {
        FavoriteResponse favoriteResponse = favoriteService.findById(loginMember, id);
        return ResponseEntity.ok().body(favoriteResponse);
    }

    @Secured({"ROLE_ADMIN", "ROLE_MEMBER"})
    @GetMapping
    public ResponseEntity<List<FavoriteResponse>> createLine(@AuthenticationPrincipal LoginMember loginMember) {
        List<FavoriteResponse> favoriteResponses = favoriteService.findAll(loginMember);
        return ResponseEntity.ok().body(favoriteResponses);
    }

    @Secured({"ROLE_ADMIN", "ROLE_MEMBER"})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorite(@AuthenticationPrincipal LoginMember loginMember, @PathVariable Long id) {
        favoriteService.delete(loginMember, id);
        return ResponseEntity.noContent().build();
    }
}
