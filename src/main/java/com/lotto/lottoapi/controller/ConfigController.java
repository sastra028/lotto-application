package com.lotto.lottoapi.controller;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lotto.lottoapi.entity.RoundMasterEntity;
import com.lotto.lottoapi.repository.RoundMasterRepository;
import com.lotto.lottoapi.request.RoundRequest;
import com.lotto.lottoapi.response.CommondResponse;

@Controller
@RequestMapping(path = "/api/lotto/config")
@CrossOrigin(origins = "*")
public class ConfigController {

	@Autowired
	private RoundMasterRepository roundMasterRepository;

	@PostMapping(path = "/round/list", produces = "application/json")
	public @ResponseBody ResponseEntity<?> roundList() {
		List<RoundMasterEntity> roundMasterEntityList = roundMasterRepository.findByActive("Y");
		return new ResponseEntity<>(roundMasterEntityList, HttpStatus.OK);
	}

	@PostMapping(path = "/round/add", produces = "application/json")
	public @ResponseBody ResponseEntity<?> roundAdd(@RequestBody RoundRequest request) {

		CommondResponse commondResponse = new CommondResponse();

		if (StringUtils.isBlank(request.getRound())) {
			commondResponse.setStatus("error");
			commondResponse.setErrorMessage("กรุณาระบุงวด");
			return new ResponseEntity<>(commondResponse, HttpStatus.BAD_REQUEST);
		}

		Optional<RoundMasterEntity> roundMasterEntityOptional = roundMasterRepository.findById(request.getRound());
		if (roundMasterEntityOptional.isPresent()) {
			commondResponse.setStatus("error");
			commondResponse.setErrorMessage("มีงวดนี้ในระบบแล้ว");
			return new ResponseEntity<>(commondResponse, HttpStatus.BAD_REQUEST);
		}
		RoundMasterEntity roundMasterEntity = new RoundMasterEntity();
		roundMasterEntity.setRound(request.getRound());
		roundMasterRepository.save(roundMasterEntity);

		commondResponse.setStatus("success");

		return new ResponseEntity<>(commondResponse, HttpStatus.OK);
	}

	@PostMapping(path = "/round/delete", produces = "application/json")
	public @ResponseBody ResponseEntity<?> roundDelete(@RequestBody RoundRequest request) {

		CommondResponse commondResponse = new CommondResponse();

		if (StringUtils.isBlank(request.getRound())) {
			commondResponse.setStatus("error");
			commondResponse.setErrorMessage("กรุณาระบุงวด");
			return new ResponseEntity<>(commondResponse, HttpStatus.BAD_REQUEST);
		}

		Optional<RoundMasterEntity> roundMasterEntityOptional = roundMasterRepository.findById(request.getRound());
		if (!roundMasterEntityOptional.isPresent()) {
			commondResponse.setStatus("error");
			commondResponse.setErrorMessage("ไม่มีงวดนี้ในระบบ");
			return new ResponseEntity<>(commondResponse, HttpStatus.BAD_REQUEST);
		}

		roundMasterRepository.delete(roundMasterEntityOptional.get());

		commondResponse.setStatus("success");

		return new ResponseEntity<>(commondResponse, HttpStatus.OK);
	}
}
