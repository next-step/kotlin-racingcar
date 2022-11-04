package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec() {
    init {
        "이름 붙인 인자" {
            val person = Person(nickname = "윤", age = 20, name = "김윤수")

            person.name shouldBe "김윤수"
            person.age shouldBe 20
            person.nickname shouldBe "윤"
        }

        "널 타입" {
            val person = Person("김윤수", 20, null)

            person.nickname shouldBe null
        }

        "기본 인자" {
            val person = Person("김윤수", 20)

            person.nickname shouldBe person.nickname
        }

        "데이터 클래스" {
            val person1 = Person("김윤수", 20, "윤")
            val person2 = Person("김윤수", 20, "윤")

            person1 shouldBe person2
        }
    }
}
