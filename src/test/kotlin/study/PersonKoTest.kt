package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "한맹희", age = 30, nickname = "맹귄")
        actual.name shouldBe "한맹희"
        actual.nickname shouldBe "맹귄"
        actual.age shouldBe 30
    }
})
