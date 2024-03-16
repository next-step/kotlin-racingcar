package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldBeEmpty
import org.junit.jupiter.api.Test

class StringKoTest : AnnotationSpec() {

    @Test
    fun isEmpty() {
        "".isEmpty() shouldBe true
        "".shouldBeEmpty()
    }

    @Test
    fun isBlank() {
        "".isBlank() shouldBe true
    }
}