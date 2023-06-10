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
        assertThat(racingField.getGameCount()).isEqualTo(5)
    }
}
