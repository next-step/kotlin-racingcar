package racingcar.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RacingGameTest {

    lateinit var racingGame: RacingGameUseCase

    @BeforeEach
    fun setUp() {
        racingGame = RacingGame()
    }

    @DisplayName("자동차 이름 리스트를 통해 자동차들을 생성한다")
    @Test
    fun createCarsTest() {
        // given
        val carNameList = listOf("a", "b", "c")

        // when
        val cars = racingGame.createCars(carNameList)

        // then
        assertThat(cars.getCars().size).isEqualTo(3)
        assertThat(cars.getCars().map { it.name.name }).containsAll(carNameList)
    }

    @DisplayName("자동차들을 전진시킨다")
    @Test
    fun runTest() {
        // given
        val carNameList = listOf("a", "b", "c")
        val cars = racingGame.createCars(carNameList)

        // when
        racingGame.run(cars)

        // then
        assertThat(cars.getCars().map { it.position.position }).containsAnyOf(0, 1)
    }

    @DisplayName("우승자의 이름을 반환한다")
    @Test
    fun getWinnersTest() {
        // given
        val carNameList = listOf("a", "b", "c")
        val cars = racingGame.createCars(carNameList)

        for (i in 1..5) { racingGame.run(cars) }

        // when
        val actual = racingGame.getWinners(cars)

        // then
        val expected = cars.getWinners().map { it.name.name }
        assertThat(actual).containsAll(expected)
    }
}
