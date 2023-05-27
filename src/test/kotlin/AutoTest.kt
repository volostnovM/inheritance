import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class AutoTest {

    @Test
    fun checkAddToArray() {
        val firstPost = Post(0, 1, 1, 1, 1, "firstPost", Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)
        val post = WallService.add(firstPost)

        assertEquals(1, post.id)
    }

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun updateExistingTrue() {
        val firstPost = Post(0, 1, 1, 1, 1, "firstPost", Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)
        val secondPost = Post(0, 2, 2, 2, 2, "secondPost", Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)

        WallService.add(firstPost)
        WallService.add(secondPost)

        val update = Post(1, 3, 3, 3, 3, "updatePost", Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)

        val result = WallService.update(update)

        assertTrue(result)
    }

    @Before
    fun clearBeforeTestUpdateFalse() {
        WallService.clear()
    }

    @Test
    fun updateExistingFalse() {
        val firstPost = Post(0, 1, 1, 1, 1, "firstPost", Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)
        val secondPost = Post(0, 2, 2, 2, 2, "secondPost", Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)

        WallService.add(firstPost)
        WallService.add(secondPost)

        val update = Post(10, 3, 3, 3, 3, "updatePost", Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)

        // выполняем целевое действие
        val result = WallService.update(update)

        assertFalse(result)
    }
}