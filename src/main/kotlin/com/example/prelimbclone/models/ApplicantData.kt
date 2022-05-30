package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate
import java.time.LocalDateTime


data class ApplicantData(
    val creditAmountPrefered: Int?,
    val creditTypePrefered: String?,
    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
    val time: LocalDateTime?,
    val maxValueRd: Int?,
    val maxValueSc: Int?,
    val typeProcess: String?,
    val cuid: Int?,
//    val expense: Expense?,
    val previousApplications: PreviousApplications?,
//    val previousApplicationsFraud: ArrayList<PreviousApplicationsFraud>?,
    val cars: ArrayList<Car>?,
//    val campaigns: ArrayList<Campaign>?,
//    val applicantCar: Car?,
//    val bankAccountOwner: Int?,
//    val creditOwnerCard: Int?,
//    val creditLimit: CreditLimit?,
//    val default30D_ZIP: Float?,
//    val directDebit: String?,
//    val familyCar: Car?,
//    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
//    val lastLimitdecrase: LocalDateTime,
//    @JsonFormat(pattern = "dd.MM.yyyy HH:mm:ss")
//    val lastUnblockCardDate: LocalDate,
//    val otherBankContact: String?,
//    val persons: ArrayList<ApplicantData>?,
//    val repeatedPhone: Int?,
//    val seriousNo: String,
//    val clientReality: ClientReality?,
//    val minorApplication: MinorApplication?,
//    val scNonUsedMinLimitRD: Float?,
//    val scNonUsedNewLimitRD: Float?,
//    val isPhoneChanged: Int?,
//    val productTypeProcess: String?,
//    val productRequested: String?,
//    val serviceProcessType: String?,
//    val isDataChanged: String?,
)
