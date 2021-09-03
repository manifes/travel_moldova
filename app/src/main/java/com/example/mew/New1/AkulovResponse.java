package com.example.mew.New1;

public class AkulovResponse {


        private String status;
        private Discounts[] discounts;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Discounts[] getDiscounts() {
            return discounts;
        }

        public void setDiscounts(Discounts[] discounts) {
            this.discounts = discounts;
        }

        static class Discounts {
            private String id;

            private String end_date;

            private String discount_text;

            private String start_date;

            private String customer_id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getEnd_date() {
                return end_date;
            }

            public void setEnd_date(String end_date) {
                this.end_date = end_date;
            }

            public String getDiscount_text() {
                return discount_text;
            }

            public void setDiscount_text(String discount_text) {
                this.discount_text = discount_text;
            }

            public String getStart_date() {
                return start_date;
            }

            public void setStart_date(String start_date) {
                this.start_date = start_date;
            }

            public String getCustomer_id() {
                return customer_id;
            }

            public void setCustomer_id(String customer_id) {
                this.customer_id = customer_id;
            }
        }
    }

