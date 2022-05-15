package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import racingcar.domain.Cars.Companion.MIN_COUNT

internal class CarsTest : StringSpec({

    "자동차 수가 $MIN_COUNT 보다 작을 경우 예외가 발생한다." {
        // given
        val invalidValue = MIN_COUNT - 1

        // when
        val exception = shouldThrowExactly<IllegalArgumentException> { Cars(countOfCars = invalidValue) }

        // then
        exception.message shouldBe "자동차 수는 $MIN_COUNT 이상이어야 합니다."
    }
})
