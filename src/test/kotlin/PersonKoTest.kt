import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : StringSpec({
    "이름 붙인 인자" {
        val actual = Person(name = "김다보미", nickname = "마모미", age = 30)
        actual.name shouldBe "김다보미"
        actual.age shouldBe 30
        actual.nickname shouldBe "마모미"
    }

    "널 타입" {
        val actual = Person(name = "김다보미", age = 30, nickname = null)
        actual.nickname shouldBe null
    }

    "기본 인자" {
        val actual = Person(name = "김다보미", age = 30)
        actual.nickname shouldBe "김다보미"
    }

    "데이터 클래스" {
        val person1 = Person(name = "김다보미", age = 30)
        val person2 = Person(name = "김다보미", age = 30)
        person1 shouldBe person2
    }
})
