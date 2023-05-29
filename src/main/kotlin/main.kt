fun main() {
    val firstPhoto = Photo(1,1,"URL_firstPhoto","URL_firstPhoto")
    val audio = Audio(1,1,"Artist","Song")
    val video = Video(1,1,"video", 120)
    val document = Document(1,1,"document", 256)
    val graffiti = Graffiti(1,1,"URL", "URL")

    val arrayAttachments: Array<Attachments> = arrayOf(PhotoAttachment(firstPhoto), AudioAttachment(audio), VideoAttachment(video), DocumentAttachment(document), GraffitiAttachment(graffiti))

    val firstPost = Post(0, 1, 1, 1, 1, "firstPost", arrayAttachments, Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)
    val secondPost = Post(0, 2, 2, 2, 2, "secondPost", arrayAttachments, Comment(), Copyright(), Like(), Report(), null,null,null,null,null,null,null,null,null,null,null, null, null)

    WallService.add(firstPost)
    WallService.add(secondPost)
    WallService.update(firstPost)
    val test = WallService.printArr()
    for (i in test) {
        println(i)
    }
}
