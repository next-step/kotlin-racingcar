package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun 이름_붙인_인자() {
        val people = listOf(
            Person("윤도현", 31, "엘렌"),
            Person("윤도현", 31, nickname = "엘렌"),
            Person(name = "윤도현", age = 31, nickname = "엘렌")
        )

        assertThat(people[0].name).isEqualTo("윤도현")
        assertThat(people[1].name).isEqualTo("윤도현")
        assertThat(people[2].name).isEqualTo("윤도현")
    }

    @Test
    fun `널 타입`() {
        val person = Person("윤도현", 31, null)
        assertThat(person.name).isEqualTo("윤도현")
        assertThat(person.age).isEqualTo(31)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("윤도현", 31)
        assertThat(person.name).isEqualTo("윤도현")
        assertThat(person.age).isEqualTo(31)
        assertThat(person.nickname).isEqualTo("윤도현")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("윤도현", 31)
        val person2 = Person("윤도현", 31)
        assertThat(person1).isEqualTo(person2)
    }
}