package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe

class PersonKoTest: StringSpec({
    val name = "sangwon"
    val age = 35
    val nickname = "hy43"
    val defaultNickName = "guest"

    "이름 붙인 인자" {
        val person = Person(name, age, nickname)
        person should {
            person.name shouldBe name
            person.age shouldBe age
            person.nickname shouldBe nickname
        }
    }

    "널 타입" {
        val person = Person(name, age, null)
        person should {
            person.name shouldBe name
            person.age shouldBe age
            person.nickname shouldBe null
        }
    }

    "기본 타입" {
        val person = Person(name, age, defaultNickName)
        person should {
            person.name shouldBe name
            person.age shouldBe age
            person.nickname shouldBe defaultNickName
        }
    }

    "데이터 클래스" {
        val person1 = Person(name, age, nickname)
        val person2 = Person(name, age, nickname)
        person1 shouldBe person2
    }
})
