package com.laczkoattilalaszlo.stub.service

class NumberProvider() {

    private val value: Int = 123

    fun provideNumber(): Int {
        return value
    }

}