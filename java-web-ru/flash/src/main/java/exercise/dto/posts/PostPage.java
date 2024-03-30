package exercise.dto.posts;

import exercise.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

import exercise.dto.BasePage;

@AllArgsConstructor
@Getter
public class PostPage extends BasePage {
    private Post post;
}
