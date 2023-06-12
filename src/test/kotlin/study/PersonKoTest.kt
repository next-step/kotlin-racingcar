package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "박태임", age = 24, nickname = "태이밍")
        actual.name shouldBe "박태임"
        actual.nickname shouldBe "태이밍"
        actual.age shouldBe 24
    }
})
