package com.google.code.guava;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;


public class FunctionPrograming {	
	public static void main(String[] args) {
		//// 过滤
		List<String> request = new ArrayList<String>();
		request.add("?abcd=baiduhhhhhh");
		request.add("bcd");
		request.add("addhd");
		Collection<String> filtered = Collections2.filter(request, new Predicate<String>(){
			@Override
			public boolean apply(String input) {
				// TODO Auto-generated method stub
				if(input.length() > 5)
					return false;
				return true;
			}			
		 });
		System.out.println(filtered.toString());
		//类型转换
		List<Long> dates = new ArrayList<Long>();
		dates.add(System.currentTimeMillis());
		dates.add(0L);
		dates.add(19930610L);
		Collection<String> day = Collections2.transform(dates, new Function<Long,String>(){
			@Override
			public String apply(Long input) {
				// TODO Auto-generated method stub
				return new SimpleDateFormat("MM/dd/yyyy").format(input);
			}			
		});
		for(String str : day){
			System.out.println(str);
		}
		//组合函数编程
		List<String> lst = new ArrayList<String>();
		lst.add("haoli");
		lst.add("beihanguniversity");
		lst.add("pcm2017");
		Function<String, String> f1 = new Function<String,String>(){			
			@Override
			public String apply(String input) {
				return input.length() > 5 ? input.substring(0,5) : input;
			}			
		};
		Function<String, String> f2 = new Function<String,String>(){			
			@Override
			public String apply(String input) {
				return input.toUpperCase();
			}			
		};
		Collection<String> res = Collections2.transform(lst, Functions.compose(f1, f2));
		System.out.println(res.toString());
		/*//约束,在guava22.0中为找到约束类
		Set<String> sets = Sets.newHashSet();
		Constraint<String> constraint = new Constraint<String>(){
			
		};
		sets.add()*/
	}
}
