package st.kotlin.jun.four

import org.junit.Test
import st.kotlin.jun.four.ObjectTest.A.Companion.getFacebookName
import java.awt.Dialog
import java.awt.Frame
import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.io.File

class ObjectTest {

    @Test
    fun `비교 테스트`() {
        println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))
        println(listOf(File("/Z"), File("/a")).sortedWith(CaseInsensitiveFileComparator))

        val persons = listOf<Person>(Person("Bob"), Person("Alice"))
        println(persons.sortedWith(Person.NameComparator))
    }

    object CaseInsensitiveFileComparator : Comparator<File> {
        override fun compare(o1: File, o2: File): Int {
            return o1.path.compareTo(o2.path, ignoreCase = true)
        }
    }

    data class Person(val name: String) {
        object NameComparator : Comparator<Person> {
            override fun compare(p1: Person, p2: Person): Int {
                return p1.name.compareTo(p2.name)
            }
        }
    }

    @Test
    fun `동반객체 테스트`() {
        A.bar()

        println(User2.newSubscribingUser("bob@gmail.com"))
        println(User2.newFacebookUser(4))
    }

    class A {
        companion object {
            fun bar() {
                println("Companion object called")
            }

            fun getFacebookName(id: Int): String = id.toString()
        }
    }

    class User {
        val nickname: String

        constructor(email: String) {
            nickname = email.substringBefore('@')
        }

        constructor(facebookAccountId: Int) {
            nickname = getFacebookName(facebookAccountId)
        }
    }

    data class User2 private constructor(val nickname: String) {
        companion object {
            fun newSubscribingUser(email: String) = User2(email.substringBefore('@'))
            fun newFacebookUser(accountId: Int) = User2(getFacebookName(accountId))
        }
    }

    @Test
    fun `이름있는 동반객체`() {
        val person = Person2.Loader.fromJSON("{name: 'test'}")
        println(person.name)
        val person2 = Person2.fromJSON("{name: 'wow'}")
        println(person2.name)

        loadFromJSON(Person3)
    }

    class Person2(val name: String) {
        companion object Loader {
            fun fromJSON(jsonText: String): Person2 = Person2(jsonText)
        }
    }

    interface JSONFactory<T> {
        fun fromJSON(jsonText: String): T
    }

    class Person3(val name: String) {
        companion object: JSONFactory<Person3> {
            override fun fromJSON(jsonText: String): Person3 = Person3(jsonText)
        }
    }

    fun <T> loadFromJSON(factory: JSONFactory<T>) : T? {
        return null
    }


    class Person4(val firstName: String, val lastName: String) {
        companion object
    }

    fun Person4.Companion.fromJSON(json: String): Person4 {
        return Person4(json, json)
    }

    @Test
    fun `확장 동반함수`() {
        println(Person4.fromJSON("test"))
    }

    @Test
    fun `무명 객체`() {
        var clickCount = 0

        Frame().addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) {
                clickCount++
                super.mouseClicked(e)
            }
            override fun mouseEntered(e: MouseEvent?) {
                super.mouseEntered(e)
            }
        })
    }

}