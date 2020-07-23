import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {

    @Test
    fun constructor() {
        val person = Person("김가을", 29, "김가을")
        assertThat(person.name).isEqualTo("김가을")
        person.nickname = "kelly"
        assertThat(person.nickname).isEqualTo("kelly")
    }

    /**
     * test code에 한해, ` 은 display name 처럼 사용 가능
     * named 선언이 앞에오면 뒤에도 전부 named가 되어야 함
     */
    @Test
    fun `named arguments`() {
        val people = listOf(
            Person("박재성", 29, "제이슨"),
            Person("박재성", 29, nickname = "제이슨"),
            Person(name = "박재성", nickname = "제이슨", age = 29)
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("박재성")
            assertThat(it.age).isEqualTo(29)
            assertThat(it.nickname).isEqualTo("제이슨")
        }
    }

    /**
     * nullable 변수를 선언할 땐 ? 를 사용
     */
    @Test
    fun `nullable types`() {
        val person = Person("박재성", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("박재성") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    /**
     * default 값을 주는 생성자를 만들고 싶을 때
     * ex) var nickname: String? = null
     */
    @Test
    fun `default arguments`() {
        val person = Person("박재성")
        assertAll(
            { assertThat(person.name).isEqualTo("박재성") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    /**
     * class 앞에 data 를 붙이고 data class로 만들어주면 기존 class와 같이 사용할 수 있음
     */
    @Test
    fun `data classes`() {
        val person1 = Person("박재성", 29, "제이슨")
        val person2 = Person("박재성", 29, "제이슨")
        assertThat(person1).isEqualTo(person2)
    }
}
