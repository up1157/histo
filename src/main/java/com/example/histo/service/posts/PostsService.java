package com.example.histo.service.posts;

import com.example.histo.domain.posts.Posts;
import com.example.histo.domain.posts.PostsRepository;
import com.example.histo.web.dto.PostsListResponseDto;
import com.example.histo.web.dto.PostsResponseDto;
import com.example.histo.web.dto.PostsSaveRequestDto;
import com.example.histo.web.dto.PostsUpdateRequestDto;
//import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id)); //트랜젝션 안에서 데이터 호출 - 영속성 컨텍스트 유지
        posts.update(requestDto.getTitle(), requestDto.getContent()); //더티체킹 업데이트
        return id;
    }

    public PostsResponseDto findById(Long id){

        Posts entity= postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly=true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepository.delete(posts);
    }


}
