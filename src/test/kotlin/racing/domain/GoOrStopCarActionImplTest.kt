package racing.domain

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever
import racing.model.CarAction

internal class GoOrStopCarActionImplTest {

    private lateinit var goOrStopCarAction: GoOrStopCarAction
    private val randomMovingCarConditionNumber: RandomMovingCarConditionNumber = mock()

    @BeforeEach
    fun setUp() {
        goOrStopCarAction = GoOrStopCarActionImpl(
            randomMovingCarConditionNumber = randomMovingCarConditionNumber
        )
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 102])
    fun `경주용 자동차 이동 조건이 4이상일 때`(count: Int) {
        whenever(randomMovingCarConditionNumber.random()).thenReturn(count)
        assertThat(goOrStopCarAction.castCarAction()).isEqualTo(CarAction.GO)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `경주용 자동차 이동 조건이 4미만일 때`(count: Int) {
        whenever(randomMovingCarConditionNumber.random()).thenReturn(count)
        assertThat(goOrStopCarAction.castCarAction()).isEqualTo(CarAction.STOP)
    }
}
