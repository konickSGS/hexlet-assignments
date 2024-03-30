@import exercise.dto.MainPage
@import exercise.util.NamedRoutes

@param MainPage page

@template.layout.page(
    content = @`
        @if(page.getName() != null)
            <h1>${page.getName().toString()}</h1>
            <form method="post" action="${NamedRoutes.logoutPath()}">
                <div>
                    <label>
                        <p>Выйти</p>
                        <input type="submit" value="Выйти">
                    </label>
                </div>
            </form>
        @else
            <a href="${NamedRoutes.buildSessionPath()}">
                Войти
            </a>
        @endif
    `
)
