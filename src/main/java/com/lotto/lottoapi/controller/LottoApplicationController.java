package com.lotto.lottoapi.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

import com.lotto.lottoapi.entity.BillEntity;
import com.lotto.lottoapi.entity.LottoApplicationEntity;
import com.lotto.lottoapi.entity.RewardEntity;
import com.lotto.lottoapi.repository.BillRepository;
import com.lotto.lottoapi.repository.LottoApplicationRepository;
import com.lotto.lottoapi.repository.LottoRepository;
import com.lotto.lottoapi.repository.RewardRepository;
import com.lotto.lottoapi.request.ConfirmBillRequest;
import com.lotto.lottoapi.request.DeleteRequest;
import com.lotto.lottoapi.request.LottoSaveRequest;
import com.lotto.lottoapi.request.UnConfirmBillRequest;
import com.lotto.lottoapi.response.BillDetial;
import com.lotto.lottoapi.response.BillListResponse;
import com.lotto.lottoapi.response.DeleteResponse;
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

	private static final String typeTwo = "2";
	private static final String typeThree = "3";
	private static final String subTypeUp = "up";
	private static final String subTypeDown = "down";
	private static final String subTypeDirect = "direct";
	private static final String subTypeTote = "tote";
	private static final String createBy = "SYSTEM";

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

			List<BillDetial> listTwoUpList = new ArrayList<>();
			List<BillDetial> listTwoDownList = new ArrayList<>();
			List<BillDetial> listThreeDirectList = new ArrayList<>();
			List<BillDetial> listThreeToteList = new ArrayList<>();

			List<LottoApplicationEntity> lottoApplicationTwoUpEntityList = lottoApplicationRepository.findByBuyerNameAndTypeAndSubType(billEntity.getBuyerName(), typeTwo, subTypeUp);
			for (LottoApplicationEntity lottoApplicationTwoUpEntity : lottoApplicationTwoUpEntityList) {
				BillDetial billDetial = new BillDetial();
				billDetial.setId(lottoApplicationTwoUpEntity.getId());
				billDetial.setNumber(lottoApplicationTwoUpEntity.getNumber());
				billDetial.setPrice(lottoApplicationTwoUpEntity.getPrice());
				if (StringUtils.isNotBlank(rewardTwoUp) && rewardTwoUp.equals(lottoApplicationTwoUpEntity.getNumber())) {
					billDetial.setPrize(true);
				} else {
					billDetial.setPrize(false);
				}
				twoUpTotal += billDetial.getPrice();
				listTwoUpList.add(billDetial);
			}
			List<LottoApplicationEntity> lottoApplicationTwoDownEntityList = lottoApplicationRepository.findByBuyerNameAndTypeAndSubType(billEntity.getBuyerName(), typeTwo, subTypeDown);
			for (LottoApplicationEntity entity : lottoApplicationTwoDownEntityList) {
				BillDetial billDetial = new BillDetial();
				billDetial.setId(entity.getId());
				billDetial.setNumber(entity.getNumber());
				billDetial.setPrice(entity.getPrice());
				if (StringUtils.isNotBlank(rewardTwoDown) && rewardTwoDown.equals(entity.getNumber())) {
					billDetial.setPrize(true);
				} else {
					billDetial.setPrize(false);
				}
				twoDownTotal += billDetial.getPrice();
				listTwoDownList.add(billDetial);
			}
			List<LottoApplicationEntity> lottoApplicationThreeDirectEntityList = lottoApplicationRepository.findByBuyerNameAndTypeAndSubType(billEntity.getBuyerName(), typeThree, subTypeDirect);
			for (LottoApplicationEntity entity : lottoApplicationThreeDirectEntityList) {
				BillDetial billDetial = new BillDetial();
				billDetial.setId(entity.getId());
				billDetial.setNumber(entity.getNumber());
				billDetial.setPrice(entity.getPrice());
				if (StringUtils.isNotBlank(rewardThree) && rewardThree.equals(entity.getNumber())) {
					billDetial.setPrize(true);
				} else {
					billDetial.setPrize(false);
				}
				threeDirectTotal += billDetial.getPrice();
				listThreeDirectList.add(billDetial);
			}
			List<LottoApplicationEntity> lottoApplicationThreeToteEntityList = lottoApplicationRepository.findByBuyerNameAndTypeAndSubType(billEntity.getBuyerName(), typeThree, subTypeTote);
			for (LottoApplicationEntity entity : lottoApplicationThreeToteEntityList) {
				BillDetial billDetial = new BillDetial();
				billDetial.setId(entity.getId());
				billDetial.setNumber(entity.getNumber());
				billDetial.setPrice(entity.getPrice());
				if (!rewardTote.isEmpty() && rewardTote.contains(entity.getNumber())) {
					billDetial.setPrize(true);
				} else {
					billDetial.setPrize(false);
				}
				threeToteTotal += billDetial.getPrice();
				listThreeToteList.add(billDetial);
			}

			BillListResponse billListResponse = new BillListResponse();
			billListResponse.setBillId(billEntity.getId());
			billListResponse.setName(billEntity.getBuyerName());
			billListResponse.setLock(billEntity.isLock());

			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
			String updated = dateFormat.format(billEntity.getUpdated());
			billListResponse.setUpdate(updated);

			billListResponse.setTwoUpTotal(twoUpTotal);
			billListResponse.setTwoUpPrize(twoUpPrize);

			billListResponse.setTwoDownTotal(twoDownTotal);
			billListResponse.setTwoDownPrize(twoDownPrize);

			billListResponse.setThreeDirectTotal(threeDirectTotal);
			billListResponse.setThreeDirectPrize(threeDirectPrize);

			billListResponse.setThreeToteTotal(threeToteTotal);
			billListResponse.setThreeTotePrize(threeTotePrize);

			int priceTotal = twoUpTotal + twoDownTotal + threeDirectTotal + threeToteTotal;
			int prizeTotal = twoUpPrize + twoDownPrize + threeDirectPrize + threeTotePrize;

			billListResponse.setPriceTotal(priceTotal);
			billListResponse.setPrizeTotal(prizeTotal);

			billListResponse.setListTwoUp(listTwoUpList);
			billListResponse.setListTwoDown(listTwoDownList);
			billListResponse.setListThreeDirect(listThreeDirectList);
			billListResponse.setListThreeTote(listThreeToteList);

			billListResponseList.add(billListResponse);
		}

		return new ResponseEntity<>(billListResponseList, HttpStatus.OK);
	}

	@PostMapping(path = "/save", produces = {"application/json"})
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
			lottoSaveResponse.setErrorMessage("กรุณาระบุราคาที่ซื้อ");
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

		Optional<BillEntity> billEntityOptional = billRepository.findById(buyerName);
		if (billEntityOptional.isPresent()) {
			BillEntity billEntity = billEntityOptional.get();
			if (billEntity.isLock()) {
				lottoSaveResponse.setStatus("error");
				lottoSaveResponse.setErrorMessage("บิลนี้ถูกล็อคแล้ว");
				return new ResponseEntity<>(lottoSaveResponse, HttpStatus.BAD_REQUEST);
			}

			billEntity.setUpdated(new Date());
			billRepository.save(billEntity);
		} else {
			Long id = billRepository.findMaxId();
			if (id == null) {
				id = 0l;
			}
			BillEntity billEntity = new BillEntity();
			billEntity.setId(id++);
			billEntity.setBuyerName(buyerName);
			billEntity.setSellerName(sellerName);
			billEntity.setUpdated(new Date());
			billEntity.setCreated(new Date());
			billEntity.setNote("");
			billEntity.setUpdated(new Date());
			billRepository.save(billEntity);
		}

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
				lottoEntity.setPrice(priceB);
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

	@PostMapping(path = "/delete", produces = "application/json")
	public @ResponseBody ResponseEntity<?> delete(@RequestBody DeleteRequest deleteRequest) {
		DeleteResponse deleteResponse = new DeleteResponse();
		if (StringUtils.isBlank(deleteRequest.getLottoApplicationId())) {
			deleteResponse.setStatus("error");
			deleteResponse.setErrorMessage("คำขอไม่สมบูรณ์");
			return new ResponseEntity<>(deleteResponse, HttpStatus.BAD_REQUEST);
		}

		Optional<LottoApplicationEntity> lottoApplicationEntityOptional = lottoApplicationRepository.findById(deleteRequest.getLottoApplicationId());

		if (!lottoApplicationEntityOptional.isPresent()) {
			deleteResponse.setStatus("error");
			deleteResponse.setErrorMessage("บิลนี้ถูกล็อคแล้ว");
			return new ResponseEntity<>(deleteResponse, HttpStatus.BAD_REQUEST);
		}

		lottoApplicationRepository.delete(lottoApplicationEntityOptional.get());

		deleteResponse.setStatus("success");

		return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
	}

	@PostMapping(path = "/confirm", produces = "application/json")
	public @ResponseBody ResponseEntity<?> confirm(@RequestBody ConfirmBillRequest request) {

		DeleteResponse deleteResponse = new DeleteResponse();
		if (StringUtils.isBlank(request.getBuyerName())) {
			deleteResponse.setStatus("error");
			deleteResponse.setErrorMessage("คำขอไม่สมบูรณ์");
			return new ResponseEntity<>(deleteResponse, HttpStatus.BAD_REQUEST);
		}

		Optional<BillEntity> billEntityOptional = billRepository.findById(request.getBuyerName());

		if (!billEntityOptional.isPresent()) {
			deleteResponse.setStatus("error");
			deleteResponse.setErrorMessage("ไม่พบบิลผู้ใช้ในระบบ");
			return new ResponseEntity<>(deleteResponse, HttpStatus.BAD_REQUEST);
		}

		BillEntity billEntity = billEntityOptional.get();
		if (billEntity.isLock()) {
			deleteResponse.setStatus("error");
			deleteResponse.setErrorMessage("บิลนี้ถูกล็อคอยู่แล้ว");
			return new ResponseEntity<>(deleteResponse, HttpStatus.BAD_REQUEST);
		}

		billEntity.setLock(true);
		billEntity.setLockDate(new Date());

		billRepository.save(billEntity);

		deleteResponse.setStatus("success");

		return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
	}

	@PostMapping(path = "/unConfirm", produces = "application/json")
	public @ResponseBody ResponseEntity<?> unConfirm(@RequestBody UnConfirmBillRequest request) {

		DeleteResponse deleteResponse = new DeleteResponse();
		if (StringUtils.isBlank(request.getBuyerName())) {
			deleteResponse.setStatus("error");
			deleteResponse.setErrorMessage("คำขอไม่สมบูรณ์");
			return new ResponseEntity<>(deleteResponse, HttpStatus.BAD_REQUEST);
		}

		Optional<BillEntity> billEntityOptional = billRepository.findById(request.getBuyerName());
		if (!billEntityOptional.isPresent()) {
			deleteResponse.setStatus("error");
			deleteResponse.setErrorMessage("ไม่พบบิลผู้ใช้ในระบบ");
			return new ResponseEntity<>(deleteResponse, HttpStatus.BAD_REQUEST);
		}

		BillEntity billEntity = billEntityOptional.get();
		if (!billEntity.isLock()) {
			deleteResponse.setStatus("error");
			deleteResponse.setErrorMessage("บิลนี้ยังไม่ถูกล็อค");
			return new ResponseEntity<>(deleteResponse, HttpStatus.BAD_REQUEST);
		}

		billEntity.setLock(false);
		billEntity.setLockDate(null);

		billRepository.save(billEntity);

		deleteResponse.setStatus("success");

		return new ResponseEntity<>(deleteResponse, HttpStatus.OK);
	}

}
