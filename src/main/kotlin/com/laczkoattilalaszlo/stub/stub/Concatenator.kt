package com.laczkoattilalaszlo.stub.stub

class Concatenator(
    private val textProvider: TextProvider,
    private val numberProvider: NumberProvider
) {

    fun concatenate(): String {
        return textProvider.provideText() + numberProvider.provideNumber()
    }
}