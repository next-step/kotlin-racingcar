package study

import io.kotest.assertions.assertSoftly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class JoinStringTest {

    @Test
    fun `test parameters`() {
        listOf(1,2).joinToString(",", transform = { "t" + it }) shouldBe "t1,t2"
    }

    @Test
    fun joinToString() {
        assertSoftly {
            (1..3).map { "-" }.joinToString { "" } shouldBe ", , "
            (1..3).map { "-" }.joinToString("") shouldBe "---"

            (1..3).map { (0 until it).map { "-" }.joinToString("") }.joinToString(",") shouldBe "-,--,---"
            (2..3).map { (0 until it).map { "-" }.joinToString("") }.joinToString(",") shouldBe "--,---"
        }
    }

    @Test
    fun print() {
        val result = listOf((1..3), (1..3))
            // .map { it.map { "-" }.joinToString("") }
            .map {
                it.map { number ->
                    (0 until number).map { "-" }.joinToString("")
                }.joinToString("\n")
            }
            .joinToString("\n\n")

        result shouldBe
            """-
--
---

-
--
---"""
    }
}
