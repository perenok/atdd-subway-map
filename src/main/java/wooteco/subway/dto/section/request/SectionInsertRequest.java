package wooteco.subway.dto.section.request;

import wooteco.subway.domain.Section;

import javax.validation.constraints.NotNull;

public class SectionInsertRequest {
    @NotNull
    private Long upStationId;
    @NotNull
    private Long downStationId;
    @NotNull
    private int distance;

    public SectionInsertRequest() {
    }

    public SectionInsertRequest(Long upStationId, Long downStationId, int distance) {
        this.upStationId = upStationId;
        this.downStationId = downStationId;
        this.distance = distance;
    }

    public Long getUpStationId() {
        return upStationId;
    }

    public Long getDownStationId() {
        return downStationId;
    }

    public int getDistance() {
        return distance;
    }

    public Section toEntity(Long lineId) {
        return new Section(lineId, upStationId, downStationId, distance);
    }
}
