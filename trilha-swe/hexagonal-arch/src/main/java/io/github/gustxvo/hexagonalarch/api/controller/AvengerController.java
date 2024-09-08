package io.github.gustxvo.hexagonalarch.api.controller;

import io.github.gustxvo.hexagonalarch.api.model.AvengerRequest;
import io.github.gustxvo.hexagonalarch.api.model.AvengerResponse;
import io.github.gustxvo.hexagonalarch.domain.model.Avenger;
import io.github.gustxvo.hexagonalarch.domain.service.AvengerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/avengers")
@RequiredArgsConstructor
public class AvengerController {

    private final AvengerService avengerService;

    @GetMapping
    public List<AvengerResponse> list() {
        return avengerService.getAvengers().stream()
                .map(AvengerResponse::fromModel)
                .toList();
    }

    @GetMapping("{id}")
    public ResponseEntity<AvengerResponse> findById(@PathVariable Long id) {
        Avenger avenger = avengerService.findById(id);
        return ResponseEntity.ok(AvengerResponse.fromModel(avenger));
    }

    @PostMapping
    public ResponseEntity<AvengerResponse> create(@Valid @RequestBody AvengerRequest request) {
        Avenger avenger = avengerService.create(request.toModel());
        URI uri = createAvengerUri(avenger);
        return ResponseEntity.created(uri).body(AvengerResponse.fromModel(avenger));
    }

    @PutMapping("{avengerId}")
    public ResponseEntity<AvengerResponse> update(@PathVariable Long avengerId, @Valid @RequestBody AvengerRequest request) {
        Avenger avenger = avengerService.update(request.toModel(avengerId));
        return ResponseEntity.ok(AvengerResponse.fromModel(avenger));
    }

    @DeleteMapping("{avengerId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long avengerId) {
        avengerService.deleteById(avengerId);
        return ResponseEntity.noContent().build();
    }

    private URI createAvengerUri(Avenger avenger) {
        String uri = String.format("/api/v1/avengers/%d", avenger.id());
        return URI.create(uri);
    }
}
