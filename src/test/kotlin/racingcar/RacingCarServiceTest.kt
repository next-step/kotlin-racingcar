package racingcar

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe

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

        val movingCars = Cars(movingCarNames.map { Car(it) }, AlwaysMoveStrategy())
        val stopCars = Cars(stopCarNames.map { Car(it) }, NeverMoveStrategy())

        repeat(5) {
            movingCars.moveCars()
            stopCars.moveCars()
        }

        val allCars = Cars(movingCars.getCars() + stopCars.getCars())

        val winners = allCars.getWinners()

        winners.size shouldBe movingCars.getCars().size
        winners.map { it.name } shouldContainExactly movingCarNames
    }

    "레이싱카 서비스는 승자가 여러 명일 때 승자를 올바르게 결정해야 합니다." {
        val movingCarNames = listOf("M1", "M2", "M3")
        val stopCarNames = listOf("S1", "S2")

        val movingCars = Cars(movingCarNames.map { Car(it) }, AlwaysMoveStrategy())
        val stopCars = Cars(stopCarNames.map { Car(it) }, NeverMoveStrategy())

        repeat(5) {
            movingCars.moveCars()
            stopCars.moveCars()
        }

        val allCars = Cars(movingCars.getCars() + stopCars.getCars())

        val winners = allCars.getWinners()

        winners.size shouldBe movingCars.getCars().size
        winners.map { it.name } shouldContainExactly movingCarNames
    }
})
