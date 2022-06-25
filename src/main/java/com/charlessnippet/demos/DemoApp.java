package com.charlessnippet.demos;

public class DemoApp
{
    private final String message = "Hello World!";

    public DemoApp() {
        System.out.println("Constructor running");
    }

    public static void main(String[] args) {
        DemoApp demoApp = new DemoApp();
        demoApp.printMessage(); // test java availability
    }

    private final void printMessage() {
        System.out.println(message);
    }
}
