class PostNotFoundException(message: String) : RuntimeException(message)
class ReasonNotFoundException(message: String) : RuntimeException(message)
class CommentNotFoundException(message: String) : RuntimeException(message)

fun main() {
    val firstPhoto = Photo(1,1,"URL_firstPhoto","URL_firstPhoto")
    val audio = Audio(1,1,"Artist","Song")
    val video = Video(1,1,"video", 120)
    val document = Document(1,1,"document", 256)
    val graffiti = Graffiti(1,1,"URL", "URL")

    val arrayAttachments: Array<Attachments> = arrayOf(PhotoAttachment(firstPhoto), AudioAttachment(audio), VideoAttachment(video), DocumentAttachment(document), GraffitiAttachment(graffiti))

    val firstPost = Post(0, 1, 1, 1, 1, "firstPost", arrayAttachments, null, Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)
    val secondPost = Post(1, 2, 2, 2, 2, "secondPost", arrayAttachments, null, Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)

    WallService.add(firstPost)
    WallService.add(secondPost)
    WallService.update(firstPost)


    val firstComment = Comment(0, "Кто-то оставил коммент", 0)
    val secondComment = Comment(0, "Кто-то второй оставил коммент", 0)

    WallService.createComment(1,firstComment)
    WallService.createComment(2,secondComment)

    val firstReport = ReportComment(0,0,0)
    WallService.createReport(0, firstReport)

    val test = WallService.printArr()
    for (i in test) {
        println(i)
    }
}
