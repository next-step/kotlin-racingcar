package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "김다희", age = 99, nickname = "히히")
        assertThat(person.name).isEqualTo("김다희")
        assertThat(person.age).isEqualTo(99)
        assertThat(person.nickname).isEqualTo("히히")
    }

    @Test
    fun `널 타입`() {
        val person = Person("김다희", 99, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("김다희", 99)
        assertThat(person.nickname).isEqualTo("히히")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김다희", 99)
        val person2 = Person("김다희", 99)
        assertThat(person1).isEqualTo(person2)
    }
}
