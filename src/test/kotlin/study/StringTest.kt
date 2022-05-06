package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringTest : StringSpec({
    "isEmpty 함수를 테스트한다" {
        val sut = "".isEmpty()

        sut shouldBe true
    }

    "널 타입" {
        val person = Person("김경록", 20, null)

        person.name shouldBe "김경록"
        person.nickname shouldBe null
    }

    "기본 인자" {
        val person = Person("김경록", 20)

        person.name shouldBe "김경록"
        person.nickname shouldBe "김경록"
    }
})
