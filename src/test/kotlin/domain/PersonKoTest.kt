package domain


import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "김세윤", age = 30, nickname = "마르코")
        assertSoftly {
            person.name shouldBe "김세윤"
            person.age shouldBe 30
            person.nickname shouldBe "마르코"
        }
    }

    "널 타입" {
        val person = Person("김세윤", 30, null)
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person("김세윤", 30)
        person.name shouldBe person.nickname
    }

    "데이터 클래스" {
        val person1 = Person("김세윤", 30)
        val person2 = Person("김세윤", 30)
        person1 shouldBe person2
    }
})