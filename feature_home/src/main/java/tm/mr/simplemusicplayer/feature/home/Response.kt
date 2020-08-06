package tm.mr.simplemusicplayer.feature.home

data class Response(
    val _embedded: ResponseEmbedded?
)

data class ResponseEmbedded(
    val sort: String?,
    val items: List<Item>?,
    val limit: Int?,
    val offset: Int?,
    val total: Int?
)

data class Item(
    val size: Long?,
    val name: String?,
    val created: String?,
    val modified: String?,
    val file: String?
)