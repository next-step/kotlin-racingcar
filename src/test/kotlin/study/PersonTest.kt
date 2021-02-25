package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(
            name = "오상우",
            age = 20,
            nickname = "sangw0804"
        )

        assertThat(person.name).isEqualTo("오상우")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("sangw0804")
    }

    @Test
    fun `널 타입`() {
        val person = Person("오상우", 20, null)

        assertAll(
            { assertThat(person.nickname).isNull() },
            { assertThat(person.age).isEqualTo(20) }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person("오상우", 20)

        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("오상우", 20)
        val person2 = Person("오상우", 20)

        assertThat(person1).isEqualTo(person2)
    }
}
