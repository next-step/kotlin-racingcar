package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자 테스트에요" {
        val person = Person(nickname = "다정", age = 63, name = "김다정")

        person.name shouldBe "김다정"
        person.age shouldBe 63
        person.nickname shouldBe "다정"
    }

    "널 타입" {
        val person = Person("김다정", 45, null)
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person("김다정", 45)
        person.nickname shouldBe person.name
    }

    "데이터 클래스" {
        val person1 = Person("김다정", 45)
        val person2 = Person("김다정", 45)
        person1 shouldBe person2
    }
})
