package step2.calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class ArithmeticParameterTest : DescribeSpec({
    describe("find") {
        it("+를 입력받으면 PLUS 를 반환한다.") {
            val input = "+"

            val find = ArithmeticParameter.find(input)

            find shouldBe ArithmeticParameter.PLUS
        }

        it("-를 입력받으면 MINUS 를 반환한다.") {
            val input = "-"

            val find = ArithmeticParameter.find(input)

            find shouldBe ArithmeticParameter.MINUS
        }

        it("*를 입력받으면 MULTIPLE 를 반환한다.") {
            val input = "*"

            val find = ArithmeticParameter.find(input)

            find shouldBe ArithmeticParameter.MULTIPLE
        }

        it("/를 입력받으면 DIVIDE 를 반환한다.") {
            val input = "/"

            val find = ArithmeticParameter.find(input)

            find shouldBe ArithmeticParameter.DIVIDE
        }

        it("연산자가 아닌 다른 문자열을 입력받으면 IllegalArgumentException 을 던진다.") {
            val input = "&"

            val exception = shouldThrow<IllegalArgumentException> {
                ArithmeticParameter.find(input)
            }

            exception.message shouldBe "유효하지 않은 입력 값입니다."
        }
    }
})
