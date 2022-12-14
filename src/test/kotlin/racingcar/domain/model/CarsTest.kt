package racingcar.domain.model

import io.kotest.matchers.shouldBe
import org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CarsTest {

    @DisplayName("자동차 경주자가 있어야 합니다.")
    @Test
    fun empty() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                Cars(emptyList())
            }
            .withMessage("자동차 경주자가 있어야 합니다.")
    }

    @DisplayName("자동차 이름을 가져올 수 있습니다")
    @Test
    fun names() {
        val cars = Cars(
            listOf(
                Car(CarName("aaa"), Position(0)),
                Car(CarName("bbb"), Position(0)),
                Car(CarName("ccc"), Position(0))
            )
        )

        val result = cars.names()

        result shouldBe CarNames(listOf("aaa", "bbb", "ccc"))
    }

    @DisplayName("가장 많이 이동한 자동차를 찾습니다")
    @Test
    fun findMaximumPositionCar() {
        val cars = Cars(
            listOf(
                Car(CarName("aaa"), Position(1)),
                Car(CarName("bbb"), Position(3)),
                Car(CarName("ccc"), Position(5))
            )
        )

        val result = cars.findMostFarthestCar()

        result.names() shouldBe CarNames(listOf("ccc"))
    }
}
