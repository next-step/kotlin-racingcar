import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe
import study.Person

class PersonKoTest : StringSpec({

    "이름 붙인 인자" {
        var people = listOf(
            Person("정지선", 35, "케이라"), Person("정지선", 35, nickname = "케이라"), Person(name = "정지선", age = 35, nickname = "케이라")
        )

        people.forAll {
            it.name shouldBe "정지선"
            it.age shouldBe 35
            it.nickname shouldBe "케이라"
        }
    }

    "널 타입" {
        val person = Person(name = "정지선", age = 35, nickname = null)

        person.name shouldBe "정지선"
        person.age shouldBe 35
        person.nickname shouldBe null
    }

    "기본 인자" {
        val person = Person("정지선", 35)

        person.name shouldBe "정지선"
        person.age shouldBe 35
        person.nickname shouldBe "정지선"
    }

    "데이터 클래스" {
        val person1 = Person("정지선", 35)
        val person2 = Person("정지선", 35)

        person1 shouldBe person2
    }
})
