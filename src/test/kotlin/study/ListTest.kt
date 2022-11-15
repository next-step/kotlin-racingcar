package study

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.util.Arrays.asList

class ListTest {
    @Test
    fun `test List`() {
        List(3) { it } shouldBe listOf(0, 1, 2)
    }

    @Test
    fun BuildLst() {
        buildList(3) {
            addAll(listOf(1, 2, 3))
        } shouldBe listOf(1, 2, 3)
    }

    @Test
    fun asList() {
        asList(1, 2, 3) shouldBe listOf(1, 2, 3)
    }

    @Test
    fun MutableList() {
        val list = MutableList(3) { it }
        val arr = arrayOf(3, 4)
        list.addAll(arr)

        list shouldBe listOf(0, 1, 2, 3, 4)
    }
}
