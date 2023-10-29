package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `테스트`() {
        val people = listOf(
            Person("김정우", 25, "베어"),
            Person("김정우", 25, nickname = "베어"),
            Person(name = "김정우", nickname = "베어", age = 25)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("김정우")
            assertThat(it.age).isEqualTo(25)
            assertThat(it.nickname).isEqualTo("베어")
        }
    }

    @Test
    fun `널 테스트`() {
        val person = Person("김정우", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("김정우") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 테스트`() {
        val person = Person("김정우")
        assertAll(
            { assertThat(person.name).isEqualTo("김정우") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김정우", 25, "베어")
        val person2 = Person("김정우", 25, "베어")
        assertThat(person1).isEqualTo(person2)
    }
}
