package study.racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.racingcar.dto.CarName
import study.racingcar.dto.RacingCar

class RacingCarTest {

    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    @ParameterizedTest
    fun `RacingCar 는 무작위 값이 4 이상일 경우, 한칸 전진한다`(num: Int) {
        // given
        val winGameRule = WinGameRule()
        val racingCar = RacingCar(CarName("test"), winGameRule)

        // when
        racingCar.moveForward(winGameRule)

        // then
        assertEquals(1, racingCar.position)
    }

    @ValueSource(ints = [0, 1, 2, 3])
    @ParameterizedTest
    fun `RacingCar 는 무작위 값이 3이하일 경우 정지한다`(num: Int) {
        // given
        val loseGame = LoseGameRule()
        val racingCar = RacingCar(CarName("test"), loseGame)

        // when
        racingCar.moveForward(loseGame)

        // then
        assertEquals(0, racingCar.position)
    }
}
