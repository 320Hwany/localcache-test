package local_cache_test.presentation;

import local_cache_test.application.NoticeService;
import local_cache_test.dto.NoticeResponse;
import local_cache_test.dto.NoticeResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping
    public NoticeResult findAll() {
        List<NoticeResponse> noticeResponses = noticeService.findAll();
        return new NoticeResult(noticeResponses);
    }

    @GetMapping("/cache")
    public NoticeResult findAllFromCache() {
        List<NoticeResponse> noticeResponses = noticeService.findAllFromCache();
        return new NoticeResult(noticeResponses);
    }
}
