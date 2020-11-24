package io.lavagna.ext.api

import io.lavagna.ext.model.CardLabelValue

class BulkOperation(
    val labelId: Int?,
    val value: CardLabelValue.LabelValue?,
    val cardIds: List<Int>
)
