package com.lintcode._190810;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.lintcode._190710.Interval;

public class Solution {
	
	public boolean canAttendMeetings(List<Interval> intervals) {
		Collections.sort(intervals,new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				return o1.start - o2.start;
			}
		});
		for(int i=0;i<intervals.size()-1;i++){
			if(intervals.get(i).end > intervals.get(i+1).start){
				return false;
			}
		}
		return true;
    }
}