package racingCar.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec

class CarNamesTest : StringSpec({

    "중복된 자동차 이름이 주어지면 예외가 발생한다." {
        shouldThrowWithMessage<IllegalArgumentException>("자동차 이름은 중복될 수 없습니다.") {
            CarNames(
                listOf(
                    CarName("a"),
                    CarName("a"),
                )
            )
        }
    }
})
