package study

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class PersonKoTest : AnnotationSpec() {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("나윤지", 29, "yj"),
            Person("나윤지", 29, nickname = "yj"),
            Person(name = "나윤지", age = 29, "yj"),
        )
        people[0].name shouldBe "나윤지"
        people[1].name shouldBe "나윤지"
        people[2].name shouldBe "나윤지"
    }

    @Test
    fun `널 타입`() {
        val person = Person("나윤지", 29, null)
        person.name shouldBe "나윤지"
        person.age shouldBe 29
        person.nickname shouldBe null
    }

    @Test
    fun `기본 인자`() {
        val person = Person("나윤지", 29, null)
        person.name shouldBe "나윤지"
        person.age shouldBe 29
        person.nickname shouldBe null
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("나윤지", 29)
        val person2 = Person("나윤지", 29)
        person1 shouldBe person2
    }
}
