import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class PersonTest {
    @Test
    fun constructor() {
        val person = Person("이보람", 29, "이보람")
        assertThat(person.name).isEqualTo("이보람") // person.getName()
        person.nickname = "마크"
        assertThat(person.nickname).isEqualTo("마크") // person.getName()
    }

    @Test // test코드에서는 ''을 사용하여 함수 이름을 띄워쓸 수 있다. 또는 @DisplayName("") 사용
    fun `named arguments`() {
        val people = listOf(
            Person("박재성", 29, "제이슨"),
            Person("박재성", 29, nickname = "제이슨"),
            Person(
                name = "박재성",
                nickname = "제이슨",
                age = 29
            ) // 인수 입력의 순서를 바꿔도 된다. 단, named argument를 쓰는 경우엔 그 다음부터 모두 named argument를 써야 한다.
        )
        assertThat(people).allSatisfy {
            assertThat(it.name).isEqualTo("박재성")
            assertThat(it.age).isEqualTo(29)
            assertThat(it.nickname).isEqualTo("제이슨")
        }
    }

    @Test
    fun `nullable types`() {
        val person = Person("박재성", null, null)
        assertAll(
            { assertThat(person.name).isEqualTo("박재성") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `default arguments`() {
        val person = Person("박재성")
        assertAll(
            { assertThat(person.name).isEqualTo("박재성") },
            { assertThat(person.age).isNull() },
            { assertThat(person.nickname).isNull() }
        )
    }

    @Test
    fun `data classes`() {
        val person1 = Person("박재성", 29, "제이슨")
        val person2 = Person("박재성", 29, "제이슨")
        assertThat(person1).isEqualTo(person2)
    }
}
