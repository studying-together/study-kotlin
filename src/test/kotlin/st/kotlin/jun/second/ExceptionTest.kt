package st.kotlin.jun.second

import org.junit.Test
import java.io.BufferedReader
import java.io.StringReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import javax.print.attribute.IntegerSyntax

class ExceptionTest {
    @Test
    fun `예외 테스트`() {
        val percentage = 101

        if (percentage !in 1..100) {
            throw IllegalArgumentException("A Percentage value must be between 0 and 100: $percentage")
        }
    }

    @Test
    fun `예외 테스트2`() {
        fun percentage(number: Int) =
            if (number in 0..100)
                number
            else
                throw IllegalArgumentException("A Percentage value must be between 0 and 100: $number")

        println(percentage(101))
    }

    @Test
    fun `예외 테스트3`() {
        val reader = BufferedReader(StringReader("239"))
        println(readNumber(reader))
        readNumber2(BufferedReader(StringReader("not a number")))
        readNumber3(BufferedReader(StringReader("not a number")))
    }

    fun readNumber(reader: BufferedReader): Int? {
        try {
            val line = reader.readLine()
            return Integer.parseInt(line)
        } catch (e: NumberFormatException) {
            return null
        } finally {
            reader.close()
        }
    }

    fun readNumber2(reader: BufferedReader) {
        val number = try {
            Integer.parseInt(reader.readLine())
        } catch (e: NumberFormatException) {
            return
        }
        println(number)
    }

    fun readNumber3(reader: BufferedReader) {
        val number = try {
            Integer.parseInt(reader.readLine())
        } catch (e: NumberFormatException) {
            null
        }
        println(number)
    }

}