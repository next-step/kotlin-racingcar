package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeSameInstanceAs

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "홍길동", age = 20, nickname = "Hong")
        actual.name shouldBe "홍길동"
        actual.nickname shouldBe "Hong"
        actual.age shouldBe 20
    }

    "널 타입" {
        val actual = Person(name = "홍길동", age = 20, nickname = null)
        actual.nickname shouldBe null
    }

    "기본 인자" {
        val actual = Person(name = "홍길동", age = 20)
        actual.nickname shouldBe "Guest"
    }

    "데이터 클래스" {
        val person1 = Person(name = "홍길동", age = 20, nickname = "Hong")
        val person2 = Person(name = "홍길동", age = 20, nickname = "Hong")
        person1 shouldBe person2

    }
})