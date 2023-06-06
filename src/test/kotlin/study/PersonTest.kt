package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun 이름_붙인_인자() {
        val actual = Person(name = "최진호", age = 30, nickname = "g1063114")
        assertThat(actual.name).isEqualTo("최진호")
        assertThat(actual.nickname).isEqualTo("g1063114")
        assertThat(actual.age).isEqualTo(30)
    }

    @Test
    fun 널_타입() {
        val actual = Person(name = "최진호", age = 30, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun 기본_인자() {
        val actual = Person(name = "최진호", age = 30)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun 데이터_클래스() {
        val person1 = Person("최진호", 30, "g1063114")
        val person2 = Person("최진호", 30, "g1063114")
        assertThat(person1).isEqualTo(person2)
    }
}
