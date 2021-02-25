package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {

    companion object {
        private const val NAME = "김상구"
        private const val NICKNAME = "sgkim94"
        private const val AGE = 20
    }

    @Test
    internal fun `이름 붙인 인자`() {
        val person = Person(name = Companion.NAME, age = AGE, nickname = NICKNAME)

        assertThat(person.name).isEqualTo(Companion.NAME)
        assertThat(person.age).isEqualTo(AGE)
        assertThat(person.nickname).isEqualTo(NICKNAME)

        val person1 = Person(nickname = NICKNAME, name = Companion.NAME, age = AGE)

        assertThat(person1.name).isEqualTo(Companion.NAME)
        assertThat(person1.age).isEqualTo(AGE)
        assertThat(person1.nickname).isEqualTo(NICKNAME)
    }

    @Test
    fun `널 타입`() {
        val person = Person(Companion.NAME, 20, null)

        assertAll(
            { assertThat(person.name).isEqualTo(Companion.NAME) },
            { assertThat(person.age).isEqualTo(AGE) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person(Companion.NAME, 20)

        assertAll(
            { assertThat(person.name).isEqualTo(Companion.NAME) },
            { assertThat(person.age).isEqualTo(AGE) },
            { assertThat(person.nickname).isEqualTo(Companion.NAME) }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(Companion.NAME, 20, "sgkim94")
        val person2 = Person(Companion.NAME, 20, "sgkim94")

        assertThat(person1).isEqualTo(person2)
    }
}
