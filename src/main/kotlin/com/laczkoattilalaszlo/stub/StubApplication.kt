package com.laczkoattilalaszlo.stub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class StubApplication

fun main(args: Array<String>) {
	runApplication<StubApplication>(*args)
}
