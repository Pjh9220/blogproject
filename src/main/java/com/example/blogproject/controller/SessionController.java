package com.example.blogproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;

import com.example.blogproject.model.Member;
import com.example.blogproject.repository.MemberRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {
    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/login")
    public String login(){
        return "html/login";
    }
    
    @PostMapping("/login")
    public String loginPost(@RequestParam("memberId") String memberId,
                            @RequestParam("memberPw") String memberPw,
                            HttpSession session){
            Member member;
            member = memberRepository.findByMemberIdAndMemberPw(memberId, memberPw);
            session.setAttribute("member", member);
            return "redirect:/main";  
    }

    @GetMapping("/main")
    public String main(){
        return "html/main";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/main";
    }

    @GetMapping("/register")
    public String register(){
        return "html/register";
    }
    @GetMapping("/registersuccess")
    public String registerSuccess(){
        return "html/registersuccess";
    }

    @PostMapping("/register")
    public String registerPost(
                    @RequestParam("memberId") String memberId,
                    @RequestParam("memberPw") String memberPw,
                    @RequestParam("memberName") String memberName){
        Member member = new Member();
        member.setMemberId(memberId);
        member.setMemberPw(memberPw);
        member.setMemberName(memberName);
        memberRepository.save(member);
        return "redirect:/registersuccess";
    }
}
