@import exercise.util.NamedRoutes;
@import exercise.dto.posts.PostsPage

@param PostsPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                  @if(page.getPosts() != null)
                    <ul>
                    @for(var post: page.getPostsList())
                        <li>
                            <a href='${NamedRoutes.postPath(post.getId())}'>
                                ${post.getName()}
                            </a>
                            <p>
                                ${post.getBody()}
                            </p>
                        </li>
                    @endfor
                    </ul>
                  @else
                    <p>Нет постов</p>
                  @endif

                  <div>
                    @if(page.getPage() != 1)
                    <a href="${NamedRoutes.postsPath()}?page=${(page.getPage() - 1)}">
                        Назад
                    </a>
                    @else
                    <a href="#">Назад</a>
                    @endif
                    @if(page.end() != page.getPosts().size())
                    <a href="${NamedRoutes.postsPath()}?page=${(page.getPage() + 1)}">
                        Вперед
                    </a>
                    @else
                    <a href="#">Назад</a>
                    @endif
                  </div>
            </main>
        </div>
    `
)
