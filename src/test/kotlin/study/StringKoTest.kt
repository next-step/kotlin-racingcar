package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class StringKoTest : AnnotationSpec() {
    @Test
    fun isEmpty() {
        "".isEmpty() shouldBe false
    }
}