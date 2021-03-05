package st.kotlin.jun.second

import org.junit.Test
import st.kotlin.jun.second.WhenNEnumTest.Color.*

class WhenNEnumTest {
    @Test
    fun `enum 테스트`() {
        println(BLUE.rgb())
    }

    @Test
    fun `when 테스트`() {
        println(getMnemonic(BLUE))
        println(getWarmth(ORANGE))
        println(mix(BLUE, YELLOW))
        println(mixOptimized(BLUE, YELLOW))
    }

    fun getMnemonic(color: Color) =
            when (color) {
                RED -> "Richard"
                ORANGE -> "Of"
                YELLOW -> "York"
                GREEN -> "Gave"
                BLUE -> "Battle"
                INDIGO -> "In"
                VIOLET -> "Vain"
            }

    fun getWarmth(color: Color) = when (color) {
        RED, ORANGE, YELLOW -> "warm"
        GREEN -> "neutral"
        BLUE, INDIGO, VIOLET -> "cold"
    }

    fun mix(c1: Color, c2: Color) = when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("dirty colosr")
    }

    fun mixOptimized(c1: Color, c2: Color) = when {
        (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
        (c1 == YELLOW && c2 == BLUE) || (c1 == BLUE && c2 == YELLOW) -> GREEN
        (c1 == BLUE && c2 == VIOLET) || (c1 == VIOLET && c2 == BLUE) -> INDIGO
        else -> throw Exception("Dirty color")
    }

    // enum : soft keyword
    enum class Color(val r: Int, val g: Int, val b: Int) {
        RED(255, 0, 0), ORANGE(255, 165, 0),
        YELLOW(255, 255, 0), GREEN(0, 255, 0),
        BLUE(0, 0, 255), INDIGO(75, 0, 130), VIOLET(238, 130, 238);

        fun rgb() = (r * 256 + g) * 256 + b
    }
}