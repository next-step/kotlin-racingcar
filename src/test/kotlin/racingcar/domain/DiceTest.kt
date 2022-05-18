package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

/**
 * Created by Jaesungchi on 2022.05.15..
 */
class DiceTest {
    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `주사위 숫자가 4이상일때 전진이 가능한 상태인가`(source: Int) {
        assertThat(Dice.rollDiceAndGetIsCanGo(source)).isTrue
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `주사위 숫자가 3이하일때 전진이 안되는 상태인가`(source: Int) {
        assertThat(Dice.rollDiceAndGetIsCanGo(source)).isFalse
    }
}
