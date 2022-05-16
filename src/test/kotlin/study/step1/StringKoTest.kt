package study.step1

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class StringKoTest : AnnotationSpec() {

    @Test
    fun isBlank() {
        "".isBlank() shouldBe true
        " ".isBlank() shouldBe true
    }
    @Test
    fun string() {
        "jason"[0] shouldBe 'j'
        "jason"[1] shouldBe 'a'
        "jason"[2] shouldBe 's'
        "jason"[3] shouldBe 'o'
        "jason"[4] shouldBe 'n'
    }
}
