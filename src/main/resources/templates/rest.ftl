<#import "parts/common.ftl" as c>

<@c.page>
<div>
    <label for="expertCountry">Country</label>
    <input type="text" placeholder="Country" name="expertCountry" id="expertCountry" />
</div>
<script>
    $(document).ready(function () {
        $("#gettools").click(function () {
            // alert("clicked");
            var val = $("#expertCountry").val();
            $.ajax({
                url : '/getc',
                data: { val : val },
                success : function (data) {
                    $("#results").html(data);
                },
                error : function () {
                    alert("error");
                }

            })
        })

    });

</script>


<p id="results">Тут будет выведен результат</p>
    <button id="gettools">Get tools</button>

</@c.page>