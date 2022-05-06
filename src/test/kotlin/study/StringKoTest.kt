package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

// Kotest 플러그인 설치 실제로 코테스트에서 Ko는 안붙여도됨. 지금은 분리하기 위해
class StringKoTest : AnnotationSpec() {
    @Test
    fun isEmpty() {
        "".isEmpty() shouldBe true
        " ".isEmpty() shouldBe false
        "a".isEmpty() shouldBe false
    }
}
