package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "이성훈", age = 30, nickname = "Harris")
        person.name shouldBe "이성훈"
        person.age shouldBe 30
        person.nickname shouldBe "Harris"
    }
    "널 타입" {
        val person = Person("이성훈", 30, null)
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person("이성훈", 30)
        person.name shouldBe person.nickname
    }

    "데이터 클래스" {
        val person1 = Person("이성훈", 30)
        val person2 = Person("이성훈", 30)
        person1 shouldBe person2
    }
})
