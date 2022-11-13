import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val person = Person(name = "이정환", age = 31, nickname = "열정환")
        person.name shouldBe "이정환"
        person.age shouldBe 31
        person.nickname shouldBe "열정환"
    }

    "널 타입" {
        val person = Person(name = "이정환", age = 31, null)
        person.nickname.shouldBeNull()
    }

    "기본 인자" {
        val person = Person(name = "이정환", age = 31)
        person.name shouldBe person.nickname
    }

    "데이터 클래스" {
        val person1 = Person("이정환", 31)
        val person2 = Person("이정환", 31)
        person1 shouldBe person2
    }
})
