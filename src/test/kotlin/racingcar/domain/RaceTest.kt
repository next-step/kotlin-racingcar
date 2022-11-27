package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec

class RaceTest : DescribeSpec({
    describe("레이싱 자동차 게임") {
        it("자동차 대수와 시도할 횟수를 선택하면 경기를 시작할 수 있다.") {
            val numberOfCar = 4
            val totalCountOfRound = 3

            var cars = List(numberOfCar) { Car("pobi") }

            val race = Race(cars, totalCountOfRound)
            race.run()
        }
    }
})
