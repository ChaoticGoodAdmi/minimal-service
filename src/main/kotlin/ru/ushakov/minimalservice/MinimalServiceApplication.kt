package ru.ushakov.minimalservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MinimalServiceApplication

fun main(args: Array<String>) {
    runApplication<MinimalServiceApplication>(*args)
}
