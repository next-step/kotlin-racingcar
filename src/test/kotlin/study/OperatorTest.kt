package study

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class OperatorTest : FunSpec({
    context("Plus Operator를 사용하면 두 수의 합을 구할 수 있다") {
        withData(
            Pair(2, 3) to 5,
            Pair(1, 1) to 2,
        ) { (nums, expected) ->
            Operator.PLUS.calculate(nums.first, nums.second) shouldBe expected
        }
    }

    context("Minus Operator를 사용하면 두 수의 차를 구할 수 있다") {
        withData(
            Pair(2, 3) to -1,
            Pair(1, 1) to 0,
        ) { (nums, expected) ->
            Operator.MINUS.calculate(nums.first, nums.second) shouldBe expected
        }
    }

    context("Multiply Operator를 사용하면 두 수의 곱을 구할 수 있다") {
        withData(
            Pair(2, 3) to 6,
            Pair(1, 1) to 1,
        ) { (nums, expected) ->
            Operator.MULTIPLY.calculate(nums.first, nums.second) shouldBe expected
        }
    }

    context("Divide Operator를 사용하면 두 수의 나눗셈을 구할 수 있다") {
        withData(
            Pair(6, 3) to 2,
            Pair(1, 1) to 1,
        ) { (nums, expected) ->
            Operator.DIVIDE.calculate(nums.first, nums.second) shouldBe expected
        }
    }
})
