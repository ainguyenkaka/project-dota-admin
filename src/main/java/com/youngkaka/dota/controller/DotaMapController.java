package com.youngkaka.dota.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.youngkaka.dota.entity.DotaMap;
import com.youngkaka.dota.repository.DotaMapRepository;

@Controller
@RequestMapping("/map")
public class DotaMapController {

	@Autowired
	private DotaMapRepository dotaMapRepository;

	private final String INDEX_REDIRECT = "redirect:/map";


	@GetMapping(value = { "", "/" })
	public String index(Model model) {
		// get all maps from db
		model.addAttribute("maps", dotaMapRepository.findAll());

		return "map/maps";
	}

	@GetMapping("/new")
	public String newMap() {
		return "map/new_map";
	}

	@PostMapping("/new")
	public String addNewMap(Model model, @RequestParam("name") String name,
			@RequestParam("imgUrl") String imgUrl, @RequestParam("sourceUrl") String sourceUrl) {
		if (dotaMapRepository.save(new DotaMap( name, imgUrl, sourceUrl)) != null)
			return INDEX_REDIRECT;
		else
			return "map/new_map";
	}

	@GetMapping("/update/{id}")
	public String updateMap(Model model, @PathVariable("id") int id) {

		if (dotaMapRepository.exists(id)) {
			model.addAttribute("map", dotaMapRepository.findOne(id));
			return "map/update_map";
		} else
			return INDEX_REDIRECT;
	}

	@PostMapping("/update")
	public String updateMap(Model model, @RequestParam("name") String name,
			@RequestParam("imgUrl") String imgUrl, @RequestParam("sourceUrl") String sourceUrl) {

		if (dotaMapRepository.save(new DotaMap(name, imgUrl, sourceUrl)) != null)
			return INDEX_REDIRECT;
		else
			return "map/update_map";
	}

	@GetMapping("/del/{id}")
	public String deleteMap(Model model, @PathVariable("id") int id) {
		if (dotaMapRepository.exists(id)) {
			dotaMapRepository.delete(id);
			return INDEX_REDIRECT;
		} else
			return "map/new_map";
	}

}
