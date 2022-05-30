package racing.domain.race

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.domain.common.CarRaceProperty
import racing.domain.utils.RandomNumberStrategy

class CarRaceTest {

    @Test
    fun `이동이 되었는지 테스트`() {
        val roundSize = 1
        val carNames = listOf("A")
        val carRaceProperty = CarRaceProperty(roundSize, carNames)

        carRaceProperty.cars[0].moveForward()

        assertThat(carRaceProperty.cars[0].moveCount).isEqualTo(1)
    }

    @Test
    fun `모든 라운드가 이동되는 조건인 경우에 대한 테스트`() {
        class RandomNumberMakerForTest(val testNumber: Int) : RandomNumberStrategy {
            override fun getRandomNumber(): Int {
                return testNumber
            }
        }

        val roundSize = 5
        val carNames = listOf("A")
        val carRaceProperty = CarRaceProperty(roundSize, carNames)
        val carRace = CarRace(carRaceProperty)
        val randomNumber = RandomNumberMakerForTest(10)

        carRace.start(randomNumber)

        assertThat(carRaceProperty.cars[0].moveCount).isEqualTo(5)
    }

    @Test
    fun `조건에 따라 이동, 이동하지 않는 경우에 대한 테스트`() {
        class RandomNumberMakerForTest(val testNumber: Int) : RandomNumberStrategy {
            override fun getRandomNumber(): Int {
                return testNumber
            }
        }

        val roundSize = 5
        val randomNumberByRound = listOf(5, 2, 10, 9, 2)
        val carNames = listOf("A")
        val carRaceProperty = CarRaceProperty(roundSize, carNames)
        val carRace = CarRace(carRaceProperty)

        repeat(roundSize) {
            val randomNumber = RandomNumberMakerForTest(randomNumberByRound[it])
            carRace.startByRound(it, randomNumber)
        }

        assertThat(carRaceProperty.cars[0].moveCount).isEqualTo(3)
    }
}
