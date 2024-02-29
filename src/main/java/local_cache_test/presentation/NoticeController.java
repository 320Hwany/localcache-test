package local_cache_test.presentation;

import local_cache_test.application.NoticeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/notices")
@RestController
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(final NoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @PostMapping
    public void saveDummyNotices() {
        noticeService.saveDummyNotices();
    }
}