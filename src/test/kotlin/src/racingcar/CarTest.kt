package src.racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차는 한번에 두번 이상 움직일 수 없다`() {
        val moveCount = Car().move()

        Assertions.assertThat(moveCount).isLessThan(2)
    }
}
