interface Attachments {
    val type: String
}

class Photo(
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo604: String
) : Attachments {
    override val type: String = "photo"
}

class Video(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val duration: Int
) : Attachments {
    override val type: String = "video"
}

class Audio(
    val id: Int,
    val ownerId: Int,
    val artist: String,
    val title: String
) : Attachments {
    override val type: String = "audio"
}

class Document(
    val id: Int,
    val ownerId: Int,
    val title: String,
    val size: Int
) : Attachments {
    override val type: String = "document"
}

class Graffiti(
    val id: Int,
    val ownerId: Int,
    val photo130: String,
    val photo604: String
) : Attachments {
    override val type: String = "graffiti"
}