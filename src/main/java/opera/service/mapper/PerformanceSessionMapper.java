package opera.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import opera.dto.request.PerformanceSessionRequestDto;
import opera.dto.response.PerformanceSessionResponseDto;
import opera.model.PerformanceSession;
import opera.service.PerformanceService;
import opera.service.StageService;
import opera.util.DateTimePatternUtil;
import org.springframework.stereotype.Component;

@Component
public class PerformanceSessionMapper implements
        RequestDtoMapper<PerformanceSessionRequestDto, PerformanceSession>,
        ResponseDtoMapper<PerformanceSessionResponseDto, PerformanceSession> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final StageService stageService;
    private final PerformanceService performanceService;

    public PerformanceSessionMapper(StageService stageService,
                                    PerformanceService performanceService) {
        this.stageService = stageService;
        this.performanceService = performanceService;
    }

    @Override
    public PerformanceSession mapToModel(PerformanceSessionRequestDto dto) {
        PerformanceSession performanceSession = new PerformanceSession();
        performanceSession.setPerformance(performanceService.get(dto.getPerformanceId()));
        performanceSession.setStage(stageService.get(dto.getStageId()));
        performanceSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        return performanceSession;
    }

    @Override
    public PerformanceSessionResponseDto mapToDto(PerformanceSession performanceSession) {
        PerformanceSessionResponseDto responseDto = new PerformanceSessionResponseDto();
        responseDto.setPerformanceSessionId(performanceSession.getId());
        responseDto.setStageId(performanceSession.getStage().getId());
        responseDto.setPerformanceId(performanceSession.getPerformance().getId());
        responseDto.setPerformanceTitle(performanceSession.getPerformance().getTitle());
        responseDto.setShowTime(performanceSession.getShowTime().format(formatter));
        return responseDto;
    }
}
