package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKotest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "권재용", age = 29, nickname = "jaeykweon")

        person.name shouldBe "권재용"
        person.age shouldBe 29
        person.nickname shouldBe "jaeykweon"
    }

    "널 타입" {
        val person = Person(name = "권재용", age = 29, nickname = null)

        person.nickname shouldBe null
    }

    "기본 인자" {
        val person = Person(name = "권재용", age = 29)

        person.name shouldBe person.nickname
    }

    "데이터 클래스" {
        val person1 = Person(name = "권재용", age = 29)
        val person2 = Person(name = "권재용", age = 29)

        person1 shouldBe person2
    }

    "테스트" {
        val test = "테 스   트"
        println(test.split(" "))
        val test2 = ""
        println(test2.split(" "))
    }
})
