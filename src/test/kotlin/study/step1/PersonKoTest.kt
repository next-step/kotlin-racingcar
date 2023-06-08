package study.step1

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "서동성", age = 34, nickname = "lullaaaby13")
        actual.name shouldBe "서동성"
        actual.nickname shouldBe "lullaaaby13"
        actual.age shouldBe 34
    }
})
