import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe

internal class PersonTest : StringSpec({

    "이름 붙인 인자 테스트" {
        val people = listOf(
            Person("박재성", 29, "제이슨"),
            Person("박재성", 29, nickname = "제이슨"),
            Person(name = "박재성", nickname = "제이슨", age = 29)
        )

        people.forAll {
            it.name shouldBe "박재성"
            it.age shouldBe 29
            it.nickname shouldBe "제이슨"
        }
    }

    "널 타입 테스트" {
        val person = Person("박재성", null, null)

        person.name shouldBe "박재성"
        person.age.shouldBeNull()
        person.nickname.shouldBeNull()
    }

    "기본 인자 테스트" {
        val person = Person("박재성")

        person.name shouldBe "박재성"
        person.age.shouldBeNull()
        person.nickname.shouldBeNull()
    }

    "데이터 클래스 테스트" {
        val person1 = Person("박재성", 29, "제이슨")
        val person2 = Person("박재성", 29, "제이슨")

        person1 shouldBe person2
    }
})
