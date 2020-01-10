package com.example.kotwitter.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/tweets") // ①
class DisplayController {

    // map<id, value>
var tweetList = mutableMapOf(1 to "aaa", 2 to "bbb", 3 to "ccc")

    // 一覧表示
    @RequestMapping(value = [""], method = [RequestMethod.GET])
    fun findAll(model: Model): String {
        model.addAttribute("tweets", tweetList)
        return "index" // Thymeleaf テンプレートファイル名
    }

    // 登録
    @PostMapping
    fun create(@RequestParam new_tweet: String, model: Model): String {
        tweetList.putIfAbsent(tweetList.size + 1, new_tweet)
        model.addAttribute("tweets", tweetList)
        return "index"
    }

    // 詳細
    @GetMapping("{id}")
    fun detail(@PathVariable id: Int, model: Model): String {
        model.addAttribute("tweet", tweetList[id])
        return "Detail"
    }

    // 更新
    // TODO: method=postからputに変更したい
    @PostMapping("update/{id}")
    fun update(@PathVariable id: Int, @RequestParam update_tweet: String, model: Model): String {
        tweetList[id] = update_tweet
        model.addAttribute("tweets", tweetList)
        return "redirect:/tweets/{id}"
    }

    // 削除
    // TODO: method=postからdeleteに変更したい
    @PostMapping("delete")
    fun delete(@RequestParam tweet_id: Int, model: Model): String {
        tweetList.remove(tweet_id)
        model.addAttribute("tweets", tweetList)
        return "index"
    }
}