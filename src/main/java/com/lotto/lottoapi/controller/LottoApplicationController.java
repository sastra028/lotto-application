package com.lotto.lottoapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
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

import com.lotto.lottoapi.dto.LottoGroupPrice;
import com.lotto.lottoapi.entity.BillEntity;
import com.lotto.lottoapi.entity.LottoApplicationEntity;
import com.lotto.lottoapi.entity.LottoEntity;
import com.lotto.lottoapi.entity.RewardEntity;
import com.lotto.lottoapi.repository.BillRepository;
import com.lotto.lottoapi.repository.LottoApplicationRepository;
import com.lotto.lottoapi.repository.LottoRepository;
import com.lotto.lottoapi.repository.RewardRepository;
import com.lotto.lottoapi.request.LottoSaveRequest;
import com.lotto.lottoapi.response.BillDetial;
import com.lotto.lottoapi.response.BillListResponse;
import com.lotto.lottoapi.response.LottoSaveResponse;
import com.lotto.lottoapi.utils.CommonUtils;

@Controller
@RequestMapping(path = "/api/v2/lotto")
@CrossOrigin(origins = "*")
public class LottoApplicationController {

	@Autowired
	private LottoRepository lottoRepository;

	@Autowired
	private BillRepository billRepository;

	@Autowired
	private RewardRepository rewardRepository;

	@Autowired
	private LottoApplicationRepository lottoApplicationRepository;

	@PostMapping(path = "/list-bill", produces = "application/json")
	public @ResponseBody ResponseEntity<?> listBill() {

		List<BillListResponse> billListResponseList = new ArrayList<>();

		String currentDate = "";
		Optional<RewardEntity> rewardEntityOptional = rewardRepository.findById(currentDate);
		String rewardTwoUp = "";
		String rewardTwoDown = "";
		String rewardThree = "";
		List<String> rewardTote = new ArrayList<>();

		if (rewardEntityOptional.isPresent()) {
			RewardEntity rewardEntity = rewardEntityOptional.get();
			rewardTwoUp = rewardEntity.getTwoUp();
			rewardTwoDown = rewardEntity.getTwoDown();
			rewardThree = rewardEntity.getThree();
			rewardTote = CommonUtils.getTote(rewardThree);
		}

		List<BillEntity> billEntityList = billRepository.findAll();
		for (BillEntity billEntity : billEntityList) {

			int twoUpTotal = 0;
			int twoUpPrize = 0;

			int twoDownTotal = 0;
			int twoDownPrize = 0;

			int threeDirectTotal = 0;
			int threeDirectPrize = 0;

			int threeToteTotal = 0;
			int threeTotePrize = 0;

			int priceTotal = 0;
			int prizeTotal = 0;

			List<BillDetial> listTwoUpList = new ArrayList<>();
			List<BillDetial> listTwoDownList = new ArrayList<>();
			List<BillDetial> listThreeDirectList = new ArrayList<>();
			List<BillDetial> listThreeToteList = new ArrayList<>();

			List<LottoEntity> lottoTwoList = lottoRepository.findByBuyerNameAndType(billEntity.getName(), "2");
			for (LottoEntity lottoEntity : lottoTwoList) {
				if (lottoEntity != null) {
					twoUpTotal = +lottoEntity.getPriceA();
					twoDownTotal = +lottoEntity.getPriceB();
				}
			}

			BillListResponse billListResponse = new BillListResponse();
			billListResponse.setBillId(billEntity.getId());
			billListResponse.setName(billEntity.getName());
			billListResponse.setUpdate(billEntity.getUpdated());

			billListResponse.setTwoUpTotal(twoUpTotal);
			billListResponse.setTwoUpPrize(twoUpPrize);

			billListResponse.setTwoDownTotal(twoDownTotal);
			billListResponse.setTwoDownPrize(twoDownPrize);

			billListResponse.setThreeDirectTotal(threeDirectTotal);
			billListResponse.setThreeDirectPrize(threeDirectPrize);

			billListResponse.setThreeToteTotal(threeToteTotal);
			billListResponse.setThreeTotePrize(threeTotePrize);

			billListResponse.setPriceTotal(priceTotal);
			billListResponse.setPrizeTotal(prizeTotal);

			billListResponse.setListTwoUp(listTwoUpList);
			billListResponse.setListTwoDown(listTwoDownList);
			billListResponse.setListThreeDirect(listThreeDirectList);
			billListResponse.setListThreeTote(listThreeToteList);

			billListResponseList.add(billListResponse);
		}

		return new ResponseEntity<>("", HttpStatus.OK);
	}

