import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class PersonTest {
    @DisplayName("이름 붙인 인자")
    @Test
    fun `named arguments`() {
        val people = listOf(
            Person(name, age, nickName),
            Person(name, age, nickname = nickName),
            Person(name = name, nickname = nickName, age = age)
        )

        SoftAssertions.assertSoftly { sa ->
            people.forEach {
                sa.assertThat(it.name).isEqualTo("김재녕")
                sa.assertThat(it.age).isEqualTo(10)
                sa.assertThat(it.nickname).isEqualTo("jaenyeong")
            }
        }
    }

    @DisplayName("Nullable 타입")
    @Test
    fun `nullable types`() {
        val person = Person(name, null, null)

        assertAll(
            { assertThat(person.name).isEqualTo("김재녕") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @DisplayName("기본 인자")
    @Test
    fun `default arguments`() {
        val person = Person(name)

        assertAll(
            { assertThat(person.name).isEqualTo("김재녕") },
            { assertThat(person.age).isEqualTo(10) },
            { assertThat(person.nickname).isEqualTo("김재녕") }
        )
    }

    @DisplayName("데이터 클래스")
    @Test
    fun `data classes`() {
        val person1 = Person(name, age, nickName)
        val person2 = Person(name, age, nickName)

        assertThat(person1).isEqualTo(person2)
    }

    companion object {
        private const val name: String = "김재녕"
        private const val age: Int = 10
        private const val nickName: String = "jaenyeong"
    }
}
