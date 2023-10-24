package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "조경현", 33, nickname = "kycho")
        assertThat(actual.name).isEqualTo("조경현")
        assertThat(actual.age).isEqualTo(33)
        assertThat(actual.nickname).isEqualTo("kycho")
    }

    @Test
    fun `널 타입`() {
        val actual = Person("조경현", 33, null)
        assertThat(actual.name).isEqualTo("조경현")
        assertThat(actual.age).isEqualTo(33)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person("조경현", 33)
        assertThat(actual.name).isEqualTo("조경현")
        assertThat(actual.age).isEqualTo(33)
        assertThat(actual.nickname).isEqualTo("조경현")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("조경현", 33)
        val person2 = Person("조경현", 33)
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `copy`() {
        val person = Person("조경현", 33)
        val actual = person.copy(nickname = "kycho")

        assertThat(actual.name).isEqualTo("조경현")
        assertThat(actual.age).isEqualTo(33)
        assertThat(actual.nickname).isEqualTo("kycho")
    }
}
