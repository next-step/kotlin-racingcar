package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class GameTest {
    @ParameterizedTest
    @CsvSource(
        "1,0",
        "4,0",
        "5,1",
        "9,1"
    )
    fun `이동 테스트`(input: Int, result: Int) {
        val racingCar = RacingCar("a").apply {
            this.move(input)
        }
        assertThat(racingCar.carDistance).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(
        "1,4,9"
    )
    fun `우승자 출력 테스트`(count1: Int, count2: Int, count3: Int) {
        val cars = RacingCars(carNameList = listOf("a", "b", "c"))
        val carList = cars.carList
        carList[0].move(count1)
        carList[1].move(count2)
        carList[2].move(count3)
        val game = Game(cars)
        assertThat(game.winner()).contains(carList[2])
    }
}
