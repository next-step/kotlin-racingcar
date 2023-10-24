package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "김강호", age = 20, nickname = "khkim")
        assertThat(actual.name).isEqualTo("김강호")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("khkim")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "김강호", age = 20, nickname = null)
        assertThat(actual.name).isEqualTo("김강호")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "김강호", age = 20)
        assertThat(actual.name).isEqualTo("김강호")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("김강호")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "김강호", age = 20)
        val person2 = Person(name = "김강호", age = 20)
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `copy`() {
        val person = Person(name = "김강호", age = 20)
        assertThat(person.nickname).isEqualTo("김강호")

        val actual = person.copy(nickname = "kkkk")

        assertThat(actual.name).isEqualTo("김강호")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("kkkk")
    }
}
