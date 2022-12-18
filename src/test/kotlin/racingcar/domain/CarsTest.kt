package racingcar.domain

import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun move() {
        val cars = Cars(
            listOf(Car("test1", 0), Car("test2", 0))
        )

        val result = cars.move(FixedNumberProvider())

        result shouldBe RacingCarGameSnapShot(
            listOf(CarSnapShot("test1", 1), CarSnapShot("test2", 1))
        )
    }

    @DisplayName("우승자명을 반환한다")
    @Test
    fun getWinners() {
        val cars = Cars(listOf(Car("test1", 0), Car("test2", 1)))

        cars.getWinnersOfGame() shouldContainExactly listOf("test2")
    }

    @DisplayName("우승자가 여럿인 경우")
    @Test
    fun getMultipleWinners() {
        val cars = Cars(listOf(Car("test1", 0), Car("test2", 1), Car("test3", 1)))

        cars.getWinnersOfGame() shouldContainExactly listOf("test2", "test3")
    }
}
