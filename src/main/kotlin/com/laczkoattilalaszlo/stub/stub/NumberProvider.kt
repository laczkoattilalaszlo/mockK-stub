package com.laczkoattilalaszlo.stub.stub

class NumberProvider() {

    private val value: Int = 123

    fun provideNumber(): Int {
        return value
    }

}