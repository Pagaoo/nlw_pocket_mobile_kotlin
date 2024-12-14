package devandroid.gabriel.nearby.ui.component.categories

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import devandroid.gabriel.nearby.data.model.Category
import devandroid.gabriel.nearby.data.model.mock.mockCategory

@Composable
fun NearbyCategoryFilterList(
    modifier: Modifier = Modifier,
    categories: List<Category>,
    onSelectedCategory: (Category) -> Unit
) {
    var selectedCategoryId by remember { mutableStateOf(categories.firstOrNull()?.id.orEmpty()) }

    LaunchedEffect(key1 = selectedCategoryId) {
        val selectedCategoryOrNull = categories.find { it.id == selectedCategoryId }
        selectedCategoryOrNull?.let {
            onSelectedCategory(it)
        }
    }
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(7.dp)
    ) {
        items(
            items = categories, key = { it.id },
        ) { category ->
            NearbyCategoryFilter(
                category = category,
                isSelected = category.id == selectedCategoryId,
                onClick = { isSelected -> if (isSelected) selectedCategoryId = category.id })
        }
    }
}

@Preview
@Composable
private fun NearbyCategoryFilterListView() {
    NearbyCategoryFilterList(
        modifier = Modifier.fillMaxWidth(),
        categories = mockCategory,
        onSelectedCategory = {}
    )
}