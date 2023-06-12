package racing.view.result

import racing.model.Car

class BasicCarResultView : CarResultView {
    override fun render(car: Car) {
        println("-".repeat(car.dist))
    }
}
