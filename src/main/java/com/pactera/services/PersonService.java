package com.pactera.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.pactera.domain.Person;

/**
 * @Description:
 * @Author:	闄堝瓙鏋�
 * @Company:	http://java.itcast.cn
 * @CreateDate:	2014-7-19
 */

@Service
public class PersonService {
	//妯℃嫙鍐呭瓨鏁版嵁搴擄紝鍑嗗鏁版嵁
	private static Map<Integer,Person> map = new HashMap<Integer, Person>();	//澹版槑涓�釜瀹瑰櫒
	private static Integer id = 0;												//鍒濆鍖杋d
	
	//鍒╃敤闈欐�鍧楀垵濮嬪寲鏁版嵁
	static{
		for(int i=0;i<10;i++){
			Person p = new Person();
			p.setId(id++);
			p.setName("tony"+i);
			p.setAge(10+i);
			
			map.put(i, p);
		}
	}
	
	//鍒楄〃
	public List<Person> findAll(){
		return new ArrayList<Person>(map.values());			//灏唌ap瀵硅薄杞崲涓簂ist闆嗗悎
	}
	
	//鑾峰緱涓�釜璁板綍
	public Person get(Integer id){
		return map.get(id);
	}
	
	//鏂板
	public void insert(Person p){
		id++;
		p.setId(id);
		
		map.put(id, p);
	}
	
	//淇敼
	public void update(Person p){
		map.put(p.getId(), p);
	}
	
	//鍒犻櫎鍗曟潯
	public void deleteById(Integer id){
		map.remove(id);
	}

}
