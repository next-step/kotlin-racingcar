package racing.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `전진 정상 케이스`(input: Int) {
        val car = Car(name = "부부")
        val pedal = Pedal(0)
        for (i in 1..input) {
            assertThat(car.moveForward(pedal)).isEqualTo(Pair("부부", i))
        }
    }

    @Test
    fun `자동차 이름이 5자 초과인 테스트`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { Car(name = "안녕하세요. 반갑습니다") }
            .withMessage("자동차 이름은 5자를 초과할 수 없습니다.")
    }
}
