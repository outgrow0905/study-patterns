package com.example.patterns.M_Proxy.v1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageLoaderProxyTest {

    @Test
    void proxy() {
        Image image = new ImageLoaderProxy("/User/user/proxy.png"); // 실제 ImageLoader 클래스를 생성하지 않음. (생성 지연)
        image.displayImage(); // ImageLoader 클래스 생성
        image.displayImage();
    }
}