package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        Person("박재성", 20, "제이슨")
        val actual = Person(name = "박재성", age = 20, nickname = "제이슨")
        assertThat(actual.name).isEqualTo("박재성")
        assertThat(actual.age).isEqualTo(20)
        assertThat(actual.nickname).isEqualTo("제이슨")
    }

    @Test
    fun `널 타입`() {
        val actual = Person("홍길동", 20, null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "홍길동", age = 20)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("홍길동", 20, "Hong")
        val person2 = Person("홍길동", 20, "Hong")
        assertThat(person1).isEqualTo(person2)
    }
}
