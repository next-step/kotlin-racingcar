package study.carRace

import org.junit.jupiter.api.Test
import study.CarRace
import java.io.ByteArrayInputStream
import java.io.InputStream

class CarRaceTest {

    companion object {
        val carRace = CarRace()
    }

    @Test
    fun movement() {
        val input = "3\n5\n"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        carRace.start()
    }
}