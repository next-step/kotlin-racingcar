package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "정미수", nickname = "misudev", age = 29)

        assertThat(person.name).isEqualTo("정미수")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("misudev")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "정미수", nickname = null, age = null)

        assertThat(person.nickname).isNull()
        assertThat(person.age).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "정미수", age = 29)

        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "정미수", age = 29)
        val person2 = Person(name = "정미수", age = 29)

        assertThat(person1).isEqualTo(person2)
    }
}
