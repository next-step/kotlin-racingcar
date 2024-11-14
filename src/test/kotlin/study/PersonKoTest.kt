package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "함석호", nickname = "호석이", age = 100)
        actual.name shouldBe "함석호"
        actual.age shouldBe 100
        actual.nickname shouldBe "호석이"
    }

    "널 타입" {
        val actual = Person("함석호", age = 100, null)
        actual.nickname.shouldBeNull()
    }

    "기본 인자" {
        val actual = Person(name = "함석호", age = 100)
        actual.nickname shouldBe actual.name
    }

    "데이터 클래스" {
        val person1 = Person(name = "함석호", age = 100, nickname = "호석이")
        val person2 = Person(name = "함석호", age = 100, nickname = "호석이")

        person1 shouldBe person2
    }
})
