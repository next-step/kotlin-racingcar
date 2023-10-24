package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "Seongmo", age = 20, nickname = "nickname")
        assertThat(person.name).isEqualTo("Seongmo")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("nickname")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "Seongmo")
        assertThat(person.name).isEqualTo("Seongmo")
        assertThat(person.age).isNull()
        assertThat(person.nickname).isEqualTo("Seongmo")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("hi", 20)
        val person2 = Person("hi", 20)
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun copy() {
        val person = Person("hi", 20)
        val copied = person.copy(age = 25, nickname = "test")
        assertThat(copied.name).isEqualTo("hi")
        assertThat(copied.age).isEqualTo(25)
        assertThat(copied.nickname).isEqualTo("test")
    }
}
