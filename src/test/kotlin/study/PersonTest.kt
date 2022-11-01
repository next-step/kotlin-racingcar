package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "길상현", age = 26, nickname = "로드")
        assertThat(person.name).isEqualTo("길상현")
        assertThat(person.age).isEqualTo(26)
        assertThat(person.nickname).isEqualTo("로드")
    }

    @Test
    fun `널 타입`() {
        val person = Person("박재성", 26, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("길상현", 26)
        assertThat(person.name).isEqualTo("길상현")
        assertThat(person.age).isEqualTo(26)
        assertThat(person.nickname).isEqualTo("길상현")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("길상현", 26)
        val person2 = Person("길상현", 26)
        assertThat(person1).isEqualTo(person2)
    }
}
