package com.fintech.market.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
public class CFAView extends CFA {
    private File file;

    public CFAView(long id, String title, Owner owner, Price price, File file, Owner.Online online,
                   Owner.Registration registration, Owner.Activity activity) {
        super(id, title, owner, price);
        owner.setOnline(online);
        owner.setRegistration(registration);
        owner.setActivity(activity);
        this.file = file;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class File {
        private Contract contract;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Contract {
            private String name;
            private Download download;

            @Data
            @NoArgsConstructor
            @AllArgsConstructor
            public static class Download {
                private String link;
            }
        }
    }
}
