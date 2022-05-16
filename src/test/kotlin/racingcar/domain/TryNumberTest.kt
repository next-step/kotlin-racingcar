package racingcar.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class TryNumberTest : StringSpec({
    "시도횟수가 0이상이면 정상적으로 객체를 생성한다." {
        // given
        val value = 0

        // when //then
        shouldNotThrowAny { TryNumber(value) }
    }

    "시도횟수가 0미만이면 예외를 발생시킨다." {
        // given
        val value = -1

        // when //then
        shouldThrowExactly<IllegalArgumentException> { TryNumber(value) }
    }

    "시도횟수를 차감한다." {
        // given
        val tryNumber = TryNumber(1)

        // when
        val actual = tryNumber.consume()

        // then
        actual.value shouldBe 0
    }

    "잔여 시도횟수가 없을 때, 시도횟수를 차감하면 예외를 발생시킨다." {
        // given
        val tryNumber = TryNumber(0)

        // when // then
        shouldThrowExactly<IllegalStateException> { tryNumber.consume() }
    }

    "시도횟수가 남아있는지 확인한다." {
        listOf(
            row(0, false),
            row(1, true),
        ).forAll { (tryNumberValue, expected) ->
            // given
            val tryNumber = TryNumber(tryNumberValue)

            // when
            val actual = tryNumber.isPlaying

            // then
            actual shouldBe expected
        }
    }
})
