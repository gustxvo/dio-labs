package api.dto;

import java.util.List;

public record ElectionResponse(String id, List<CandidateResponse> candidates) {
}
