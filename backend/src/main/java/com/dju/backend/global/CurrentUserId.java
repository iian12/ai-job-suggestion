package com.dju.backend.global;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUserId {
    boolean required() default true;

    boolean requie();
}

/**
 * 사용 예시
 * @PostMapping("/cases/{caseId}/votes")
 * public void vote(
 *         @PathVariable String caseId,
 *         @CurrentUserId UserId userId,
 *         @RequestBody VoteRequest request
 * ) {
 *     voteService.vote(userId, CaseId.of(caseId), request.option());
 * }
 */