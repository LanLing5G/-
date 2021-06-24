package com.neu.ch2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.neu.bean.Teacher;
import javafx.scene.control.ListCell;

public class CollectionDemo {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//创建一个教师对象
		Teacher t1=new Teacher("t001","孙悟空");
		Teacher t2=new Teacher("t002","唐僧");
		
		//创建一个列表对象
		List<Teacher> list=new ArrayList();
		//添加对象
		list.add(t1);
		list.add(t2);
		//取出
		for(Teacher t:list) {
			System.out.println(t.getAnme());
		}
		
		
		//Map
		Map<String,Teacher> map=new HashMap();
		map.put(t1.getUserNo(),t1);
		map.put(t2.getUserNo(),t2);
		System.out.println("=====================");
		System.out.println(map.get(t1.getUserNo()).getAnme());
		System.out.println("=====================");
		//先取出map中的建，通过建取出教师对象
		for(String key:map.keySet()) {
			System.out.println(map.get(key).getAnme());
		}
	}

}
