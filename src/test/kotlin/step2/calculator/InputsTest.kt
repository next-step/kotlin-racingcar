package step2.calculator

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import step2.calculator.vo.Number
import step2.calculator.vo.Operation

class InputsTest : StringSpec({
    "정확한 input 포멧으로 Inputs를 생성한다." {
        shouldNotThrowAny {
            Inputs.from(
                listOf(
                    Number(1),
                    Operation.from("+"),
                    Number(2),
                    Operation.from("-"),
                    Number(3)
                )
            )
        }
    }

    "input 포멧이 부정확 하면 exception. (피연산자)" {
        shouldThrowAny {
            Inputs.from(
                listOf(
                    Number(1),
                    Operation.from("+"),
                    Number(2),
                    Operation.from("-")
                )
            )
        }
    }

    "input 포멧이 부정확 하면 exception.(길이)" {
        shouldThrowAny {
            Inputs.from(
                listOf(
                    Number(1),
                    Operation.from("+")
                )
            )
        }
    }

    "input 포멧이 부정확 하면 exception.(순서)" {
        shouldThrowAny {
            Inputs.from(
                listOf(
                    Number(1),
                    Operation.from("+"),
                    Operation.from("-")
                )
            )
        }
    }
})
