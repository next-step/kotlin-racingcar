package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "정명구", 20, nickname = "dding94")
        actual.name shouldBe "정명구"
        actual.age shouldBe 20
        actual.nickname shouldBe "dding94"
    }
})
