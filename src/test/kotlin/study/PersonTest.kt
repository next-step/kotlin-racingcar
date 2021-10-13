package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person1 = Person(name = "박재성", age = 20, nickname = "제이슨")
        val person2 = Person(age = 20, nickname = "제이슨", name = "박재성")
        assertThat(person1.name).isEqualTo(person2.name)
        assertThat(person1.age).isEqualTo(person2.age)
        assertThat(person1.nickname).isEqualTo(person2.nickname)
    }

    @Test
    fun `널 타입`() {
        val person = Person("박재성", 20, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("박재성", 20)
        assertThat(person.nickname).isEqualTo("박재성")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("박재성", 20, "제이슨")
        val person2 = Person("박재성", 20, "제이슨")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person("박재성", 20, "제이슨")
        val person2 = person1.copy(nickname = null)

        assertThat(person1.nickname).isEqualTo("제이슨")
        assertThat(person2.nickname).isNull()
    }
}