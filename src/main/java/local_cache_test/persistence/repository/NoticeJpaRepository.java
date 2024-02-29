package local_cache_test.persistence.repository;

import local_cache_test.persistence.entity.NoticeJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NoticeJpaRepository extends JpaRepository<NoticeJpaEntity, Long> {
}
