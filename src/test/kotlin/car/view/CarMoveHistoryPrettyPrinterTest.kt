package car.view

import car.domain.CarMoveHistory
import car.domain.CarName
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarMoveHistoryPrettyPrinterTest {
    @Test
    fun `이쁘게 나오는지 확인해보자`() {
        val history = CarMoveHistory(CarName("Soora"), 5)
        val pretty = CarMoveHistoryPrettyPrinter(history, "@")

        assertThat(pretty.toString())
            .isEqualTo("Soora : @@@@@")
    }
}
