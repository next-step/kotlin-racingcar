package racingcar.domain

import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun move() {
        val cars = Cars(
            listOf(Car("test1", 0), Car("test2", 4))
        )

        val result = cars.move(AlwaysMoveConditionProvider())

        result shouldBe RacingCarGameSnapShot(
            listOf(CarSnapShot("test1", 1), CarSnapShot("test2", 5))
        )
    }

    @Test
    fun not_move() {
        val cars = Cars(
            listOf(Car("test1", 0), Car("test2", 4))
        )

        val result = cars.move(NeverMoveConditionProvider())

        result shouldBe RacingCarGameSnapShot(
            listOf(CarSnapShot("test1", 0), CarSnapShot("test2", 4))
        )
    }

    @DisplayName("우승자명을 반환한다")
    @Test
    fun getWinners() {
        val car1 = Car("test1", 0)
        val car2 = Car("test2", 1)
        val cars = Cars(listOf(car1, car2))

        cars.getWinnersOfGame() shouldContainExactly listOf(car2)
    }

    @DisplayName("우승자가 여럿인 경우")
    @Test
    fun getMultipleWinners() {
        val car1 = Car("test1", 0)
        val car2 = Car("test2", 1)
        val car3 = Car("test3", 1)
        val cars = Cars(listOf(car1, car2, car3))

        cars.getWinnersOfGame() shouldContainExactly listOf(car2, car3)
    }
}
