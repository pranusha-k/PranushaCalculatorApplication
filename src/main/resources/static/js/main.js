$(document).ready(function () {

    $("#calculator").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();
        fire_ajax_calculate();

    });

});

function fire_ajax_calculate() {

    var request = {}
    request["number1"] = $("#number1").val() ;
    request["number2"] = $("#number2").val();
    request["operation"] = $("#operations").val();
    $("#btn-calculate").prop("disabled", true);

    console.log(request);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/api/calculate",
        data: JSON.stringify(request),
        dataType: 'json',
        cache: false,
        timeout: 600000,
        success: function (data) {

            var json = "<h4>Result Value</h4><pre>"
                + JSON.stringify(data, null, 4) + "</pre>";
            $('#feedback').html(json);

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

        },
        error: function (e) {

            var json = "<h4>Ajax Response</h4><pre>"
                + e.responseText + "</pre>";
            $('#feedback').html(json);

            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}