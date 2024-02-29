package local_cache_test.persistence.repository;

import local_cache_test.persistence.entity.NoticeJpaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoticeRepositoryImpl implements NoticeRepository {

    private final NoticeJpaRepository noticeJpaRepository;

    public NoticeRepositoryImpl(final NoticeJpaRepository noticeJpaRepository) {
        this.noticeJpaRepository = noticeJpaRepository;
    }

    @Override
    public void save(final NoticeJpaEntity noticeJpaEntity) {
        noticeJpaRepository.save(noticeJpaEntity);
    }

    @Override
    public List<NoticeJpaEntity> findAll() {
        return noticeJpaRepository.findAll();
    }
}
