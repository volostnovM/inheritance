import java.io.PipedOutputStream

object WallService {

    private var arrayPost = emptyArray<Post>()
    private var comments = emptyArray<Comment>()
    private var reports = emptyArray<ReportComment>()
    private var identificator: Int = 0
    private var arrayReason: Array<Int> = arrayOf(0,1,2,3,4,5,6,7,8)

    fun createReport(commentId: Int, report: ReportComment): ReportComment? {
        for ((index, commentFind) in comments.withIndex()) {
            if (commentId == commentFind.id) {
                val updateReport = report.copy()
                reports += updateReport

                if(arrayReason.contains(report.reason)) {
                    return report
                }
                return throw ReasonNotFoundException("Неверно указана причина")
            }
        }
        return throw PostNotFoundException("Пост для записи жалобы не найден:)")
    }

    fun createComment(postId: Int, comment: Comment): Comment {
        for ((index, postFind) in arrayPost.withIndex()) {
            if (postId == postFind.id) {
                arrayPost[index].comments = comment
                val updateComment = comment.copy()
                comments += updateComment
                return comment
            }
        }
        return throw PostNotFoundException("Пост не найден:)")
    }

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