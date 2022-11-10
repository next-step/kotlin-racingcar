package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        // given, when
        val person = Person(name = "이상인", age = 20, nickname = "위푸")

        // then
        person.name shouldBe "이상인"
        person.age shouldBe 20
        person.nickname shouldBe "위푸"
    }

    "널 타입" {
        // given, when
        val person = Person(name = "이상인", age = 20, nickname = null)

        // then
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        // given, when
        val person = Person(name = "이상인", age = 20)

        // then
        person.name shouldBe person.nickname
    }

    "데이터 클래스" {
        // given, when
        val person1 = Person(name = "이상인", age = 20)
        val person2 = Person(name = "이상인", age = 20)

        // then
        person1 shouldBe person2
    }
})
