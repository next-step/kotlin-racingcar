package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith
import io.kotest.matchers.types.shouldBeTypeOf

class TryCountTest : BehaviorSpec({
    given("시도횟수를 입력했을 때") {

        `when`("숫자가 아닌 문자를 입력할 경우") {
            notConvertToIntList.forAll {
                val exception = shouldThrow<IllegalArgumentException> {
                    TryCount.from(it)
                }
                exception.message should startWith("입력 값은 정수 여야 합니다.")
            }
        }

        `when`("0 이하의 숫자를 입력할 경우") {
            zeroAndNegativeNumberList.forAll {
                then("illegalArgumentException 예외를 반환한다.") {
                    val exception = shouldThrow<IllegalArgumentException> {
                        TryCount.from(it)
                    }
                    exception.message should startWith("입력 값은 1 이상이어야 합니다.")
                }
            }
        }

        `when`("양의 정수를 입력할 경우") {
            positiveNumberList.forAll {
                then("입력한 값이 Int 타입으로 반환된다.") {
                    val tryCount = TryCount.from(it).getCount()
                    tryCount.shouldBeTypeOf<Int>()
                }
            }
        }
    }
}) {
    companion object {
        private val notConvertToIntList = listOf("car", "4.56", "44g6")
        private val zeroAndNegativeNumberList = listOf("-3", "-55", "0")
        private val positiveNumberList = listOf("1", "5", "100")
    }
}
