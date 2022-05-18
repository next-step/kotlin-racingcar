import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class IntParserTest : DescribeSpec({

    describe("IntParser") {
        it("받은 입력 값을 정수로 변환해 반환한다.") {
            // given
            val result = IntParser.toInt("11")

            // then
            result shouldBe 11
        }

        it("정수로 변환 불가능한 입력값이라면 에러를 일으킨다.") {
            // given
            val exception = shouldThrow<IllegalArgumentException> {
                IntParser.toInt("$")
            }

            // then
            exception.message shouldBe "올바른 정수로 입력해주세요. 입력값: \$"
        }
    }
})
