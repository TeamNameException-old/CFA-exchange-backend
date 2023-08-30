package com.fintech.market.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CFA {
    private long id;
    private String title;
    private Owner owner;
    private Price price;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Owner {
        private long id;
        private String username;
        private Transactions transactions;
        private Online online;
        private Registration registration;
        private Activity activity;

        public Owner(long id, String username, Transactions transactions) {
            this.id = id;
            this.username = username;
            this.transactions = transactions;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Transactions {
            private int count;
            @Schema(defaultValue = "integer")
            private String successfully;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Online {
            private Date last;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Registration {
            private Date date;
        }

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Activity {
            private Month month;
            private Average average;

            @Data
            @NoArgsConstructor
            @AllArgsConstructor
            public static class Month {
                private int orders;
                @Schema(defaultValue = "integer")
                private String successfully;
            }

            @Data
            @NoArgsConstructor
            @AllArgsConstructor
            public static class Average {
                private Time time;

                @Data
                @NoArgsConstructor
                @AllArgsConstructor
                public static class Time {
                    private Seconds seconds;

                    @Data
                    @NoArgsConstructor
                    @AllArgsConstructor
                    public static class Seconds {
                        private int transfer, payment;
                    }
                }
            }
        }
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Price {
        private long count;
        private String currency;
    }
}
