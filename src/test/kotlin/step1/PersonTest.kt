package step1

import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `nullable types`() {
        val person = Person("장민봉", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("장민봉") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `default arguments`() {
        val person = Person("장민봉")
        assertAll(
            { assertThat(person.name).isEqualTo("장민봉") },
            { assertThat(person.age).isEqualTo(10) },
            { assertThat(person.nickname).isEqualTo("hiro") }
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("장민봉", 20, "hiro")
        val person2 = Person("장민봉", 20, "hiro")
        assertThat(person1).isEqualTo(person2)
    }

}

