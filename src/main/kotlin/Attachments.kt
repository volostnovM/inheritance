interface Attachments {
    val type: String
}

data class PhotoAttachment(
    val photo: Photo
) : Attachments {
    override val type: String = "photo"
}

data class VideoAttachment(
    val video: Video
) : Attachments {
    override val type: String = "video"
}

data class DocumentAttachment(
    val document: Document
) : Attachments {
    override val type: String = "document"
}

data class AudioAttachment(
    val audio: Audio
) : Attachments {
    override val type: String = "audio"
}

data class GraffitiAttachment(
    val graffiti: Graffiti
) : Attachments {
    override val type: String = "graffiti"
}
class Photo(
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo604: String
)

class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val duration: Int
)

class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String
)

class Document(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int
)

class Graffiti(
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo604: String
)