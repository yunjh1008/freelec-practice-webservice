package com.jay.book.springboot.web;

import com.jay.book.springboot.service.PostsService.PostsService;
import com.jay.book.springboot.web.dto.PostsResponseDto;
import com.jay.book.springboot.web.dto.PostsSaveRequestDto;
import com.jay.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        System.out.println(">>>>>>>>>>>>>>>>>> Jay before delete");
        postsService.delete(id);
        System.out.println(">>>>>>>>>>>>>>>>>> Jay after delete");
        return id;
    }
}
