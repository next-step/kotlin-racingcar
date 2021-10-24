import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙은 인자`() {
        val person1 = Person(name = "박재성", age = 20, nickname = "제이슨")
        val person2 = Person(nickname = "제이슨", age = 20, name = "박재성")

        assertThat(person1.name).isEqualTo(person2.name)
        assertThat(person1.age).isEqualTo(person2.age)
        assertThat(person1.nickname).isEqualTo(person2.nickname)
    }

    @Test
    fun `널 타입`() {
        val person = Person(name = "박재성", age = 20, nickname = null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person(name = "박재성", age = 20)
//        assertThat(person.nickname).isNull()
        assertThat(person.nickname).isEqualTo("박재성")
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("박재성", 20, "제이슨")
        val person2 = Person("박재성", 20, "제이슨")
        assertThat(person1).isEqualTo(person2)
    }

    @Test
    fun `복사`() {
        val person1 = Person("박재성", 20, "제이슨")
        val person2 = person1.copy(nickname = null)
        assertThat(person2.nickname).isNull()
    }
}
