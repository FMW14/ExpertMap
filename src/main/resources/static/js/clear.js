$(document).ready(function () {
    // $("#problemList").selectedIndex = -1;
    $("#problemList").on('change', function () {
        $("#tools tr").remove();
        $("#confirm").css("visibility", "hidden");
    })

});