package me.parker.nextstep.kotlinracingcar.study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PersonTest {

    @Test
    fun `이름 붙인 인자`() {
        val p1 = Person("박성범", 30, "파커")
        val p2 = Person(name = "박성범", age = 30, nickname = "파커")
        val p3 = Person(age = 30, nickname = "파커", name = "박성범")
        val p4 = Person(nickname = "파커", age = 30, name = "박성범")

        assertThat(p1.name).isEqualTo("박성범")
        assertThat(p1.age).isEqualTo(30)
        assertThat(p1.nickname).isEqualTo("파커")
        assertThat(p2.name).isEqualTo("박성범")
        assertThat(p2.age).isEqualTo(30)
        assertThat(p2.nickname).isEqualTo("파커")
        assertThat(p3.name).isEqualTo("박성범")
        assertThat(p3.age).isEqualTo(30)
        assertThat(p3.nickname).isEqualTo("파커")
        assertThat(p4.name).isEqualTo("박성범")
        assertThat(p4.age).isEqualTo(30)
        assertThat(p4.nickname).isEqualTo("파커")
    }

    @Test
    fun `널 타입`() {
        val p1 = Person("박성범", 30, null)

        assertThat(p1.name).isEqualTo("박성범")
        assertThat(p1.age).isEqualTo(30)
        assertThat(p1.nickname).isNull()
    }

    @Test
    fun `기본 인자`() {
        val p1 = Person("박성범", 30)

        assertThat(p1.name).isEqualTo("박성범")
        assertThat(p1.age).isEqualTo(30)
        assertThat(p1.nickname).isEqualTo("박성범")
    }

    @Test
    fun `데이터 클래스`() {
        val p1 = Person("박성범", 30)
        val p2 = Person("박성범", 30)

        assertThat(p1).isEqualTo(p2)
    }

    @Test
    fun copy() {
        val person = Person("박성범", 30)
        assertThat(person.nickname).isEqualTo("박성범")

        val p1 = person.copy(nickname = "파커")

        assertThat(p1.name).isEqualTo("박성범")
        assertThat(p1.age).isEqualTo(30)
        assertThat(p1.nickname).isEqualTo("파커")
    }
}
