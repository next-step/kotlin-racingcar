package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = ["Kobe", "Jason", "Curry"])
    fun `운전자 이름이 5자 이하인 경우`(driver: String) {
        assertThat(CarName(driver)).isNotNull
    }

    @ParameterizedTest
    @ValueSource(strings = ["Kobe Bryant", "Jason Kids", "Steffan Curry", "LeBron Jame"])
    fun `운전자 이름이 5자 초과하는 경우`(driver: String) {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            CarName(driver)
        }
    }
}
