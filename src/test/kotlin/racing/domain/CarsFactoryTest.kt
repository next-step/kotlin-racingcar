package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.view.GameInputView

internal class CarsFactoryTest {

    @ParameterizedTest
    @ValueSource(strings = ["1,2,3", "A,B,C,D"])
    fun `자동차 이름들로 생성 요청하여 동일한 자동차 수 반환`(names: String) {
        val nameOfCars = GameInputView.splitNameOfCars(names)
        val cars = CarsFactory.createCars(nameOfCars)
        assertThat(cars.size).isEqualTo(nameOfCars.size)
    }
}
