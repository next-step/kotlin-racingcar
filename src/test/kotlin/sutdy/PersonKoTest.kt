package sutdy

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    val name = "최용석"
    val age = 32
    val nickname = "노엘"

    "이름 붙인 인자" {
        // Given & When
        val person = Person(name = name, age = age, nickname = nickname)

        // Then
        person.name shouldBe name
        person.age shouldBe age
        person.nickname shouldBe nickname
    }

    "널 타입" {
        // Given & When
        val person = Person(name = name, age = age, null)

        // Then
        person.nickname shouldBe null
    }

    "기본 인자를 가지는 프로퍼티 생성자" {
        // Given & When
        val person = Person(name = name, age = age)

        // Then
        person.nickname shouldBe person.name
    }

    "데이터 클래스" {
        // Given & When
        val person1 = Person(name = "최용석", age = 32)
        val person2 = Person(name = "최용석", age = 32)

        // Then
        person1 shouldBe person2
    }
})
