package study.step3

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import step3.domain.MoveCarUseCase

class MoveCarUseCaseTest {

    private lateinit var moveCarUseCase: MoveCarUseCase

    @BeforeEach
    fun `MoveCarUseCae 초기 설정`() {
        moveCarUseCase = MoveCarUseCase()
        moveCarUseCase.initCarMovementCountList(1)
    }

    @Test
    fun `carCount 에 해당하는 count 확인`() {
        assertThat(moveCarUseCase.moveCar(0)).isEqualTo(moveCarUseCase.getCarMovementCountList(0).count)
    }

    @Test
    fun `경주 자동차가 없는 경우`() {
        assertThatThrownBy {
            MoveCarUseCase().moveCar(0)
        }.isInstanceOf(IndexOutOfBoundsException::class.java).hasMessage("The car does not exist.")
    }
}
