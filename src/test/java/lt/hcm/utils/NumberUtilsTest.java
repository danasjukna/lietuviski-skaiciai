package lt.hcm.utils;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/***
  

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.


    Copyright (C) 2017 HCM.LT. All rights reserved. 

    Contact authors at info@hcm.lt

*/


public class NumberUtilsTest {

	public void testNumber(int n, String result){
		assertEquals(result, NumberUtils.numberToWords(n));
	}
	
	@Test
	public void test(){

		testNumber(0, "nulis");
		testNumber(8, "aštuoni");
		testNumber(10, "dešimt");
		testNumber(19, "devyniolika");
		testNumber(20, "dvidešimt");
		testNumber(21, "dvidešimt vienas");
		testNumber(99, "devyniasdešimt devyni");
		testNumber(100, "vienas šimtas");
		testNumber(101, "vienas šimtas vienas");
		testNumber(200, "du šimtai");
		testNumber(713, "septyni šimtai trylika");
		testNumber(999, "devyni šimtai devyniasdešimt devyni");
		testNumber(1000, "vienas tūkstantis");
		testNumber(1001, "vienas tūkstantis vienas");
		testNumber(3078, "trys tūkstančiai septyniasdešimt aštuoni");
		testNumber(1978, "vienas tūkstantis devyni šimtai septyniasdešimt aštuoni");
		testNumber(10000, "dešimt tūkstančių");
		testNumber(10010, "dešimt tūkstančių dešimt");
		testNumber(10700, "dešimt tūkstančių septyni šimtai");
		testNumber(17917, "septyniolika tūkstančių devyni šimtai septyniolika");
		testNumber(57917, "penkiasdešimt septyni tūkstančiai devyni šimtai septyniolika");
		testNumber(100000, "vienas šimtas tūkstančių");
		testNumber(777777, "septyni šimtai septyniasdešimt septyni tūkstančiai septyni šimtai septyniasdešimt septyni");
		testNumber(1017917, "vienas milijonas septyniolika tūkstančių devyni šimtai septyniolika");
		testNumber(3057917, "trys milijonai penkiasdešimt septyni tūkstančiai devyni šimtai septyniolika");
		testNumber(56100000, "penkiasdešimt šeši milijonai vienas šimtas tūkstančių");
		testNumber(999777777, "devyni šimtai devyniasdešimt devyni milijonai septyni šimtai septyniasdešimt septyni tūkstančiai septyni šimtai septyniasdešimt septyni");

	}
}
