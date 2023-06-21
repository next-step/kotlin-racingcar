package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = ["abcdef", "abcdefg", "abcdefgh", "abcdefghi"])
    fun `자동차의 이름이 5자보다 많으면 에러 발생`(name: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { CarName(name) }
    }

    @ParameterizedTest
    @EmptySource
    fun `자동차의 이름이 공백이면 에러 발생`(name: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { CarName(name) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["test", "test1", "test2"])
    fun `이름이 같으면 같은 CarName 객체`(name: String) {
        val first = CarName(name)
        val second = CarName(name)
        assertThat(first).isEqualTo(second)
    }

}