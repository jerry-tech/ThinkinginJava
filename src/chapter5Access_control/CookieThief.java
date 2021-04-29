package chapter5Access_control;

import classcreation.Cookie;

public class CookieThief {
    public static void main(String[] args) {
        Cookie x = new Cookie();
        //x.bite(); // access protected
    }
}