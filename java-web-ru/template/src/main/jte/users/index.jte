@import exercise.dto.users.UsersPage
@param UsersPage users

<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
            crossorigin="anonymous">
    <title>Hello Hexlet!</title>
  </head>
  <body>
    <div class="mx-auto p-4 py-md-5">
      <main>
            <a href="/users">Пользователи</a>
            @if(users.getUsers().isEmpty())
                <p>Нет пользователей</p>
            @else
                <ul class="list-group">
                @for(var user: users.getUsers())
                    <li class="list-group-item">
                        <a href="/users/${user.getId()}">
                            ${user.toString()}
                        </a>
                    </li>
                @endfor
                </ul>
            @endif
      </main>
    </div>
  </body>
</html>
