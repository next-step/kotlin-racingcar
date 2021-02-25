package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "송태헌", age = 20, nickname = "쏭")
        assertThat(person.name).isEqualTo("송태헌")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("쏭")
    }

    @Test
    fun `NULL 타입`() {
        val person = Person(name = "송태헌", age = 20, nickname = null)
        assertAll(
            { assertThat(person.name).isEqualTo("송태헌") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "송태헌", age = 20)
        assertAll(
            { assertThat(person.name).isEqualTo("송태헌") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isEqualTo("송태헌") }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "송태헌", age = 20)
        val person2 = Person(name = "송태헌", age = 20)

        assertThat(person1).isEqualTo(person2)
    }
}
