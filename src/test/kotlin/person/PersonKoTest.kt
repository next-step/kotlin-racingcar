package person

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "이정수", age = 20, nickname = "도리루")
        actual.name shouldBe "이정수"
        actual.nickname shouldBe "도리루"
        actual.age shouldBe 20
    }
})
