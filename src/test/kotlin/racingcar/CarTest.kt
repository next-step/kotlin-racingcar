package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CarTest {

    @Test
    @DisplayName("자동차 이름이 5자 초과이면, 예외가 발생한다.")
    internal fun carNameTest() {

        // given
        val carName = "koiCar"

        // when, then
        assertThatIllegalArgumentException().isThrownBy { Car(carName) }
    }

    @CsvSource(value = ["0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"], delimiter = ':')
    @ParameterizedTest(name = "0-3의 값은 제자리이며, 4-9 사이의 값이 나오면 차가 전진한다.")
    fun driveRace(input: Int, expectedPos: Int) {
        // given
        val car = Car("koi")
        // when
        val afterRaceCar = car.race(RacingCarEngine.canMove(input))

        // then
        assertThat(afterRaceCar.pos).isEqualTo(expectedPos)
    }

    @Test
    @DisplayName("자동차 위치가 같으면 true를 반환한다.")
    internal fun equalsPosTrueTest() {
        // given
        val carA = Car("carA", 10)
        val carB = Car("carB", 10)

        // when, then
        assertThat(carA.equalsPos(carB)).isTrue
    }

    @Test
    @DisplayName("자동차 위치가 다르면 false를 반환한다.")
    internal fun equalsPosFalseTest() {
        // given
        val carA = Car("carA", 10)
        val carB = Car("carB", 5)

        // when, then
        assertThat(carA.equalsPos(carB)).isFalse
    }
}
