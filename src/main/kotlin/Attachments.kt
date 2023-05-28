interface Attachments {
    val type: String
}

interface AudioAtttachment: Attachments {
    val id: Int
    val ownerId: Int
    val artist: String
    val title: String
}

interface PhotoAttachment: Attachments {
    val id: Int
    val ownerId: Int
    val photo130: String
    val photo604: String
}

interface VideoAttachment: Attachments {
    val id: Int
    val ownerId: Int
    val title: String
    val duration: Int
}

interface DocumentAttachment: Attachments{
    val id: Int
    val ownerId: Int
    val title: String
    val size: Int
}

interface GraffitiAttachment: Attachments {
    val id: Int
    val ownerId: Int
    val photo130: String
    val photo604: String
}

class Photo(
    override val id: Int,
    override val ownerId: Int,
    override val photo130: String,
    override val photo604: String
) : PhotoAttachment {
    override val type: String = "photo"
}

class Video(
    override val id: Int,
    override val ownerId: Int,
    override val title: String,
    override val duration: Int
) : VideoAttachment {
    override val type: String = "video"
}

class Audio(
    override val id: Int,
    override val ownerId: Int,
    override val artist: String,
    override val title: String
) : AudioAtttachment {
    override val type: String = "audio"
}

class Document(
    override val id: Int,
    override val ownerId: Int,
    override val title: String,
    override val size: Int
) : DocumentAttachment {
    override val type: String = "document"
}

class Graffiti(
    override val id: Int,
    override val ownerId: Int,
    override val photo130: String,
    override val photo604: String
) : GraffitiAttachment {
    override val type: String = "graffiti"
}