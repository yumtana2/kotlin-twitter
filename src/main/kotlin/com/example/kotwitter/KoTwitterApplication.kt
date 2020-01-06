package com.example.kotwitter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KoTwitterApplication

fun main(args: Array<String>) {
	runApplication<KoTwitterApplication>(*args)
}
