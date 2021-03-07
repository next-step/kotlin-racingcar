package racingcar.racing.car

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = ["남동민", "ABCDE", "한글다섯자", "12 45", "", "1"])
    fun `이름은 여백 포함 5자 이하면 생성되며, 이름을 조회하면 생성 시 이름이 조회된다`(name: String) {
        assertThat(CarName(name).name).isEqualTo(name)
    }

    @ParameterizedTest
    @ValueSource(strings = ["남동민", "ABCDE", "한글다섯자", "12 45", "", "1"])
    fun `각 인스턴스는 이름이 같으면 동일하다`(name: String) {
        assertThat(CarName(name)).isEqualTo(CarName(name))
    }

    @ParameterizedTest
    @ValueSource(strings = ["Mercedes Benz", "6자이상이름", "중간을 띄움", " 왼쪽보세요", "see->\t"])
    fun `이름은 여백 포함 6자 이상을 넘으면 IllegalArgumentException throw`(name: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { CarName(name) }
            .withMessage("The length of name must be less than 6. name='$name'")
    }
}
