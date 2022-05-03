package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeEmpty

class StringKoTest : AnnotationSpec() {
    @Test
    fun isEmpty() {
        "".isEmpty() shouldBe true
        "".shouldBeEmpty()
        " ".isEmpty() shouldBe false
    }

    @Test
    fun isBlank() {
        " ".isBlank() shouldBe true
    }
}
