package step1.test

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

internal class StringKoTest : AnnotationSpec() {

    @Test
    fun isEmpty() {
        "".isEmpty() shouldBe true
    }
}
