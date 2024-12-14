package devandroid.gabriel.nearby.ui.component.welcome

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import devandroid.gabriel.nearby.ui.theme.Gray500
import devandroid.gabriel.nearby.ui.theme.RedBase
import devandroid.gabriel.nearby.ui.theme.Typography

@Composable
fun WelcomeHowItWorks(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    @DrawableRes iconRes: Int
) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.spacedBy(16.dp)) {
        Icon(
            modifier = Modifier.size(30.dp),
            painter = painterResource(id = iconRes),
            tint = RedBase,
            contentDescription = "Ícone de como funciona"
        )
        Spacer(modifier = Modifier.height(6.dp))
        Column(
            verticalArrangement = Arrangement.spacedBy(7.dp)
        ) {
            Text(text = title, style = Typography.headlineSmall)
            Text(text = subtitle, color = Gray500, style = Typography.bodyLarge)
        }
    }
}