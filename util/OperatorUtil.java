package com.tcs.ilp.infinity.util;

public class OperatorUtil {
	public static String addEightHours(String time){
		String subTime1 = "";
		String subTime2 = "";
		boolean minutes = false;
		
		for (int i = 0; i <= time.length() - 1; i++)
		{			
			if (time.charAt(i) == ':')
			{
				minutes = true;
			}
			
			if (minutes == false)
			{
				subTime1 += time.charAt(i);
			}
			
			if (minutes == true)
			{				
				if (time.charAt(i) != ':')
				{
					subTime2 += time.charAt(i);
				}
			}												
		}
		
		int hourTime = Integer.parseInt(subTime1);				
		hourTime += 8;		
		if (hourTime >= 24)
		{
			hourTime -= 24;
		}
	
		subTime1 = Integer.toString(hourTime);
		time = subTime1 + ':' + subTime2;		
		
		return time;
	}
}
