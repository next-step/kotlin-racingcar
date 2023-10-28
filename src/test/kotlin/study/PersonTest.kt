package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `테스트 인자`() {
        val actual = Person(name = "장진혁", age = 38, nickname = "ironelder")
        assertThat(actual.name).isEqualTo("장진혁")
        assertThat(actual.age).isEqualTo(38)
        assertThat(actual.nickname).isEqualTo("ironelder")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "장진혁", age = 38, nickname = null)
        assertThat(actual.name).isEqualTo("장진혁")
        assertThat(actual.age).isEqualTo(38)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "장진혁", age = 38)
        assertThat(actual.name).isEqualTo("장진혁")
        assertThat(actual.age).isEqualTo(38)
        assertThat(actual.nickname).isEqualTo("장진혁")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "장진혁", age = 38)
        val person2 = Person(name = "장진혁", age = 38)
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `copy`() {
        val person = Person(name = "장진혁", age = 38)
        val actual = person.copy(nickname = "ironelder")
        assertThat(actual.name).isEqualTo("장진혁")
        assertThat(actual.age).isEqualTo(38)
        assertThat(actual.nickname).isEqualTo("ironelder")
    }

}