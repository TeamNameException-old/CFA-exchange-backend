package com.fintech.market.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class CFA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private User owner;
    private int priceCount;
    private String title, contractFilename, contractDownloadLink, priceCurrency;

    public CFA(User owner, int priceCount, String priceCurrency, String title, String contractFilename, String contractDownloadLink) {
        this.owner = owner;
        this.priceCount = priceCount;
        this.priceCurrency = priceCurrency;
        this.title = title;
        this.contractFilename = contractFilename;
        this.contractDownloadLink = contractDownloadLink;
    }
}
