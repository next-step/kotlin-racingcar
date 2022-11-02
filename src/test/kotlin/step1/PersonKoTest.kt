package step1

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "조규현", age = 30, nickname = "리규")
        person.name shouldBe "조규현"
        person.age shouldBe 30
        person.nickname shouldBe "리규"
    }

    "널 타입" {
        val person = Person("조규현", 30, null)
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person("조규현", 30)
        person.name shouldBe person.nickname
    }

    "데이터 클래스" {
        val person1 = Person("조규현", 30)
        val person2 = Person("조규현", 30)
        person1 shouldBe person2
    }
})
