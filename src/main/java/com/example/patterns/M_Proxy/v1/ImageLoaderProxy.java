package com.example.patterns.M_Proxy.v1;

import org.springframework.util.StringUtils;

public class ImageLoaderProxy implements Image {

    ImageLoader imageLoader;
    String path;

    public ImageLoaderProxy(String path) {
        this.path = path;
    }

    @Override
    public void displayImage() {
        if (null == imageLoader) {
            imageLoader = new ImageLoader(path);
            System.out.println("image is loading..");
        } else {
            imageLoader.displayImage();
        }
    }
}
