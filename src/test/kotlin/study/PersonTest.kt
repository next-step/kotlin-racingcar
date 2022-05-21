package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 있는 인자`() {
        val people = listOf(
            Person("김진우", 37, "제이슨"),
            Person("김진우", 37, nickname = "제이슨"),
            Person(name = "김진우", age = 37, nickname = "제이슨")
        )

        assertThat(people[0].name).isEqualTo("김진우")
        assertThat(people[1].name).isEqualTo("김진우")
        assertThat(people[2].name).isEqualTo("김진우")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김진우", 37, null)
        assertThat(person.name).isEqualTo("김진우")
        assertThat(person.age).isEqualTo(37)
        assertThat(person.nickname).isNull()
    }

    @Test
    internal fun `기본 인자`() {
        val person = Person("김진우", 37)
        assertThat(person.name).isEqualTo("김진우")
        assertThat(person.age).isEqualTo(37)
        assertThat(person.nickname).isEqualTo("김진우")
    }

    @Test
    internal fun `데이터 클래스`() {
        val person1 = Person("김진우", 37)
        val person2 = Person("김진우", 37)
        assertThat(person1).isEqualTo(person2)
    }
}
