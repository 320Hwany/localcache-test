package local_cache_test.application;

import local_cache_test.dto.NoticeResponse;
import local_cache_test.persistence.entity.NoticeJpaEntity;
import local_cache_test.persistence.repository.NoticeRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

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

    @Transactional(readOnly = true)
    public List<NoticeResponse> findAll() {
        List<NoticeJpaEntity> noticeJpaEntities = noticeRepository.findAll();

        return noticeJpaEntities.stream()
                .map(NoticeResponse::of)
                .collect(toList());
    }

    @Cacheable(value = "NoticeFinder.findAll")
    @Transactional(readOnly = true)
    public List<NoticeResponse> findAllFromCache() {
        List<NoticeJpaEntity> noticeJpaEntities = noticeRepository.findAll();

        return noticeJpaEntities.stream()
                .map(NoticeResponse::of)
                .collect(toList());
    }
}
