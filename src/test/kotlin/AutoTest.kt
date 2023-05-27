import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class AutoTest {

    @Test
    fun checkAddToArray() {
        val firstPhoto = Photo(1,1,"URL_firstPhoto","URL_firstPhoto")
        val secondPhoto = Photo(2,2,"URL_secondPhoto","URL_secondPhoto")
        val audio = Audio(1,1,"Artist","Song")
        val video = Video(1,1,"video", 120)
        val document = Document(1,1,"document", 256)
        val graffiti = Graffiti(1,1,"URL", "URL")

        var arrayAttachments: Array<Attachments> = arrayOf(firstPhoto, secondPhoto, audio, video, document, graffiti)

        val firstPost = Post(0, 1, 1, 1, 1, "firstPost",arrayAttachments, Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)
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
        val secondPhoto = Photo(2,2,"URL_secondPhoto","URL_secondPhoto")
        val audio = Audio(1,1,"Artist","Song")
        val video = Video(1,1,"video", 120)
        val document = Document(1,1,"document", 256)
        val graffiti = Graffiti(1,1,"URL", "URL")

        var arrayAttachments: Array<Attachments> = arrayOf(firstPhoto, secondPhoto, audio, video, document, graffiti)

        val firstPost = Post(0, 1, 1, 1, 1, "firstPost",arrayAttachments, Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)
        val secondPost = Post(0, 2, 2, 2, 2, "secondPost", arrayAttachments, Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)

        WallService.add(firstPost)
        WallService.add(secondPost)

        val update = Post(1, 3, 3, 3, 3, "updatePost", arrayAttachments, Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)

        val result = WallService.update(update)

        assertTrue(result)
    }

    @Before
    fun clearBeforeTestUpdateFalse() {
        WallService.clear()
    }

    @Test
    fun updateExistingFalse() {
        val firstPhoto = Photo(1,1,"URL_firstPhoto","URL_firstPhoto")
        val secondPhoto = Photo(2,2,"URL_secondPhoto","URL_secondPhoto")
        val audio = Audio(1,1,"Artist","Song")
        val video = Video(1,1,"video", 120)
        val document = Document(1,1,"document", 256)
        val graffiti = Graffiti(1,1,"URL", "URL")

        var arrayAttachments: Array<Attachments> = arrayOf(firstPhoto, secondPhoto, audio, video, document, graffiti)

        val firstPost = Post(0, 1, 1, 1, 1, "firstPost", arrayAttachments, Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)
        val secondPost = Post(0, 2, 2, 2, 2, "secondPost", arrayAttachments, Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)

        WallService.add(firstPost)
        WallService.add(secondPost)

        val update = Post(10, 3, 3, 3, 3, "updatePost", arrayAttachments, Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)

        // выполняем целевое действие
        val result = WallService.update(update)

        assertFalse(result)
    }
}