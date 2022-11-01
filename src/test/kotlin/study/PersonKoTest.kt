package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "이우찬", age = 20, nickname = "테오")
        person.name shouldBe "이우찬"
        person.age shouldBe 20
        person.nickname shouldBe "테오"
    }

    "널 타입" {
        val person = Person("이우찬", 20, null)
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person("이우찬", 20)
        person.name shouldBe "이우찬"
    }

    "데이터 클래스" {
        val person1 = Person("이우찬", 20)
        val person2 = Person("이우찬", 20)
        person1 shouldBe person2
    }
})
