package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "이동준", age = 34, nickname = "dongjoon1251")
        actual.name shouldBe "이동준"
        actual.age shouldBe 34
        actual.nickname shouldBe "dongjoon1251"
    }
})
