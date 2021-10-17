package racingcar.domain

import java.util.stream.Collectors

/**
 * 자동차 목록.
 */
data class Cars(val cars: List<Car>) {
    /**
     * 자동차를 이동하고 변경된 자동차 목록을 리턴한다.
     */
    fun move(): Cars {
        return Cars(
            cars.stream()
                .map { it.moveForward() }
                .collect(Collectors.toList())
        )
    }

    fun size(): Int {
        return cars.size
    }

    companion object {
        val EMPTY = Cars(emptyList())

        /**
         * 입력받은 대수만큼 자동차 목록을 생성하여 리턴한다.
         */
        fun createCars(count: Int): Cars = Cars((1..count).map { Car() })
    }
}
