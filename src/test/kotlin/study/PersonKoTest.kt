package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "김모토", 20, nickname = "개발자")
        actual.name shouldBe "김모토"
        actual.age shouldBe 20
        actual.nickname shouldBe "개발자"
    }

    "널 타입" {
        val actual = Person("정도전", 27, null)
        actual.nickname shouldBe null
    }

    "기본인자" {
        val actual = Person("이성계", 27)
        actual.nickname shouldBe actual.name
    }

    "데이터 클래스 동등성" {
        val actual1 = Person("정몽주", 27)
        val actual2 = Person("정몽주", 27)
        actual1 shouldBe actual2
    }

    "데이터 클래스 copy" {
        val origin = Person("이방원", 99)
        val copy = origin.copy(nickname = "태조")
        copy.name shouldBe origin.name
        copy.nickname shouldBe "태조"
    }
})
