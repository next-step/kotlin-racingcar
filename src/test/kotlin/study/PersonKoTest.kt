package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "서준수", age = 22, nickname = "제임스")
        person.name shouldBe "서준수"
        person.age shouldBe 22
        person.nickname shouldBe "제임스"
    }

    "널 타입" {
        val person = Person("서준수", 22, null)
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person("서준수", 22)
        person.name shouldBe person.nickname
    }

    "데이터 클래스" {
        val person1 = Person("서준수", 22)
        val person2 = Person("서준수", 22)
        person1 shouldBe person2
    }
})
