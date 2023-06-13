package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름_붙인_인자" {
        val actual = Person(name = "송시은", age = 24, nickname = "sieun")
        actual.name shouldBe "송시은"
        actual.nickname shouldBe "sieun"
        actual.age shouldBe 24
    }
})
