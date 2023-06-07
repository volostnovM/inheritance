data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String?,
    val attachments: Array<Attachments>,
    var comments: Comment?,
    val copyright: Copyright,
    val likes: Like,
    val reposts: Report,
    val views: View?,
    val postType: String?,
    val geo: Geo?,
    val signerId: Int?,
    val copyHistory: List<String>?,
    val canPin: Boolean?,
    val canDelete: Boolean?,
    val canEdit: Boolean?,
    val isPinned: Boolean?,
    val markedAsAds: Boolean?,
    val isFavorite: Boolean?,
    val donut: Donut?,
    val postponedId: Int?
)

data class ReportComment(
    val ownerId: Int,
    val commentId: Int,
    val reason: Int
)



data class Comment(
    val id: Int,
    val text: String,
    val fromId: Int
)

data class Copyright(
    val id: Int = 0,
    val link: String? = "link",
    val name: String? = "name",
    val type: String? = "type"
)

data class Like(
    val count: Int = 50,
    val userLikes: Boolean? = false,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)

data class Report(
    val count: Int = 10,
    val userReposted: Boolean = true
)

data class View(
    val count: Int
)

data class Geo(
    val type: String,
    val coordinates: String
)

data class Donut(
    val isDonut: Boolean,
    val paidDuration: Int,
    val canPublishFreeCopy: Boolean,
    val edit_mode: String
)