package com.lotto.lottoapi.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

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

import com.lotto.lottoapi.entity.LottoEntity;
import com.lotto.lottoapi.repository.LottoRepository;
import com.lotto.lottoapi.request.LottoSaveRequest;
import com.lotto.lottoapi.request.LottoThreeRequest;
import com.lotto.lottoapi.response.LottoSaveResponse;
import com.lotto.lottoapi.response.LottoThreeListNewResponse;
import com.lotto.lottoapi.response.LottoThreeListResponse;
import com.lotto.lottoapi.response.LottoThreeListSubResponse;
import com.lotto.lottoapi.response.LottoTwoListNewResponse;
import com.lotto.lottoapi.response.LottoTwoListNewResponse2;
import com.lotto.lottoapi.response.LottoTwoListResponse;

@Controller
@RequestMapping(path = "/api/lotto")
@CrossOrigin(origins = "*")
public class LottoController {

	@Autowired
	private LottoRepository lottoRepository;

	
	@PostMapping(path = "/list-bill", produces = "application/json")
	public @ResponseBody ResponseEntity<?> listBill() {

		List<LottoEntity> lottoEntityList = lottoRepository.findByType("2");

		HashMap<String, Integer> countPriceA = new HashMap<String, Integer>();
		HashMap<String, Integer> countPriceB = new HashMap<String, Integer>();
		HashMap<String, String> buyerName = new HashMap<String, String>();

		for (LottoEntity lottoEntity : lottoEntityList) {
			if (countPriceA.containsKey(lottoEntity.getNumber())) {
				Integer price = countPriceA.get(lottoEntity.getNumber()) + lottoEntity.getPriceA();
				countPriceA.put(lottoEntity.getNumber(), price);
			} else {
				countPriceA.put(lottoEntity.getNumber(), lottoEntity.getPriceA());
			}

			if (countPriceB.containsKey(lottoEntity.getNumber())) {
				Integer price = countPriceB.get(lottoEntity.getNumber()) + lottoEntity.getPriceB();
				countPriceB.put(lottoEntity.getNumber(), price);
			} else {
				countPriceB.put(lottoEntity.getNumber(), lottoEntity.getPriceB());
			}
			if(buyerName.containsKey(lottoEntity.getBuyerName())) {
				buyerName.put(null, lottoEntity.getBuyerName());
			} else {
				
			}
		}

//		List<LottoTwoListNewResponse> lottoTwoListNewResponseList = new ArrayList<>();
//		LottoTwoListNewResponse lottoTwoListNewResponse = new LottoTwoListNewResponse();
		List<LottoTwoListResponse> lottoTwoListResponseList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			LottoTwoListResponse model = new LottoTwoListResponse();

			String number = StringUtils.leftPad(String.valueOf(i), 2, "0");
			model.setNumber(number);

			if (countPriceA.containsKey(number)) {
				Integer price = countPriceA.get(number);
				model.setUp(String.valueOf(price));
			}

			if (countPriceB.containsKey(number)) {
				Integer price = countPriceB.get(number);
				model.setDown(String.valueOf(price));
			}

			if (StringUtils.isNotBlank(model.getUp()) && StringUtils.isNotBlank(model.getDown())) {
				lottoTwoListResponseList.add(model);
			}

		}

