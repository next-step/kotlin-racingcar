package racing.view.result

import racing.model.Car

interface CarResultView {
    fun render(car: Car)
}
