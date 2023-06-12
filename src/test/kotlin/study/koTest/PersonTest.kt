package study.koTest

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import study.Person

class PersonTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "김정욱", age = 28, nickname = "hue")
        person.name shouldBe "김정욱"
        person.age shouldBe 28
        person.nickname shouldBe "hue"
    }
})
