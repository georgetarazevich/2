package com.unit.pen.testing;

import org.testng.annotations.DataProvider;

public class TestBase {

	private final int inkContainerValue = 500;
	private final int inkContainerZeroValue = 0;
	private final double sizeLetterValue = 2.0;
	private final double sizeLetterZeroValue = 0.0;
	private final String color = "BLUE";

	@DataProvider(name = "InkContainer_TrueValue")
	public Object[][] createPens_InkContainer_TrueValue() {
		return new Object[][] {
				new Object[] { new Pen(inkContainerValue) },
				new Object[] { new Pen(inkContainerValue, sizeLetterValue) },
				new Object[] { new Pen(inkContainerValue, sizeLetterValue,
						color) } };
	}

	@DataProvider(name = "InkContainer_FalseValue")
	public Object[][] createPens_InkContainer_FalseValue() {
		return new Object[][] {
				new Object[] { new Pen(inkContainerZeroValue) },
				new Object[] { new Pen(inkContainerZeroValue, sizeLetterValue) },
				new Object[] { new Pen(inkContainerZeroValue, sizeLetterValue,
						color) },
				new Object[] { new Pen(inkContainerZeroValue - 1) },
				new Object[] { new Pen(inkContainerZeroValue - 1,
						sizeLetterValue) },
				new Object[] { new Pen(inkContainerZeroValue - 1,
						sizeLetterValue, color) } };
	}

	@DataProvider(name = "SizeLetter_FalseValue")
	public Object[][] createPens_SizeLetter_FalseValue() {
		return new Object[][] {
				new Object[] { new Pen(inkContainerValue, sizeLetterZeroValue) },
				new Object[] { new Pen(inkContainerValue,
						sizeLetterZeroValue - 1, color) } };
	}

}
