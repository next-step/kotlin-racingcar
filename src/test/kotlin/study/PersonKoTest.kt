package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.equality.shouldBeEqualToComparingFields
import io.kotest.matchers.equality.shouldNotBeEqualToComparingFields
import io.kotest.matchers.shouldBe

class PersonKoTest : AnnotationSpec() {
    @Test
    fun `객체 초기화시 생성자에 필드명을 일부만 명시할 경우에도 초기화가 되야한다`() {
        val people = listOf(
            Person("한인규", 32, "hayden"),
            Person("한인규", 32, nickname = "hayden"),
            Person(name = "한인규", age = 32, "hayden"),
        )
        people[0].name shouldBe "한인규"
        people[1].name shouldBe "한인규"
        people[2].name shouldBe "한인규"
    }

    @Test
    fun `객체 초기화시 생성자에 필드명을 전부 명시하지않을경우에도 초기화가 되야한다`() {
        val person = Person("한인규", 32, null)
        person.name shouldBe "한인규"
        person.age shouldBe 32
        person.nickname shouldBe null
    }

    @Test
    fun `객체 초기화시 기본값이 지정된 변수를 생성자에서 생략하면 기본값으로 초기화가 되야한다`() {
        val person = Person("한인규", 32)
        person.name shouldBe "한인규"
        person.age shouldBe 32
        person.nickname shouldBe null
    }

    @Test
    fun `데이터 클래스를 동일한 값으로 초기화시 equal로 비교시 동일해야한다`() {
        val person1 = Person("한인규", 32)
        val person2 = Person("한인규", 32)
        person1 shouldBeEqualToComparingFields person2
    }

    @Test
    fun `데이터 클래스를 동일하지않은 값으로 초기화시 equal로 비교하면 달라야한다`() {
        val person1 = Person("한인규", 32, "iamgroot")
        val person2 = Person("한인규", 32, "iamhayden")
        person1 shouldNotBeEqualToComparingFields  person2
    }
}