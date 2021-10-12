package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person1 = Person(name = "Youngjik Yoon", age = 20, nickname = "Laco")
        val person2 = Person(nickname = "Laco", age = 20, name = "Youngjik Yoon")

        assertThat(person1.name).isEqualTo(person2.name)
        assertThat(person1.age).isEqualTo(person2.age)
        assertThat(person1.nickname).isEqualTo(person2.nickname)
    }

    @Test
    fun `널 타입`() {
        val person = Person("Youngjik Yoon", 20, null)

        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("Youngjik Yoon", 20)

        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("Youngjik Yoon", 20, "Youngjik Yoon")
        val person2 = Person("Youngjik Yoon", 20, "Youngjik Yoon")

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person("Youngjik Yoon", 20, "Youngjik Yoon")
        val person2 = person1.copy(nickname = null)

        assertThat(person1.nickname).isEqualTo("Youngjik Yoon")
        assertThat(person2.nickname).isNull()
    }
}
