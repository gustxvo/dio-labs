package io.github.gustxvo.bootcamp.claro.domain.model.account;

import io.github.gustxvo.bootcamp.claro.domain.model.client.Client;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity(name = "tb_account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "client_id")
    private Client client;

    @Column(unique = true, nullable = false)
    private String number;

    @Column(name = "renewal_date", nullable = false)
    private LocalDate renewalDate;

    @Column(name = "available_data_in_mb", precision = 14, scale = 6, nullable = false)
    private BigDecimal availableDataInMb;

    @Enumerated
    @Column(name = "account_plan", nullable = false)
    private AccountPlan plan;

    @Column(name = "price", precision = 10, scale = 4, nullable = false)
    private BigDecimal price;

    public Account() {
    }

    public Account(Long id, Client client, String number, LocalDate renewalDate, BigDecimal availableDataInMb, AccountPlan plan, BigDecimal price) {
        this.id = id;
        this.client = client;
        this.number = number;
        this.renewalDate = renewalDate;
        this.availableDataInMb = availableDataInMb;
        this.plan = plan;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(LocalDate renewalDate) {
        this.renewalDate = renewalDate;
    }

    public BigDecimal getAvailableDataInMb() {
        return availableDataInMb;
    }

    public void setAvailableDataInMb(BigDecimal availableDataInMb) {
        this.availableDataInMb = availableDataInMb;
    }

    public AccountPlan getPlan() {
        return plan;
    }

    public void setPlan(AccountPlan plan) {
        this.plan = plan;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
