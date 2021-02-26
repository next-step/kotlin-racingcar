package kotlinbasic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {

    @Test
    @DisplayName("코틀린은 positional arguments와 named arguments 모두 사용 가능하다")
    fun namedArguments() {
        val people = listOf(
            Person("황준오", 20, "박토리아"),
            Person("황준오", 20, nickname = "박토리아"),
            Person(name = "황준오", nickname = "박토리아", age = 20)
        )

        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("황준오")
            assertThat(it.age).isEqualTo(20)
            assertThat(it.nickname).isEqualTo("박토리아")
        }
    }

    @Test
    fun `널 타입`() {
        val person = Person("황준오", 20, null)

        assertAll(
            { assertThat(person.name).isEqualTo("황준오") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person("황준오", 20)
        assertAll(
            { assertThat(person.name).isEqualTo("황준오") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isEqualTo("황준오") }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("황준오", 20, "박토리아")
        val person2 = Person("황준오", 20, "박토리아")
        assertThat(person1).isEqualTo(person2)
    }
}
