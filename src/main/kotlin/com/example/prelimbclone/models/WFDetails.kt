package com.example.prelimbclone.models

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class WFDetails(
    var decision: String? = null,
    var rejectReason: String? = null,
)
