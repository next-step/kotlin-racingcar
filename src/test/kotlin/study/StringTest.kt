package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class StringTest : AnnotationSpec() {
    @Test
    fun isEmpty() {
        "".isEmpty() shouldBe true
    }

    @Test
    fun isBlank() {
        "".isBlank() shouldBe true
        " ".isBlank() shouldBe true
        "\r\n".isBlank() shouldBe true
        "\t".isBlank() shouldBe true
    }
}
