package racingcar.tasks

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.model.Car
import racingcar.util.Message.Companion.MIN_CONDITION_FOR_GOING
import racingcar.util.Message.Companion.ONE_DISTANCE

@Suppress("NonAsciiCharacters")
class CarTest {

    @Test
    fun `자동차 1회 전진`() {

        val car = Car(name = "김대겸").apply {
            tryMove(true)
        }

        assertThat(car.whereIs())
            .isEqualTo(ONE_DISTANCE)
    }

    @ParameterizedTest
    @CsvSource(
        "1, false", "2, false", "3, false", "4, false", "5, true",
        "6, true", "7, true", "8, true", "9, true"
    )
    fun `랜덤 값이 4 이상 일 때 1회 전진`(value: Int, expected: Boolean) {
        val car = Car(name = "김대겸")

        val canGo = value > MIN_CONDITION_FOR_GOING
        car.tryMove(canGo)

        assertThat(car.whereIs() == ONE_DISTANCE).isEqualTo(expected)
    }
}
