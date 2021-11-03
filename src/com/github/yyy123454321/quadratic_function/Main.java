package com.github.yyy123454321.quadratic_function;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        new Window(-50, -10, 50, 90, 3, a, b, c);
    }
}
