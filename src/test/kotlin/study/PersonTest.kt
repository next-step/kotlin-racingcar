package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "박영호", age = 27, nickname = "lalize")

        person.name shouldBe "박영호"
        person.age shouldBe 27
        person.nickname shouldBe "lalize"
    }

    "널 타입" {
        val person = Person(name = "박영호", age = 27, nickname = null)

        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person(name = "박영호", age = 27)

        person.nickname shouldBe person.name
    }

    "데이터 클래스" {
        val person1 = Person(name = "박영호", age = 27)
        val person2 = Person(name = "박영호", age = 27)

        person1 shouldBe person2
    }
})
