package edu.neu.madcourse.numad21s_ashwinashok.models;

public class Page {
    private int page_num;
    private String page_text;
    private String button_text;

    public Page(int page_num, String page_text, String button_text) {
        this.page_num = page_num;
        this.page_text = page_text;
        this.button_text = button_text;
    }

    public int getPage_num() {
        return page_num;
    }

    public String getPage_text() {
        return page_text;
    }

    public String getButton_text() {
        return button_text;
    }
}
