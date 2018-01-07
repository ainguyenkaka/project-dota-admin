package com.youngkaka.dota.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "dota_map")
public class DotaMap {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	public String name;
	@Column(name = "img_url")
	public String imgUrl;

	@Column(name = "source_url")
	public String sourceUrl;

	public DotaMap() {

	}

	public DotaMap(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public DotaMap( String name, String imgUrl, String sourceUrl) {
		this.name = name;
		this.imgUrl = imgUrl;
		this.sourceUrl = sourceUrl;
	}

}
