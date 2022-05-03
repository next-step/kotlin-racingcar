package study

import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeEmpty
import org.assertj.core.api.Assertions.assertThat
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
        assertThat("hyeon9mak"[0]).isEqualTo('h')
        assertThat("hyeon9mak"[1]).isEqualTo('y')
        assertThat("hyeon9mak"[2]).isEqualTo('e')
        assertThat("hyeon9mak"[3]).isEqualTo('o')
        assertThat("hyeon9mak"[4]).isEqualTo('n')
        assertThat("hyeon9mak"[5]).isEqualTo('9')
    }
}
