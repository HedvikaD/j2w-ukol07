[#ftl]

<title> Blog Hedviky D. </title>
    <br><br>
    <h1 class="display-5 fw-bold text-body-emphasis">Vítejte!</h1><br><br>

    <h2>Tak dnes začnu psát...</h2><br><br>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Title</th>
            <th scope="col"></th>
            <th scope="col">Date</th>
            <th scope="col">Author</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        [#list index.content as post]
            <tr>
                <td>${post.title}</td>
                <td>${post.perex?no_esc}</td>
                <td>${post.getPublished()?date}</td>
                <td>${post.author}</td>
                <td>
                    <a href="/${post.slug}">
                        <i class="bi bi-arrow-right-square-fill"></i>
                    </a>
                </td>
            </tr>
        [/#list]
        </tbody>
    </table>

    <div class="a_title">
        <a href="/create">Přidat nový příspěvek</a>
        <a href="/edit_post/${post.slug}">Přidat nový příspěvek</a></td>
</div>



