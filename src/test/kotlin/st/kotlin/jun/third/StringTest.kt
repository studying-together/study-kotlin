package st.kotlin.jun.third

import kotlin.test.Test

class StringTest {
    @Test
    fun `문자열 테스트`() {
        println("12.345-6.A".split(".", "-"))
    }

    @Test
    fun `경로명 추출 테스트`() {
        val path = "/Users/yole/kotlin-book/chapter.adoc"
        println(">> 1")
        parsePath(path)
        println(">> 2")
        parsePath2(path)
    }

    fun parsePath(path: String) {
        val directory = path.substringBeforeLast("/")
        var fullName = path.substringAfterLast("/")
        val fileName = fullName.substringBeforeLast(".")
        val extension = fullName.substringAfterLast(".")
        println("Dir: $directory, name: $fileName, ext: $extension")
    }

    fun parsePath2(path: String) {
        val regex = """(.+)/(.+)\.(.+)""".toRegex()
        val matchResult = regex.matchEntire(path)
        if (matchResult != null) {
            val (directory, filename, extension) = matchResult.destructured
            println("Dir: $directory, name: $filename, ext: $extension")
        }
    }

    @Test
    fun `3중 따옴표 문자열`() {
        val kotlinLogo = """|  //
                           .| //
                           .|/ \"""
        println(kotlinLogo.trimMargin("."))
    }
}