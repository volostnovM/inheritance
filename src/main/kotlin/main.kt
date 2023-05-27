fun main() {
    val firstPost = Post(0, 1, 1, 1, 1, "firstPost", Comment(), Copyright(), Like(), Report())
    val secondPost = Post(0, 2, 2, 2, 2, "secondPost", Comment(), Copyright(), Like(), Report())

    WallService.add(firstPost)
    WallService.add(secondPost)
    WallService.update(firstPost)
    val test = WallService.printArr()
    for (i in test) {
        println(i)
    }
}
