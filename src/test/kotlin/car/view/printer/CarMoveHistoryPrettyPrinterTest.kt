package car.view.printer

import car.domain.history.CarMoveHistory
import car.domain.CarName
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarMoveHistoryPrettyPrinterTest {
    @Test
    fun `CarMoveHistory가 원하는 문자로 나오도록 테스트한다`() {
        val history = CarMoveHistory(CarName("Soora"), 5)
        val pretty = CarMoveHistoryPrettyPrinter(history, "@")

        assertThat(pretty.toString())
            .isEqualTo("Soora : @@@@@")
    }
}
