package com.unit.pen.testing;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckForDoSomethingElseMethodTest {

	int inkContainerValue = 100;
	double sizeLetter = 2.0;
	String color = "GREEN";
	ByteArrayOutputStream baOut;
	Pen pen;
	PrintStream out;

	@BeforeMethod
	public void setUp() {
		pen = new Pen(inkContainerValue, sizeLetter, color);
		baOut = new ByteArrayOutputStream();
		out = new PrintStream(baOut);
		System.setOut(out);
		System.setErr(out);
	}

	@Test(enabled = true)
	public void checkFor_DoSomethingElse_Working() {
		pen.doSomethingElse();
		String reroutedOutput = new String(baOut.toByteArray());
		assertThat(reroutedOutput.trim(), equalTo(color));
	}

	@AfterMethod
	public void tearDown() {
		PrintStream sysOut = System.out;
		System.setOut(sysOut);
	}
}
