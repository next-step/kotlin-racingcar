package racingcar

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.blocking.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import racingcar.domain.RacingCar

class RacingCarTest : StringSpec({
    "1 ~ 9 까지의 입력 중 4 미만일 경우 차가 전진할 수 없다." {
        forAll(
            row(0),
            row(1),
            row(2),
            row(3),
        ) { input ->
            val racingCar = RacingCar("raceC") { input }
            racingCar.move()
            racingCar.position shouldBe 0
        }
    }

    "1 ~ 9 까지의 입력 중 4 이상일 경우 차가 전진한다." {
        forAll(
            row(4),
            row(5),
            row(6),
            row(7),
            row(8),
            row(9),
        ) { input ->
            val racingCar = RacingCar("raceC") { input }
            racingCar.move()
            racingCar.position shouldBe 1
        }
    }

    "자동차의 이름이 5글자 초과할 경우 exception을 발생시킨다." {
        val name = "isLong"
        val exception = shouldThrow<IllegalArgumentException> { RacingCar(name) { 0 } }

        exception.message shouldBe "자동차 이름은 5자 까지 사용 가능 합니다. 입력하신 차의 이름은 : $name 입니다."
    }
})
