package study

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class PersonTest {
    @Test
    fun `이름_붙인_인자`() {
        val actual = Person(name = "송시은", age = 24, nickname = "sieun")
        assertThat(actual.name).isEqualTo("송시은")
        assertThat(actual.nickname).isEqualTo("sieun")
        assertThat(actual.age).isEqualTo(24)
    }

    @Test
    fun `널_타입`() {
        val actual = Person(name = "송시은", age = 24, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본_인자`() {
        val actual = Person(name = "송시은", age = 24)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터_클래스`() {
        val person1 = Person(name = "송시은", age = 24, "sieun")
        val person2 = Person(name = "송시은", age = 24, "sieun")
        assertThat(person1).isEqualTo(person2)
    }
}