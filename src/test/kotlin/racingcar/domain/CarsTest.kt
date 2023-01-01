package racingcar.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.equality.shouldNotBeEqualToComparingFields
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldNotBeSameInstanceAs

class CarsTest : DescribeSpec({
    val listOfCars = List(2) { Car("자동차$it", it) }
    val carPositions = listOfCars.map { it.position }
    val cars = Cars(listOfCars)

    describe("자동차 일급 컬렉션 테스트") {
        it("전진조건을 만족하는 경우 자동차들은 이동할 수 있다.") {
            val carPositionsAfterMove = cars
                .move(movableStrategy = { true })
                .map { it.position }

            carPositions shouldNotBeEqualToComparingFields carPositionsAfterMove
        }

        it("전진조건을 만족하지 못하는 경우 자동차들은 이동할 수 없다.") {
            val carPositionsAfterMove = cars
                .move(movableStrategy = { false })
                .map { it.position }

            carPositions shouldNotBeEqualToComparingFields carPositionsAfterMove
        }

        it("현재 자동차들의 position을 기록할 수 있다.") {
            val recordedCars = cars.record()

            recordedCars shouldNotBeSameInstanceAs cars
        }

        it("현재 자동차들 중 가장 앞선 position을 찾아낼 수 있다.") {
            val maxPositionCars = cars.getMaxPositionCars()

            maxPositionCars shouldBe listOf(listOfCars.last())
        }
    }
})
