package com.example.prelimbclone.models
import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class RGDetails(
    var cutOffValue: Double? = null,
    var riskGroup: Int? = null,
)
