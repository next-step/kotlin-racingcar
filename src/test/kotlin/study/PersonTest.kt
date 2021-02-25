package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person1 = Person(name = "박재성", age = 20, nickname = "제이슨")
        assertThat(person1.name).isEqualTo("박재성")
        assertThat(person1.age).isEqualTo(20)
        assertThat(person1.nickname).isEqualTo("제이슨")

        val person2 = Person(nickname = "제이슨", name = "박재성", age = 20)
        assertThat(person2.name).isEqualTo("박재성")
        assertThat(person2.age).isEqualTo(20)
        assertThat(person2.nickname).isEqualTo("제이슨")
    }

    @Test
    fun `널 타입`() {
        val person = Person("박재성", 20, null)
        assertAll(
            { assertThat(person.name).isEqualTo("박재성") },
            { assertThat(person.age).isEqualTo(20) },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "박재성", age = 20, nickname = "제이슨")
        val person2 = Person(name = "박재성", age = 20, nickname = "제이슨")

        assertThat(person1).isEqualTo(person2)
    }
}
