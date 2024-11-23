package misson.car.domain

class CarPositionFormatter {
    companion object {
        fun formatCarPosition(car: RacingCar): String {
            return "자동차 ${car.name} : ${formatPosition(car.position)}"
        }

        fun formatPosition(position: Int): String {
            return "-".repeat(position)
        }
    }
}
