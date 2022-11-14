package racingcar.domain

class Cars(val value: List<Car> = emptyList()) {

    fun racing(): Cars {
        var cars = Cars()
        value.forEach { car ->
            cars += if (isMove())
                car.move()
             else
                car
        }

        return cars
    }

    operator fun plus(car: Car): Cars {
        return Cars(value + car)
    }

    private fun isMove(): Boolean {
        return (TERMS_OF_RACING_MIN..TERMS_OF_RACING_MAX).random() > TERMS_OF_RACING
    }

    companion object {
        private const val TERMS_OF_RACING_MIN = 0
        private const val TERMS_OF_RACING_MAX = 10

        private const val TERMS_OF_RACING = 4
    }

}