package study

import org.junit.jupiter.api.Test

class PersonTest {
    @Test
    fun personTest() {
        val actual = Person(
            name = "이홍구",
            age = 29,
            nickname = "silvio",
        )

        assert(actual.name == "이홍구")
        assert(actual.age == 29)
        assert(actual.nickname == "silvio")
    }

    @Test
    internal fun nullTest() {
        val actual = Person(
            name = "이홍구",
            age = 29,
            nickname = null,
        )

        assert(actual.name == "이홍구")
        assert(actual.age == 29)
        assert(actual.nickname == null)
    }

    @Test
    internal fun defaultValueTest() {
        val actual = Person(
            name = "이홍구",
            age = 29,
        )

        assert(actual.name == "이홍구")
        assert(actual.age == 29)
        assert(actual.nickname == "이홍구")
    }

    @Test
    internal fun dataClassTest() {
        val person1 = Person("이홍구", 29)
        val person2 = Person("이홍구", 29)

        assert(person1 == person2)
    }

    @Test
    internal fun copyTest() {
        val person = Person("이홍구", 29)
        assert(person.nickname == "이홍구")

        val actual = person.copy(nickname = "silvio")
        assert(actual.name == "이홍구")
        assert(actual.age == 29)
        assert(actual.nickname == "silvio")
    }
}
