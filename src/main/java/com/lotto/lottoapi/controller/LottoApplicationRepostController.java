package com.lotto.lottoapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

import com.lotto.lottoapi.entity.LottoApplicationEntity;
import com.lotto.lottoapi.entity.LottoLimitEntity;
import com.lotto.lottoapi.repository.LottoApplicationRepository;
import com.lotto.lottoapi.repository.LottoLimitRepository;
import com.lotto.lottoapi.request.ReportTwoRequest;
import com.lotto.lottoapi.response.LottoTwoListResponse;
import com.lotto.lottoapi.response.ReportTwoDetail;
import com.lotto.lottoapi.response.ReportTwoResponse;

@Controller
@RequestMapping(path = "/api/v2/lotto/report")
@CrossOrigin(origins = "*")
public class LottoApplicationRepostController {

	@Autowired
	private LottoApplicationRepository lottoApplicationRepository;

	@Autowired
	private LottoLimitRepository lottoLimitRepository;

	private static final String typeTwo = "2";
	private static final String typeThree = "3";
	private static final String subTypeUp = "up";
	private static final String subTypeDown = "down";
	private static final String subTypeDirect = "direct";
	private static final String subTypeTote = "tote";
	private static final String createBy = "SYSTEM";

	@PostMapping(path = "/two", produces = "application/json")
	public @ResponseBody ResponseEntity<?> reportTwo(@RequestBody ReportTwoRequest request) {

		List<LottoLimitEntity> lottoLimitEntityList = new ArrayList<>();
		HashMap<String, Integer> limit = new HashMap<String, Integer>();
		if (StringUtils.isNotBlank(request.getRound()) && StringUtils.isNotBlank(request.getSellerName())) {
			lottoLimitEntityList = lottoLimitRepository.findByRoundAndSellerName(request.getRound(), request.getSellerName());
			for (LottoLimitEntity lottoLimitEntity : lottoLimitEntityList) {
				limit.put(lottoLimitEntity.getNumber() + "-" + lottoLimitEntity.getType() + "-" + lottoLimitEntity.getSubtype(), lottoLimitEntity.getLimitPrice());

			}
		}

		ReportTwoResponse reportTowResponse = new ReportTwoResponse();

		int over = 0;
		int sum = 0;

		HashMap<String, LottoApplicationEntity> listUp = new HashMap<String, LottoApplicationEntity>();
		HashMap<String, LottoApplicationEntity> listDown = new HashMap<String, LottoApplicationEntity>();

		List<LottoApplicationEntity> lottoApplicationEntityList = lottoApplicationRepository.findBytype(typeTwo);
		for (LottoApplicationEntity lottoApplicationEntity : lottoApplicationEntityList) {

			String number = lottoApplicationEntity.getNumber();
			if (subTypeUp.equals(lottoApplicationEntity.getSubType())) {
				listUp.put(number, lottoApplicationEntity);
			}
			if (subTypeDown.equals(lottoApplicationEntity.getSubType())) {
				listDown.put(number, lottoApplicationEntity);
			}

		}

		List<ReportTwoDetail> ReportTwoDetailList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			ReportTwoDetail model = new ReportTwoDetail();

			String number = StringUtils.leftPad(String.valueOf(i), 2, "0");
			model.setNumber(number);

			if (listUp.containsKey(number)) {
				LottoApplicationEntity lottoApplicationEntity = listUp.get(number);
				model.setUp(lottoApplicationEntity.getPrice());
				sum += lottoApplicationEntity.getPrice();
				Integer limitPrice = limit.get(lottoApplicationEntity.getNumber() + "-" + lottoApplicationEntity.getType() + "-" + lottoApplicationEntity.getSubType());
				if (limitPrice != null) {
					model.setUpLimit(limitPrice);
					if (lottoApplicationEntity.getPrice() >= limitPrice) {
						model.setUpMax(true);
						over += limitPrice - lottoApplicationEntity.getPrice();
					}
				}
			}

			if (listDown.containsKey(number)) {
				LottoApplicationEntity lottoApplicationEntity = listDown.get(number);
				model.setDown(lottoApplicationEntity.getPrice());
				sum += lottoApplicationEntity.getPrice();
				Integer limitPrice = limit.get(lottoApplicationEntity.getNumber() + "-" + lottoApplicationEntity.getType() + "-" + lottoApplicationEntity.getSubType());
				if (limitPrice != null) {
					model.setDownLimit(limitPrice);
					if (lottoApplicationEntity.getPrice() >= limitPrice) {
						model.setDownMax(true);
						over += limitPrice - lottoApplicationEntity.getPrice();
					}
				}
			}

			ReportTwoDetailList.add(model);

		}

		reportTowResponse.setList(ReportTwoDetailList);
		reportTowResponse.setOver(over);
		reportTowResponse.setSum(sum);

		return new ResponseEntity<>(reportTowResponse, HttpStatus.OK);
	}

}
