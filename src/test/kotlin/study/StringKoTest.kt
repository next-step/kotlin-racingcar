package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

// Kotest 플러그인 설치
class StringKoTest : AnnotationSpec() {
    @Test
    fun isEmpty() {
        "".isEmpty() shouldBe true
        " ".isEmpty() shouldBe false
        "a".isEmpty() shouldBe false
    }
}
