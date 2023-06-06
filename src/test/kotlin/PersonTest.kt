import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val person = Person(name = "김태훈", age = 23, nickname = "sksskaw")
        assertThat(person.name).isEqualTo("김태훈")
        assertThat(person.age).isEqualTo(23)
        assertThat(person.nickname).isEqualTo("sksskaw")
    }

    @Test
    fun `널 타입`() {
        val actual = Person("홍길동", 20, null)
        assertThat(actual.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val actual = Person("홍길동", 20)
        assertThat(actual.nickname).isEqualTo("Guest")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("홍길동", 20, "Hong")
        val person2 = Person("홍길동", 20, "Hong")
        assertThat(person1).isEqualTo(person2)
    }
}
