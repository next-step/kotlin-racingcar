package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙은 인자`() {
        val person1 = Person(name = "최상용", age = 28, nickname = "스티치")
        val person2 = Person(age = 28, nickname = "스티치", name = "최상용")

        assertThat(person1.name).isEqualTo(person2.name)
        assertThat(person1.age).isEqualTo(person2.age)
        assertThat(person1.nickname).isEqualTo(person2.nickname)
    }

    @Test
    fun `널타입`() {
        val person = Person("최상용", 28, null)

        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("최상용", 28)

        assertThat(person.nickname).isEqualTo(person.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person(name = "최상용", age = 28, nickname = "스티치")
        val person2 = Person(name = "최상용", age = 28, nickname = "스티치")

        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `불변`() {
        val person1 = Person(name = "최상용", age = 28, nickname = "스티치")
        val person2 = person1.copy(nickname = null)

        assertThat(person1.nickname).isEqualTo("스티치")
        assertThat(person2.nickname).isNull()
    }
}
