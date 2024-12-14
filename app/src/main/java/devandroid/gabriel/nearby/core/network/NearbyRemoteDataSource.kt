package devandroid.gabriel.nearby.core.network

import devandroid.gabriel.nearby.core.network.KtorHttpClient.httpClientAndroid
import devandroid.gabriel.nearby.data.model.Category
import devandroid.gabriel.nearby.data.model.Coupon
import devandroid.gabriel.nearby.data.model.Market
import devandroid.gabriel.nearby.data.model.MarketDetail
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.patch

object NearbyRemoteDataSource {

    private const val LOCAL_HOST_EMULATOR_BASE_URL = "http://10.0.2.2:3333"
    private const val BASE_URL = LOCAL_HOST_EMULATOR_BASE_URL

    suspend fun getCategories(): Result<List<Category>> = try {
        val categories = httpClientAndroid.get("$BASE_URL/categories").body<List<Category>>()

        Result.success(categories)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getMarkets(categoryId: String): Result<List<Market>> = try {
        val markets =
            httpClientAndroid.get("$BASE_URL/markets/category/${categoryId}").body<List<Market>>()

        Result.success(markets)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getMarketDetailsInfo(marketId: String): Result<MarketDetail> = try {
        val marketDetail = httpClientAndroid.get("$BASE_URL/markets/${marketId}").body<MarketDetail>()

        Result.success(marketDetail)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun patchCoupon(marketId: String): Result<Coupon> = try {
        val coupon = httpClientAndroid.patch("$BASE_URL/coupons/${marketId}").body<Coupon>()

        Result.success(coupon)
    } catch (e: Exception) {
        Result.failure(e)
    }
}