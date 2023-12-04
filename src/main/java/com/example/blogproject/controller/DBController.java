package com.example.blogproject.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.blogproject.mapper.BlogMapper;

import jakarta.servlet.http.HttpSession;

// import jakarta.servlet.http.HttpSession;

@Controller
public class DBController {
    @Autowired
    BlogMapper blogmapper;

    @GetMapping("/blog")
    public String test(HttpSession session, Model model,Model guestbook, Model guestbookcomment){

        List<Map<String,Object>> data = blogmapper.select();
        model.addAttribute("data", data);

        Map<String,Object> cnt = blogmapper.totalcnt();
        model.addAttribute("cnt", cnt);

        Map<String,Object> todaycnt = blogmapper.todaycnt();
        model.addAttribute("todaycnt", todaycnt);

        List<Map<String,Object>> guestbooklist = blogmapper.selectguestbook();
        guestbook.addAttribute("guestbooklist", guestbooklist);

        List<Map<String,Object>> guestbookcommentlist = blogmapper.selectguestbookcomment();
        guestbookcomment.addAttribute("guestbookcommentlist", guestbookcommentlist);

        Map<String,Object> boardtotalcnt = blogmapper.boardtotalcnt();
        model.addAttribute("boardtotalcnt", boardtotalcnt);

        Map<String,Object> boardtodaycnt = blogmapper.boardtodaycnt();
        model.addAttribute("boardtodaycnt", boardtodaycnt);

        Map<String,Object> guestbooktotalcnt = blogmapper.guestbooktotalcnt();
        model.addAttribute("guestbooktotalcnt", guestbooktotalcnt);

        Map<String,Object> guestbooktodaycnt = blogmapper.guestbooktodaycnt();
        model.addAttribute("guestbooktodaycnt", guestbooktodaycnt);
        
        return "html/index";
    }

    @PostMapping("/blog")
    public String updateCnt(
        @RequestParam("memberId") String memberId
    ){
        blogmapper.insertcnt(memberId);
        return "redirect:/blog";
    }

    @PostMapping("/blog/uproad")
    public String uploadPost(
        HttpSession session,
        @RequestParam("memberId") String memberId,
        @RequestParam("memberName") String memberName,
        @RequestParam("content") String content,   
        @RequestParam("nickname") String nickname
    ){blogmapper.insert(memberId,memberName,content,nickname);
        return "redirect:/blog";
    }

    @PostMapping("blog/delete")
    public String deletePost(
        HttpSession session,
        @RequestParam("memberId") String memberId, 
        @RequestParam("seq") String seq
    ){blogmapper.delete(memberId,seq);
        return "redirect:/blog";
    }

    @PostMapping("blog/update")
    public String updatePost(
        @RequestParam("content") String content,
        @RequestParam("nickname") String nickname,
        @RequestParam("seq") String seq
    ){blogmapper.update(content,nickname,seq);
        return "redirect:/blog";
    }
    @PostMapping("blog/writepost")
    public String writepost(
        @RequestParam("writename") String memberName,
        @RequestParam("writecontent") String content,
        @RequestParam("memberId") String memberId
    ){blogmapper.writepost(memberName,content,memberId);
        return "redirect:/blog";
    }

    @PostMapping("blog/deleteguestbook")
    public String deleteguest(
        @RequestParam("memberId") String memberId,
        @RequestParam("seq") String seq
    ){blogmapper.deleteguestbook(memberId,seq);
        return "redirect:/blog";
    }

    @PostMapping("blog/updateguestbook")
    public String updateguest(
        @RequestParam("content") String content,
        @RequestParam("seq") String seq
    ){blogmapper.updateguestbook(content, seq);
        return "redirect:/blog";
    }
    
    @PostMapping("blog/guestbookcomment")
    public String commentinsert(
        @RequestParam("memberId") String memberId,
        @RequestParam("comment") String comment,
        @RequestParam("memberName") String memberName,
        @RequestParam("seq") String seq
    ){blogmapper.insertguestbookcomment(memberId, comment, memberName, seq);
        return "redirect:/blog";
    }

    @PostMapping("blog/deleteguestbookcomment")
    public String deletecomment(
        @RequestParam("memberId") String memberId,
        @RequestParam("commentseq") String commentseq
    ){blogmapper.deleteguestbookcomment(memberId, commentseq);
        return "redirect:/blog";
    }
}
