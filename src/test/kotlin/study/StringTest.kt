package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class StringTest : AnnotationSpec() {
    @AnnotationSpec.Test
    fun isEmpty() {
        // kotest assertion library 포함됨
        "".isEmpty() shouldBe true
        " ".isEmpty() shouldBe false
        "a".isEmpty() shouldBe false
    }
}
