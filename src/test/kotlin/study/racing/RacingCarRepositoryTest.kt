package study.racing

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import study.racing.domain.repository.RacingCarRepositoryImpl

class RacingCarRepositoryTest {

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `Power값이 4 이상일 경우에 전진한다`(power: Int) {
        val repo = RacingCarRepositoryImpl(RandomPowerSource())
        assert(repo.canMoveForward(power))
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3])
    fun `Power값이 4 미만일 경우에 정지한다`(power: Int) {
        val repo = RacingCarRepositoryImpl(RandomPowerSource())
        assert(!repo.canMoveForward(power))
    }
}