@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes

@param LoginPage page

@template.layout.page(
    content = @`
        @if(page.getErrors() != null)
            <ul>
            @for(var validator: page.getErrors().values())
                @for(var error: validator)
                    <li>
                        ${error.getMessage()}
                    </li>
                @endfor
            @endfor
            </ul>
        @endif

        <form method="post" action="${NamedRoutes.loginPath()}">
            <div>
                <label>
                    <p>Login: </p>
                    <input type="text" required name="name" value="${page.getName()}">
                </label>
            </div>
            <div>
                <label>
                    <p>Password: </p>
                    <input type="password" required name="password">
                </label>
            </div>
            <input type="submit" value="Войти">
        </form>
    `
)
