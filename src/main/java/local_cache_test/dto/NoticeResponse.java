package local_cache_test.dto;

import local_cache_test.persistence.entity.NoticeJpaEntity;
import lombok.Builder;

@Builder
public record NoticeResponse(
        long noticeId,
        String content
) {

    public static NoticeResponse of(final NoticeJpaEntity noticeJpaEntity) {
        return NoticeResponse.builder()
                .noticeId(noticeJpaEntity.getId())
                .content(noticeJpaEntity.getContent())
                .build();
    }
}
