package com.densoft.cards.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "card_id", nullable = false)
    private int cardId;

    @Column(name = "customer_id", nullable = false)
    private int customerId;

    @Column(name = "card_number", length = 100, nullable = false)
    private String cardNumber;

    @Column(name = "card_type", length = 100, nullable = false)
    private String cardType;

    @Column(name = "total_limit", nullable = false)
    private int totalLimit;

    @Column(name = "amount_used", nullable = false)
    private int amountUsed;

    @Column(name = "available_amount", nullable = false)
    private int availableAmount;

    @Column(name = "create_dt")
    private Date createDt;
}
