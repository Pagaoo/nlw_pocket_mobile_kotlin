package devandroid.gabriel.nearby

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import devandroid.gabriel.nearby.data.model.Market
import devandroid.gabriel.nearby.ui.routes.Home
import devandroid.gabriel.nearby.ui.routes.QrCodeScanner
import devandroid.gabriel.nearby.ui.routes.Splash
import devandroid.gabriel.nearby.ui.routes.Welcome
import devandroid.gabriel.nearby.ui.screen.home.HomeScreen
import devandroid.gabriel.nearby.ui.screen.home.HomeViewModel
import devandroid.gabriel.nearby.ui.screen.market_details.MarketDetailUiEvent
import devandroid.gabriel.nearby.ui.screen.market_details.MarketDetailViewModel
import devandroid.gabriel.nearby.ui.screen.market_details.MarketDetailsScreen
import devandroid.gabriel.nearby.ui.screen.qr_code.QrCodeScannerScreen
import devandroid.gabriel.nearby.ui.screen.splash.SplashScreen
import devandroid.gabriel.nearby.ui.screen.welcome.WelcomeScreen
import devandroid.gabriel.nearby.ui.theme.NearbyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NearbyTheme {
                val navController = rememberNavController()

                val homeViewModel by viewModels<HomeViewModel>()
                val homeUiState by homeViewModel.uiState.collectAsStateWithLifecycle()

                val marketDetailViewModel by viewModels<MarketDetailViewModel>()
                val marketDetailUiState by marketDetailViewModel.uiState.collectAsStateWithLifecycle()

                NavHost(
                    navController = navController, startDestination = Splash
                ) {
                    composable<Splash> {
                        SplashScreen(onNavigateToWelcome = {
                            navController.navigate(Welcome)
                        })
                    }
                    composable<Welcome> {
                        WelcomeScreen(onNavigateToHome = {
                            navController.navigate(Home)
                        })
                    }
                    composable<Home> {
                        HomeScreen(
                            onNavigateToMarketDetail = { selectedMarket ->
                                navController.navigate(selectedMarket)
                            },
                            uiState = homeUiState,
                            onEvent = homeViewModel::onEvent
                        )
                    }
                    composable<Market> {
                        val selectedMarket = it.toRoute<Market>()
                        MarketDetailsScreen(
                            market = selectedMarket,
                            uiState = marketDetailUiState,
                            onEvent = marketDetailViewModel::onEvent,
                            onNavigateBack = { navController.popBackStack() },
                            onNavigateToQrCodeScanner = { navController.navigate(QrCodeScanner) })
                    }
                    composable<QrCodeScanner> {
                        QrCodeScannerScreen(onCompleteScan = { qrCodeContent ->
                            if (qrCodeContent.isNotEmpty()) {
                                marketDetailViewModel.onEvent(
                                    MarketDetailUiEvent.OnFetchCoupon(
                                        qrCodeContent = qrCodeContent
                                    )
                                )
                            }
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NearbyTheme {

    }
}