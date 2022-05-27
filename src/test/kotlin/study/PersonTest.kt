package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.function.Consumer

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("김태헌", 29, "디디"),
            Person("김태헌", 29, nickname = "디디"),
            Person(name = "김태헌", age = 29, nickname = "디디")
        )

        assertThat(people).allSatisfy(
            Consumer {
                assertThat(it.name).isEqualTo("김태헌")
                assertThat(it.age).isEqualTo(29)
                assertThat(it.nickname).isEqualTo("디디")
            }
        )
    }

    @Test
    fun `널 타입`() {
        val person = Person("김태헌", 29, null)

        assertThat(person.name).isEqualTo("김태헌")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isNull()
    }

    @Test
    internal fun `기본 인자`() {
        val person = Person("김태헌", 29)

        assertThat(person.name).isEqualTo("김태헌")
        assertThat(person.age).isEqualTo(29)
        assertThat(person.nickname).isEqualTo("김태헌")
    }

    @Test
    internal fun `데이터 클래스`() {
        val person1 = Person("김태헌", 29)
        val person2 = Person("김태헌", 29)

        assertThat(person1).isEqualTo(person2)
    }
}
