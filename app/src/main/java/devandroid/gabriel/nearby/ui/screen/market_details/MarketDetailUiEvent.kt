package devandroid.gabriel.nearby.ui.screen.market_details

sealed class MarketDetailUiEvent {
    data class OnFetchRules(val marketId: String) : MarketDetailUiEvent()
    data class OnFetchCoupon(val qrCodeContent: String) : MarketDetailUiEvent()
    data object OnResetCoupon : MarketDetailUiEvent()
}