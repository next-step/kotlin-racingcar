package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class StringKoTest : AnnotationSpec() {

    @Test
    fun isEmpty() {
        "".isEmpty() shouldBe true
        "not empty".isEmpty() shouldBe false
    }

    @Test
    fun isBlank() {
        "".isBlank() shouldBe true
        " ".isBlank() shouldBe true
        "\t".isBlank() shouldBe true
        "\r\n".isBlank() shouldBe true
        "not\tempty".isBlank() shouldBe false
    }
}
