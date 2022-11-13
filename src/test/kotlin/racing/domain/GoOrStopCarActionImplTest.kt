package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.model.CarAction

internal class GoOrStopCarActionImplTest {

    private lateinit var goOrStopCarAction: GoOrStopCarAction
    private lateinit var moveStrategy: MoveStrategy
    
    @ParameterizedTest
    @ValueSource(booleans = [true])
    fun `경주용 자동차 이동 조건이 되었을 때`(move: Boolean) {
        moveStrategy = FakeRandomMoveStrategy(move)
        goOrStopCarAction = GoOrStopCarActionImpl(
            moveStrategy = moveStrategy
        )
        assertThat(goOrStopCarAction.castCarAction()).isEqualTo(CarAction.GO)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false])
    fun `경주용 자동차 이동 조건이 안되었을 때`(move: Boolean) {
        moveStrategy = FakeRandomMoveStrategy(move)
        goOrStopCarAction = GoOrStopCarActionImpl(
            moveStrategy = moveStrategy
        )
        assertThat(goOrStopCarAction.castCarAction()).isEqualTo(CarAction.STOP)
    }
}
