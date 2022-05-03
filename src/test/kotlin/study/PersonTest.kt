package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        var people = listOf(
            Person("김동우", 29, "몰리"), Person("김동우", 29, nickname = "몰리"), Person(name = "김동우", age = 29, nickname = "몰리")
        )

        // 리스트에 있는 것들이 전부 만족해야 함.
        assertThat(people[0].name).isEqualTo("김동우")
        assertThat(people[1].name).isEqualTo("김동우")
        assertThat(people[2].name).isEqualTo("김동우")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "김동우", age = 29)
        assertThat(person.name).isEqualTo("김동우")
        assertThat(person.age).isEqualTo(29)
        // assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김동우", 29)
        assertThat(person.name).isEqualTo("김동우")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("김동우")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김동우", 29)
        val person2 = Person("김동우", 29)

        assertThat(person1).isEqualTo(person2)
    }
}
