package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.PageRequest;
import com.example.feiyang.entity.PageResult;
import com.example.feiyang.entity.Post;
import com.example.feiyang.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static com.example.feiyang.controller.BaseController.OK;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;


    @RequestMapping("/add")
    public JsonResponse<Post> addPost(@RequestBody Map<String, Object> params) {
        Post data = postService.addPost(params);
        return new JsonResponse<>(OK, data);
    }

    ;

    @RequestMapping("/update")
    public JsonResponse<Post> updatePostStatus(@RequestParam("postId") Long postId) {
        Post data = postService.updatePostStatus(postId);
        return new JsonResponse<>(OK, data);
    }

    @RequestMapping("/delete")
    public JsonResponse<Void> deletePost(@RequestParam("postId") Integer postId) {
        postService.deletePost(Long.valueOf(postId));
        return new JsonResponse<>(OK);
    }

    @RequestMapping("/all")
    public JsonResponse<Map> selectAllByCondition(Long userId, Long relatedQuestionId) {
        Map<String, Object> data = postService.selectAllByCondition(userId, relatedQuestionId);
        return new JsonResponse<>(OK, data);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/postAndQuesion")
    public JsonResponse getAllPostAndQuestion(@RequestBody PageRequest pageQuery) {
        Map<String, Object> res = new HashMap<>();
        PageResult allPosts = postService.getAllPostAndQuestions(pageQuery);

        res.put("posts", allPosts);
        return JsonResponse.success(res, "查询成功！");
    }
}
