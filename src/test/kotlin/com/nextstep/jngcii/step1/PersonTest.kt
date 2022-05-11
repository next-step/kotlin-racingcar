package com.nextstep.jngcii.step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `nullable types`() {
        val person = Person("정형수", 31, null)

        assertThat(person.name).isEqualTo("정형수")
        assertThat(person.age).isEqualTo(31)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `default arguments`() {
        val person = Person("정형수")
        assertThat(person.name).isEqualTo("정형수")
        assertThat(person.age).isEqualTo(31)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `data classes`() {
        val person1 = Person("정형수", 31)
        val person2 = Person("정형수", 31)
        assertThat(person1).isEqualTo(person2)
    }

}
