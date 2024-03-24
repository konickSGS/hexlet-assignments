package exercise.controller;

import java.util.List;
import java.util.Collections;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.NotFoundResponse;
import io.javalin.http.Handler;

public class PostsController {
    // BEGIN
    public static Handler showPost = ctx -> {
        Long id = ctx.pathParamAsClass("id", Long.class)
            .getOrDefault(null);
        Post post = PostRepository.find(id)
            .orElseThrow(() -> new NotFoundResponse("Post not found"));

        PostPage page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    };

    public static Handler listPosts = ctx -> {
        Integer page = ctx.queryParamAsClass("page", Integer.class)
            .getOrDefault(1);
        Integer per = ctx.queryParamAsClass("per", Integer.class)
            .getOrDefault(5);

        List<Post> posts = PostRepository.getEntities();
        PostsPage postsPage = new PostsPage(posts, page, per);

        ctx.render("posts/index.jte", Collections.singletonMap("page", postsPage));
    };
    // END
}
