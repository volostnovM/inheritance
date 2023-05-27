data class Post(
    val id: Int,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val comments: Comment,
    val copyright: Copyright,
    val likes: Like,
    val reposts: Report
)

data class Comment(
    val count: Int = 0,
    val canPost: Boolean = true,
    val groupsCanPost: Boolean = true,
    val canClose: Boolean = true,
    val canOpen: Boolean = true
)

data class Copyright(
    val id: Int = 0,
    val link: String = "link",
    val name: String = "name",
    val type: String = "type"
)

data class Like(
    val count: Int = 50,
    val userLikes: Boolean = false,
    val canLike: Boolean = true,
    val canPublish: Boolean = true
)

data class Report(
    val count: Int = 10,
    val userReposted: Boolean = true
)