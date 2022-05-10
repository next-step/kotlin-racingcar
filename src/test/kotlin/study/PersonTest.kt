package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("홍보미", 30, "chloe"),
            Person("홍보미", 30, nickname = "chloe"),
            Person(
                name = "홍보미",
                age = 30,
                nickname = "chloe"
            )
        )

        assertThat(people[0].name).isEqualTo("홍보미")
        assertThat(people[1].name).isEqualTo("홍보미")
        assertThat(people[2].name).isEqualTo("홍보미")
    }

    @Test
    fun `null type`() {
        val person = Person("홍보미", 30, null)
        assertThat(person.name).isEqualTo("홍보미")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `default type`() {
        val person = Person("홍보미", 30)
        assertThat(person.name).isEqualTo("홍보미")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("홍보미")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("홍보미", 30)
        val person2 = Person("홍보미", 30)
        assertThat(person1).isEqualTo(person2)
    }
}
