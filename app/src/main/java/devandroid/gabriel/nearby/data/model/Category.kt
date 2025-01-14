package devandroid.gabriel.nearby.data.model

import androidx.annotation.DrawableRes
import kotlinx.serialization.Serializable

@Serializable
data class Category(val id: String, val name: String) {
    @get:DrawableRes
    val icon: Int?
        get() = CategoryFilterViewEnum.fromDescription(description = name)?.icon
}