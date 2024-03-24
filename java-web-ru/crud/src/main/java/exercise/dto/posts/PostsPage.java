package exercise.dto.posts;

import java.util.List;
import exercise.model.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;


// BEGIN
@Getter
@AllArgsConstructor
public class PostsPage {
    private static final int PAGING = 5;
    private List<Post> posts;
    //private String term;
    private int page;
    private int per;

    public PostsPage(List<Post> posts, int page) {
        this(posts, page, PAGING);
    }

    public List<Post> getPostsList() {
        if (start() == -1) {
            return List.of();
        }
        return posts.subList(start(), end());
    }

    public int start() {
        int start = (page - 1) * per;
        if (start < posts.size()) {
            return start;
        }
        return -1;
    }

    public int end() {
        int end = page * per;
        if (end <= posts.size()) {
            return end;
        }
        return posts.size();
    }
}
// END


