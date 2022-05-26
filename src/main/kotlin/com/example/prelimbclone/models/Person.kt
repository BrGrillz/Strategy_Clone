package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDateTime


data class Person(
    val FZcnt: Int?,
    val cntContractActiveCar: Int?,
    val cntContractActiveCash: Int?,
    val cntContractActivePos: Int?,
    val cntContractActiveRevolving: Int?,
    val cntContractActiveRevolvingHomer: Int?,
    val cntContractActiveRevolvingTW: Int?,
    val cntContractActiveRevolvingTWPolza: Int?,
    val cuid: Int?,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val dateEmployedFrom: LocalDateTime?,
    val daysFromPreviousCredit: Int?,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val firstADateNotRD: LocalDateTime?,
    val firstaCreditAmount: Int?,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val firstaDate: LocalDateTime?,
    val firstaDownpayment: Int?,
    val lastActiveCreditAmount: Int?,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val lastApplicationDate: LocalDateTime?,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val lastApprovalDate: LocalDateTime?,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val lastApprovalDateNotRD: LocalDateTime?,
    val lastApprovedEducation: Int?,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val lastBirth: LocalDateTime?,
    val lastCarOwner: Int?,
    val lastChildNum: Int?,
    val lastContactAddress: String?,
    val lastContactMobilePhone: Int?,
    val lastCreditAmount: Int?,
    val lastEducation: Int?,
    val lastEmail: String?,
    val lastEmploymentAddress: String?,
    val lastEmploymentName: String?,
    val lastExistingCreditType: String?,
    val lastFamilyState: Int?,
    val lastFieldExperience: Int?,
    val lastFlatCnt: Int?,
    val lastHouseType: Int?,
    val lastIdent: Int?,
    val lastInitPay: Int?,
    val lastMainOccupationIncome: Int?,
    val lastMobil: Int?,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss") val lastMobilePhoneChangeDate: LocalDateTime?,
    val lastOccupation: String?,
    val lastOccupationSector: Int?,
    val lastPaymentNum: Int?,
    val lastPhone: Int?,
    val lastPhoneEmp: Int?,
    val lastRegisteredAddress: String?,
    val lastSellerplaceName: String?,
    val lastStatus: String?,
    ) {


}
