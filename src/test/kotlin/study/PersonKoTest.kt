package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "Ohsung", age = 20, nickname = "oh")
        actual.name shouldBe "Ohsung"
        actual.age shouldBe 20
        actual.nickname shouldBe "oh"
    }
})
