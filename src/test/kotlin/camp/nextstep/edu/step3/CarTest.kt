package camp.nextstep.edu.step3

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class CarTest {

    @DisplayName("자동차는 트랙 위에서 달릴 수 있다.")
    @Test
    fun canRaceOnTrack() {
        val car = Car()
        val track = Track(5)

        car.raceOn(track, 3)
        TODO()
    }
}
