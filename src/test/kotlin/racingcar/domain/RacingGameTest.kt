package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RacingGameTest {

    private val car1 = Car(Name("car1"))
    private val car2 = Car(Name("car2"), Distance(1))
    private val car3 = Car(Name("car3"), Distance(1))
    private val cars = Cars(listOf(car1, car2, car3))

    @ParameterizedTest(name = "{0}일 경우")
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `시도할 횟수는 0보다 커야 한다 0보다 큰 경우 생성 가능하다`(round: Int) {
        assertDoesNotThrow { RacingGame(round, cars) }
    }

    @ParameterizedTest(name = "{0}일 경우")
    @ValueSource(ints = [0, -1, -2])
    fun `시도할 횟수는 0보다 커야 한다 0이거나 작은 경우 생성 불가능하다`(round: Int) {
        assertThrows<IllegalArgumentException> { RacingGame(round, cars) }
    }

    @ParameterizedTest(name = "{0}일 경우")
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `round 만큼 시도 한다`(round: Int) {
        val result = RacingGame(round, cars).race(RandomNumberGenerator())

        assertThat(result.elements.size).isEqualTo(round)
    }
}
