package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RacingGameTest {
    private lateinit var cars: List<Car>
    private lateinit var racingGame: RacingGame

    @BeforeEach
    fun setup() {
        cars = listOf(
            Car(name = "one", distance = 1),
            Car(name = "two", distance = 2),
            Car(name = "three", distance = 3)
        )
        racingGame = RacingGame(racingCars = cars)
    }

    @Test
    fun `자동차 대 수와 횟수에 따른 총 이벤트 발생 개수 확인`() {
        racingGame.play(5)

        assertThat(racingGame.movingDistanceHistory.size).isEqualTo(5 * cars.size)
    }

    @Test
    fun `최대 이동 거리 구하기`() {
        assertThat(racingGame.getFarthestCarDistance()).isEqualTo(3)
    }
}
