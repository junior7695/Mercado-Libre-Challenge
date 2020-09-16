package com.jaime.ml.challenge.models;

/*-----------------------------------------------*/
/*					Author                       */
/*				Jaime Vallejo                    */
/*                                               */
/*				Fecha Creacion                   */
/*				  14/09/2020                     */
/*                                               */
/*				Descripcion                      */
/*   Proyecto creado como un Challenge de ML     */
/*   como proceso de selección                   */
/*-----------------------------------------------*/

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductML {
    public static final String ID = "productMl";
    @SerializedName("id")
    private String id;
    @SerializedName("site_id")
    private String siteId;
    @SerializedName("title")
    private String title;
    @SerializedName("seller")
    private Seller seller;
    @SerializedName("price")
    private long price;
    @SerializedName("currency_id")
    private String currencyId;
    @SerializedName("available_quantity")
    private long availableQuantity;
    @SerializedName("sold_quantity")
    private long soldQuantity;
    @SerializedName("buying_mode")
    private String buyingMode;
    @SerializedName("listing_type_id")
    private String listingTypeId;
    @SerializedName("stop_time")
    private String stopTime;
    @SerializedName("condition")
    private String condition;
    @SerializedName("permalink")
    private String permalink;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("accepts_mercadopago")
    private boolean acceptsMercadopago;
    @SerializedName("installments")
    private Installments installments;
    @SerializedName("address")
    private Address address;
    @SerializedName("shipping")
    private Shipping shipping;
    @SerializedName("seller_address")
    private SellerAddress sellerAddress;
    @SerializedName("attributes")
    private List<Attribute> attributes;
    @SerializedName("original_price")
    private long originalPrice;
    @SerializedName("category_id")
    private String categoryId;
    @SerializedName("official_store_id")
    private long officialStoreId;
    @SerializedName("domain_id")
    private String domainId;
    @SerializedName("catalog_product_id")
    private String catalogProductId;
    @SerializedName("tags")
    private List<String> tags;


    public String getId() { return id; }

    public void setId(String value) { this.id = value; }


    public String getSiteId() { return siteId; }

    public void setSiteId(String value) { this.siteId = value; }


    public String getTitle() { return title; }

    public void setTitle(String value) { this.title = value; }


    public Seller getSeller() { return seller; }

    public void setSeller(Seller value) { this.seller = value; }


    public long getPrice() { return price; }

    public void setPrice(long value) { this.price = value; }


    public String getCurrencyId() { return currencyId; }

    public void setCurrencyId(String value) { this.currencyId = value; }


    public long getAvailableQuantity() { return availableQuantity; }

    public void setAvailableQuantity(long value) { this.availableQuantity = value; }


    public long getSoldQuantity() { return soldQuantity; }

    public void setSoldQuantity(long value) { this.soldQuantity = value; }


    public String getBuyingMode() { return buyingMode; }

    public void setBuyingMode(String value) { this.buyingMode = value; }


    public String getListingTypeId() { return listingTypeId; }

    public void setListingTypeId(String value) { this.listingTypeId = value; }


    public String getStopTime() { return stopTime; }

    public void setStopTime(String value) { this.stopTime = value; }


    public String getCondition() { return condition; }

    public void setCondition(String value) { this.condition = value; }


    public String getPermalink() { return permalink; }

    public void setPermalink(String value) { this.permalink = value; }


    public String getThumbnail() { return thumbnail; }

    public void setThumbnail(String value) { this.thumbnail = value; }


    public boolean getAcceptsMercadopago() { return acceptsMercadopago; }

    public void setAcceptsMercadopago(boolean value) { this.acceptsMercadopago = value; }


    public Installments getInstallments() { return installments; }

    public void setInstallments(Installments value) { this.installments = value; }


    public Address getAddress() { return address; }

    public void setAddress(Address value) { this.address = value; }


    public Shipping getShipping() { return shipping; }

    public void setShipping(Shipping value) { this.shipping = value; }


    public SellerAddress getSellerAddress() { return sellerAddress; }

    public void setSellerAddress(SellerAddress value) { this.sellerAddress = value; }


    public List<Attribute> getAttributes() { return attributes; }

    public void setAttributes(List<Attribute> value) { this.attributes = value; }


    public long getOriginalPrice() { return originalPrice; }

    public void setOriginalPrice(long value) { this.originalPrice = value; }


    public String getCategoryId() { return categoryId; }

    public void setCategoryId(String value) { this.categoryId = value; }


    public long getOfficialStoreId() { return officialStoreId; }

    public void setOfficialStoreId(long value) { this.officialStoreId = value; }


    public String getDomainId() { return domainId; }

    public void setDomainId(String value) { this.domainId = value; }


    public String getCatalogProductId() { return catalogProductId; }

    public void setCatalogProductId(String value) { this.catalogProductId = value; }


    public List<String> getTags() { return tags; }

    public void setTags(List<String> value) { this.tags = value; }
}
