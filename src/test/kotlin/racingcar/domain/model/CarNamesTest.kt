package racingcar.domain.model

import io.kotest.matchers.collections.shouldContainInOrder
import org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CarNamesTest {

    @DisplayName("자동차 이름이 있어야 합니다")
    @Test
    fun createByEmptyList() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                CarNames()
            }
            .withMessage("자동차 이름이 있어야 합니다")
    }

    @DisplayName("자동차 이름으로 자동차를 생성합니다")
    @Test
    fun createCar() {
        val carNames = CarNames(listOf("aaa", "bbb", "ccc"))

        val cars = carNames.makeCars()

        cars.names() shouldContainInOrder listOf("aaa", "bbb", "ccc")
    }
}
