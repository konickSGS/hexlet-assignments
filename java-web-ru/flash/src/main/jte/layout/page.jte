<!-- BEGIN -->
@import exercise.dto.BasePage
@import exercise.util.NamedRoutes
@import gg.jte.Content

@param Content content
@param BasePage page = null

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>Hexlet Javalin Example</title>
</head>
<body>
    <header>
        <nav>
            <div>
                <a href="${NamedRoutes.postsPath()}">
                    Все посты
                </a>
                <a href="${NamedRoutes.buildPostPath()}">
                    Создать новый пост
                </a>
            </div>
        </nav>
    </header>

    <main>
        @if(page != null && page.getFlash() != null)
            <p>
                page.getFlash()
            </p>
        @endif
        ${content}
    </main>
</body>
</html>
<!-- END -->
