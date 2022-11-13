package racingcar.domain

@JvmInline
value class Cars(val value: List<Car> = emptyList()) {

    fun racing(): Cars {
        var cars = Cars()
        value.forEach { car ->
            cars += if (isMove())
                car.moveCar()
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
        const val TERMS_OF_RACING_MIN = 0
        const val TERMS_OF_RACING_MAX = 10

        const val TERMS_OF_RACING = 4
    }

}