package devandroid.gabriel.nearby.ui.screen.market_details

import devandroid.gabriel.nearby.data.model.Rule

data class MarketDetailUiState(
    val rule: List<Rule>? = null,
    val coupon: String? = null
)
