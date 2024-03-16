@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <form action="/users" method="get">
            <input type="search" name="term" value="${page.getTerm()}">
            <input type="submit" name="Искать">
        </form>

        @if (page.getUsers() != null)
            <ul>
            @for (var user: page.getUsers()) {
                <li>
                    ${user.getFirstName()} ${user.getLastName()}
                </li>
            }
            @endfor
            </ul>
        @endif
    `
)
