package com.example.kotwitter.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/tweets") // ①
class DisplayController {

var tweetList = mutableListOf("aaa", "bbb", "ccc")

    // 一覧表示
    @RequestMapping(value = [""], method = [RequestMethod.GET])
    fun findAll(model: Model): String {
        model.addAttribute("tweets", tweetList)
        return "index" // Thymeleaf テンプレートファイル名
    }

    // 登録
    @PostMapping
    fun create(@ModelAttribute new_tweet: String, model: Model): String {
        tweetList.add(new_tweet)
        model.addAttribute("tweets", tweetList)
        return "index"
    }
}