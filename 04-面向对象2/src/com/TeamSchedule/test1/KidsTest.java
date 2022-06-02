package com.TeamSchedule.test1;

public class KidsTest {
	public static void main(String[] args) {
		Kids someKids = new Kids(18);
		someKids.sex=0;
		someKids.salary=1000;
		someKids.manOrWoman();
		someKids.employeed();
		someKids.printAge();
	}
}
