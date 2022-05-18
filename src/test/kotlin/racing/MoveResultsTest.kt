package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.model.CarMoveResult
import racing.model.MoveResults
import racing.model.Name
import racing.model.Position

class MoveResultsTest {
    @Test
    fun `최대로 이동한 자동차 이름 구하기 테스트`() {
        // given
        val moveResults = MoveResults(
            listOf(
                CarMoveResult(Name("이름1"), Position(10)),
                CarMoveResult(Name("이름2"), Position(16)),
                CarMoveResult(Name("이름3"), Position(13))
            )
        )

        // when
        val names = moveResults.getMaxPositionCarNames()

        // then
        assertThat(names.names[0].value).isEqualTo("이름2")
    }
}
