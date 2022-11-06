package calculator.domain.operator.enums

import calculator.domain.operation.enums.Operator
import calculator.domain.operation.model.BinaryInputCommand
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

internal class OperatorKoTest : FreeSpec({

    "문자열에서 Operator enum 으로 변환" - {
        listOf(
            ADDITION_LITERAL_STRING,
            SUBTRACTION_LITERAL_STRING,
            MULTIPLICATION_LITERAL_STRING,
            DIVISION_LITERAL_STRING
        ).forEach {
            "COMMAND INPUT STRING: $it" {
                val operator = Operator.operatorOf(it)
                operator.shouldNotBeNull()
            }
        }
    }

    "문자열에서 Operator enum 으로 변환 오류" - {
        listOf(
            "0",
            "__",
            "++",
            "!"
        ).forEach {
            "COMMAND INPUT STRING: $it" {
                shouldThrow<IllegalArgumentException> {
                    Operator.operatorOf(it)
                }
            }
        }
    }

    "Operator enum 을 Command 로 전환" - {
        Operator.values().forEach {
            "COMMAND INPUT STRING: $it" {
                when (it) {
                    Operator.ILLEGAL_STATE -> assertThrows<IllegalStateException> { it.toCommand() }
                    else -> assertThat(it.toCommand()).isNotNull
                }
            }
        }
    }

    "Operator Command 동작 확인" - {
        listOf(
            ADDITION_LITERAL_STRING,
            SUBTRACTION_LITERAL_STRING,
            MULTIPLICATION_LITERAL_STRING,
            DIVISION_LITERAL_STRING
        ).forEach {
            "COMMAND INPUT STRING: $it" {
                val binaryInputCommand = BinaryInputCommand(firstNumber = 1, secondNumber = 2)
                val result = Operator.operatorOf(it).toCommand().operate(binaryInputCommand)
                when (it) {
                    ADDITION_LITERAL_STRING -> assertThat(result).isEqualTo(3)
                    SUBTRACTION_LITERAL_STRING -> assertThat(result).isEqualTo(-1)
                    MULTIPLICATION_LITERAL_STRING -> assertThat(result).isEqualTo(2)
                    DIVISION_LITERAL_STRING -> assertThat(result).isEqualTo(0)
                }
            }
        }
    }
})

private const val ADDITION_LITERAL_STRING = "+"
private const val SUBTRACTION_LITERAL_STRING = "-"
private const val MULTIPLICATION_LITERAL_STRING = "*"
private const val DIVISION_LITERAL_STRING = "/"
