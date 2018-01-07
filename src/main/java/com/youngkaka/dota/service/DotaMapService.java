package com.youngkaka.dota.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youngkaka.dota.entity.DotaMap;
import com.youngkaka.dota.repository.DotaMapRepository;

@RestController
@RequestMapping("/api/map")
public class DotaMapService {

	@Autowired
	private DotaMapRepository dotaMapRepository;
	
	@GetMapping(value={"/",""})
	public List<DotaMap> all(){
		return dotaMapRepository.findAll();
	}
}
