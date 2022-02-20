package com.lotto.lottoapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lotto.lottoapi.entity.LottoApplicationEntity;
import com.lotto.lottoapi.repository.LottoApplicationRepository;

@Controller
@RequestMapping(path = "/api/v2/lotto/repost")
@CrossOrigin(origins = "*")
public class LottoApplicationRepostController {

	@Autowired
	private LottoApplicationRepository lottoApplicationRepository;

	@PostMapping(path = "/two", produces = "application/json")
	public @ResponseBody ResponseEntity<?> reportTwo() {

		List<LottoApplicationEntity> lottoApplicationEntityList = lottoApplicationRepository.findBytype("2");
		for (LottoApplicationEntity lottoApplicationEntity : lottoApplicationEntityList) {

		}

		return new ResponseEntity<>(null, HttpStatus.OK);
	}

}
