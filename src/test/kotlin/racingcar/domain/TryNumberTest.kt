package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class TryNumberTest : StringSpec({
    "시도횟수가 1이상이면 정상적으로 객체를 생성한다." {
        listOf(
            1, 2, 3, 4,
        ).forAll {
            // when //then
            shouldNotThrowAny { TryNumber(it) }
        }
    }

    "시도횟수가 1미만이면 예외를 발생시킨다." {
        listOf(
            -3, -2, -1, 0,
        ).forAll {
            // when //then
            shouldThrowExactly<IllegalArgumentException> { TryNumber(it) }
        }
    }

    "시도횟수를 차감한다." {
        // given
        val tryNumber = TryNumber(1)

        // when
        tryNumber.consume()

        // then
        tryNumber.value shouldBe 0
    }

    "잔여 시도횟수가 없을 때, 시도횟수를 차감하면 예외를 발생시킨다." {
        // given
        val tryNumber = TryNumber(1)
        tryNumber.consume()

        // when // then
        shouldThrowExactly<IllegalStateException> { tryNumber.consume() }
    }

    "시도횟수를 모두 소진했는지 확인한다." {
        listOf(
            row(1, true),
            row(2, false),
        ).forAll { (tryNumberValue, expected) ->
            // given
            val tryNumber = TryNumber(tryNumberValue)
            tryNumber.consume()

            // when
            val actual = tryNumber.isComplete()

            // then
            actual shouldBe expected
        }
    }
})
