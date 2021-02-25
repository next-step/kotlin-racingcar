package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PersonTest {

    @Test
    fun `생성`() {
        val name = "정현수"
        val age = 30405
        val nickName = "zino"

        val person = Person(name, age, nickName)
        assertThat(person.name).isEqualTo(name)
        assertThat(person.age).isEqualTo(age)
        assertThat(person.nickName).isEqualTo(nickName)

        val newNickName = "박토리아"
        person.nickName = newNickName
        assertThat(person.nickName).isEqualTo(newNickName)
    }

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "정현수", nickName = "zino", age = 30405)
        assertThat(person.nickName).isEqualTo("zino")
    }

    @Test
    fun `기본인자`() {
        val person = Person("정현수", 30405)
        assertThat(person.nickName)
            .isNotNull()
            .isEqualTo("정현수")
    }
}
