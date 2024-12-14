package devandroid.gabriel.nearby.ui.component.market_details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import devandroid.gabriel.nearby.R
import devandroid.gabriel.nearby.data.model.Market
import devandroid.gabriel.nearby.data.model.mock.mockMarkets
import devandroid.gabriel.nearby.ui.theme.Gray400
import devandroid.gabriel.nearby.ui.theme.Gray500
import devandroid.gabriel.nearby.ui.theme.Typography

@Composable
fun NearbyMarketDetailsInfo(modifier: Modifier = Modifier, market: Market) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = "Informações", style = Typography.headlineSmall, color = Gray400)
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_ticket),
                    tint = Gray500,
                    contentDescription = "Ícone do cupom"
                )
                Text(
                    "${market.coupons} disponíveis",
                    style = Typography.labelMedium,
                    color = Gray500
                )
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_map_pin),
                    tint = Gray500,
                    contentDescription = "Ícone do endereço"
                )
                Text(
                    market.address,
                    style = Typography.labelMedium,
                    color = Gray500
                )
            }
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.ic_phone),
                    tint = Gray500,
                    contentDescription = "Ícone do telefone"
                )
                Text(
                    market.phone,
                    style = Typography.labelMedium,
                    color = Gray500
                )
            }
        }
    }
}

@Preview
@Composable
private fun MarketDetailsInfoPreview() {
    NearbyMarketDetailsInfo(
        modifier = Modifier.fillMaxWidth(),
        market = mockMarkets.first()
    )
}