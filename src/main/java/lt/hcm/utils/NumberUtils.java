package lt.hcm.utils;

/***
    Copyright (C) 2017 HCM.LT. All rights reserved. 

    Contact authors at info@hcm.lt
  

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

*/

public class NumberUtils {

	public static String numberToWords(int number){
		if (number == 0)
			return "nulis";
		
		String rez = "";
		
		if (number < 0){
			rez = "minus ";
			number = -number;
		}
		
		int tens         = number %       100;
		int hundreds     = number %      1000 / 100;
		int thousands    = number %   1000000 / 1000;
		
		int millions = number % 1000000000 / 1000000 ;
		
		rez = rez 
				+ millions(millions)
				+ thousands(thousands)
				+ hundreds(hundreds) 
				+ tens(tens);
		
		return rez.trim();
	}
	
	private static String tens(int number){
		if (number < 20)
			return liolika(number);
		
		int tens = number / 10;
		int ones = number % 10;
		
		return liasdesimt(tens)+liolika(ones);
	}
	
	private static String liolika(int number){
		switch(number){
		case 0: return "";
		case 1: return " vienas";
		case 2: return " du";
		case 3: return " trys";
		case 4: return " keturi";
		case 5: return " penki";
		case 6: return " šeši";
		case 7: return " septyni";
		case 8: return " aštuoni";
		case 9: return " devyni";
		case 10: return " dešimt";
		case 11: return " vienuolika";
		case 12: return " dvylika";
		case 13: return " trylika";
		case 14: return " keturiolika";
		case 15: return " penkiolika";
		case 16: return " šešiolika";
		case 17: return " septyniolika";
		case 18: return " aštuoniolika";
		case 19: return " devyniolika";
		default:
			throw new RuntimeException("internal number conversion logic error");
		}
	}
	
	private static String liasdesimt(int n){
		switch(n){
		case 2: return " dvidešimt";
		case 3: return " trisdešimt";
		case 4: return " keturiasdešimt";
		case 5: return " penkiasdešimt";
		case 6: return " šešiasdešimt";
		case 7: return " septyniasdešimt";
		case 8: return " aštuoniasdešimt";
		case 9: return " devyniasdešimt";
		default:
			throw new RuntimeException("internal number conversion logic error");
		}
	}
	
	private static String hundreds(int n){
		if (n == 0)
			return "";
		
		if (n > 9)
			throw new RuntimeException("internal number conversion logic error");
		
		if (n == 1)
			return " vienas šimtas";
		
		return liolika(n) + " šimtai";
	}
	
	private static String thousands(int n){
		if (n == 0)
			return "";
		
		if (n > 999)
			throw new RuntimeException("internal number conversion logic error");
		
		int tens = n % 100;
		int hundreds = n / 100;
		
		return hundreds(hundreds)
				+ tens(tens)
				+ thousandsEnding(n);
	}
	
	private static String thousandsEnding(int n){
		int m = n%100;
		
		if (m >=10 && m <=20)
			return " tūkstančių";
		
		if (m % 10 == 0)
			return " tūkstančių";
		
		if (m % 10 == 1)
			return " tūkstantis";
		
		return " tūkstančiai";
	}
	
	private static String millions(int n){
		if (n == 0)
			return "";
		
		if (n > 999)
			throw new RuntimeException("internal number conversion logic error");
		
		int tens = n % 100;
		int hundreds = n / 100;
		
		return hundreds(hundreds)
				+ tens(tens)
				+ millionsEnding(n);
	}
	
	private static String millionsEnding(int n){
		int m = n%100;
		
		if (m >=10 && m <=20)
			return " milijonų";
		
		if (m % 10 == 0)
			return " milijonų";
		
		if (m % 10 == 1)
			return " milijonas";
		
		return " milijonai";
	}

}
