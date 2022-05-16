package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racing.domain.Car
import racing.domain.StaticPowerStrategy

class CarTest {

    @ParameterizedTest
    @CsvSource(
        value = [
            "10, 5, 1",
            " 7, 3, 1",
            " 3, 6, 0"
        ]
    )
    fun `임계점 이상의 값이 오면 전진, 아니면 정지한다`(power: Int, moveThreshold: Int, expect: Int) {
        with(Car(name = "", powerStrategy = StaticPowerStrategy(power), moveThreshold = moveThreshold)) {
            move()
            assertThat(position).isEqualTo(expect)
        }
    }
}
