package car.view.print

import car.domain.history.CarMoveHistory
import car.domain.CarName
import car.domain.Position
import car.view.input.PrettyPrinterInput
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarMoveHistoryPrettyPrinterTest {
    @Test
    fun `CarMoveHistory가 원하는 문자로 나오도록 테스트한다`() {
        val history = CarMoveHistory(CarName("Soora"), Position(5))
        val pretty = CarMoveHistoryPrettyPrinter(history, "@")

        assertThat(pretty.toString())
            .isEqualTo("Soora : @@@@@")
    }
}
