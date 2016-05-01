package com.jfilowk.elementstest.data.entity;

import com.opencsv.bean.CsvBind;

public class ItemEntity {

  @CsvBind
  private String title;
  @CsvBind
  private String description;
  @CsvBind
  private String url;

  public ItemEntity() {
  }

  public ItemEntity(String title, String description, String url) {
    this.title = title;
    this.description = description;
    this.url = url;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  @Override public String toString() {
    return "ItemEntity{" +
        "title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", url='" + url + '\'' +
        '}';
  }
}
