package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*

class AccumulatorTest: StringSpec({

    "(정상 입력) 계산식 문자열을 입력 받아 결과를 누적하여 반환한다" {
        forAll<List<String>, Double>(
            row(listOf("1", "+", "1"), 2.0),
            row(listOf("1", "+", "1", "+", "3"), 5.0),
            row(listOf("2", "+", "3", "*", "4", "/", "2"), 10.0),
            row(listOf("2", "*", "3", "+", "4", "/", "2"), 5.0),
        ) { input, result ->
            val accumulator = Accumulator.startAccumulate(input[0])
            for (i in 1 until input.size) {
                accumulator.accumulate(input[i])
            }
            accumulator.getResult() shouldBe result
        }
    }

    "(비정상 입력) 계산식 문자열중 숫자가 아닌 문자열이 포함되어 있을 경우 IllegalArgumentException을 던진다" {
        val accumulator = Accumulator.startAccumulate("1")
        shouldThrow<IllegalArgumentException> {
            listOf("+", "a").forEach(accumulator::accumulate)
        }
    }

    "(비정상 입력) 계산식 문자열중 연속 숫자가 존재하는경우 IllegalArgumentException을 던진다" {
        val accumulator = Accumulator.startAccumulate("1")
        shouldThrow<IllegalArgumentException> {
            listOf("1", "+").forEach(accumulator::accumulate)
        }
    }

    "(비정상 입력) 계산식 문자열중 연속 연산자가 존재하는경우 IllegalArgumentException을 던진다" {
        val accumulator = Accumulator.startAccumulate("1")
        shouldThrow<IllegalArgumentException> {
            listOf("+", "+").forEach(accumulator::accumulate)
        }
    }
})
