import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PersonTest {

    @Test
    fun `named parameter`() {
        val person = Person(name = "김승갑", age = 10, nickname = "justin")

        assertThat(person.name).`as`("person 의 이름을 확인합니다.", person.name).isEqualTo("김승갑")
        assertThat(person.age).`as`("person 의 나이를 확인합니다.", person.age).isEqualTo(10)
    }

    @Test
    fun `init parameter`() {
        val person = Person(name = "김승갑", age = 10)

        assertThat(person.nickname).`as`("person 의 닉네임을 확인합니다.", person.nickname).isEqualTo("김승갑")
    }

    @Test
    fun `데이터 클래스 equals 체크`() {
        assertThat(Person(name = "김승갑", age = 10)).isEqualTo(Person(name = "김승갑", age = 10))
    }
}
