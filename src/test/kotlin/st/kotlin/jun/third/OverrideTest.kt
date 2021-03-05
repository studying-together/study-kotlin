package st.kotlin.jun.third

import kotlin.test.Test

class OverrideTest {
    @Test
    fun `함수 상속 테스트`() {
        val view: View = Button()
        view.click()
        view.showOff()
    }
}

open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() = println("Button clicked")
}

fun View.showOff() = println("I'm a view!")

fun Button.showOff() = println("I'm a Button!")