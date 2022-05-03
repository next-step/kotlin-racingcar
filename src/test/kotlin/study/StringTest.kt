package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class StringTest: AnnotationSpec() {
    @Test
    fun aa() {
        "".isEmpty() shouldBe true
    }
}