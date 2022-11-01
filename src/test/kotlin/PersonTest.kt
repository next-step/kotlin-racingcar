import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙임 인자`() {
        val person = Person(name = "최차영", age = 33, nickname = "이든")
        assertThat(person.name).isEqualTo("최차영")
        assertThat(person.nickname).isEqualTo("이든")
        assertThat(person.age).isEqualTo(33)
    }

    @Test
    fun `널 타입`() {
        val person = Person("최차영", 33, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("최차영", 33)
        assertThat(person.name).isEqualTo(person.nickname)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("최차영", 33, "이든")
        val person2 = Person("최차영", 33, "이든")
        assertThat(person1).isEqualTo(person2)
    }
}
