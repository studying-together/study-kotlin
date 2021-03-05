package st.kotlin.jun.second

import org.junit.Test
import java.lang.IllegalArgumentException

class SmartCastTest {

    @Test
    fun sumTest() {
        println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
        println(eval2(Sum(Sum(Num(1), Num(2)), Num(4))))
        println(eval3(Sum(Sum(Num(1), Num(2)), Num(4))))
        println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
    }

    fun eval(e: Expr): Int {
        if (e is Num) {
            val n = e as Num
            return n.value
        }
        if (e is Sum) {
            return eval(e.right) + eval(e.left)
        }
        throw IllegalArgumentException("Unknown expression")
    }

    fun eval2(e: Expr) =
            if (e is Num) {
                e.value
            } else if (e is Sum) {
                eval(e.right) + eval(e.left)
            } else {
                throw IllegalArgumentException("Unknown expression")
            }

    fun eval3(e: Expr) =
            when (e) {
                is Num -> e.value
                is Sum -> eval(e.right) + eval(e.left)
                else -> throw IllegalArgumentException("Unknown expression")
            }

    fun evalWithLogging(e: Expr): Int =
            when (e) {
                is Num -> {
                    println("num: ${e.value}")
                    e.value
                }
                is Sum -> {
                    val left = evalWithLogging(e.left)
                    val right = evalWithLogging(e.right)
                    println("sum: $left + $right")
                    left + right
                }
                else -> throw IllegalArgumentException("Unknown expression")
            }

    @Test
    fun `피즈버즈 테스트`() {
        for (i in 1..100) {
            println(fizzBuzz(i))
        }
        for (i in 100 downTo 1 step 2) {
            println(fizzBuzz(i))
        }
    }

    fun fizzBuzz(i: Int) = when {
        i % 15 == 0 -> "FizzBuzz "
        i % 3 == 0 -> "Fizz "
        i % 5 == 0 -> "Buzz "
        else -> "$i "
    }

}

interface Expr

class Num(val value: Int): Expr

class Sum(val left: Expr, val right: Expr): Expr