package com.example.object.ch2.v1;

public class AmountDiscountMovie extends Movie {
    private Long amount;

    @Override
    protected long getDiscountFee(Movie movie) {
        return 0;
    }
}