	private List<LottoGroupPrice> getLottoGroupPriceTwo(List<LottoEntity> lottoEntityList) {
		List<LottoGroupPrice> LottoGroupPriceList = new ArrayList<>();
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

		for (int i = 0; i < 100; i++) {
			LottoGroupPrice model = new LottoGroupPrice();

			String number = StringUtils.leftPad(String.valueOf(i), 2, "0");
			model.setNumber(number);

			if (countPriceA.containsKey(number)) {
				Integer price = countPriceA.get(number);
				model.setPriceA(String.valueOf(price));
			}

			if (countPriceB.containsKey(number)) {
				Integer price = countPriceB.get(number);
				model.setPriceB(String.valueOf(price));
			}

			if (StringUtils.isNotBlank(model.getPriceA()) && StringUtils.isNotBlank(model.getPriceB())) {
				LottoGroupPriceList.add(model);
			}

		}

		return LottoGroupPriceList;
	}

	private List<LottoGroupPrice> getLottoGroupPriceThree(List<LottoEntity> lottoEntityList) {
		List<LottoGroupPrice> LottoGroupPriceList = new ArrayList<>();
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

		for (int i = 0; i < 1000; i++) {
			LottoGroupPrice model = new LottoGroupPrice();

			String number = StringUtils.leftPad(String.valueOf(i), 3, "0");
			model.setNumber(number);

			if (countPriceA.containsKey(number)) {
				Integer price = countPriceA.get(number);
				model.setPriceA(String.valueOf(price));
			}

			if (countPriceB.containsKey(number)) {
				Integer price = countPriceB.get(number);
				model.setPriceB(String.valueOf(price));
			}

			if (StringUtils.isNotBlank(model.getPriceA()) && StringUtils.isNotBlank(model.getPriceB())) {
				LottoGroupPriceList.add(model);
			}

		}

		return LottoGroupPriceList;
	}

