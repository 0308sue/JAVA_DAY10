package swing1;

import java.util.Calendar;

public class CalendarTest {
 
	public static void main(String[] args) {
	  Calendar now = 	Calendar.getInstance();
	 int year =  now.get(Calendar.YEAR);
	 int month = now.get(Calendar.MONTH)+1; //0부터 시작
	 int day = now.get(Calendar.DAY_OF_MONTH);
	 System.out.println(year + "년 " + month +" 월" + day + "일");
	 int ampm = now.get(Calendar.AM_PM);
	 int h = now.get(Calendar.HOUR);
	 int m = now.get(Calendar.MINUTE);
	 int s = now.get(Calendar.SECOND);
	 String str ="";
	 if(ampm == Calendar.PM) { //Calendar.PM =1
		 str = "오후";
	 }else {    // Calendar.AM = 0
		 str = "오전";
	 }
	 System.out.println("ampm : " + ampm);
	 System.out.println( str + " >> " +h +" : " + m +" : " + s);
	 System.out.println("=====");
	 int hourOfDay = now.get(Calendar.HOUR_OF_DAY);
	 System.out.println( "hourOfDay  >> " +hourOfDay +" : " + m +" : " + s);
	 System.out.println("==요일===");
	  int dayOfWeek =  now.get(Calendar.DAY_OF_WEEK);
	  System.out.println("요일 : " +dayOfWeek );
	  //일 1, 월 2, 화 3, 수 4, 목 5, 금 6, 토 7
	  //switch 사용해서 요일 알려주기
	  String tmp="";
	  switch(dayOfWeek) {
		  case Calendar.SUNDAY: tmp = "일"; break;
		  case Calendar.MONDAY: tmp = "월"; break;
		  case 3: tmp = "화"; break;
		  case 4: tmp = "수"; break;
		  case 5: tmp = "목"; break;
		  case 6: tmp = "금"; break;
		  case Calendar.SATURDAY: tmp = "토"; break;	
	  }
	  System.out.println("switch요일 : " +tmp );
	  //배열 arr 사용해서 요일 알려주기
	  String[] arr = {"일","월","화","수","목","금","토"};
	  System.out.println("배열요일 : " + arr[dayOfWeek-1]);
	  
	  Calendar someday = Calendar.getInstance();
	  //2022년 12월 25일
	  someday.set(2022, 11,25);
	  // 2022년 12월 25일 요일구하기
	  System.out.println("올해 크리스마스 요일 : " + arr[someday.get(Calendar.DAY_OF_WEEK)-1]);
	  // 생일의 요일 구하기 (2019. 6. 6)
	  Calendar birth = Calendar.getInstance();
	  birth.set(2019,5,6);
	    
	  System.out.println("생일요일 : " + arr[birth.get(Calendar.DAY_OF_WEEK)-1]);
  
	}
 
}

