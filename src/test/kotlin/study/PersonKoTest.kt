package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "김준호", age = 20, nickname = "준")
        actual.name shouldBe "김준호"
        actual.nickname shouldBe "준"
        actual.age shouldBe 20
    }
})
