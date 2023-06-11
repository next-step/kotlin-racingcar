package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingCar

class RacingCarTest : StringSpec({
    val racingCar = RacingCar()

    "1 ~ 9 까지의 입력 중 4 이하일 경우 차가 전진할 수 없다." {
        forAll(
            row(0),
            row(1),
            row(2),
            row(3),
        ) { input ->
            racingCar.move(input)
            racingCar.position() shouldBe 0
        }
    }

    "1 ~ 9 까지의 입력 중 4 이상일 경우 차가 전진한다." {
        forAll(
            row(4, 1),
            row(5, 2),
            row(6, 3),
            row(7, 4),
            row(8, 5),
            row(9, 6),
        ) { input, position ->
            racingCar.move(input)
            racingCar.position() shouldBe position
        }
    }
})
