package domain.step3.domain.game

import domain.step3.domain.racingcar.DistanceDriven
import domain.step3.domain.racingcar.RacingCar
import domain.step3.domain.racingcar.RacingCars
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class GameRecordTest {

    @Test
    fun `GameRecord 생성시 빈 콜렉션이 들어오면 안 된다`() {
        assertThatThrownBy { GameRecord(listOf()) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("비어있는 값은 들어올 수 없습니다.")
    }

    @Test
    fun `자동차들의 현재 상태 정보가 들어온다`() {
        val movingStrategy = { true }
        val numberOfCars = 1
        val expected = GameRecord(listOf(RacingCars((listOf(RacingCar(DistanceDriven(3), movingStrategy))))))

        val racingCars = RacingCars.from(numberOfCars, movingStrategy)
        var gameRecord = GameRecord.initialize(racingCars)
        gameRecord = gameRecord.add(racingCars.moveForward())
        gameRecord = gameRecord.add(racingCars.moveForward())

        assertAll(
            { assertThat(gameRecord).hasSameHashCodeAs(expected) },
            { assertThat(gameRecord).isEqualTo(expected) }
        )
    }
}