package com.example.prelimbclone.models

data class PreviousApplications(
    val isTwPartnerLimitAvailable: Int?,
    val approvalData: ApprovalData?,
    val appArray: ArrayList<AppArray>?,
    val persons: ArrayList<Person>?,
    val personContact: ArrayList<PersonContact>?,
)
