import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun `이름 붙인 인자`() {
        val person1 = Person(name = "박재성", age = 20, nickname = "제이슨")
        val person2 = Person(name = "김수연", age = 20, nickname = "onemask")
        assertThat(person1.name).isEqualTo(person2.name)
        assertThat(person1.age).isEqualTo(person2.age)
        assertThat(person1.nickname).isEqualTo(person2.nickname)
    }

    @Test
    fun `널 타입`() {
        val person3 = Person("김수연", 20, null)
        assertThat(person3.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person3 = Person("김수연", 20)
        assertThat(person3.nickname).isEqualTo(person3.name)
    }

    @Test
    fun `데이터 클래스`() {
        val person1 = Person("김수연", 20, "onemask")
        val person2 = Person("김수연", 20, "onemask")
        assertThat(person1).isEqualTo(person2)
    }
}
