package com.example.feiyang.controller;

import com.example.feiyang.common.utils.JsonResponse;
import com.example.feiyang.entity.Post;
import com.example.feiyang.entity.PostAndQuestion;
import com.example.feiyang.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.feiyang.controller.BaseController.OK;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    /**
     * 添加帖子
     *
     * @param params
     * @return
     */
    @RequestMapping("/add")
    public JsonResponse<Post> addPost(@RequestBody Map<String, Object> params) {
        Post data = postService.addPost(params);
        return new JsonResponse<>(OK, data);
    }

    /**
     * 修改帖子
     *
     * @param postId
     * @return
     */
    @RequestMapping("/update")
    public JsonResponse<Post> updatePostStatus(@RequestParam("postId") Long postId) {
        Post data = postService.updatePostStatus(postId);
        return new JsonResponse<>(OK, data);
    }

    /**
     * 删除帖子
     *
     * @param postId
     * @return
     */
    @RequestMapping("/delete")
    public JsonResponse<Void> deletePost(@RequestParam("postId") Integer postId) {
        postService.deletePost(Long.valueOf(postId));
        return new JsonResponse<>(OK);
    }

    /**
     * 按条件查看帖子
     *
     * @param userId
     * @param relatedQuestionId
     * @return
     */
    @RequestMapping("/all")
    public JsonResponse<Map> selectAllByCondition(Long userId, Long relatedQuestionId) {
        Map<String, Object> data = postService.selectAllByCondition(userId, relatedQuestionId);
        return new JsonResponse<>(OK, data);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/postAndQuestion")
    public JsonResponse getAllPostAndQuestion(@PathParam("pageNum") Integer pageNum, @PathParam("pageSize") Integer pageSize) {
        Map<String, Object> res = new HashMap<>();
        List<PostAndQuestion> allPosts = postService.getAllPostAndQuestions(pageNum, pageSize);

        res.put("posts", allPosts);
        res.put("totalCount", postService.getPostNum());
        return JsonResponse.success(res, "查询成功！");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getNoExamine")
    public JsonResponse getNoExamine() {
        Map<String, Object> res = new HashMap<>();

        List<PostAndQuestion> postAndQuestions = postService.getNoExamine();
        res.put("posts", postAndQuestions);
        res.put("totalCount", postAndQuestions.size());

        return JsonResponse.success(res, "查询成功！");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/get")
    public JsonResponse getPostById(@PathParam("post_id") Long post_id) {
        Map<String, Object> res = new HashMap<>();

        PostAndQuestion post = postService.getPostById(post_id);
        res.put("post", post);

        return JsonResponse.success(res, "查询成功!");
    }
}
