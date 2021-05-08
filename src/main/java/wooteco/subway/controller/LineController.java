package wooteco.subway.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import wooteco.subway.dto.request.LineRequest;
import wooteco.subway.dto.response.LineResponse;
import wooteco.subway.service.LineService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/lines", produces = MediaType.APPLICATION_JSON_VALUE)
public class LineController {

    private final LineService lineService;

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        LineValidator lineValidator = new LineValidator();
        webDataBinder.addValidators(lineValidator);
    }

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @PostMapping
    public ResponseEntity<LineResponse> createStation(@RequestBody @Valid LineRequest lineRequest) {
        LineResponse lineResponse = lineService.create(lineRequest.getColor(), lineRequest.getName());
        return ResponseEntity.created(URI.create("/lines/" + lineResponse.getId())).body(lineResponse);
    }

    @GetMapping
    public ResponseEntity<List<LineResponse>> showLines() {
        List<LineResponse> lineResponses = lineService.showAll();
        return ResponseEntity.ok().body(lineResponses);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LineResponse> showLine(@PathVariable Long id) {
        LineResponse lineResponse = lineService.showById(id);
        return ResponseEntity.ok().body(lineResponse);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<LineResponse> updateLine(@PathVariable Long id, @RequestBody LineRequest lineRequest) {
        lineService.updateById(id, lineRequest.getColor(), lineRequest.getName());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteLine(@PathVariable Long id) {
        lineService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
