package study

import io.kotest.matchers.shouldBe
import io.kotest.core.spec.style.AnnotationSpec


class StringKoTest : AnnotationSpec() {

    @Test
    fun isEmpty() {
        "".isEmpty() shouldBe true
        " ".isEmpty() shouldBe false
    }
}

