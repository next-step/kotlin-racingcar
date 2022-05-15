package step3.model

import io.kotest.core.spec.style.FunSpec

class CarTest : FunSpec({

    test("move") {
        val car = Car(1)
        car.move()
    }
})
