package racingcar.domain.car

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CarNamesTest : StringSpec ({

    "자동차들의 이름이 서로 중복되면 예외가 발생한다." {
        // given
        val invalidValues = listOf(
            CarName(value = "윤혁"),
            CarName(value = "윤혁"),
        )

        // when
        val exception = shouldThrowExactly<IllegalArgumentException> { CarNames(values = invalidValues) }

        // then
        exception.message shouldBe "자동차 이름은 서로 중복될 수 없습니다."
    }
})
