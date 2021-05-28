document.addEventListener('DOMContentLoaded', () => {
    $(document).on("click", "#addToTableBtn", e => {
        let firstName = $("#firstName").val();
        let lastName = $("#lastName").val();
        let userData = ({
            'firstName': firstName,
            'lastName': lastName
        });

        $.ajax({
            type: "POST",
            url: "addToTable",
            dataType: "text",
            data: userData,
            success: function (response) {
                $("#table").append(
                    `<tr>
                         <td>${firstName}</td>
                         <td>${lastName}</td>
                         <td id='state-${response}'>ACTIVE</td>
                         <td><a href="#" id='ban-${response}' class="ban">ban</a></td>
                         <td><a href="#" id='unban-${response}' class="unban" hidden>unban</a></td>
                    </tr>`)
            }
        })
    })

    $(document).on("click", ".ban", function (e) {
        e.preventDefault();

        let clickedId = this.id.split("-");
        let email = clickedId[1];
        let userData = ({
            'recordToDelete': email
        });

        $.ajax({
            type: "POST",
            url: "ban",
            dataType: "text",
            data: userData,
            success: function (response) {
                $('#ban-' + email).hide();
                $('#state-' + email).text('BANNED');
                $('#unban-' + email).show();
            }
        });
    });

    $(document).on("click", ".unban", function (e) {
        e.preventDefault();

        let clickedId = this.id.split("-");
        let email = clickedId[1];
        let userData = ({
            'recordToDelete': email
        });

        $.ajax({
            type: "POST",
            url: "unban",
            dataType: "text",
            data: userData,
            success: function (response) {
                $('#ban-' + email).show();
                $('#state-' + email).text('ACTIVE');
                $('#unban-' + email).hide();
            }
        });
    });

    $(document).on("click", ".delete", function (e) {
        e.preventDefault();

        let clickedId = this.id.split("-");
        let email = clickedId[1];
        let userData = ({
            'recordToDelete': email
        });

        $.ajax({
            type: "POST",
            url: "delete",
            dataType: "text",
            data: userData,
            success: function (response) {
                e.target.parentNode.parentNode.style.display = "none";
                $('#delete-' + email).hide();
            }
        });
    });
});