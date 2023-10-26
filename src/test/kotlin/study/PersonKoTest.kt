package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "이범석", age = 26, nickname = "범")
        person.name shouldBe "이범석"
        person.age shouldBe 26
        person.nickname shouldBe "범"
    }
})
