package learning

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person("홍길동", 20, "Hong")
        actual.name shouldBe "홍길동"
        actual.nickname shouldBe "Hong"
        actual.age shouldBe 20
    }

    "널 타입" {
        val actual = Person("홍길동", 20, null)
        actual.nickname shouldBe null
    }

    "기본 인자" {
        val actual = Person("홍길동", 20)
        actual.nickname shouldBe "Guest"
    }

    "데이터 클래스" {
        val person1 = Person("홍길동", 20, "Hong")
        val person2 = Person("홍길동", 20, "Hong")
        person1 shouldBe person2
    }
})
