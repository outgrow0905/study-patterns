#### Proxy
이미지 로더를 만들어보자.  
이미지 로딩은 꽤나 오래 걸려서 처음 이미지를 가져오는데 5초가 걸린다.    
매번 5초가 걸리는 부담스러운 작업이다보니, 실제로 이미지 보여주기 요청 (displayImage)이 오기 전까지는 생성을 미루는게 좋을 것 같다.


#### v1
이미지 인터페이스와 이미지로더 클래스를 살펴보자.

~~~java
public interface Image {
    void displayImage();
}

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
~~~

이미지로더는 생성이 5초가 걸리는 매우 부담스러운 작업이다.  
실제 displayImage 요청이 오면 이미지로더가 생성되도록 프록시를 만들어보자.


~~~java
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
        } else {
            imageLoader.displayImage();
        }
    }
}
~~~

아래와 같이 클라이언트 입장에서 확인해보자.

~~~java
@Test
void proxy() {
    Image image = new ImageLoaderProxy("/User/user/proxy.png"); // 실제 ImageLoader 클래스를 생성하지 않음. (생성 지연)
    image.displayImage(); // ImageLoader 클래스 생성
    image.displayImage();
}
~~~