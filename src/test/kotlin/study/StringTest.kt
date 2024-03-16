package study

import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeEmpty
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class StringTest {

    @Test
    fun isEmpty() {
        "".isEmpty() shouldBe true
        "".shouldBeEmpty()
        " ".isEmpty() shouldBe false

        assertThat(" ").isBlank
    }

    @Test
    fun isBlank() {
        " ".isBlank() shouldBe true

        assertThat(" ").isBlank
    }

    @Test
    fun string() {
        assertThat("binghe"[0]).isEqualTo('b')
        assertThat("binghe"[1]).isEqualTo('i')
        assertThat("binghe"[2]).isEqualTo('n')
        assertThat("binghe"[3]).isEqualTo('g')
        assertThat("binghe"[4]).isEqualTo('h')
        assertThat("binghe"[5]).isEqualTo('e')
    }
}