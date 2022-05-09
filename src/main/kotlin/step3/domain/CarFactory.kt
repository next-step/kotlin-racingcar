package step3.domain

import step3.model.Car

fun interface CarFactory {
    fun create(): Car
}