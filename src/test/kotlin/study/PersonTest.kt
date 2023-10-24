package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    @Test
    @DisplayName("이름 붙인 인자")
    fun namedArgumentsTest() {
        // given.
        val name = "김희동"
        val age = 25
        val nickname = "wilump"

        // when.
        val actual = Person(name = name, age = age, nickname = nickname)

        // then.
        assertThat(actual.name).isEqualTo(name)
        assertThat(actual.age).isEqualTo(age)
        assertThat(actual.nickname).isEqualTo(nickname)
    }

    @Test
    @DisplayName("널 타입")
    fun nullableTypeTest() {
        // given.
        val name = "김희동"

        // when.
        val actual = Person(name = name, age = null, nickname = null)

        // then.
        assertAll(
            { assertThat(actual.name).isEqualTo(name) },
            { assertThat(actual.age).isNull() },
            { assertThat(actual.nickname).isNull() }
        )
    }

    @Test
    @DisplayName("기본 인자")
    fun defaultArgumentsTest() {
        // given.
        val name = "김희동"

        // when.
        val actual = Person(name)

        // then.
        assertAll(
            { assertThat(actual.name).isEqualTo(name) },
            { assertThat(actual.age).isNull() },
            { assertThat(actual.nickname).isEqualTo(name) }
        )
    }

    @Test
    @DisplayName("데이터 클래스")
    fun dataClassTest() {
        // given.
        val name = "김희동"
        val age = 25
        val nickname = "wilump"
        val person = Person(name = name, age = age, nickname = nickname)

        // when.
        val actual = person.copy()

        // then.
        assertThat(actual).isEqualTo(person)
    }

    @Test
    @DisplayName("copy 메서드")
    fun copyTest() {
        // given.
        val name = "김희동"
        val age = 25
        val nickname = "wilump"
        val person = Person(name = name, age = age, nickname = nickname)

        // when.
        val actual = person.copy(nickname = "wilump2")

        // then.
        assertAll(
            { assertThat(actual.name).isEqualTo(name) },
            { assertThat(actual.age).isEqualTo(age) },
            { assertThat(actual.nickname).isEqualTo("wilump2") }
        )
    }
}
