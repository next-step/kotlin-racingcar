package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "dk-ko", age = 22, nickname = "dk")
        assertThat(person.name).isEqualTo("dk-ko")
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "dk-ko", age = 22)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("dk-ko", 0)
        assertAll(
            { assertThat(person.name).isEqualTo("dk-ko") },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("dk-ko", 0)
        val person2 = Person("dk-ko", 0)
        assertThat(person1).isEqualTo(person2)
    }
}
