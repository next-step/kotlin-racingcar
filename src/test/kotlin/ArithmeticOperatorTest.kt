import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class ArithmeticOperatorTest : BehaviorSpec({

    Given("문자열이 입력 되었을 때") {
        When("문자열이 사칙 연산 기호라면 (+, -, *, /)") {
            Then("문자열과 매칭되는 기호를 반환한다") {
                ArithmeticOperator.of("+") shouldBe ArithmeticOperator.PLUS
                ArithmeticOperator.of("-") shouldBe ArithmeticOperator.MINUS
                ArithmeticOperator.of("*") shouldBe ArithmeticOperator.MUL
                ArithmeticOperator.of("/") shouldBe ArithmeticOperator.DIV
            }
        }

        When("문자열이 사칙 연산 기호가 아니면") {
            Then("IllegalArgumentException 에러가 발생한다") {
                shouldThrow<IllegalArgumentException> { ArithmeticOperator.of("a") }
                shouldThrow<IllegalArgumentException> { ArithmeticOperator.of(" ") }
                shouldThrow<IllegalArgumentException> { ArithmeticOperator.of("?") }
                shouldThrow<IllegalArgumentException> { ArithmeticOperator.of("++") }
                shouldThrow<IllegalArgumentException> { ArithmeticOperator.of("+/") }
                shouldThrow<IllegalArgumentException> { ArithmeticOperator.of("?/") }
            }
        }
    }

    Given("두 수가 입력 되었을 때") {
        ArithmeticOperator.values().forEach { operator ->
            When("$operator 연산을 하면") {
                Then("$operator 결과를 반환한다") {
                    with(operator) {
                        when (this) {
                            ArithmeticOperator.PLUS -> {
                                execute(1.0, 2.0) shouldBe 3.0
                                execute(-1.0, 2.0) shouldBe 1.0
                                execute(1.0, -2.0) shouldBe -1.0
                                execute(-1.0, -2.0) shouldBe -3.0
                            }
                            ArithmeticOperator.MINUS -> {
                                execute(1.0, 2.0) shouldBe -1.0
                                execute(-1.0, 2.0) shouldBe -3.0
                                execute(1.0, -2.0) shouldBe 3.0
                                execute(-1.0, -2.0) shouldBe 1.0
                            }
                            ArithmeticOperator.MUL -> {
                                execute(1.0, 2.0) shouldBe 2.0
                                execute(-1.0, 2.0) shouldBe -2.0
                                execute(1.0, -2.0) shouldBe -2.0
                                execute(-1.0, -2.0) shouldBe 2.0
                            }
                            ArithmeticOperator.DIV -> {
                                execute(1.0, 2.0) shouldBe 0.5
                                execute(-1.0, 2.0) shouldBe -0.5
                                execute(1.0, -2.0) shouldBe -0.5
                                execute(-1.0, -2.0) shouldBe 0.5
                            }
                        }
                    }
                }
            }
        }
    }
})
