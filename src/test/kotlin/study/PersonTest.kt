package study

import io.kotest.core.spec.style.AnnotationSpec
import org.assertj.core.api.Assertions.assertThat

class PersonTest : AnnotationSpec() {
    @Test
    fun `이름 붙인 인자`() {
        val person = Person("shinyoung Kim", 30, "rolroralra")
        assertThat(person.name).isEqualTo("shinyoung Kim")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("rolroralra")
    }

    @Test
    fun `널 타입`() {
        val person = Person("shinyoung Kim", 20, null)
        assertThat(person.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val person = Person("shinyoung Kim", 30)
        assertThat(person.name).isEqualTo("shinyoung Kim")
        assertThat(person.age).isEqualTo(30)
        assertThat(person.nickname).isEqualTo("nickname")
    }

    @Test
    fun `데이터 클래스`() {
        val person = Person("shinyoung Kim", 30)
        val person2 = Person("shinyoung Kim", 30)

        assertThat(person).isEqualTo(person2)
    }
}
