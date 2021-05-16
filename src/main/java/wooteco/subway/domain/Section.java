package wooteco.subway.domain;

public class Section {

    private Long id;
    private Long lineId;
    private Long upStationId;
    private Long downStationId;
    private int distance;

    public Section() {
    }

    public Section(Long upStationId, Long downStationId, int distance) {
        this(null, upStationId, downStationId, distance);

    }

    public Section(Long lineId, Station upStation, Station downStation, int distance) {
        this(lineId, upStation.getId(), downStation.getId(), distance);
    }

    public Section(Long lineId, Long upStationId, Long downStationId, int distance) {
        this(null, lineId, upStationId, downStationId, distance);
    }

    public Section(Long id, Long lineId, Long upStationId, Long downStationId, int distance) {
        this.id = id;
        this.lineId = lineId;
        this.upStationId = upStationId;
        this.downStationId = downStationId;
        this.distance = distance;
    }

    public int minusDistance(Section otherSection) {
        return this.distance - otherSection.distance;
    }

    public boolean isGreaterOrEqualThan(Section otherSection) {
        return distance >= otherSection.getDistance();
    }

    public Long getId() {
        return id;
    }

    public Long getLineId() {
        return lineId;
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
}
