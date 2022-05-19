package step4.racingcar.racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarRacingTest {

    @ParameterizedTest
    @ValueSource(ints = [3, 6])
    fun `우승자 확인 테스트`(input: Int) {
        val racers = listOf("molly", "jayce", "pug")
        val cars = racers.map { Car(it) }
        cars.first().moveOrStop(5)
        cars.forEach {
            it.moveOrStop(input)
        }
        val winner = CarRacing.getWinner(cars)
        assertThat(winner).isEqualTo(listOf(cars.first()))
    }

    @ParameterizedTest
    @ValueSource(ints = [3, 6])
    fun `우승자 여러명 테스트`(input: Int) {
        val racers = listOf("molly", "jayce", "pug")
        val cars = racers.map { Car(it) }
        cars.forEach {
            it.moveOrStop(input)
        }
        val winner = CarRacing.getWinner(cars)
        assertThat(winner).isEqualTo(cars)
    }
}
