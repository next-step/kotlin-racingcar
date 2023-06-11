package racingcar.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RandomRaceMoveRuleTest {
    private fun sut(randomGenerator: RandomGenerator): RandomRaceMoveRule = RandomRaceMoveRule(randomGenerator)

    @Test
    fun `randomGenerator 로 생성한 랜덤값이 4 이상인 경우 true 를 반환한다`() {
        // given
        val sut = sut(TestStaticRandomGenerator(4))

        // when
        val result = sut.canMove(CarFactory.newCar())

        // then
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun `randomGenerator 로 생성한 랜덤값이 3 이하인 경우 false 를 반환한다`() {
        // given
        val sut = sut(TestStaticRandomGenerator(3))

        // when
        val result = sut.canMove(CarFactory.newCar())

        // then
        assertThat(result).isEqualTo(false)
    }
}

class TestStaticRandomGenerator(private val alwaysReturnNumber: Int) : RandomGenerator {
    override fun generate(from: Int, until: Int): Int {
        return alwaysReturnNumber
    }
}
