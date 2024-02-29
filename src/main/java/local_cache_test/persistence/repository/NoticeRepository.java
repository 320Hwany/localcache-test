package local_cache_test.persistence.repository;

import local_cache_test.persistence.entity.NoticeJpaEntity;

import java.util.List;

public interface NoticeRepository {

    void save(final NoticeJpaEntity noticeJpaEntity);

    List<NoticeJpaEntity> findAll();
}
