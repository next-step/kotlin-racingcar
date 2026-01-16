import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val actual = Person(name = "홍길동", age = 29, nickname = "홍")
        assertThat(actual.name).isEqualTo("홍길동")
        assertThat(actual.age).isEqualTo(29)
        assertThat(actual.nickname).isEqualTo("홍")
    }

    @Test
    fun `널 타입`() {
        val actual = Person(name = "홍길동", age = 29, nickname = null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person(name = "홍길동", age = 29)
        assertThat(actual.nickname).isEqualTo("홍길동")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = DataPerson(name = "홍길동", age = 29)
        val person2 = DataPerson(name = "홍길동", age = 29)
        assertThat(person1).isEqualTo(person2)
    }
}