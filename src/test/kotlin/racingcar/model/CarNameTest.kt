package racingcar.model

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarNameTest {

    @ParameterizedTest(name = "{0} 이름을 가진 자동차는 5자를 초과해 에러가 발생한다.")
    @ValueSource(strings = ["abcdef, sonata, aventaN"])
    fun `자동차 이름이 5자를 초과할 경우 에러가 발생한다`(name: String) {
        assertThrows<IllegalArgumentException> { CarName(name) }
    }
}
