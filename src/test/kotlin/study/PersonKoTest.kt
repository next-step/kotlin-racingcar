package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "안지영", age = 25, nickname = "지영")
        person.name shouldBe "안지영"
        person.age shouldBe 25
        person.nickname shouldBe "지영"
    }

    "널 타입" {
        val person = Person("안지영", 25, null)
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person("안지영", 25)
        person.name shouldBe person.nickname
    }

    "데이터 클래스" {
        val person1 = Person("안지영", 25)
        val person2 = Person("안지영", 25)
        person1 shouldBe person2
    }
})
