package infrastructure.entity;

import domain.candidate.Candidate;
import domain.election.Election;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity(name = "election_candidates")
public class ElectionCandidateEntity {

    @EmbeddedId
    private ElectionCandidateId id;

    private Integer votes;

    public ElectionCandidateEntity() {
    }

    public ElectionCandidateEntity(ElectionCandidateId id, Integer votes) {
        this.id = id;
        this.votes = votes;
    }

    public ElectionCandidateId getId() {
        return id;
    }

    public void setId(ElectionCandidateId id) {
        this.id = id;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public static ElectionCandidateEntity fromDomain(Election election, Candidate candidate, Integer votes) {
        ElectionCandidateId id = new ElectionCandidateId(election.id(), candidate.id());
        return new ElectionCandidateEntity(id, votes);
    }
}
