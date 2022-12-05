package study

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.util.Arrays.asList

class KotlinTest {

    @Test
    fun `test repeat`() {
        repeat(5) { print(it) }
    }

    @Test
    fun `test forEach`() {

        listOf(1, 2, 3).forEach { print(it) }
    }

    fun foo(
        bar: Int = 0,
        baz: Int = 1,
        qux: () -> Unit,
    ) {
        println(bar)
        println(baz)
        qux.run { }
    }

    fun bar(
        bar: Int = 0,
        baz: Int,
        qux: () -> Unit,
    ) {
        println(bar)
        println(baz)
        qux.run { }
    }

    @Test
    fun `test parameters`() {
        foo(1) { println("hello") } // 앞부터 채운다, 마지막 lambda 이렇게 표현할 수 있다

        bar(baz = 0) { println("hello") }
    }

    @Test
    fun `add vararg to list`() {
        val arr = arrayOfNulls<Int>(3)
        repeat(arr.size) { arr[it] = it }

        asList(-1, *arr) shouldBe listOf(-1, 0, 1, 2)
    }
}
