package com.vfuchong.sptsm.common.apdu;

import com.vfuchong.sptsm.common.util.ByteUtil;

import java.io.Serializable;

public class CPLCAPDUResp implements Serializable {
	private static final long serialVersionUID = 1L;
	// Begin as POS 3(In Array it's 4)
	private String icFabricator;
	
	private String operatingSystemID; // hex String -- 2 bytes

	// Begin as POS 13(In Array it's 12)
	private String fabricationDate; // hex String -- 2 bytes
	private String cardNO; // hex String -- 4 bytes
	// Begin as POS 20(In Array it's 19)
	private String batchID; // hex String -- 2 bytes

	// Begin as POS 13(In Array it's 12)
	private String uid; // hex String -- 10 bytes, icFabricator + fabricationDate + cardNO +
						// batchID
	
	private String fabricator;	// hex String -- 2 bytes
	
	private String manufacturerID; // hex String -- 2 bytes

	private String prePersonalizer;
	private String prePersoEquipDate;
	private String prePersoEquipID;

	private String persoEquipmentID;
	
	// ps:此处仅适用交通部的ATS
	private String ats; // 4D54 + icFabricator + fabricator + cardNO;
	
	private String physicNo; //  icFabricator + fabricator + cardNO;

	public CPLCAPDUResp() {
	}

	public CPLCAPDUResp(byte[] input, int offset) {
		byte[] icFabricatorBuff = new byte[2];
		System.arraycopy(input, offset, icFabricatorBuff, 0,
				icFabricatorBuff.length);
		icFabricator = ByteUtil.byteArrayToHex(icFabricatorBuff);
		
		offset += 4;
		byte[] operatingSystemIDBuff = new byte[2];
		System.arraycopy(input, offset, operatingSystemIDBuff, 0,
				operatingSystemIDBuff.length);
		operatingSystemID = ByteUtil.byteArrayToHex(operatingSystemIDBuff);

		offset += 6;

		byte[] uidBuff = new byte[8];
		System.arraycopy(input, offset, uidBuff, 0, uidBuff.length);
		uid = icFabricator + ByteUtil.byteArrayToHex(uidBuff);

		byte[] fabricationDateBuff = new byte[2];
		System.arraycopy(input, offset, fabricationDateBuff, 0,
				fabricationDateBuff.length);
		fabricationDate = ByteUtil.byteArrayToHex(fabricationDateBuff);

		offset += 2;
		byte[] cardNOBuff = new byte[4];
		System.arraycopy(input, offset, cardNOBuff, 0, cardNOBuff.length);
		cardNO = ByteUtil.byteArrayToHex(cardNOBuff);

		offset += 4;
		byte[] batchIdBuff = new byte[2];
		System.arraycopy(input, offset, batchIdBuff, 0, batchIdBuff.length);
		batchID = ByteUtil.byteArrayToHex(batchIdBuff);
		
		offset += 2;
		byte[] fabricatorBuff = new byte[2];
		System.arraycopy(input, offset, fabricatorBuff, 0, fabricatorBuff.length);
		fabricator = ByteUtil.byteArrayToHex(fabricatorBuff);

		offset += 4;
		byte[] manufacturerIdBuff = new byte[2];
		System.arraycopy(input, offset, manufacturerIdBuff, 0,
				manufacturerIdBuff.length);
		manufacturerID = ByteUtil.byteArrayToHex(manufacturerIdBuff);

		offset += 4;
		byte[] prePersonalizerBuff = new byte[2];
		System.arraycopy(input, offset, prePersonalizerBuff, 0,
				prePersonalizerBuff.length);
		prePersonalizer = ByteUtil.byteArrayToHex(prePersonalizerBuff);

		offset += 2;
		byte[] prePersoEquipDateBuff = new byte[2];
		System.arraycopy(input, offset, prePersoEquipDateBuff, 0,
				prePersoEquipDateBuff.length);
		prePersoEquipDate = ByteUtil.byteArrayToHex(prePersoEquipDateBuff);

		offset += 2;
		byte[] prePersoEquipIDBuff = new byte[4];
		System.arraycopy(input, offset, prePersoEquipIDBuff, 0,
				prePersoEquipIDBuff.length);
		prePersoEquipID = ByteUtil.byteArrayToHex(prePersoEquipIDBuff);

		offset += 8;
		byte[] persoEquipmentIDBuff = new byte[4];
		System.arraycopy(input, offset, persoEquipmentIDBuff, 0,
				persoEquipmentIDBuff.length);
		persoEquipmentID = ByteUtil.byteArrayToHex(persoEquipmentIDBuff);
		
		ats = "4D54" + icFabricator + operatingSystemID + fabricator + cardNO;
		
		physicNo = icFabricator  + fabricator + cardNO;
	}

	public String getCardNO() {
		return cardNO;
	}

	public void setCardNO(String cardNO) {
		this.cardNO = cardNO;
	}

	public String getManufacturerID() {
		return manufacturerID;
	}

	public void setManufacturerID(String manufacturerID) {
		this.manufacturerID = manufacturerID;
	}

	public String getBatchID() {
		return batchID;
	}

	public void setBatchID(String batchID) {
		this.batchID = batchID;
	}

	public String getFabricationDate() {
		return fabricationDate;
	}

	public void setFabricationDate(String fabricationDate) {
		this.fabricationDate = fabricationDate;
	}

	public String getPrePersonalizer() {
		return prePersonalizer;
	}

	public void setPrePersonalizer(String prePersonalizer) {
		this.prePersonalizer = prePersonalizer;
	}

	public String getPrePersoEquipDate() {
		return prePersoEquipDate;
	}

	public void setPrePersoEquipDate(String prePersoEquipDate) {
		this.prePersoEquipDate = prePersoEquipDate;
	}

	public String getPrePersoEquipID() {
		return prePersoEquipID;
	}

	public void setPrePersoEquipID(String prePersoEquipID) {
		this.prePersoEquipID = prePersoEquipID;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getIcFabricator() {
		return icFabricator;
	}

	public void setIcFabricator(String icFabricator) {
		this.icFabricator = icFabricator;
	}

	public String getPersoEquipmentID() {
		return persoEquipmentID;
	}

	public void setPersoEquipmentID(String persoEquipmentID) {
		this.persoEquipmentID = persoEquipmentID;
	}

	public String getOperatingSystemID() {
		return operatingSystemID;
	}

	public void setOperatingSystemID(String operatingSystemID) {
		this.operatingSystemID = operatingSystemID;
	}

	public String getFabricator() {
		return fabricator;
	}

	public void setFabricator(String fabricator) {
		this.fabricator = fabricator;
	}

	public String getPhysicNo() {
		return physicNo;
	}

	public void setPhysicNo(String physicNo) {
		this.physicNo = physicNo;
	}

	public String getAts() {
		return ats;
	}

	public void setAts(String ats) {
		this.ats = ats;
	}
}
