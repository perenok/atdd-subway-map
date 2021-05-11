package wooteco.subway.dto.line.response;

import wooteco.subway.domain.Line;
import wooteco.subway.dto.station.response.StationResponse;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class LineResponse {
    @NotNull
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String color;
    @NotEmpty
    private List<StationResponse> stations;

    public LineResponse() {
    }

    public LineResponse(Line line) {
        this(line.getId(), line.getName(), line.getColor(), new ArrayList<>());
    }

    public LineResponse(Line line, List<StationResponse> stations) {
        this(line.getId(), line.getName(), line.getColor(), stations);
    }

    public LineResponse(Long id, String name, String color, List<StationResponse> stations) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.stations = stations;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public List<StationResponse> getStations() {
        return stations;
    }
}
