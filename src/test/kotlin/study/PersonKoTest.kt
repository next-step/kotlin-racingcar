package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "박상오", age = 20, nickname = "Bob")
        actual.name shouldBe "박상오"
        actual.age shouldBe 20
        actual.nickname shouldBe "Bob"
    }
})
