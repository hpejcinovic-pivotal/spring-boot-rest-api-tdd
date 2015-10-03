package io.pivotal.chicago.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultPostService implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public PostResponse createPost(PostRequest postRequest) {
        Post post = new Post();
        post.setTitle(postRequest.getTitle());

        post = postRepository.save(post);

        PostResponse postResponse = new PostResponse();
        postResponse.setId(post.getId());
        postResponse.setTitle(post.getTitle());
        return postResponse;
    }
}