package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person("김태정", 20, "검프")
        person.name shouldBe "김태정"
        person.age shouldBe 20
        person.nickname shouldBe "검프"
    }
})
