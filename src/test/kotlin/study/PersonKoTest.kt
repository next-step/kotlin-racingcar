package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({

    "이름 붙인 인자" {
        val person = Person(name = "김성훈", age = 20, nickname = "이바")

        person.name shouldBe "김성훈"
        person.age shouldBe 20
        person.nickname shouldBe "이바"
    }

    "널 타입" {
        val person = Person(name = "김성훈", age = 20, nickname = null)

        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person(name = "김성훈", age = 20)

        person.nickname shouldBe person.name
    }

    "데이터 클래스" {
        val person1 = Person(name = "김성훈", age = 20)
        val person2 = Person(name = "김성훈", age = 20)

        person1 shouldBe person2
    }
})
