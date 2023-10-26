package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "최윤녕", age = 29, nickname = "부농이")
        assertThat(actual.name).isEqualTo("최윤녕")
        assertThat(actual.age).isEqualTo(29)
        assertThat(actual.nickname).isEqualTo("부농이")
    }

    @Test
    fun `널 타입`() {
        val actual = Person("최윤녕", 20, null)
        assertThat(actual.name).isEqualTo("최윤녕")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person("최윤녕", 20)
        assertThat(actual.name).isEqualTo("최윤녕")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("최윤녕")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("최윤녕", 20)
        val person2 = Person("최윤녕", 20)
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `copy`() {
        val person = Person("최윤녕", 20)
        val copyPerson = person.copy(nickname = "최윤녕")
        assertThat(copyPerson.age).isEqualTo(20)
    }
}
