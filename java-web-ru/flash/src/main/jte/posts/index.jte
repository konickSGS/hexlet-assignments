@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes

@param PostsPage page

@template.layout.page(
    content = @`
        @for(var post: page.getPosts())
        <ul>
            <li>
                <a href="${NamedRoutes.postPath(post.getId())}">
                    ${post.getName()}
                </a>
            </li>
        </ul>
        @endfor
 `
)