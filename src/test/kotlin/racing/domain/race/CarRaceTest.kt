package racing.domain.race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.domain.common.CarRaceProperty
import racing.domain.utils.RandomNumberStrategy

class CarRaceTest {
    class RandomNumberFixture(private val number: Int) : RandomNumberStrategy {
        override fun getRandomNumber(): Int {
            return number
        }
    }

    @Test
    fun `모든 라운드가 이동되는 조건인 경우에 대한 테스트`() {
        val roundSize = 5
        val carNames = listOf("A")
        val carRaceProperty = CarRaceProperty(roundSize, carNames)
        val carRace = CarRace(carRaceProperty)
        val randomNumber = RandomNumberFixture(10)

        carRace.start(randomNumber)

        assertThat(carRaceProperty.cars[0].moveCount).isEqualTo(5)
    }
}
