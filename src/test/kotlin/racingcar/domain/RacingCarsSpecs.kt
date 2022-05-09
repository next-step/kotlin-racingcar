package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RacingCarsSpecs : DescribeSpec({

    val numberOfCars = 3

    describe("경주에 참여한 자동차들은") {
        val racingCars = RacingCars(
            List(numberOfCars) { Car() }
        )
        it("경주가 종료되면 경주 결과를 반환한다") {
            val raceRecords = racingCars.race()
            raceRecords.cars.size shouldBe numberOfCars
        }
    }
})
