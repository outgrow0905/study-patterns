package com.example.patterns.D_Factory.button.v1;

public class WindowsDialog extends Dialog{
	@Override
	Button createButton() {
		return new WindowsButton();
	}
}
