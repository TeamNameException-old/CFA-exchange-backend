package com.fintech.market.model;

import com.fintech.market.dto.CFAView;
import com.fintech.market.entity.CFA;
import com.fintech.market.repos.CFARepos;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class CFAModel {
    private final CFARepos cfaRepos;

    public CFAModel(CFARepos cfaRepos) {
        this.cfaRepos = cfaRepos;
    }

    public com.fintech.market.dto.CFAView create(CFAView cfa) {
        CFA cfaEntity = new CFA(
                cfaRepos.findById(cfa.getOwner().getId()).orElseThrow().getOwner(),
                (int) cfa.getPrice().getCount(),
                cfa.getPrice().getCurrency(),
                cfa.getTitle(),
                cfa.getFile().getContract().getName(),
                cfa.getFile().getContract().getDownload().getLink()
        );
        cfa.setId(cfaRepos.save(cfaEntity).getId());
        return cfa;
    }

    public CFAView get(CFA cfaEntity) {
        return new CFAView(
                cfaEntity.getId(),
                cfaEntity.getTitle(),
                new com.fintech.market.dto.CFA.Owner(cfaEntity.getOwner().getId(), cfaEntity.getOwner().getUsername(), new com.fintech.market.dto.CFA.Owner.Transactions(cfaEntity.getOwner().getTransactionsCount(), cfaEntity.getOwner().getTransactionsSuccessfully() + "%")),
                new com.fintech.market.dto.CFA.Price(cfaEntity.getPriceCount(), cfaEntity.getPriceCurrency()),
                new CFAView.File(new CFAView.File.Contract(cfaEntity.getContractFilename(), new CFAView.File.Contract.Download(cfaEntity.getContractDownloadLink()))),
                new com.fintech.market.dto.CFA.Owner.Online(new Date(cfaEntity.getOwner().getLastOnlineSeconds())),
                new com.fintech.market.dto.CFA.Owner.Registration(new Date(cfaEntity.getOwner().getRegistrationTimestamp())),
                new com.fintech.market.dto.CFA.Owner.Activity(new com.fintech.market.dto.CFA.Owner.Activity.Month(cfaEntity.getOwner().getActivityMonthOrders(), cfaEntity.getOwner().getActivityMonthOrdersSuccessfully() + "%"), new com.fintech.market.dto.CFA.Owner.Activity.Average(new com.fintech.market.dto.CFA.Owner.Activity.Average.Time(new com.fintech.market.dto.CFA.Owner.Activity.Average.Time.Seconds(cfaEntity.getOwner().getActivityAverageTransferSeconds(), cfaEntity.getOwner().getActivityAveragePaymentsCount()))))
        );
    }
}
