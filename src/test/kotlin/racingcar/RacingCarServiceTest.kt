package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import racingcar.domain.Car
import racingcar.domain.Cars

class AlwaysMoveStrategy : MoveStrategy {
    override fun move(): Int = Car.MOVE_THRESHOLD
}

class NeverMoveStrategy : MoveStrategy {
    override fun move(): Int = 0
}

class RacingCarServiceTest : StringSpec({
    "레이싱카 서비스는 승자가 한 명일 때 승자를 올바르게 결정해야 합니다." {
        val movingCarNames = listOf("T1")
        val stopCarNames = listOf("S1", "S2")
        val attemptNumber = 5

        val movingCars = Cars(movingCarNames.map { Car(it) }, AlwaysMoveStrategy())
        val stopCars = Cars(stopCarNames.map { Car(it) }, NeverMoveStrategy())

        movingCars.moveCars(attemptNumber)
        stopCars.moveCars(attemptNumber)

        val allCars = Cars(movingCars.cars + stopCars.cars)

        val winners = allCars.getWinners()

        winners.size shouldBe movingCars.cars.size
        winners.map { it.name } shouldContainExactly movingCarNames
    }

    "레이싱카 서비스는 승자가 여러 명일 때 승자를 올바르게 결정해야 합니다." {
        val movingCarNames = listOf("M1", "M2", "M3")
        val stopCarNames = listOf("S1", "S2")
        val attemptNumber = 5

        val movingCars = Cars(movingCarNames.map { Car(it) }, AlwaysMoveStrategy())
        val stopCars = Cars(stopCarNames.map { Car(it) }, NeverMoveStrategy())

        movingCars.moveCars(attemptNumber)
        stopCars.moveCars(attemptNumber)

        val allCars = Cars(movingCars.cars + stopCars.cars)

        val winners = allCars.getWinners()

        winners.size shouldBe movingCars.cars.size
        winners.map { it.name } shouldContainExactly movingCarNames
    }
})
