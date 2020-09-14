// ProductMl.java

package com.jaime.ml.challenge.models;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;
import java.util.List;

public class ProductML {
    private String id;
    private String siteId;
    private String title;
    private Seller seller;
    private long price;
    private String currencyId;
    private long availableQuantity;
    private long soldQuantity;
    private String buyingMode;
    private String listingTypeId;
    private OffsetDateTime stopTime;
    private String condition;
    private String permalink;
    private String thumbnail;
    private boolean acceptsMercadopago;
    private Installments installments;
    private Address address;
    private Shipping shipping;
    private SellerAddress sellerAddress;
    private List<Attribute> attributes;
    private Object originalPrice;
    private String categoryId;
    private long officialStoreId;
    private String domainId;
    private String catalogProductId;
    private List<String> tags;

    @JsonProperty("id")
    public String getId() { return id; }
    @JsonProperty("id")
    public void setId(String value) { this.id = value; }

    @JsonProperty("site_id")
    public String getSiteId() { return siteId; }
    @JsonProperty("site_id")
    public void setSiteId(String value) { this.siteId = value; }

    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("seller")
    public Seller getSeller() { return seller; }
    @JsonProperty("seller")
    public void setSeller(Seller value) { this.seller = value; }

    @JsonProperty("price")
    public long getPrice() { return price; }
    @JsonProperty("price")
    public void setPrice(long value) { this.price = value; }

    @JsonProperty("currency_id")
    public String getCurrencyId() { return currencyId; }
    @JsonProperty("currency_id")
    public void setCurrencyId(String value) { this.currencyId = value; }

    @JsonProperty("available_quantity")
    public long getAvailableQuantity() { return availableQuantity; }
    @JsonProperty("available_quantity")
    public void setAvailableQuantity(long value) { this.availableQuantity = value; }

    @JsonProperty("sold_quantity")
    public long getSoldQuantity() { return soldQuantity; }
    @JsonProperty("sold_quantity")
    public void setSoldQuantity(long value) { this.soldQuantity = value; }

    @JsonProperty("buying_mode")
    public String getBuyingMode() { return buyingMode; }
    @JsonProperty("buying_mode")
    public void setBuyingMode(String value) { this.buyingMode = value; }

    @JsonProperty("listing_type_id")
    public String getListingTypeId() { return listingTypeId; }
    @JsonProperty("listing_type_id")
    public void setListingTypeId(String value) { this.listingTypeId = value; }

    @JsonProperty("stop_time")
    public OffsetDateTime getStopTime() { return stopTime; }
    @JsonProperty("stop_time")
    public void setStopTime(OffsetDateTime value) { this.stopTime = value; }

    @JsonProperty("condition")
    public String getCondition() { return condition; }
    @JsonProperty("condition")
    public void setCondition(String value) { this.condition = value; }

    @JsonProperty("permalink")
    public String getPermalink() { return permalink; }
    @JsonProperty("permalink")
    public void setPermalink(String value) { this.permalink = value; }

    @JsonProperty("thumbnail")
    public String getThumbnail() { return thumbnail; }
    @JsonProperty("thumbnail")
    public void setThumbnail(String value) { this.thumbnail = value; }

    @JsonProperty("accepts_mercadopago")
    public boolean getAcceptsMercadopago() { return acceptsMercadopago; }
    @JsonProperty("accepts_mercadopago")
    public void setAcceptsMercadopago(boolean value) { this.acceptsMercadopago = value; }

    @JsonProperty("installments")
    public Installments getInstallments() { return installments; }
    @JsonProperty("installments")
    public void setInstallments(Installments value) { this.installments = value; }

    @JsonProperty("address")
    public Address getAddress() { return address; }
    @JsonProperty("address")
    public void setAddress(Address value) { this.address = value; }

    @JsonProperty("shipping")
    public Shipping getShipping() { return shipping; }
    @JsonProperty("shipping")
    public void setShipping(Shipping value) { this.shipping = value; }

    @JsonProperty("seller_address")
    public SellerAddress getSellerAddress() { return sellerAddress; }
    @JsonProperty("seller_address")
    public void setSellerAddress(SellerAddress value) { this.sellerAddress = value; }

    @JsonProperty("attributes")
    public List<Attribute> getAttributes() { return attributes; }
    @JsonProperty("attributes")
    public void setAttributes(List<Attribute> value) { this.attributes = value; }

    @JsonProperty("original_price")
    public Object getOriginalPrice() { return originalPrice; }
    @JsonProperty("original_price")
    public void setOriginalPrice(Object value) { this.originalPrice = value; }

    @JsonProperty("category_id")
    public String getCategoryId() { return categoryId; }
    @JsonProperty("category_id")
    public void setCategoryId(String value) { this.categoryId = value; }

    @JsonProperty("official_store_id")
    public long getOfficialStoreId() { return officialStoreId; }
    @JsonProperty("official_store_id")
    public void setOfficialStoreId(long value) { this.officialStoreId = value; }

    @JsonProperty("domain_id")
    public String getDomainId() { return domainId; }
    @JsonProperty("domain_id")
    public void setDomainId(String value) { this.domainId = value; }

    @JsonProperty("catalog_product_id")
    public String getCatalogProductId() { return catalogProductId; }
    @JsonProperty("catalog_product_id")
    public void setCatalogProductId(String value) { this.catalogProductId = value; }

    @JsonProperty("tags")
    public List<String> getTags() { return tags; }
    @JsonProperty("tags")
    public void setTags(List<String> value) { this.tags = value; }
}
