package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "이기원", age = 20, nickname = "꽃미남")
        assertThat(person.name).isEqualTo("이기원")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("꽃미남")

        val person2 = Person(nickname = "꽃미남", name = "이기원", age = 20)
        assertThat(person2.name).isEqualTo("이기원")
        assertThat(person2.age).isEqualTo(20)
        assertThat(person2.nickname).isEqualTo("꽃미남")
    }

    @Test
    fun `널 타입`() {
        val person = Person("이기원", 20, null)
        assertAll(
            { assertThat(person.name).isEqualTo("이기원") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `기본 인자`() {
        val person = Person("이기원", 20)
        assertAll(
            { assertThat(person.name).isEqualTo("이기원") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isEqualTo("이기원") }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("이기원", 20, "꽃미남")
        val person2 = Person("이기원", 20, "꽃미남")
        assertThat(person1).isEqualTo(person2)
    }
}
