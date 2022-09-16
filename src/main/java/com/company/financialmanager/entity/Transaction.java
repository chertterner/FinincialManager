package com.company.financialmanager.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "TRANSACTION_", indexes = {
        @Index(name = "IDX_TRANSACTION__FROM_ACCOUNT", columnList = "FROM_ACCOUNT_ID"),
        @Index(name = "IDX_TRANSACTION__TO_ACCOUNT", columnList = "TO_ACCOUNT_ID")
})
@Entity(name = "Transaction_")
public class Transaction {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "DATE_")
    private LocalDateTime date;

    @Column(name = "SUM_", precision = 19, scale = 2)
    @PositiveOrZero
    private BigDecimal sum;

    @Column(name = "FOR_WHAT")
    private String forWhat;

    @JoinColumn(name = "FROM_ACCOUNT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account fromAccount;

    @JoinColumn(name = "TO_ACCOUNT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Account toAccount;

    @JoinTable(name = "TRANSACTION_CATEGORY_LINK",
            joinColumns = @JoinColumn(name = "TRANSACTION_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getForWhat() {
        return forWhat;
    }

    public void setForWhat(String forWhat) {
        this.forWhat = forWhat;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}