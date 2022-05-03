package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({

    "이름 붙인 인자" {
        val people = listOf(
            Person("최현구", 27, "현구막"),
            Person("최현구", 27, nickname = "현구막"),
            Person(
                name = "최현구",
                nickname = "현구막",
                age = 27
            )
        )

        people.forAll {
            it.name shouldBe "최현구"
        }
    }

    "널 타입" {
        val person = Person("최현구", 27, null)
        person.name shouldBe "최현구"
        person.age shouldBe 27
        person.nickname shouldBe null
    }


    "기본 인자" {
        val person = Person("최현구", 27)
        person.name shouldBe "최현구"
        person.age shouldBe 27
        person.nickname shouldBe "현구막"
    }


    "데이터 클래스" {
        val person1 = Person("최현구", 27)
        val person2 = Person("최현구", 27)
        person1 shouldBe person2
    }
})
