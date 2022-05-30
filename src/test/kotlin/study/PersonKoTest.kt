package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val people = listOf(
            Person("장재주", 32, "제이"),
            Person("장재주", 32, nickname = "제이"),
            Person(name = "장재주", age = 32, nickname = "제이")
        )
        people.forAll {
            it.name shouldBe "장재주"
            it.age shouldBe 32
            it.nickname shouldBe "제이"
        }
    }

    "널 타입" {
        val person = Person("장재주", 32, null)
        person.name shouldBe "장재주"
        person.age shouldBe 32
        person.nickname shouldBe null
    }

    "기본 인자" {
        val person = Person("장재주", 32)
        person.name shouldBe "장재주"
        person.age shouldBe 32
        person.nickname shouldBe "장재주"
    }

    "데이터 클래스" {
        val person1 = Person("장재주", 32)
        val person2 = Person("장재주", 32)
        person1 shouldBe person2
    }
})
