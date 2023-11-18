package racingcar

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.Cars

class CarsTest {
    @ValueSource(strings = ["test,123,ㅅㄷㅈ", "민균,한솔,재성"])
    @ParameterizedTest
    fun `각 자동차 이름을 구분자(,)로 구분한다`(param: String) {
        val cars = Cars.of(param)
        cars.cars shouldBe param.split(",")
    }
}
