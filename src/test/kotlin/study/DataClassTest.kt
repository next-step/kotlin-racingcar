package study

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class DataClassTest : DescribeSpec({

    /*
    equals, hashcode, toString 구현해서 보일러플래이트를 제거한다.
    클래스 위임패턴?
     */

    describe("equals() & hashcode() test") {
        it("data class는 equals() 메서드를 제공한다") {
            val person1 = Person(name = "홍길동", age = 20)
            val person2 = Person(name = "홍길동", age = 20)
            val actual = person1 == person2
            actual shouldBe true
        }

        it("주생성자 밖에 정의된 프로퍼티는 equals나 hashcode의 고려 대상이 아니다") {
            val person1 = Person(name = "홍길동", age = 20)
            val person2 = Person(name = "홍길동", age = 20)
            person1.region = "서울"
            person2.region = "경기"
            val actual = person1 == person2

            person1.region shouldBe "서울"
            person2.region shouldBe "경기"
            actual shouldBe true
        }
    }

    describe("toString()") {
        it("data class는 toString() 메서드를 제공한다.") {
            val person1 = Person(name = "홍길동", age = 20)

            println("persion1: $person1")
        }
    }
})
