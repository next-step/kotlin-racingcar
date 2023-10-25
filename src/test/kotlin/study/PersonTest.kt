package study

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PersonTest : FunSpec({
    test("이름 붙인 인자") {
        val person = Person(name = "홍길동", age = 30, nickname = "홍")

        person.name shouldBe "홍길동"
        person.age shouldBe 30
        person.nickname shouldBe "홍"
    }

    test("널 타입") {
        val person = Person("홍길동", 30, null)

        person.name shouldBe "홍길동"
        person.age shouldBe 30
        person.nickname shouldBe null
    }

    test("디폴트 값") {
        val person = Person("홍길동", 30)

        person.name shouldBe "홍길동"
        person.age shouldBe 30
        person.nickname shouldBe "홍길동"
    }

    test("데이터 클래스") {
        val person1 = Person("홍길동", 30)
        val person2 = Person("홍길동", 30)

        person1 shouldBe person2
    }

    test("copy") {
        val person = Person("홍길동", 30)
        val actual = person.copy("홍")

        actual.name shouldBe "홍길동"
        actual.age shouldBe 30
        actual.nickname shouldBe "홍"
    }
})
