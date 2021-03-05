package st.kotlin.jun.third

import org.junit.Test

class CollectionUtilTest {
    @Test
    fun `가변인자함수 테스트`() {
        val array = arrayOf(1, 2, 3)
        val list = listOf(4, *array)
        println(list)

        1 to "one"
        1 to "one"
        "1".plus("2")
    }
}