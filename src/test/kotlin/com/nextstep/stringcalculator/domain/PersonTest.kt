package com.nextstep.stringcalculator.domain

import com.nextstep.stringcalculator.domain.Person
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {

    @Test
    internal fun `아아ㅏㅇ벋가ㅣㅓㄴ 아ㅣ러ㅏㅣㅂ ㅈ덕ㄹㄷㅈ바ㅣ거 ㅇ파ㅣ ㅏ ㅏ 압ㄹ받ㅈ갑 ㅏㅂㅈㄷ ㅏ ㅏ ㅂㅈㄷ`() {
        val person = Person("반선호", 28, "shakeVan")

        assertThat(person.name).isEqualTo("반선호")
        person.nickname = "ShakeVan"

        assertThat(person.nickname).isEqualTo("ShakeVan")
    }

    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("반선호", 28, "ShakeVan"),
            Person("반선호", 28, nickname = "ShakeVan"),
            Person(name = "반선호", nickname = "ShakeVan", age = 28)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("반선호")
            assertThat(it.age).isEqualTo(28)
            assertThat(it.nickname).isEqualTo("ShakeVan")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("반선호", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("반선호") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("반선호", 28, "ShakeVan")
        val person2 = Person("반선호", 28, "ShakeVan")
        assertThat(person1).isEqualTo(person2)
    }
}
