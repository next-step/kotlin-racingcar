package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person("홍길동", 20, "길똥")
        assertThat(person.name).isEqualTo("홍길동")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("길똥")
    }

    @Test
    fun `기본 인자`() {
        val person = Person("홍길동", 20)
        assertThat(person.name).isEqualTo("홍길동")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("홍길동")
    }

    @Test
    fun `copy`() {
        val person = Person("홍길동", 20)
        assertThat(person.name).isEqualTo("홍길동")
        assertThat(person.age).isEqualTo(20)
        assertThat(person.nickname).isEqualTo("홍길동")

        val copy = person.copy(name = "홍길동2")
        assertThat(copy.name).isEqualTo("홍길동2")
        assertThat(copy.age).isEqualTo(20)
        assertThat(copy.nickname).isEqualTo("홍길동")
    }
}
