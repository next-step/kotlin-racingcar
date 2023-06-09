package step3

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomDriveCarTest {

    @Test
    fun `drive car`() {
        val alwaysOneGenerator = RandomNumberGenerator(randomLimit = 1, randomBase = 1)
        val minDriveRandomNumber: Long = 1
        val car = RandomDriveCar(
            carNumber = 1,
            randomNumberGenerator = alwaysOneGenerator,
            minDriveRandomNumber = minDriveRandomNumber
        )

        car.drive()

        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `stop car`() {
        val alwaysOneGenerator = RandomNumberGenerator(randomLimit = 1, randomBase = 1)
        val minDriveRandomNumber: Long = 3
        val car = RandomDriveCar(
            carNumber = 1,
            randomNumberGenerator = alwaysOneGenerator,
            minDriveRandomNumber = minDriveRandomNumber
        )

        car.drive()

        assertThat(car.position).isEqualTo(0)
    }
}
