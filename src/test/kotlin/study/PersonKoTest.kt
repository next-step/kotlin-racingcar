package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "홍길동", age = 20, nickname = "Guest")
        actual.age shouldBe 20
        actual.name shouldBe "홍길동"
        actual.nickname shouldBe "Guest"
    }
})
