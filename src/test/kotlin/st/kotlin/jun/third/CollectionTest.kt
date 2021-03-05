package st.kotlin.jun.third

import st.kotlin.jun.third.strings.join
import kotlin.test.Test
import st.kotlin.jun.third.strings.joinToString5
import st.kotlin.jun.third.strings.joinToString6
import st.kotlin.jun.third.strings.lastChar
import st.kotlin.jun.third.strings.lastChar2 as last2

var opCount = 0
const val staticOpCount = 0

class CollectionTest {
    @Test
    fun `기본 컬렉션 테스트`() {
        val set = hashSetOf(1, 7, 3)
        val list = arrayListOf(1, 7, 3)
        val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")
        println(set)
        println(list)
        println(map)

        println(set.javaClass)
        println(list.javaClass)
        println(map.javaClass)
    }

    @Test
    fun `컬렉션 기능 테스트`() {
        val strings = listOf("first", "second", "fourteenth")
        println(strings.last())

        val numbers = setOf(1, 14, 2)
        println(numbers.max())

        val list = listOf(1, 2, 3)
        println(list)
    }

    @Test
    fun `joinToString() 테스트`() {
        val list = listOf(1, 2, 3)
        println(">> 1")
        println(joinToString(list, "; ", "(", ")"))

        println(">> 2")
        println(joinToString2(list, ", ", "", ""))
        println(joinToString2(list))
        println(joinToString2(list, "; "))
        println(joinToString2(list, postfix = " ;", prefix = "#"))

        println(">> 3")
        println(joinToString5(list))
        println(list.joinToString6("; ", "{", "}"))
        println(list.joinToString6(" "))

        println(">> 4")
        println(listOf("one", "two", "three").join(" "))
    }

    fun <T> joinToString(
            collection: Collection<T>,
            separator: String,
            prefix: String,
            postfix: String
    ): String {
        val result = StringBuilder(prefix)

        for ((index, element) in collection.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(element)
        }
        result.append(postfix)
        return result.toString()
    }

    fun <T> joinToString2(
            collection: Collection<T>,
            separator: String = ", ",
            prefix: String = "",
            postfix: String = ""
    ): String {
        return joinToString(collection, separator, prefix, postfix)
    }

    @Test
    fun `전역 변수 테스트`() {
        performOperation()
        println("opCount: $opCount")
    }

    fun performOperation() {
        opCount++
    }

    @Test
    fun `확장 함수 테스트`() {
        println("Kotlin".lastChar())
        println("Kotlin".last2())
        println("Kotlin".lastChar)
        val sb = StringBuilder("Kotlin?")
        sb.lastChar = '!'
        println(sb)
    }
}