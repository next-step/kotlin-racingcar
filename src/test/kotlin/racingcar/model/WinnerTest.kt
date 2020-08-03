package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinnerTest {

    @Test
    fun `최대 이동 거리 구하기`() {
        val cars = listOf(
            Car(name = "one", distance = 2),
            Car(name = "two", distance = 1),
            Car(name = "three", distance = 1)
        )

        assertThat(Winner.getFarthestCarDistance(cars)).isEqualTo(2)
    }

    @Test
    fun `우승자가 한 명인 경우`() {
        val cars = listOf(
            Car(name = "one", distance = 2),
            Car(name = "two", distance = 1),
            Car(name = "three", distance = 1)
        )

        assertThat(Winner.find(cars).joinToString()).isEqualTo(cars[0].name)
    }

    @Test
    fun `우승자가 여러 명인 경우`() {
        val cars = listOf(
            Car(name = "one", distance = 2),
            Car(name = "two", distance = 2),
            Car(name = "three", distance = 1)
        )

        assertThat(Winner.find(cars).size).isEqualTo(2)
    }
}
