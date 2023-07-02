package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll

class WinnersTest : StringSpec({
    "자동차들이 들어왔을때 position 값이 가장 큰 자동차들만 승리자가 된다" {
        val wadeCar = RacingCar("wade", 1)
        val pavloCar = RacingCar("pavlo", 5)
        val winners = Winners(listOf(wadeCar, pavloCar))
        winners.cars shouldContain pavloCar
    }
    "가장 큰 position의 값을 가진 자동차가 여러대라면 공동 우승자가 생겨난다." {
        val wadeCar = RacingCar("wade", 4)
        val pavloCar = RacingCar("pavlo", 4)
        val jakeCar = RacingCar("jake", 1)
        val winners = Winners(listOf(jakeCar, wadeCar, pavloCar))
        winners.cars shouldContainAll listOf(wadeCar, pavloCar)
    }
})
