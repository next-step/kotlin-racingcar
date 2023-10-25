package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "홍길동", 20, nickname = "홍")
        actual.name shouldBe "홍길동"
        actual.age shouldBe 20
        actual.nickname shouldBe "홍"
    }
})
