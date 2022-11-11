package racingcar

import fixture.NextRandomFixture
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {

    @CsvSource(value = ["0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"], delimiter = ':')
    @ParameterizedTest(name = "0-3의 값은 제자리이며, 4-9 사이의 값이 나오면 차가 전진한다.")
    fun driveRace(input: Int, expectedPos: Int) {
        // given
        val car = Car(0)
        // when
        val afterRaceCar = car.race(NextRandomFixture(input))

        // then
        assertThat(afterRaceCar.pos).isEqualTo(expectedPos)
    }

    @ValueSource(strings = ["-1", "10", "100"])
    @ParameterizedTest(name = "0-9외의 값(`{arguments}`)이 나오면 예외가 발생한다.")
    fun driveRaceExceptionTest(input: Int) {
        // given
        val car = Car(0)

        // when, then
        assertThatIllegalArgumentException().isThrownBy {
            car.race(NextRandomFixture(input))
        }
    }
}
