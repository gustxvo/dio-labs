package infrastructure.entity;

import domain.Candidate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Optional;

@Entity(name = "candidates")
public class CandidateEntity {

    @Id
    private String id;

    private String photo;

    @Column(name = "given_name")
    private String givenName;

    @Column(name = "family_name")
    private String familyName;

    private String email;

    private String phone;

    @Column(name = "job_title")
    private String jobTitle;

    public CandidateEntity() {
    }

    public CandidateEntity(Candidate candidate) {
        this.id = candidate.id();
        this.photo = candidate.photo().orElse(null);
        this.givenName = candidate.givenName();
        this.familyName = candidate.familyName();
        this.email = candidate.email();
        this.phone = candidate.phone().orElse(null);
        this.jobTitle = candidate.jobTitle().orElse(null);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Candidate toDomain() {
        return new Candidate(id, Optional.ofNullable(photo), givenName, familyName, email,
                Optional.ofNullable(phone), Optional.ofNullable(jobTitle));
    }
}
