package racingcar.domain.car

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

internal class CarsTest : StringSpec({

    "자동차들의 이름이 서로 중복되면 예외가 발생한다." {
        // given
        val invalidValue = "최현구,최현구"

        // when
        val exception = shouldThrowExactly<IllegalArgumentException> { Cars(racingCarNames = invalidValue) }

        // then
        exception.message shouldBe "자동차 이름은 서로 중복될 수 없습니다."
    }
})
