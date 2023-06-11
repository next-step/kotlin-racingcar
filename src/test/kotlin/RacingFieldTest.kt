import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingFieldTest {
    @Test
    fun racingFieldCreateCarsTest() {
        val racingField = RacingField()
        racingField.createCars(3)
        assertThat(racingField.cars.size).isEqualTo(3)
    }

    @Test
    fun racingFieldSetGameCountTest() {
        val racingField = RacingField()
        racingField.setGameCount(5)

        val field = racingField.javaClass.getDeclaredField("gameCount")
        field.trySetAccessible()

        val value = field[racingField] as Int
        assertThat(value).isEqualTo(5)
    }

    @Test
    fun racingFieldGameStartTest() {
        val carCount = 5
        val gameCount = 100

        val racingField = RacingField()
        racingField.createCars(carCount)
        racingField.setGameCount(gameCount)
        racingField.gameStart()

        racingField.cars.forEach { car ->
            assertThat(car.distance).isBetween(0, gameCount)
        }
    }
}
