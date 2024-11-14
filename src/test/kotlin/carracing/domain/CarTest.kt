package carracing.domain

import io.kotest.core.spec.style.StringSpec
import org.junit.jupiter.api.Assertions.assertEquals

class CarTest : StringSpec({
    "move should increase position" {
        val car = Car()
        car.move()
        assertEquals(1, car.position)
    }
})
