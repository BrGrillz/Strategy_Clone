package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Predictor(
    var characteristicName: String? = null,
    var characteristicValue: Any? = null,
    var value: Any? = null,
)
