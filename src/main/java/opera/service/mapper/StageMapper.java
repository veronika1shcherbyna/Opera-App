package opera.service.mapper;

import opera.dto.request.StageRequestDto;
import opera.dto.response.StageResponseDto;
import opera.model.Stage;
import org.springframework.stereotype.Component;

@Component
public class StageMapper implements RequestDtoMapper<StageRequestDto, Stage>,
        ResponseDtoMapper<StageResponseDto, Stage> {
    @Override
    public Stage mapToModel(StageRequestDto dto) {
        Stage stage = new Stage();
        stage.setDescription(dto.getDescription());
        stage.setCapacity(dto.getCapacity());
        return stage;
    }

    @Override
    public StageResponseDto mapToDto(Stage stage) {
        StageResponseDto responseDto = new StageResponseDto();
        responseDto.setId(stage.getId());
        responseDto.setDescription(stage.getDescription());
        return responseDto;
    }
}
