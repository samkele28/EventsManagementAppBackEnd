package eventsystem.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Samkele on 8/27/2016.
 */
@Entity
public class CustomerAddress implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long custAddrId;
    private String streetAddress;
    private String surburb;
    private String town;
    private String postalCode;
    private String province;

    private CustomerAddress(){

    }

    public Long getCustAddrId() {
        return custAddrId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getSurburb() {
        return surburb;
    }

    public String getTown() {
        return town;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getProvince() {
        return province;
    }

    private CustomerAddress(Builder builder){
        this.custAddrId = builder.custAddrId;
        this.streetAddress = builder.streetAddress;
        this.surburb = builder.surburb;
        this.town = builder.town;
        this.postalCode = builder.postalCode;
        this.province = builder.province;
    }

    public static class Builder {
        private Long custAddrId;
        private String streetAddress;
        private String surburb;
        private String town;
        private String postalCode;
        private String province;

        public Builder custAddrId(Long value) {
            this.custAddrId = value;
            return this;
        }

        public Builder streetAddress(String value) {
            this.streetAddress = value;
            return this;
        }

        public Builder surburb(String value) {
            this.surburb = value;
            return this;
        }

        public Builder town(String value) {
            this.town = value;
            return this;
        }

        public Builder postalCode(String value) {
            this.postalCode = value;
            return this;
        }

        public Builder province(String value) {
            this.province = value;
            return this;
        }

        public Builder copy(CustomerAddress value) {
            this.custAddrId = value.custAddrId;
            this.streetAddress = value.streetAddress;
            this.surburb = value.surburb;
            this.town = value.town;
            this.postalCode = value.postalCode;
            this.province = value.province;
            return this;
        }

        public CustomerAddress build() {
            return new CustomerAddress (this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CustomerAddress customerAddress = (CustomerAddress) o;

        if (!custAddrId.equals(customerAddress.custAddrId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode(){
        return custAddrId.hashCode();
    }
}
