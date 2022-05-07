package study

import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class PersonKoTestStringSpec : StringSpec({
    "이름 붙인 인자" {
        val people = listOf(
            Person("나윤지", 29, "yj"),
            Person("나윤지", 29, nickname = "yj"),
            Person(name = "나윤지", age = 29, nickname = "yj")
        )
        people.forAll {
            it.name shouldBe "나윤지"
            it.age shouldBe 29
            it.nickname shouldBe "yj"
        }
    }

    "널 타입" {
        val person = Person("나윤지", 29, null)
        person.name shouldBe "나윤지"
        person.age shouldBe 29
        person.nickname shouldBe null
    }

    "기본 인자" {
        val person = Person("나윤지", 29)
        person.name shouldBe "나윤지"
        person.age shouldBe 29
        person.nickname shouldBe "나윤지"
    }

    "데이터 클래스" {
        val person1 = Person("나윤지", 29)
        val person2 = Person("나윤지", 29)
        person1 shouldBe person2
    }
})
