package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CS401.Student;

class studentTest {

	@Test
	void test() {
		Student tester1 = new Student(20354898, "WanglinSong");
		Student tester2 = new Student(20400778, "WanglinSong");
		Student tester3 = new Student(20354898, "Bingxin");
		assertEquals(20354898, tester1.getId(), "The id of tester1 is not set correctly!");
		assertEquals("WanglinSong", tester1.getName(), "The name of tester1 is not set correctly!");
		assertEquals("The student name is: WanglinSong, id is: 20354898", tester1.toString(), 
				"The toString method of tester1 is not set correctly!");
		assertTrue("The name compareTo method is not set correctly!", tester1.compareTo(tester3)>0);
		assertTrue("The name compareTo method is not set correctly!", tester1.compareTo(tester1)==0);
		assertTrue("The name compareTo method is not set correctly!", tester3.compareTo(tester1)<0);
		assertTrue("The id compareTo method is not set correctly!", tester1.compareTo(tester2)<0);
		assertTrue("The id compareTo method is not set correctly!", tester1.compareTo(tester1)==0);
		assertTrue("The id compareTo method is not set correctly!", tester2.compareTo(tester1)>0);
		assertEquals(-1, tester1.compare(tester1, tester2), "The compare method is not correct!");
	}
}