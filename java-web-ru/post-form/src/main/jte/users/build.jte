@template.layout.page(
    content = @`
        <form action="/users" method="post">
            <div>
                <label>
                    <input type="text" required name="firstName" />
                </label>
            </div>
            <div>
                <label>
                    <input type="text" required name="lastName" />
                </label>
            <div>
            </div>
                <label>
                    <input type="email" required name="email" />
                </label>
            <div>
            </div>
                <label>
                    <input type="password" required name="password" />
                </label>
            <div>
            </div>
                <label>
                    <input type="password" required name="passwordConfirmation" />
                </label>
            </div>
            <input type="submit" name="Save" />
        </form>
    `
)
