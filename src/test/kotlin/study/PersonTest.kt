package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        // when
        val person = Person(name = "Seunghee", age = 100, nickname = "palmseung")

        // then
        assertThat(person.nickname).isEqualTo("palmseung")
        assertThat(person.age).isEqualTo(100)
        assertThat(person.name).isEqualTo("Seunghee")
    }

    @Test
    fun `널 타입`() {
        // when
        val person = Person(name = "Seunghee", age = 99, nickname = null)

        // then
        assertThat(person.nickname).isNull()
        assertThat(person.name).isEqualTo("Seunghee")
        assertThat(person.age).isEqualTo(99)
    }

    @Test
    fun `기본값 지정`() {
        // when
        val person = Person("Seunghee", 100)

        // then
        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        // when
        val p1 = Person("Seunghee", 100)
        val p2 = Person("Seunghee", 100)

        // then
        assertThat(p1).isEqualTo(p2)
    }
}
