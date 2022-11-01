package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "박재성", age = 20, nickname = "제이슨")
        person.name shouldBe "박재성"
        person.age shouldBe 20
        person.nickname shouldBe "제이슨"
    }

    "널 타입" {
        val person = Person("박재성", 20, null)
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person("박재성", 20)
        person.name shouldBe person.nickname
    }

    "데이터 클래스" {
        val person1 = Person("박재성", 20)
        val person2 = Person("박재성", 20)
        person1 shouldBe person2
    }
})
