package com.selenide.tasks;

enum Colors {
    RED("rgba(255, 0, 0, 1)", "red"),
    GREY("rgba(102, 102, 102, 1)", "grey");

    final String rgba;
    final String color;

    Colors(String rgba, String color) {
        this.rgba = rgba;
        this.color = color;
    }

}
