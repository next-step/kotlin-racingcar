package carracinggame

import carracinggame.core.domain.DetermineCarMovementUseCase
import carracinggame.feature.CarRacingGameController
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarRacingGameModelTest {
    private lateinit var carRacingGameController: CarRacingGameController

    @BeforeEach
    fun setUp() {
        carRacingGameController = CarRacingGameController()
    }

    @Test
    fun `initializeGameState를 처리하면 게임 상태가 올바르게 초기화된다`() {
        val carNamesInput = "car1,car2"
        val attemptCountInput = "3"

        carRacingGameController.initializeGameState(carNamesInput, attemptCountInput)

        assertThat(carRacingGameController.cars)
            .hasSize(2)
            .extracting<String> { it.name }
            .containsExactly("car1", "car2")
        assertThat(carRacingGameController.cars).allMatch { it.totalDistance == 0 }
        assertThat(carRacingGameController.attemptCount).isEqualTo(3)
    }

    @Test
    fun `잘못된 attemptCountInput으로 initializeGame를 처리하면 예외가 발생한다`() {
        val carNamesInput = "car1,car2"
        val attemptCountInput = "invalid"

        assertThatThrownBy { carRacingGameController.initializeGameState(carNamesInput, attemptCountInput) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("유효한 숫자를 입력해주세요.")
    }

    @Test
    fun `자동차 이름이 5자를 초과하면 예외가 발생한다`() {
        val carNamesInput = "longname1,car2"
        val attemptCountInput = "5"

        assertThatThrownBy { carRacingGameController.initializeGameState(carNamesInput, attemptCountInput) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("자동차 이름은 5자를 초과할 수 없습니다")
    }

    @Test
    fun `updateCarState를 처리하면 자동차 상태가 업데이트된다`() {
        carRacingGameController =
            CarRacingGameController(DetermineCarMovementUseCase(TestNumberGeneratorImpl(listOf(4, 5, 4, 5, 4, 5))))

        val carNamesInput = "car1,car2"
        val attemptCountInput = "3"

        carRacingGameController.initializeGameState(carNamesInput, attemptCountInput)

        carRacingGameController.updateCarDistance()
        assertThat(carRacingGameController.cars[0].totalDistance).isEqualTo(0) // 첫 번째 자동차는 이동하지 않음
        assertThat(carRacingGameController.cars[1].totalDistance).isEqualTo(1) // 두 번째 자동차는 이동

        carRacingGameController.updateCarDistance()
        assertThat(carRacingGameController.cars[0].totalDistance).isEqualTo(0)
        assertThat(carRacingGameController.cars[1].totalDistance).isEqualTo(2)

        carRacingGameController.updateCarDistance()
        assertThat(carRacingGameController.cars[0].totalDistance).isEqualTo(0)
        assertThat(carRacingGameController.cars[1].totalDistance).isEqualTo(3)
    }

    @Test
    fun `게임 종료 후 우승자가 올바르게 결정된다`() {
        carRacingGameController =
            CarRacingGameController(DetermineCarMovementUseCase(TestNumberGeneratorImpl(listOf(5, 5, 5, 5, 5, 5))))

        val carNamesInput = "car1,car2"
        val attemptCountInput = "3"
        carRacingGameController.initializeGameState(carNamesInput, attemptCountInput)

        repeat(3) {
            carRacingGameController.updateCarDistance()
        }

        assertThat(carRacingGameController.formatWinnerNames()).isEqualTo("car1, car2") // Both cars have same distance
    }
}
