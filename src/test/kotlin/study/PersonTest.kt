package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {

    @Test
    fun `이름 붙인 인자, 기본 테스트`() {
        val people = listOf(
            Person("성재우", 20, "dev-owner"),
            Person("성재우", 20, nickname = "dev-owner"),
            Person(name = "성재우", age = 20, nickname = "dev-owner")
        )

        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("성재우")
            assertThat(it.age).isEqualTo(20)
            assertThat(it.nickname).isEqualTo("dev-owner")
        }
    }

    @Test
    fun `nullable 테스트`() {
        val person = Person(name = "성재우", age = 20, nickname = null)
        assertAll(
            { assertThat(person.name).isEqualTo("성재우") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 인자 테스트`() {
        val person = Person("성재우")
        assertAll(
            { assertThat(person.name).isEqualTo("성재우") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )

        val person2 = Person("성재우", 20)
        assertAll(
            { assertThat(person2.name).isEqualTo("성재우") },
            { assertThat(person2.age).isEqualTo(20) },
            { assertThat(person2.nickname).isNull() }
        )
    }

    @Test
    fun `data 클래스 테스트`() {
        val person1 = Person("성재우", 20, "hi")
        val person2 = Person("성재우", 20, "hi")
        assertThat(person1).isEqualTo(person2)
    }
}
