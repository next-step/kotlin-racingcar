import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val people = listOf(
            Person("신동윤", 29, "몰리"),
            Person("신동윤", 29, nickName = "몰리"),
            Person(name = "신동윤", age = 29, nickName = "몰리")
        )

        assertThat(people[0].name).isEqualTo("신동윤")
        assertThat(people[1].name).isEqualTo("신동윤")
        assertThat(people[2].name).isEqualTo("신동윤")
    }

    @Test
    fun `널 타입`() {
        val person = Person("신동윤", 29, null)
        assertThat(person.name).isEqualTo("신동윤")
        assertThat(person.nickName).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("신동윤", 29)
        assertThat(person.nickName).isEqualTo("신동윤")
    }
}

data class Person(val name: String, val age: Int, var nickName: String? = name)
