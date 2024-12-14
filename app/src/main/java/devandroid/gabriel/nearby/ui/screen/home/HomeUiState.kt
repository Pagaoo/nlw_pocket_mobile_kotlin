package devandroid.gabriel.nearby.ui.screen.home

import com.google.android.gms.maps.model.LatLng
import devandroid.gabriel.nearby.data.model.Category
import devandroid.gabriel.nearby.data.model.Market

data class HomeUiState(
    val categories: List<Category>? = null,
    val markets: List<Market>? = null,
    val marketLocations: List<LatLng>? = null
)