		return new ResponseEntity<>(lottoTwoListResponseList, HttpStatus.OK);
	}
	
	@PostMapping(path = "/list2", produces = "application/json")
	public @ResponseBody ResponseEntity<?> list2() {

		List<LottoEntity> lottoEntityList = lottoRepository.findByType("2");

		HashMap<String, Integer> countPriceA = new HashMap<String, Integer>();
		HashMap<String, Integer> countPriceB = new HashMap<String, Integer>();

		for (LottoEntity lottoEntity : lottoEntityList) {
			if (countPriceA.containsKey(lottoEntity.getNumber())) {
				Integer price = countPriceA.get(lottoEntity.getNumber()) + lottoEntity.getPriceA();
				countPriceA.put(lottoEntity.getNumber(), price);
			} else {
				countPriceA.put(lottoEntity.getNumber(), lottoEntity.getPriceA());
			}

			if (countPriceB.containsKey(lottoEntity.getNumber())) {
				Integer price = countPriceB.get(lottoEntity.getNumber()) + lottoEntity.getPriceB();
				countPriceB.put(lottoEntity.getNumber(), price);
			} else {
				countPriceB.put(lottoEntity.getNumber(), lottoEntity.getPriceB());
			}
		}

		List<LottoTwoListResponse> lottoTwoListResponseList = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			LottoTwoListResponse model = new LottoTwoListResponse();

			String number = StringUtils.leftPad(String.valueOf(i), 2, "0");
			model.setNumber(number);

			if (countPriceA.containsKey(number)) {
				Integer price = countPriceA.get(number);
				model.setUp(String.valueOf(price));
			}

			if (countPriceB.containsKey(number)) {
				Integer price = countPriceB.get(number);
				model.setDown(String.valueOf(price));
			}

			if (StringUtils.isNotBlank(model.getUp()) && StringUtils.isNotBlank(model.getDown())) {
				lottoTwoListResponseList.add(model);
			}

		}

		return new ResponseEntity<>(lottoTwoListResponseList, HttpStatus.OK);
	}

	@PostMapping(path = "/list3-main", produces = "application/json")
	public @ResponseBody ResponseEntity<?> list3_0(@RequestBody LottoThreeRequest request) {

		List<LottoEntity> lottoEntityList = lottoRepository.findByType("3");

		HashMap<String, Integer> countPriceA = new HashMap<String, Integer>();
		HashMap<String, Integer> countPriceB = new HashMap<String, Integer>();

		for (LottoEntity lottoEntity : lottoEntityList) {
			if (countPriceA.containsKey(lottoEntity.getNumber())) {
				Integer price = countPriceA.get(lottoEntity.getNumber()) + lottoEntity.getPriceA();
				countPriceA.put(lottoEntity.getNumber(), price);
			} else {
				countPriceA.put(lottoEntity.getNumber(), lottoEntity.getPriceA());
			}

			if (countPriceB.containsKey(lottoEntity.getNumber())) {
				Integer price = countPriceB.get(lottoEntity.getNumber()) + lottoEntity.getPriceB();
				countPriceB.put(lottoEntity.getNumber(), price);
			} else {
				countPriceB.put(lottoEntity.getNumber(), lottoEntity.getPriceB());
			}
		}

		int startLength = 0;
		int endLength = 0;
		switch (request.getMain()) {
		case "0":
			startLength = 0;
			endLength = 100;
			break;
		case "1":
			startLength = 100;
			endLength = 200;
			break;
		case "2":
			startLength = 200;
			endLength = 300;
			break;
		case "3":
			startLength = 300;
			endLength = 400;
			break;
		case "4":
			startLength = 400;
			endLength = 500;
			break;
		case "5":
			startLength = 500;
			endLength = 600;
			break;
		case "6":
			startLength = 600;
			endLength = 700;
			break;
		case "7":
			startLength = 700;
			endLength = 800;
			break;
		case "8":
			startLength = 800;
			endLength = 900;
			break;
		case "9":
			startLength = 900;
			endLength = 1000;
			break;
		default:
			break;
		}

		List<LottoThreeListNewResponse> response = new ArrayList<>();
		for (int i = startLength; i < endLength; i++) {
			LottoThreeListNewResponse model = new LottoThreeListNewResponse();

			String number = StringUtils.leftPad(String.valueOf(i), 3, "0");
			model.setNumber(number);

			if (countPriceA.containsKey(number)) {
				Integer price = countPriceA.get(number);
				model.setDirect(String.valueOf(price));
			}

			if (countPriceB.containsKey(number)) {
				Integer price = countPriceB.get(number);
				model.setTote(String.valueOf(price));
			}

			if (StringUtils.isNotBlank(model.getDirect()) && StringUtils.isNotBlank(model.getTote())) {
				response.add(model);
			}

		}

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/save")
	public @ResponseBody ResponseEntity<?> save(@RequestBody @Valid LottoSaveRequest request) {

		LottoSaveResponse lottoSaveResponse = new LottoSaveResponse();

		// validate
		if (StringUtils.isBlank(request.getNumber())) {
			lottoSaveResponse.setStatus("error");
			lottoSaveResponse.setErrorMessage("กรุณาระบุเลขที่ซื้อ");
			return new ResponseEntity<>(lottoSaveResponse, HttpStatus.BAD_REQUEST);
		}

		if (StringUtils.isBlank(request.getPriceA()) && StringUtils.isBlank(request.getPriceB())) {
			lottoSaveResponse.setStatus("error");
			lottoSaveResponse.setErrorMessage("ไม่ได้ระบุราคาที่ซื้อ");
			return new ResponseEntity<>(lottoSaveResponse, HttpStatus.BAD_REQUEST);
		}

		int priceA = 0;
		try {
			priceA = Integer.parseInt(request.getPriceA());
		} catch (Exception e) {
//			return new ResponseEntity<>("ราคา บน/ตรง ไม่ถูกต้อง", HttpStatus.BAD_REQUEST);
		}

		int priceB = 0;
		try {
			priceB = Integer.parseInt(request.getPriceB());
		} catch (Exception e) {
//			return new ResponseEntity<>("ราคา ล้าง/โต๊ท ไม่ถูกต้อง", HttpStatus.BAD_REQUEST);
		}

		LottoEntity lottoEntity = new LottoEntity();
		lottoEntity.setId(UUID.randomUUID().toString());

		lottoEntity.setNumber(request.getNumber());
		if (request.getNumber().length() == 2) {
			lottoEntity.setType("2");
		} else if (request.getNumber().length() == 3) {
			lottoEntity.setType("3");
		} else {
			lottoSaveResponse.setStatus("error");
			lottoSaveResponse.setErrorMessage("หลักของเลขที่ซื้อไม่ถูกต้อง");
			return new ResponseEntity<>(lottoSaveResponse, HttpStatus.BAD_REQUEST);
		}

		lottoEntity.setPriceA(priceA);
		lottoEntity.setPriceB(priceB);

		lottoEntity.setBuyerName(request.getBuyerName());

		lottoEntity.setCreated(new Date());
		lottoEntity.setCreateBy("system");
		lottoRepository.save(lottoEntity);

		lottoSaveResponse.setStatus("success");

		return new ResponseEntity<>(lottoSaveResponse, HttpStatus.OK);
	}

	@PostMapping("/list3")
	public @ResponseBody ResponseEntity<?> list3() {

		List<LottoEntity> lottoEntityList = lottoRepository.findByType("3");

		HashMap<String, Integer> countPriceA = new HashMap<String, Integer>();
		HashMap<String, Integer> countPriceB = new HashMap<String, Integer>();

		for (LottoEntity lottoEntity : lottoEntityList) {
			if (countPriceA.containsKey(lottoEntity.getNumber())) {
				Integer price = countPriceA.get(lottoEntity.getNumber()) + lottoEntity.getPriceA();
				countPriceA.put(lottoEntity.getNumber(), price);
			} else {
				countPriceA.put(lottoEntity.getNumber(), lottoEntity.getPriceA());
			}

			if (countPriceB.containsKey(lottoEntity.getNumber())) {
				Integer price = countPriceB.get(lottoEntity.getNumber()) + lottoEntity.getPriceB();
				countPriceB.put(lottoEntity.getNumber(), price);
			} else {
				countPriceB.put(lottoEntity.getNumber(), lottoEntity.getPriceB());
			}
		}

		List<LottoThreeListResponse> lottoThreeListResponses = new ArrayList<>();
		LottoThreeListResponse lottoThreeListResponse = new LottoThreeListResponse();
		List<LottoThreeListSubResponse> lottoThreeListSubResponseList = new ArrayList<>();
		for (int i = 0; i < 1000; i++) {
			LottoThreeListSubResponse model = new LottoThreeListSubResponse();

			String number = StringUtils.leftPad(String.valueOf(i), 3, "0");
			model.setNumber(number);

			if (countPriceA.containsKey(number)) {
				Integer price = countPriceA.get(number);
				model.setDirect(String.valueOf(price));
			}

			if (countPriceB.containsKey(number)) {
				Integer price = countPriceB.get(number);
				model.setTote(String.valueOf(price));
			}

			if (i < 100) {
				lottoThreeListResponse.setMain("0");
				if (StringUtils.isNotBlank(model.getDirect()) && StringUtils.isNotBlank(model.getTote())) {
					lottoThreeListSubResponseList.add(model);
				}
				if (i == 99) {
					lottoThreeListResponse.setList(lottoThreeListSubResponseList);
					lottoThreeListResponses.add(lottoThreeListResponse);
					lottoThreeListResponse = new LottoThreeListResponse();
					lottoThreeListSubResponseList = new ArrayList<>();
				}
			} else if (i < 200) {
				lottoThreeListResponse.setMain("1");
				if (StringUtils.isNotBlank(model.getDirect()) && StringUtils.isNotBlank(model.getTote())) {
					lottoThreeListSubResponseList.add(model);
				}
				if (i == 199) {
					lottoThreeListResponse.setList(lottoThreeListSubResponseList);
					lottoThreeListResponses.add(lottoThreeListResponse);
					lottoThreeListResponse = new LottoThreeListResponse();
					lottoThreeListSubResponseList = new ArrayList<>();
				}
			} else if (i < 300) {
				lottoThreeListResponse = new LottoThreeListResponse();
				lottoThreeListSubResponseList = new ArrayList<>();
				lottoThreeListResponse.setMain("2");
				if (StringUtils.isNotBlank(model.getDirect()) && StringUtils.isNotBlank(model.getTote())) {
					lottoThreeListSubResponseList.add(model);
				}
				if (i == 299) {
					lottoThreeListResponse.setList(lottoThreeListSubResponseList);
					lottoThreeListResponses.add(lottoThreeListResponse);
					lottoThreeListResponse = new LottoThreeListResponse();
					lottoThreeListSubResponseList = new ArrayList<>();
				}
			} else if (i < 400) {
				lottoThreeListResponse = new LottoThreeListResponse();
				lottoThreeListSubResponseList = new ArrayList<>();
				lottoThreeListResponse.setMain("3");
				if (StringUtils.isNotBlank(model.getDirect()) && StringUtils.isNotBlank(model.getTote())) {
					lottoThreeListSubResponseList.add(model);
				}
				if (i == 399) {
					lottoThreeListResponse.setList(lottoThreeListSubResponseList);
					lottoThreeListResponses.add(lottoThreeListResponse);
					lottoThreeListResponse = new LottoThreeListResponse();
					lottoThreeListSubResponseList = new ArrayList<>();
				}
			} else if (i < 500) {
				lottoThreeListResponse = new LottoThreeListResponse();
				lottoThreeListSubResponseList = new ArrayList<>();
				lottoThreeListResponse.setMain("4");
				if (StringUtils.isNotBlank(model.getDirect()) && StringUtils.isNotBlank(model.getTote())) {
					lottoThreeListSubResponseList.add(model);
				}
				if (i == 499) {
					lottoThreeListResponse.setList(lottoThreeListSubResponseList);
					lottoThreeListResponses.add(lottoThreeListResponse);
					lottoThreeListResponse = new LottoThreeListResponse();
					lottoThreeListSubResponseList = new ArrayList<>();
				}
			} else if (i < 600) {
				lottoThreeListResponse = new LottoThreeListResponse();
				lottoThreeListSubResponseList = new ArrayList<>();
				lottoThreeListResponse.setMain("5");
				if (StringUtils.isNotBlank(model.getDirect()) && StringUtils.isNotBlank(model.getTote())) {
					lottoThreeListSubResponseList.add(model);
				}
				if (i == 599) {
					lottoThreeListResponse.setList(lottoThreeListSubResponseList);
					lottoThreeListResponses.add(lottoThreeListResponse);
					lottoThreeListResponse = new LottoThreeListResponse();
					lottoThreeListSubResponseList = new ArrayList<>();
				}
			} else if (i < 700) {
				lottoThreeListResponse = new LottoThreeListResponse();
				lottoThreeListSubResponseList = new ArrayList<>();
				lottoThreeListResponse.setMain("6");
				if (StringUtils.isNotBlank(model.getDirect()) && StringUtils.isNotBlank(model.getTote())) {
					lottoThreeListSubResponseList.add(model);
				}
				if (i == 699) {
					lottoThreeListResponse.setList(lottoThreeListSubResponseList);
					lottoThreeListResponses.add(lottoThreeListResponse);
					lottoThreeListResponse = new LottoThreeListResponse();
					lottoThreeListSubResponseList = new ArrayList<>();
				}
			} else if (i < 800) {
				lottoThreeListResponse = new LottoThreeListResponse();
				lottoThreeListSubResponseList = new ArrayList<>();
				lottoThreeListResponse.setMain("7");
				if (StringUtils.isNotBlank(model.getDirect()) && StringUtils.isNotBlank(model.getTote())) {
					lottoThreeListSubResponseList.add(model);
				}
				if (i == 799) {
					lottoThreeListResponse.setList(lottoThreeListSubResponseList);
					lottoThreeListResponses.add(lottoThreeListResponse);
					lottoThreeListResponse = new LottoThreeListResponse();
					lottoThreeListSubResponseList = new ArrayList<>();
				}
			} else if (i < 900) {
				lottoThreeListResponse = new LottoThreeListResponse();
				lottoThreeListSubResponseList = new ArrayList<>();
				lottoThreeListResponse.setMain("8");
				if (StringUtils.isNotBlank(model.getDirect()) && StringUtils.isNotBlank(model.getTote())) {
					lottoThreeListSubResponseList.add(model);
				}
				if (i == 899) {
					lottoThreeListResponse.setList(lottoThreeListSubResponseList);
					lottoThreeListResponses.add(lottoThreeListResponse);
					lottoThreeListResponse = new LottoThreeListResponse();
					lottoThreeListSubResponseList = new ArrayList<>();
				}
			} else if (i < 1000) {
				lottoThreeListResponse = new LottoThreeListResponse();
				lottoThreeListSubResponseList = new ArrayList<>();
				lottoThreeListResponse.setMain("9");
				if (StringUtils.isNotBlank(model.getDirect()) && StringUtils.isNotBlank(model.getTote())) {
					lottoThreeListSubResponseList.add(model);
				}
				if (i == 199) {
					lottoThreeListResponse.setList(lottoThreeListSubResponseList);
					lottoThreeListResponses.add(lottoThreeListResponse);
					lottoThreeListResponse = new LottoThreeListResponse();
					lottoThreeListSubResponseList = new ArrayList<>();
				}
			}

		}
		lottoThreeListResponse.setList(lottoThreeListSubResponseList);
		lottoThreeListResponses.add(lottoThreeListResponse);

		return new ResponseEntity<>(lottoThreeListResponses, HttpStatus.OK);
	}
}
