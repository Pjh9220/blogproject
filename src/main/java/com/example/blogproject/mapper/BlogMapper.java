package com.example.blogproject.mapper;
import java.util.*;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper {
    public List<Map<String,Object>> select();
    public void insert(String memberId, String memberName, String content, String nickname);
    public void delete(String memberId, String seq);
    public void update(String content, String nickname, String seq);
    public void insertcnt(String mmemberId);
    public Map<String,Object> totalcnt();
    public Map<String,Object> todaycnt();
    public void writepost(String memberName, String content, String memberId);
    public List<Map<String,Object>> selectguestbook();
    public void deleteguestbook(String memberId, String seq);
    public void updateguestbook(String content, String seq);
    public void insertguestbookcomment(String memberId, String comment, String memberName, String seq);
    public List<Map<String,Object>> selectguestbookcomment();
    public void deleteguestbookcomment(String memberId, String commentseq);
    public Map<String,Object> boardtotalcnt();
    public Map<String,Object> boardtodaycnt();
    public Map<String,Object> guestbooktotalcnt();
    public Map<String,Object> guestbooktodaycnt();
};
