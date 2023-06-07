import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class AutoTest {

    @Test
    fun checkAddNeReportToComment() {
        val firstReport = ReportComment(0,0,0)
        val newReport = WallService.createReport(0, firstReport)
        assertEquals(firstReport, newReport)
    }

//    @Test(expected = PostNotFoundException::class)
//    fun shouldThrowReportToComment() {
//        val firstReport = ReportComment(0,0,0)
//        WallService.createReport(0, firstReport)
//    }

//    @Test(expected = ReasonNotFoundException::class)
//    fun shouldThrowReasonToComment() {
//        val firstReport = ReportComment(0,0,5)
//        val firstComment = Comment(0, "Кто-то оставил коммент", 0)
//        checkAddToArray()
//        val newComment = WallService.createComment(1,firstComment)
//        WallService.createReport(0, firstReport)
//    }

    @Test
    fun checkAddNewCommentToPost() {
        val firstComment = Comment(0, "Кто-то оставил коммент", 0)
        checkAddToArray()
        val newComment = WallService.createComment(1,firstComment)

        assertEquals(firstComment, newComment)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        val firstComment = Comment(0, "Кто-то оставил коммент", 0)
        WallService.createComment(1,firstComment)
    }

    @Test
    fun checkAddToArray() {
        val firstPhoto = Photo(1,1,"URL_firstPhoto","URL_firstPhoto")
        val audio = Audio(1,1,"Artist","Song")
        val video = Video(1,1,"video", 120)
        val document = Document(1,1,"document", 256)
        val graffiti = Graffiti(1,1,"URL", "URL")

        val arrayAttachments: Array<Attachments> = arrayOf(PhotoAttachment(firstPhoto), AudioAttachment(audio), VideoAttachment(video), DocumentAttachment(document), GraffitiAttachment(graffiti))

        val firstPost = Post(0, 1, 1, 1, 1, "firstPost",arrayAttachments, null, Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)
        val post = WallService.add(firstPost)

        assertEquals(1, post.id)
    }

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateExistingTrue() {
        val firstPhoto = Photo(1,1,"URL_firstPhoto","URL_firstPhoto")
        val audio = Audio(1,1,"Artist","Song")
        val video = Video(1,1,"video", 120)
        val document = Document(1,1,"document", 256)
        val graffiti = Graffiti(1,1,"URL", "URL")

        val arrayAttachments: Array<Attachments> = arrayOf(PhotoAttachment(firstPhoto), AudioAttachment(audio), VideoAttachment(video), DocumentAttachment(document), GraffitiAttachment(graffiti))

        val firstPost = Post(0, 1, 1, 1, 1, "firstPost",arrayAttachments, null, Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)
        val secondPost = Post(0, 2, 2, 2, 2, "secondPost", arrayAttachments, null, Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)

        WallService.add(firstPost)
        WallService.add(secondPost)

        val update = Post(1, 3, 3, 3, 3, "updatePost", arrayAttachments, null, Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)

        val result = WallService.update(update)

        assertTrue(result)
    }


    @Test
    fun updateExistingFalse() {
        val firstPhoto = Photo(1,1,"URL_firstPhoto","URL_firstPhoto")
        val audio = Audio(1,1,"Artist","Song")
        val video = Video(1,1,"video", 120)
        val document = Document(1,1,"document", 256)
        val graffiti = Graffiti(1,1,"URL", "URL")

        val arrayAttachments: Array<Attachments> = arrayOf(PhotoAttachment(firstPhoto), AudioAttachment(audio), VideoAttachment(video), DocumentAttachment(document), GraffitiAttachment(graffiti))

        val firstPost = Post(0, 1, 1, 1, 1, "firstPost", arrayAttachments, null, Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)
        val secondPost = Post(0, 2, 2, 2, 2, "secondPost", arrayAttachments, null, Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)

        WallService.add(firstPost)
        WallService.add(secondPost)

        val update = Post(10, 3, 3, 3, 3, "updatePost", arrayAttachments, null, Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)

        // выполняем целевое действие
        val result = WallService.update(update)

        assertFalse(result)
    }
}