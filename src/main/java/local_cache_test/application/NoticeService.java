package local_cache_test.application;

import local_cache_test.persistence.entity.NoticeJpaEntity;
import local_cache_test.persistence.repository.NoticeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public NoticeService(final NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    @Transactional
    public void saveDummyNotices() {
        for (int i = 0; i < 5000; i++) {
            NoticeJpaEntity noticeJpaEntity = NoticeJpaEntity.toEntity(String.valueOf(i));
            noticeRepository.save(noticeJpaEntity);
        }
    }
}
