package com.britebill.interview.transformers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransformerDataTest {

	private TransformerData transformerData = new TransformerData();

	private List<String> dummyData = new ArrayList<>(
			Arrays.asList(
					"unplait",
					"globulin",
					"globulins",
					"scouring",
					"corkwing",
					"s",
					"scours",
					"scourway",
					"unplait",
					"globulinuria",
					"globulysis",
					"red-flag",
					"co",
					"cork-tipped",
					"unplait",
					"corkwing",
					"corkwood",
					"red-flagger",
					"unplait",
					"red-flaggery",
					"powwowed",
					"powwows",
					"red-flanked",
					"red-flecked",
					"red-flesheda",
					"lthein",
					"altheine",
					"Altheta",
					"s",
					"scouriness",
					"corkwing",
					"scourweed",
					"unplained",
					"unplainly",
					"unplainness",
					"unplait",
					"scourwort",
					"Scouse",
					"Althing",
					"althionic",
					"corkwing",
					"altho",
					"althorn",
					"unplait"
			)
	);


	@Test
	public void testNullInput() {
		// TODO: Add your Test implementation here
		transformerData.transformData(null);
	}
	@Test
	public void testEmptyInput() {
		// TODO: Add your Test implementation here
		transformerData.transformData(new ArrayList<>());
	}
	@Test
	public void testDuplicates() {
		// TODO: Add your Test implementation here
		transformerData.transformData(dummyData);
	}
	@Test
	public void testSorting() {
		// TODO: Add your Test implementation here
		transformerData.transformData(dummyData);
	}
}
