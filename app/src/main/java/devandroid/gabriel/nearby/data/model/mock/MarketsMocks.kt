package devandroid.gabriel.nearby.data.model.mock

import devandroid.gabriel.nearby.data.model.Market
import devandroid.gabriel.nearby.data.model.Rule

val mockMarkets = listOf(
    Market(
        id = "08392-123123sd-123132as-asda",
        categoryId = "1",
        name = "Sabor Grill",
        description = "Churrascaria asdjkaskldas jlasdj aljsdlajdlkas d as dla jasljdas jlasdjl asdadasd alsdja lksdjaklsdjaklasd askldjaklsjdsl",
        coupons = 29,
//        rules = listOf(
//            Rule(id = "1", description = "ASDPJKADLASKLJDAS", marketId = "08392-123123sd-123132as-asda"),
//            Rule(id = "2", description = "ADASJDASKL;JASD", marketId = "08392-123123sd-123132as-asda")
//        ),
        latitude = -23.55453345,
        longitude = -46.2331243,
        address = "Rua teste",
        phone = "(11) 1111-1111",
        cover = "https://images.unsplash.com/photo-1498654896293-37aacf113fd9?w=400&h=300"
    ),
    Market(
        id = "2bc11e34-5f30-4ba0-90fa-c1c98f649281",
        categoryId = "146b1a88-b3d3-4232-8b8f-c1f006f1e86d",
        name = "Café Central",
        description = "Café aconchegante com opções de lanches e bebidas artesanais. Perfeito para uma pausa.",
        coupons = 10,
//        rules = emptyList(),
        latitude = -23.559457108504436,
        longitude = -46.66252581753144,
        address = "Alameda Jaú - Jardim Paulista",
        phone = "(12) 3456-7890",
        cover = "https://images.unsplash.com/photo-1551218808-94e220e084d2?w=400&h=300"
    )
)