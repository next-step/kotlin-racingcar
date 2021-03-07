package racingcar_winner

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar_winner.model.Cars

class CarsTest {

    @Test
    fun `이름중에 5글자 이상인 글자가 존재할 때 Exception 발생`() {
        val list = listOf("Johnson", "dfdf", "dffff")
        assertThrows<IllegalArgumentException> { Cars.convertNamesToCar(list) }
    }
}
