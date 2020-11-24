package io.lavagna.web.api.model

import io.lavagna.ext.model.CardLabelValue

class BulkOperation(
    val labelId: Int?,
    val value: CardLabelValue.LabelValue?,
    val cardIds: List<Int>
)
