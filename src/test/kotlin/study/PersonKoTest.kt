package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({

    "이름 붙인 인자" {
        val person = Person(name = "김동구", age = 31, nickname = "relkimm")
        person.name shouldBe "김동구"
        person.age shouldBe 31
        person.nickname shouldBe "relkimm"
    }

    "널 타입" {
        val person = Person(name = "김동구", age = 31, nickname = null)
        person.nickname shouldBe null
    }

    "기본 인자" {
        val person = Person(name = "김동구", age = 31)
        person.name shouldBe person.nickname
    }

    "데이터 클래스" {
        val person1 = Person(name = "김동구", age = 31)
        val person2 = Person(name = "김동구", age = 31)
        person1 shouldBe person2
    }
})
