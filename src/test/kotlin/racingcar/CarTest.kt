package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import kotlin.random.Random

internal class CarTest {

    @CsvSource(value = ["0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"], delimiter = ':')
    @ParameterizedTest(name = "0-3의 값은 제자리이며, 4-9 사이의 값이 나오면 차가 전진한다.")
    fun driveRace(input: Int, expectedPos: Int) {
        // given
        val car = Car(0)
        // when
        val afterRaceCar = car.race(FixNextRandom(input))

        // then
        assertThat(afterRaceCar.pos).isEqualTo(expectedPos)
    }
}

class FixNextRandom(
    private val fixValue: Int
) : Random() {
    override fun nextBits(bitCount: Int): Int = bitCount
    override fun nextInt(until: Int): Int = fixValue
}
