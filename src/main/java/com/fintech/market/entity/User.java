package com.fintech.market.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String username;
    private long lastOnlineSeconds, registrationTimestamp;
    private int transactionsCount, transactionsSuccessfully, activityMonthOrders, activityMonthOrdersSuccessfully,
            activityAverageTransferSeconds, activityAveragePaymentsCount;
    @OneToMany(mappedBy = "owner")
    private List<CFA> cfa;

    public User(String username, long lastOnlineSeconds, long registrationTimestamp, int transactionsCount, int transactionsSuccessfully, int activityMonthOrders, int activityMonthOrdersSuccessfully, int activityAverageTransferSeconds, int activityAveragePaymentsCount) {
        this.username = username;
        this.lastOnlineSeconds = lastOnlineSeconds;
        this.registrationTimestamp = registrationTimestamp;
        this.transactionsCount = transactionsCount;
        this.transactionsSuccessfully = transactionsSuccessfully;
        this.activityMonthOrders = activityMonthOrders;
        this.activityMonthOrdersSuccessfully = activityMonthOrdersSuccessfully;
        this.activityAverageTransferSeconds = activityAverageTransferSeconds;
        this.activityAveragePaymentsCount = activityAveragePaymentsCount;
    }
}
