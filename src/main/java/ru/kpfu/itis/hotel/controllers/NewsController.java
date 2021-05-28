package ru.kpfu.itis.hotel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.hotel.dto.TagDto;
import ru.kpfu.itis.hotel.models.News;
import ru.kpfu.itis.hotel.services.NewsService;

import javax.annotation.security.PermitAll;
import java.util.List;

/**
 * 10.02.2021
 * 06.Hotel
 *
 * @author Shamil Nurkaev @nshamil
 * 11-903
 */

@Controller
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @PermitAll
    @GetMapping("/news")
    public String getAvailabilityPage(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        model.addAttribute("isAuthenticated", userDetails != null);
        return "news_page";
    }

    @PostMapping("/news")
    @PermitAll
    public @ResponseBody
    List<News> getNews(@RequestBody TagDto tagDto, Model model) {
        System.out.println("tagDto = " + tagDto);
        System.out.println("1. Ошибка с новостями 1.");
        System.out.println("newsService.findByTag = " + newsService.findByTag(tagDto.getTagName()));
        System.out.println("newsService.findByTag = " + newsService.findByTag(tagDto.getTagName()));
        System.out.println("2. Ошибка с новостями 2.");
//        tagDto.setTagName("\"" + tagDto.getTagName());

        return newsService.findByTag(tagDto.getTagName());
    }
}
