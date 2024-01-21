package com.example.object.ch2.v1;

public class PercentDiscountMovie extends Movie {
    private Double percent;
    @Override
    protected long getDiscountFee(Movie movie) {
        return 0;
    }
}
