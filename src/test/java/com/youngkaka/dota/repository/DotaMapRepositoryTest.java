package com.youngkaka.dota.repository;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.youngkaka.dota.entity.DotaMap;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DotaMapRepositoryTest {
	
	@Autowired
	private DotaMapRepository dotaMapRepository;
	
	private DotaMap dotaMap;
	
	@Before
	public void before(){
		dotaMap = new DotaMap(1, "map1");
		dotaMapRepository.save(dotaMap);
	}
	
	@Test
	public void testAll(){
		boolean expected = true;
		boolean result = dotaMapRepository.findAll().size() > 0;
		assertEquals(expected,result);
	}
	
	@Test
	public void testGetOne(){
		boolean expected = true;
		boolean result = dotaMapRepository.findOne(dotaMap.id) != null;
		assertEquals(expected,result);
	}
	
	@After
	public void after(){
		dotaMapRepository.delete(dotaMap);
	}
	
}
