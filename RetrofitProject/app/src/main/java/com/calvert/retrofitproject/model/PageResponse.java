package com.calvert.retrofitproject.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PageResponse {

    @SerializedName("page")
    private Integer page;
    @SerializedName("per_page")
    private Integer per_page;
    @SerializedName("total")
    private Integer total;
    @SerializedName("total_pages")
    private Integer total_pages;
    @SerializedName("data")
    private List<User> data;

    public PageResponse(Integer page, Integer per_page, Integer total, Integer total_pages, List<User> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }
}