	@PostMapping(path = "/save")
	public @ResponseBody ResponseEntity<?> save(@RequestBody @Valid LottoSaveRequest request) {

		LottoSaveResponse lottoSaveResponse = new LottoSaveResponse();

		String buyerName = request.getBuyerName();
		String number = request.getNumber();
		String sellerName = request.getSellerName();

		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
		String round = dateFormat.format(date);

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

		if (StringUtils.isBlank(buyerName)) {
			lottoSaveResponse.setStatus("error");
			lottoSaveResponse.setErrorMessage("กรุณาระบุผู้ซื้อ");
			return new ResponseEntity<>(lottoSaveResponse, HttpStatus.BAD_REQUEST);
		}

		if (StringUtils.isBlank(sellerName)) {
			lottoSaveResponse.setStatus("error");
			lottoSaveResponse.setErrorMessage("กรุณาระบุผู้ขาย");
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

		String typeTwo = "2";
		String typeThree = "3";
		String subTypeUp = "up";
		String subTypeDown = "down";
		String subTypeDirect = "direct";
		String subTypeTote = "tote";
		String createBy = "SYSTEM";

		if (number.length() == 2 && priceA > 0) {
			LottoApplicationEntity lottoApplicationTwoUpEntity = lottoApplicationRepository.findFirstByRoundAndBuyerNameAndNumberAndTypeAndSubType(round, buyerName, number, typeTwo, subTypeUp);
			if (lottoApplicationTwoUpEntity != null) {
				int price = lottoApplicationTwoUpEntity.getPrice() + priceA;
				lottoApplicationTwoUpEntity.setPrice(price);
				lottoApplicationRepository.save(lottoApplicationTwoUpEntity);
			} else {
				LottoApplicationEntity lottoEntity = new LottoApplicationEntity();
				lottoEntity.setId(UUID.randomUUID().toString());
				lottoEntity.setRound(round);
				lottoEntity.setNumber(number);
				lottoEntity.setType(typeTwo);
				lottoEntity.setSubType(subTypeUp);
				lottoEntity.setBuyerName(buyerName);
				lottoEntity.setSellerName(sellerName);
				lottoEntity.setPrice(priceA);
				lottoEntity.setCreated(new Date());
				lottoEntity.setCreateBy("SYSTEM");
				lottoApplicationRepository.save(lottoEntity);
			}
		}

		if (number.length() == 2 && priceB > 0) {
			LottoApplicationEntity lottoApplicationTwoDownEntityList = lottoApplicationRepository.findFirstByRoundAndBuyerNameAndNumberAndTypeAndSubType(round, buyerName, number, typeTwo, subTypeDown);
			if (lottoApplicationTwoDownEntityList != null) {
				int price = lottoApplicationTwoDownEntityList.getPrice() + priceB;
				lottoApplicationTwoDownEntityList.setPrice(price);
				lottoApplicationRepository.save(lottoApplicationTwoDownEntityList);
			} else {
				LottoApplicationEntity lottoEntity = new LottoApplicationEntity();
				lottoEntity.setId(UUID.randomUUID().toString());
				lottoEntity.setRound(round);
				lottoEntity.setNumber(number);
				lottoEntity.setType(typeTwo);
				lottoEntity.setSubType(subTypeDown);
				lottoEntity.setBuyerName(buyerName);
				lottoEntity.setSellerName(sellerName);
				lottoEntity.setPrice(priceA);
				lottoEntity.setCreated(new Date());
				lottoEntity.setCreateBy(createBy);
				lottoApplicationRepository.save(lottoEntity);
			}
		}

		if (number.length() == 3 && priceA > 0) {
			LottoApplicationEntity lottoApplicationThreeDirectEntityList = lottoApplicationRepository.findFirstByRoundAndBuyerNameAndNumberAndTypeAndSubType(round, buyerName, number, typeThree, subTypeDirect);
			if (lottoApplicationThreeDirectEntityList != null) {
				int price = lottoApplicationThreeDirectEntityList.getPrice() + priceA;
				lottoApplicationThreeDirectEntityList.setPrice(price);
				lottoApplicationRepository.save(lottoApplicationThreeDirectEntityList);
			} else {
				LottoApplicationEntity lottoEntity = new LottoApplicationEntity();
				lottoEntity.setId(UUID.randomUUID().toString());
				lottoEntity.setRound(round);
				lottoEntity.setNumber(number);
				lottoEntity.setType(typeThree);
				lottoEntity.setSubType(subTypeDirect);
				lottoEntity.setBuyerName(buyerName);
				lottoEntity.setSellerName(sellerName);
				lottoEntity.setPrice(priceA);
				lottoEntity.setCreated(new Date());
				lottoEntity.setCreateBy(createBy);
				lottoApplicationRepository.save(lottoEntity);
			}
		}

		if (number.length() == 3 && priceB > 0) {
			LottoApplicationEntity lottoApplicationThreeToteEntityList = lottoApplicationRepository.findFirstByRoundAndBuyerNameAndNumberAndTypeAndSubType(round, buyerName, number, typeThree, subTypeTote);
			if (lottoApplicationThreeToteEntityList != null) {
				int price = lottoApplicationThreeToteEntityList.getPrice() + priceB;
				lottoApplicationThreeToteEntityList.setPrice(price);
				lottoApplicationRepository.save(lottoApplicationThreeToteEntityList);
			} else {
				LottoApplicationEntity lottoEntity = new LottoApplicationEntity();
				lottoEntity.setId(UUID.randomUUID().toString());
				lottoEntity.setRound(round);
				lottoEntity.setNumber(number);
				lottoEntity.setType(typeThree);
				lottoEntity.setSubType(subTypeTote);
				lottoEntity.setBuyerName(buyerName);
				lottoEntity.setSellerName(sellerName);
				lottoEntity.setPrice(priceB);
				lottoEntity.setCreated(new Date());
				lottoEntity.setCreateBy(createBy);
				lottoApplicationRepository.save(lottoEntity);
			}
		}

		lottoSaveResponse.setStatus("success");

		return new ResponseEntity<>(lottoSaveResponse, HttpStatus.OK);
	}

}
