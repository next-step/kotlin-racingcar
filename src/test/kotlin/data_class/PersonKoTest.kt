package data_class

import Person
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({

    "이름 붙인 인자" {
        val person = Person(
            name = "허지훈",
            age = 29,
            nickname = "modernflow"
        )
        person.name shouldBe "허지훈"
        person.age shouldBe 29
        person.nickname shouldBe "modernflow"
    }

    "널 타입" {
        val person = Person(
            name = "허지훈",
            age = 29,
            nickname = null
        )
        person.nickname shouldBe null
    }

    "기본 인자" {
        val person = Person(name = "허지훈", age = 29)
        person.name shouldBe person.nickname
    }

    "데이터 클래스" {
        val person1 = Person(name = "허지훈", age = 29)
        val person2 = Person(name = "허지훈", age = 29)
        person1 shouldBe person2
    }
})
