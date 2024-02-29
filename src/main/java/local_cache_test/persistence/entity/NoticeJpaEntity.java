package local_cache_test.persistence.entity;

import jakarta.persistence.*;
import local_cache_test.persistence.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
@Table(name = "notice")
@Entity
public class NoticeJpaEntity extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notice_id")
    private Long id;

    private String content;

    protected NoticeJpaEntity() {
    }

    @Builder
    private NoticeJpaEntity(final String content) {
        this.content = content;
    }

    public static NoticeJpaEntity toEntity(final String content) {
        return NoticeJpaEntity.builder()
                .content(content)
                .build();
    }
}
