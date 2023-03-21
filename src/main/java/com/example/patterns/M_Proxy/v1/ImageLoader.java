package com.example.patterns.M_Proxy.v1;

public class ImageLoader implements Image {

    String image;

    public ImageLoader(String path) {
        image = loadImage(path);
    }

    @Override
    public void displayImage() {
        System.out.println("display " + image);
    }

    String loadImage(String path){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("image is loading from " + path);

        return path + " file is loaded.";
    }
}
