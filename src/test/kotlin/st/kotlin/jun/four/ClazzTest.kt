package st.kotlin.jun.four

import org.junit.Test

class ClazzTest {

    @Test
    fun delegate() {
        val cset = CountingSet<Int>()
        cset.addAll(listOf(1, 1, 2))
        println("${cset.objectsAdded} objects were added, ${cset.size} remain")
    }

    class DelegatingCollection<T> : Collection<T> {
        private val innerList = arrayListOf<T>()

        override val size: Int get() = innerList.size
        override fun contains(element: T): Boolean = innerList.contains(element)
        override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)
        override fun isEmpty(): Boolean = innerList.isEmpty()
        override fun iterator(): Iterator<T> = innerList.iterator()
    }

    class DelegatingCollection2<T>(innerList: Collection<T> = ArrayList<T>()) : Collection<T> by innerList {}

    class CountingSet<T>(
            val innerSet: MutableCollection<T> = HashSet<T>()
    ) : MutableCollection<T> by innerSet {
        var objectsAdded = 0

        override fun add(element: T): Boolean {
            objectsAdded++
            return innerSet.add(element)
        }

        override fun addAll(elements: Collection<T>): Boolean {
            objectsAdded += elements.size
            return innerSet.addAll(elements)
        }
    }
}