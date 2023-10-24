package study

import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "정명구", age = 30, nickname = "dding94")

        assertThat(actual.name).isEqualTo("정명구")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.nickname).isEqualTo("dding94")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "정명구", age = 30, nickname = null)

        assertThat(actual.name).isEqualTo("정명구")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "정명구", age = 30)

        assertThat(actual.name).isEqualTo("정명구")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.nickname).isEqualTo("정명구")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "정명구", age = 30)
        val person2 = Person(name = "정명구", age = 30)

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun copy() {
        val person = Person(name = "정명구", age = 30)
        assertThat(person.nickname).isEqualTo("정명구")

        val actual = person.copy(nickname = "정")
        assertThat(actual.name).isEqualTo("정명구")
        assertThat(actual.age).isEqualTo(30)
        assertThat(actual.nickname).isEqualTo("정")
    }
}
