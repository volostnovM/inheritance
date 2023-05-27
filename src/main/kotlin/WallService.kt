import java.io.PipedOutputStream

object WallService {

    private var arrayPost = emptyArray<Post>()
    private var identificator: Int = 0

    fun add(post: Post): Post {
        identificator++
        val updatePost = post.copy(id = identificator)
        arrayPost += updatePost
        return updatePost
    }

    fun update(post: Post): Boolean {
        var isFind = false
        for ((index, postFind) in arrayPost.withIndex()) {
            if (post.id == postFind.id) {
                arrayPost[index] = post
                isFind = true
            }
        }
        return isFind
    }

    fun printArr(): Array<Post> {
        return arrayPost
    }

    fun clear() {
        arrayPost = emptyArray()
        identificator = 0
    }
}