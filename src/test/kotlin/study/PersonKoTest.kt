package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({

    "이름 붙인 인자" {
        val person = Person(name = "김민경", age = 70, nickname = "Margot")
        person.name shouldBe "김민경"
        person.age shouldBe 70
        person.nickname shouldBe "Margot"
    }

    "널 타입" {
        val person = Person(name = "김민경", age = 70, nickname = null)
        person.nickname shouldBe null
    }

    "기본 인자" {
        val person = Person(name = "김민경", age = 70)
        person.name shouldBe person.nickname
    }

    "데이터 클래스" {
        val person1 = Person(name = "김민경", age = 70)
        val person2 = Person(name = "김민경", age = 70)
        person1 shouldBe person2
    }
})
