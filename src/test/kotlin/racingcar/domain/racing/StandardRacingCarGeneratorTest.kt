package racingcar.domain.racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.car.CarName

internal class StandardRacingCarGeneratorTest {
    private lateinit var generator: RacingCarGenerator

    @BeforeEach
    fun setUp() {
        generator = StandardRacingCarGenerator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["남동민", "ABCDE", "한글다섯자", "12 45", "", "1"])
    fun `차 생산 시, 넣어준 이름과 똑같은 이름의 차가 생성된다`(name: String) {
        Assertions.assertThat(generator.generate(CarName(name)).name).isEqualTo(CarName(name))
    }
}
