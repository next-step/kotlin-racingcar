package carracing

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

class RacingCarsTest : StringSpec({

    "getMaxDistanceCars 는 distance 가 가장 큰 차들을 가져온다" {
        // given
        val racingCars = RacingCars(
            listOf<Car>(
                Car("Car1", 3),
                Car("Car2", 4),
                Car("Car3", 10),
                Car("Car4", 0),
                Car("Car5"),
            )
        )

        // when
        val maxDistanceCars = racingCars.getMaxDistanceCars()

        // then
        maxDistanceCars.size shouldBe 1
        maxDistanceCars[0].name shouldBe "Car3"
        maxDistanceCars[0].distance shouldBe 10
    }

    "getMaxDistanceCars 는 가장 큰 distance 가 같은 차가  여러개인 경우 그 차를 전부 가져온다" {
        // given
        val racingCars = RacingCars(
            listOf<Car>(
                Car("Car1", 3),
                Car("Car2", 30),
                Car("Car3", 30),
                Car("Car4", 30),
                Car("Car5", 10),
                Car("Car6", 4),
            )
        )

        // when
        val maxDistanceCars = racingCars.getMaxDistanceCars()

        // then
        maxDistanceCars.size shouldBe 3
        maxDistanceCars.map { car: Car -> car.name } shouldContainExactly listOf(
            "Car2",
            "Car3",
            "Car4"
        )
        maxDistanceCars.map { car: Car -> car.distance } shouldContainExactly List(3) { 30 }
    }

    "moveCar 는 자동차를 이동시킨다" {
        // given
        val defaultDistance = 3
        val forwardDistance = 5
        val car = Car("a", defaultDistance)
        val racingCars = RacingCars(listOf(car))

        // when
        racingCars.moveCar(0, forwardDistance)

        // then
        racingCars.cars[0].distance shouldBe defaultDistance + forwardDistance
    }

    "getCarDistance 는 자동차 거리를 알려준다" {
        // given
        val defaultDistance = 3
        val car = Car("a", defaultDistance)
        val racingCars = RacingCars(listOf(car))

        // when
        val carDistance = racingCars.getCarDistance(0)

        // then
        carDistance shouldBe defaultDistance
    }

    "validateCarsIndex 는 설정하는 자동차의 Index 번호를 검증한다" {
        // given
        val car = Car("Car")
        val racingCars = RacingCars(listOf(car))
        val carIndex = -1

        // when
        val shouldThrowExactly = shouldThrowExactly<IllegalArgumentException> {
            racingCars.validateCarsIndex(carIndex)
        }

        // then
        shouldThrowExactly.message shouldBe "음수 값으로 시스템을 실행할수 없습니다"
    }

    "validateCarsIndex 는 cars 에 사이즈를 넘긴 값을 넣으면 에러가 발생한다" {
        // given
        val car = Car("Car")
        val racingCars = RacingCars(listOf(car))
        val carIndex = 30000

        // when
        val shouldThrowExactly = shouldThrowExactly<IllegalArgumentException> {
            racingCars.validateCarsIndex(carIndex)
        }

        // then
        shouldThrowExactly.message shouldBe "존재 하지 않은 번호 입니다"
    }
})
