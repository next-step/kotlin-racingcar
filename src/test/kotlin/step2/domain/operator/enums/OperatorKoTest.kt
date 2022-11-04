package step2.domain.operator.enums

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.nulls.shouldNotBeNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import step2.domain.operation.enums.Operator
import step2.domain.operation.model.BinaryInputCommand

internal class OperatorKoTest : StringSpec({

    "문자열에서 Operator enum 으로 변환" {
        listOf(
            ADDITION_LITERAL_STRING,
            SUBTRACTION_LITERAL_STRING,
            MULTIPLICATION_LITERAL_STRING,
            DIVISION_LITERAL_STRING
        ).forEach {
            val operator = Operator.operatorOf(it)
            operator.shouldNotBeNull()
        }
    }

    "문자열에서 Operator enum 으로 변환 오류" {
        listOf(
            "0",
            "__",
            "++",
            "!"
        ).forEach {
            shouldThrow<IllegalArgumentException> {
                Operator.operatorOf(it)
            }
        }
    }

    "Operator enum 을 Command 로 전환" {
        Operator.values().forEach {
            if (it == Operator.ILLEGAL_STATE) {
                assertThrows<IllegalStateException> { it.toCommand() }
                return@forEach
            }
            assertThat(it.toCommand()).isNotNull
        }
    }

    "Operator Command 동작 확인" {
        listOf(
            ADDITION_LITERAL_STRING,
            SUBTRACTION_LITERAL_STRING,
            MULTIPLICATION_LITERAL_STRING,
            DIVISION_LITERAL_STRING
        ).forEach {
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
})

private const val ADDITION_LITERAL_STRING = "+"
private const val SUBTRACTION_LITERAL_STRING = "-"
private const val MULTIPLICATION_LITERAL_STRING = "*"
private const val DIVISION_LITERAL_STRING = "/"
