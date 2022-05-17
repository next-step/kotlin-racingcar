package racingcar.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class RacingCarsSpecs : DescribeSpec({

    val movements = listOf(0, 4, 9)
    val numberOfCars = movements.size
    val commandGenerator = PreparedDriver(movements)

    describe("경주에 참여한 자동차들은") {
        context("경주에 필요한 수 만큼 자동차가 등록되었다면") {
            val cars = List(numberOfCars) { Car("name", RandomDriver) }
            val racingCars = RacingCars(cars, commandGenerator)

            it("경주를 진행하고 경주 결과를 반환한다") {
                val raceRecords = racingCars.race()
                raceRecords.also {
                    it.cars.size shouldBe numberOfCars
                    it.cars.forEachIndexed { i, state ->
                        val car = cars[i]
                        val command = MovementCommand.of(movements[i])
                        car.position - command.power shouldBe 0
                        state.currentPosition shouldBe car.position
                    }
                }
            }
        }
        context("경주에 필요한 수 만큼 자동차가 등록되지 않았다면") {
            val cars = ArrayList<Car>()

            it("예외를 발생시킨다") {
                shouldThrowExactly<IllegalArgumentException> {
                    RacingCars(cars, commandGenerator)
                }
            }
        }
    }
})
