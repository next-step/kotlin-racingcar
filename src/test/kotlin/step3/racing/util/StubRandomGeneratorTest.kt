package step3.racing.util

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class StubRandomGeneratorTest : DescribeSpec({
    describe("getInt") {
        it("생성자로 전달된 순서대로 결과를 응답한다.") {
            val expectResult = mutableListOf(1, 2, 3, 4, 5)

            val stubRandomGenerator = StubRandomGenerator(expectResult)

            stubRandomGenerator.getInt(1..10) shouldBe 1
            stubRandomGenerator.getInt(1..10) shouldBe 2
            stubRandomGenerator.getInt(1..10) shouldBe 3
            stubRandomGenerator.getInt(1..10) shouldBe 4
            stubRandomGenerator.getInt(1..10) shouldBe 5
        }

        it("생성자로 전달된 값 보다 더 많이 호출되면 NoSuchElementException 를 던진다.") {
            val expectResult = mutableListOf(1)
            val stubRandomGenerator = StubRandomGenerator(expectResult)
            stubRandomGenerator.getInt(1..10)

            val exception = shouldThrow<NoSuchElementException> {
                stubRandomGenerator.getInt(1..10)
            }

            exception.message shouldBe "주어진 값을 전부 사용했습니다."
        }
    }
})
