package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("김소영", 40, "쿠쿠"),
            Person("김소영", 40, nickname = "쿠쿠"),
            Person(name = "김소영", age = 40, nickname = "쿠쿠")
        )
        assertThat(people[0].name).isEqualTo("김소영")
        assertThat(people[1].name).isEqualTo("김소영")
        assertThat(people[2].name).isEqualTo("김소영")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김소영", 40, null)
        assertThat(person.name).isEqualTo("김소영")
        assertThat(person.age).isEqualTo(40)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김소영", 40)
        assertThat(person.name).isEqualTo("김소영")
        assertThat(person.age).isEqualTo(40)
        assertThat(person.nickname).isEqualTo("김소영")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김소영", 40)
        val person2 = Person("김소영", 40)
        assertThat(person1).isEqualTo(person2)
    }
}
