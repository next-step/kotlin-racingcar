package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions

class StringKoTest : AnnotationSpec() {
    @Test
    fun isEmpty() {
        "".isEmpty() shouldBe true
        " ".isEmpty() shouldBe false
        "a".isEmpty() shouldBe false
    }
}