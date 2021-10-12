package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun name() {
        val person1 = Person(nickname = "hunihun", age = 28, name = "정상훈")
        val person2 = Person(name = "정상훈", age = 28, nickname = "hunihun")

        assertThat(person1.name).isEqualTo(person2.name)
        assertThat(person1.age).isEqualTo(person2.age)
        assertThat(person1.nickname).isEqualTo(person2.nickname)
    }

    @Test
    fun `널 타입 체크`() {
        val person = Person("정상훈", 28, null)

        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("정상훈", 28)

        assertThat(person.nickname).isEqualTo("정상훈")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("정상훈", 28, "hunihun")
        val person2 = Person("정상훈", 28, "hunihun")

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person("정상훈", 28, "hunihun")
        val person2 = person1.copy()

        assertThat(person1).isEqualTo(person2)
    }
}