package com.jfilowk.elementstest.presentation.model;

public class ItemModel {

  private String title;
  private String description;
  private String url;

  public ItemModel() {
  }

  public ItemModel(String title, String description, String url) {
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
    return "ItemModel{" +
        "title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", url='" + url + '\'' +
        '}';
  }
}
