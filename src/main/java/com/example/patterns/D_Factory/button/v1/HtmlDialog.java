package com.example.patterns.D_Factory.button.v1;

public class HtmlDialog extends Dialog{
	@Override
	Button createButton() {
		return new HtmlButton();
	}
}
