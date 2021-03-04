package racingcar_winner

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import racingcar_winner.model.Car
import racingcar_winner.model.Car.Companion.makeCar
import racingcar_winner.model.Cars
import java.util.stream.Stream

class CarsTest {

    @Test
    fun `이름중에 5글자 이상인 글자가 존재할 때 Exception 발생`() {
        val list = listOf("Johnson", "dfdf", "dffff")
        assertThrows<IllegalArgumentException> { Cars.convertNamesToCar(list) }
    }

}
