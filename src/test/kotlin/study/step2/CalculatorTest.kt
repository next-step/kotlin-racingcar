package study.step2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({

    val calculator = Calculator()

    "더하기 연산이 정상적으로 수행 된다." {
        // when
        val result = calculator.execute("2 + 3")

        // then
        result shouldBe 5
    }

    "빼기 연산이 정상적으로 수행 된다." {
        // when
        val result = calculator.execute("6 - 4")

        // then
        result shouldBe 2
    }

    "곱하기 연산이 정상적으로 수행 된다." {
        // when
        val result = calculator.execute("3 * 4")

        // then
        result shouldBe 12
    }

    "나누기 연산이 정상적으로 수행 된다." {
        // when
        val result = calculator.execute("10 / 2")

        // then
        result shouldBe 5
    }

    "0으로 나누기를 수행하면 에러가 발생 한다." {
        // when & then
        shouldThrow<IllegalArgumentException> { calculator.execute("10 / 0") }
    }

    "연산자의 우선 순위와 상관없이 계산 결과가 반환 된다." {
        // when
        val result = calculator.execute("2 + 3 * 4")

        // then
        result shouldBe 20
    }
})
