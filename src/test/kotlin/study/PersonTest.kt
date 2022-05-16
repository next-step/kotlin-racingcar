package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("염세란", 32, "세렌"), Person("염세란", 32, nickname = "세렌"), Person(name = "염세란", age = 32, nickname = "세렌")
        )
        assertThat(people[0].name).isEqualTo("염세란")
        assertThat(people[1].name).isEqualTo("염세란")
        assertThat(people[2].name).isEqualTo("염세란")
    }

    @Test
    fun `널 타입`() {
        val person = Person("염세란", 32, nickname = null)
        assertThat(person.name).isEqualTo("염세란")
        assertThat(person.age).isEqualTo(32)
        assertThat(person.nickname).isEqualTo(null)
    }

    @Test
    fun `기본 타입`() {
        val person = Person("염세란", 32)
        assertThat(person.name).isEqualTo("염세란")
        assertThat(person.age).isEqualTo(32)
        assertThat(person.nickname).isEqualTo("염세란")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("염세란", 32)
        val person2 = Person("염세란", 32)
        assertThat(person1).isEqualTo(person2)
    }
}
