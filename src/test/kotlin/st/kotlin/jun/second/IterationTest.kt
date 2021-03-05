package st.kotlin.jun.second

import org.junit.Test
import java.util.*

class IterationTest {

    val binaryReps = TreeMap<Char, String>()

    @Test
    fun `이터레이션 테스트`() {
        for (c in 'A'..'F') {
            val binary = Integer.toBinaryString(c.toInt())
            binaryReps[c] = binary
        }
        for ((letter, binary) in binaryReps) {
            println("$letter = $binary")
        }

        val list = arrayListOf("10", "11", "1001")
        for ((index, element) in list.withIndex()) {
            println("$index: $element")
        }
    }

    @Test
    fun `in 테스트`() {
        println(isLetter('q'))
        println(isNotDigit('x'))
        println(recognize('8'))
        println("Kotlin" in "Java".."Scala")
        println("Kotlin" in setOf("Java", "Scala"))
    }

    fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

    fun isNotDigit(c: Char) = c !in '0'..'9'

    fun recognize(c: Char) = when (c) {
        in '0'..'9' -> "It's a digit"
        in 'a'..'z', in 'A'..'Z' -> "It's a letter!!"
        else -> "I don't know..."
    }

}