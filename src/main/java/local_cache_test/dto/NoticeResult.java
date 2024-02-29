package local_cache_test.dto;

import java.util.List;

public record NoticeResult(
        List<NoticeResponse> noticeResponses
) {
}
